/**
 * 2012-7-8
 * jqsl2012@163.com
 */
package net.jeeshop.web.action.manage.indexPage;

import net.jeeshop.core.Services;
import net.jeeshop.core.dao.page.PagerModel;
import net.jeeshop.services.manage.indexPage.IndexPageService;
import net.jeeshop.services.manage.indexPage.bean.IndexPage;
import net.jeeshop.web.action.BaseController;
import net.jeeshop.web.util.RequestHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 首页管理
 * 
 * @author huangf
 * @author dylan
 * 
 */
@Controller
@RequestMapping("/manage/indexPage/")
public class IndexPageAction extends BaseController<IndexPage> {
	private static final long serialVersionUID = 1L;
	private static final String page_toList = "/manage/indexPage/indexPageEdit";
	private static final String page_toEdit = "/manage/indexPage/indexPageEdit";
	private static final String page_toAdd = "/manage/indexPage/indexPageEdit";
	private IndexPageAction() {
		super.page_toList = page_toList;
		super.page_toAdd = page_toAdd;
		super.page_toEdit = page_toEdit;
	}
	@Autowired
	private IndexPageService indexPageService;

	@Override
	public Services<IndexPage> getService() {
		return indexPageService;
	}


    @Override
    public String selectList(HttpServletRequest request, @ModelAttribute("e") IndexPage indexPage) throws Exception {
        IndexPage SearchBean = new IndexPage();
        List<IndexPage> list = indexPageService.selectList(SearchBean);
        IndexPage indexPage1 = list.get(0);
        request.setAttribute("indexPage", indexPage1);
        return page_toList;
    }

    @Override
	protected void selectListAfter(PagerModel pager) {
        pager.setPagerUrl("selectList");
	}

	//上传文件
	@Deprecated
	private void uploadImage(MultipartFile image) throws IOException{
		if(image==null){
			return;
		}
		String imageName = String.valueOf(System.currentTimeMillis()) + ".jpg";
		String realpath = RequestHolder.getSession().getServletContext().getRealPath("/indexImg/");
		// D:\apache-tomcat-6.0.18\webapps\struts2_upload\images
		logger.info("realpath: " + realpath);
		if (image != null) {
			File savefile = new File(new File(realpath), imageName);
			if (!savefile.getParentFile().exists()) {
				savefile.getParentFile().mkdirs();
			}
			image.transferTo(savefile);
//			FileUtils.copyFile(image, savefile);
//			ActionContext.getContext().put("message", "文件上传成功");
		}
//		SystemInfo sInfo = SystemSingle.getInstance().getSystemInfo();
//		String url = sInfo.getWww_ip() + "/file/img/" + imageName;
		String url = "/indexImg/" + imageName;
		//e.setPicture(url);
		image = null;
	}
	

}
