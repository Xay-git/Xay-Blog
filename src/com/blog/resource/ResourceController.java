package com.blog.resource;

import com.blog.publicvar.PublicVar;
import com.jfinal.core.Controller;

public class ResourceController extends Controller{
	PublicVar p = new PublicVar();
	
	public void index(){
		setAttr("rlist",p.resource.resourceList());		
		renderFreeMarker("/blog/html/resource.html");
	}
	

}
