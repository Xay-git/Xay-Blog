package com.blog.resource;

import com.blog.publicservice.PublicService;
import com.jfinal.core.Controller;

public class ResourceController extends Controller{
	PublicService p = new PublicService();
	
	public void index(){
		setAttr("rlist",p.resource.resourceList());		
		renderFreeMarker("resource.html");
	}
	

}
