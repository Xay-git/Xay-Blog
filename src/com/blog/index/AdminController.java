package com.blog.index;

import com.blog.publicvar.PublicVar;
import com.jfinal.core.Controller;

public class AdminController extends Controller{
     PublicVar p = new PublicVar();
	 public void index(){
		 setAttr("user",p.userInfo.userInfo());
		 renderFreeMarker("index.html");
	 }
	
}
