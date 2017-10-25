package com.blog.timeLine;

import com.jfinal.core.Controller;

public class TimelineController extends Controller{

	public void index(){
		renderFreeMarker("timeline.html");
	}
}
