package com.blog.about;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import com.blog.model.XMessage;
import com.blog.model.XMessage1;
import com.blog.publicservice.PublicService;
import com.jfinal.core.Controller;

public class AboutController extends Controller{
      PublicService p = new PublicService();
      Map map = new HashMap();
      SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  	
	public void index(){
		setAttr("mlist",p.about.messageList(1,10));
		setAttr("user",p.userInfo.userInfo());
        setAttr("flist", p.flink.linkList());
        setAttr("userName", getSessionAttr("userName"));
		renderFreeMarker("about.html");
		
	}
	
	public void message(){
		renderJson(p.about.messageList(1, 10));
	}
	
	public void add(){	

		   XMessage message = getModel(XMessage.class,"m").setMUsername("xay");
		   message.save();
		   map.put("id", message.getMId());
		   map.put("userName", message.getMUsername());
		   map.put("time", message.getMTime());
		   map.put("content",message.getMContent());
		   renderJson(map);
		}
		
		public void delete(){
			int id = getParaToInt(0);
			XMessage.dao.deleteById(id);
			renderJson("msg","1");
		}
		
		public void add1(){
			XMessage1 message1 = getModel(XMessage1.class,"m1").setMUsername("xay");
			message1.save();
			map.put("id", message1.getMId());
		    map.put("userName", message1.getMUsername());
		    map.put("time", message1.getMTime());
		    map.put("content",message1.getMContent());
		    renderJson(map);
		}
		
		public void view() throws ParseException{
			renderJson(p.about.messageList1());
		}
}
