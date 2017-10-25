package com.blog.dev;

import java.util.List;

import com.blog.model.XAdmindev;
import com.blog.model.XDev;
import com.jfinal.plugin.activerecord.Page;

public class AdminDevService {

	public static final XAdmindev dao = new XAdmindev().dao();
	
	public List<XAdmindev> adminDevList(){
		return dao.find("select * from x_adminDev order by d_time asc");
	}
	
	public Page<XAdmindev> pageAdminDevList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_adminDev order by d_time asc");
	}
}
