package com.blog.article;

import java.util.HashMap;
import java.util.Map;

import com.blog.model.XArticle;
import com.blog.publicservice.PublicService;
import com.blog.util.LayuiPage;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.jfinal.upload.UploadFile;

public class ArticleMangeController extends Controller {
	Map map = new HashMap();
	PublicService p = new PublicService();
	LayuiPage<XArticle> layuiPage = new LayuiPage<XArticle>();

	public void index() {
		setAttr("tlist", p.typeNav.typeNavList());
		renderFreeMarker("articleList.html");
	}

	public void showArticles() {
		String msg = getPara("msg");
		if (msg != null) {
			if (getPara("msg") != null) {
				getSession().setAttribute("msgs", msg);
			} else {
				msg = getSessionAttr("msgs");
			}
			int pageNumber = getParaToInt("page");
			int pageSize = getParaToInt("limit");
			Page<XArticle> alist = p.article.pageArticle(pageNumber, pageSize, msg, msg, msg);
			layuiPage.setCount(alist.getTotalRow());
			layuiPage.setData(alist.getList());

		} else {
			int pageNumber = getParaToInt("page");
			int pageSize = getParaToInt("limit");
			Page<XArticle> alist = p.article.pageArticleAList(pageNumber, pageSize);
			layuiPage.setCount(alist.getTotalRow());
			layuiPage.setData(alist.getList());
		}
		renderJson(layuiPage);
	}

	public void addArticle() {
		setAttr("tlist", p.typeNav.typeNavList());
		renderFreeMarker("addArticle.html");
	}

	public void saveArticle() {
		XArticle article = getModel(XArticle.class, "a");
		String editorValue = getPara("editorValue");
//		String str[];
//		try {
//			str = editorValue.split("src=")[1].split("\"");
//			String thumbnail = str[1];
//			article.setAThumbnail(thumbnail);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			article.setAThumbnail("/upload/p1.jpg");
//		}
		article.setAArticle(editorValue).setAUsername("xay").save();
		forwardAction("/articleMange");
	}

	public void deleteArticle() {
		int id = getParaToInt(0);
		if (p.article.delectArticleById(id)) {
			map.put("msg", "删除成功");
		} else {
			map.put("msg", "删除失败");
		}
		renderJson(map);
	}

	public void editArticle() {
		int id = getParaToInt(0);
		setAttr("a", p.article.selectArticleById(id));
		setAttr("tlist", p.typeNav.typeNavList());
		renderFreeMarker("editArticle.html");
	}

	public void updataArticle() {
    
		try {
			getModel(XArticle.class, "a").setAArticle(getPara("editorValue")).update();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("编辑失败！");
		}
		forwardAction("/articleMange");
	}
	
	public void editThumbnail(){
		UploadFile f = getFile();
        String fileName = f.getFileName();
        map.put("src", "/upload/"+fileName);
        renderJson(map);
	}
	

}
