package com.blog.about;

import com.jfinal.core.Controller;

public class AboutController extends Controller{

	public void index(){
		renderFreeMarker("about.html");
	}
}
