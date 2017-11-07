package com.blog.user;

import java.util.HashMap;
import java.util.Map;

import com.blog.model.XUserinfo;
import com.blog.publicservice.PublicService;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;

public class UserInfoController extends Controller{
	Map map = new HashMap();
	PublicService p = new PublicService();
	public void index(){
		setAttr("ilist", p.userInfo.userInfoList());
		renderFreeMarker("userInfo.html");
	}
	
	public void updateUserInfo(){
		XUserinfo u = getModel(XUserinfo.class,"i");
		String imgSrc = u.getIImgsrc();
		setSessionAttr("UserImg", imgSrc);
		u.update();
		forwardAction("/userInfoMange");
	}
	
	public void imgPath(){
	    UploadFile uf = getFile();
	    String fileName = uf.getFileName();
	    map.put("src", "/upload/"+fileName);
	    renderJson(map);
	}

}
