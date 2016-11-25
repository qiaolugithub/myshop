
        import java.io.IOException;
        import java.io.BufferedReader;
        import java.io.InputStream;
        import java.io.InputStreamReader;

/**
 * Created by IntelliJ IDEA.
 * User: leizhimin
 * Date: 2008-7-18
 * Time: 14:18:27
 * Java调用Windows命令测试
 */
public class TestCmd {

    public static void main(String args[]) {
        testWinCmd();
       // dirOpt();
    }

    public static void testWinCmd() {
        System.out.println("------------------testWinCmd()--------------------");
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.maxMemory());
        System.out.println(runtime.availableProcessors());   //处理器数
        try {
            //执行一个exe文件
            runtime.exec("C://Users//Qiao//Desktop//win//shenhuojifen-qt.exe");
          /*  //执行批处理
            runtime.exec("c://x.bat");
            //执行系统命令
            runtime.exec("cmd /c dir ");
            runtime.exec("cmd /c dir c://");

            //            //-------------- 文件操作 --------------

            runtime.exec("cmd /c copy c://x.bat d://x.txt");   //copy并改名
            runtime.exec("cmd /c rename d://x.txt x.txt.bak"); //重命名
            runtime.exec("cmd /c move d://x.txt.bak c://");    //移动
            runtime.exec("cmd /c del c://x.txt.bak");          //删除

            //-------------- 目录操作 --------------
            runtime.exec("cmd /c md c://_test");          //删除*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 执行批处理文件，并获取输出流重新输出到控制台
     */
    public static void dirOpt() {
        System.out.println("------------------dirOpt()--------------------");
        Process process;
        try {
            //执行命令
            process = Runtime.getRuntime().exec("c://x.bat");
            //取得命令结果的输出流
            InputStream fis = process.getInputStream();
            //用一个读输出流类去读
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String line = null;
            //逐行读取输出到控制台
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}