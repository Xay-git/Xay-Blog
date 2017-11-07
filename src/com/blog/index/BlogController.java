package com.blog.index;

import com.blog.model.XArticle;
import com.blog.publicservice.PublicService;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;

public class BlogController extends Controller{
	PublicService p = new PublicService();
        
	public void index(){
		setAttr("user",p.userInfo.userInfo());
		setAttr("tlist",p.tips.tipsList());
		setAttr("ilist",p.userInfo.userInfoList());
		BlogController.this.right();
		renderFreeMarker("home.html");
	}
	
	public void flowArticle(){
		Integer page = getParaToInt(0);
		Page<XArticle> article = p.article.pageArticleAList(page, 10);
		renderJson(article);
	}
	
	public void right(){
		
		setAttr("vlist",p.article.viewsList(1, 6));
		setAttr("clist",p.article.newArticles(1, 6));
		setAttr("dlist",p.dev.devList());
		setAttr("adlist",p.adminDev.adminDevList());
		setAttr("flist",p.flink.linkList());	
		renderFreeMarker("public/blogRight.html");
	}
	
	

	


	
}
