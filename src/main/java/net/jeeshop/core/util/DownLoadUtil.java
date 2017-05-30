package net.jeeshop.core.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Qiao on 2017/5/27.
 */
public class DownLoadUtil {
    /**
     * Desc:根据文件头判断请求来自的浏览器，以便有针对性的对文件名转码
     * @date 2014-6-26
     * @param request
     * @return
     * @throws Exception
     */
    public static String transFileName(String fileName, HttpServletRequest request) {

        String agent = request.getHeader("USER-AGENT");
        //fileName = fileName.trim();       //去首尾空格
        try {
            //根据文件头判断请求来自的浏览器，以便有针对性的对文件名转码
            if(null != agent && -1 != agent.indexOf("theworld")){   //世界之窗
                fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");    //解决下载的文件名中含有小括号转变义符%28%29
            }else if(null != agent && -1 != agent.indexOf("MSIE 8.0")){ //IE8
                String lenFileName = URLEncoder.encode(fileName, "UTF-8");
                if (lenFileName.length() > 150) {    //文件名长度是否大于150个字符
                    fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");
                } else {
                    fileName = URLEncoder.encode(fileName,"UTF-8").replace("+","%20");
                }
            }else if(null != agent && -1 != agent.indexOf("MSIE 7.0") && -1 != agent.indexOf("SE 2.X MetaSr 1.0")){ //sogo浏览器
                fileName = URLEncoder.encode(fileName,"UTF-8").replace("+","%20");
            }else if(null != agent && (-1 != agent.indexOf("SV1") || -1 != agent.indexOf("360SE"))){    //360安全浏览器
                String lenFileName = URLEncoder.encode(fileName, "UTF-8");
                if (lenFileName.length() > 150) {    //文件名长度是否大于150个字符
                    fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");
                } else {
                    fileName = URLEncoder.encode(fileName,"UTF-8").replace("+","%20");
                }
            }else if(null != agent && -1 != agent.indexOf("Chrome")){   //google
                fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");    //解决下载的文件名中含有小括号转变义符%28%29
            }else if(null != agent && -1 != agent.indexOf("Firefox")){  //Firefox
                fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");
            }else if(null != agent && -1 != agent.indexOf("Safari")){   //Firefox
                fileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
            }else { //其它浏览器
                fileName = new String(fileName.getBytes("gb2312"), "ISO-8859-1");
            }
        } catch (Exception e) {
            throw new RuntimeException("transFileName error", e);
        }
        return fileName;
    }

    public static void downloadFile(HttpServletRequest request, HttpServletResponse response, String filePath, String filename){
        //1.设置文件ContentType类型，这样设置，会自动判断下载文件类型
        response.setContentType("multipart/form-data");
        //2.设置文件头：最后一个参数是设置下载文件名
        response.setHeader("Content-Disposition", DownLoadUtil.transFileName("attachment;fileName="+filename, request));
        ServletOutputStream out;
        //通过文件路径获得File对象(假如此路径中有一个download.pdf文件)
        File file = new File(filePath + filename);

        try {
            FileInputStream inputStream = new FileInputStream(file);

            //3.通过response获取ServletOutputStream对象(out)
            out = response.getOutputStream();

            int b = 0;
            byte[] buffer = new byte[1024 * 4];
            while ((b = inputStream.read(buffer)) != -1){
                //4.写到输出流(out)中
                out.write(buffer,0,b);
            }
            inputStream.close();
            out.flush();
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
