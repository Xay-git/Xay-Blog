package com.blog.about;

import java.util.List;

import com.blog.model.XMessage;
import com.blog.model.XMessage1;
import com.jfinal.plugin.activerecord.Page;

public class AboutService {
	
	public static final XMessage dao = new XMessage().dao();
	public static final XMessage1 dao1 = new XMessage1().dao();
	
    public Page<XMessage> messageList(int pageNumber,int pageSize){
    	return dao.paginate(pageNumber, pageSize, "select *","from x_message");
    }
    
    public Page<XMessage> messageList1(int pageNumber,int pageSize){
    	return dao.paginate(pageNumber, pageSize, "select *","from x_message1");
    }
    public List<XMessage1> messageList1(){
    	return dao1.find("select * from x_message1");
    }
    
    public List<XMessage> getMtime(){
    	return dao.find("select m_time,m_id from x_message1");
    }

}
