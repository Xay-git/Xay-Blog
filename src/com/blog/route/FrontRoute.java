package com.blog.route;

import com.blog.about.AboutController;
import com.blog.article.ArticleController;
import com.blog.index.BlogController;
import com.blog.index.IndexController;
import com.blog.resource.ResourceController;
import com.blog.test.TestController;
import com.blog.timeLine.TimelineController;
import com.blog.ueditor.UEditorController;
import com.jfinal.config.Routes;


public class FrontRoute extends Routes {

	@Override
	public void config() {
		// TODO Auto-generated method stub
		   add("/", IndexController.class);
           add("/blog", BlogController.class, "/blog/html/home");
           add("/article", ArticleController.class, "/blog/html/article");
           add("/resource", ResourceController.class, "/blog/html/resource");
           add("/timeline", TimelineController.class, "/blog/html/timeline");
           add("/about", AboutController.class, "/blog/html/about");
           add("/ue", UEditorController.class);
           add("/test", TestController.class,"blog/html");
         
           
           
	}

}
