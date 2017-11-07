package com.blog.index;

import com.blog.interceptor.LoginInterceptor;
import com.blog.model.XUser;
import com.blog.publicservice.PublicService;
import com.blog.util.MD5;
import com.jfinal.aop.Clear;
import com.jfinal.captcha.CaptchaRender;
import com.jfinal.core.Controller;
import com.jfinal.ext.kit.SessionIdKit;

public class AdminController extends Controller{
     PublicService p = new PublicService();
     
     public void index(){	
    		 setAttr("user",p.userInfo.userInfo());
    		 renderFreeMarker("index.html");
     }
     
     @Clear(LoginInterceptor.class)
	 public void loginViwer(){
		renderFreeMarker("/admin/page/login/login.html");
	 }
     
     @Clear(LoginInterceptor.class)
	 public void login(){

	    	 boolean result = validateCaptcha("code");
	         if (!result) {
	            renderJson("msg", "验证码输入有误");
	            return;
	         }
		    LoginService loginservice = new LoginService();
	        String username = getPara("username");
	        XUser u = loginservice.selectAccountNumber(username);
	        if(u!=null){
	        	 String password = MD5.GetMD5Code(getPara("password"));
	        	 if(u.getXUserpass().equals(password)){
	        		 setSessionAttr("userName", u.getXUsername());
	        		 setSessionAttr("sessionId", SessionIdKit.me().generate(getRequest()));
	        		 renderJson("msg", "1");
	        	 }else{
	        		 renderJson("msg","用户名或密码输入有误");
	        	 }
	        }else{
	        	renderJson("msg","用户名不存在");
	        }
	 }
	 
	 public void logout(){
		 removeSessionAttr("userName").removeSessionAttr("sessionId");
		 redirect("/admin");
	 }
	 
	
	 
	 @Clear(LoginInterceptor.class)
	       public void verifycode(){
	       render(new CaptchaRender());
	   }
	 
    
	
}
