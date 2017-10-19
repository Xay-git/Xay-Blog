package com.blog.index;

import com.blog.model.XArticle;
import com.jfinal.core.Controller;

public class AdminController extends Controller{

	 public void index(){
		 renderFreeMarker("index.html");
	 }
	 
	 public void main(){
		 renderFreeMarker("main.html");
	 }
	 
	
}
