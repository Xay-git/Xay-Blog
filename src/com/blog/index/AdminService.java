package com.blog.index;

import java.util.List;

import com.blog.model.XAdmindev;

public class AdminService {
	
	public static final XAdmindev dao = new XAdmindev().dao();
	
	public List<XAdmindev> adminDevList(){
		return dao.find("select * from x_adminDev order by d_Time asc");
	}

}
