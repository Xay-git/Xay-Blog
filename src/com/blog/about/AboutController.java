package com.blog.about;

import java.util.List;

import com.blog.model.XUserinfo;
import com.blog.publicvar.PublicVar;
import com.jfinal.core.Controller;

public class AboutController extends Controller{
      PublicVar p = new PublicVar();
	public void index(){
		setAttr("user",p.userInfo.userInfo());
        setAttr("flist", p.flink.linkList());		
		renderFreeMarker("about.html");
	}
}
