package com.blog.index;

import com.blog.publicvar.PublicVar;
import com.jfinal.core.Controller;

public class BlogController extends Controller{
	PublicVar p = new PublicVar();
        
	public void index(){
		setAttr("alist", p.article.articleAList());
		setAttr("tlist",p.tips.tipsList());
		setAttr("ilist",p.userInfo.userInfoList());
		BlogController.this.right();
		renderFreeMarker("home.html");
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
