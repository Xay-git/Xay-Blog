package com.blog.dev;

import java.util.List;

import com.blog.model.XDev;
import com.jfinal.plugin.activerecord.Page;

public class DevService {
	public static final XDev dao = new XDev().dao();
	
	public List<XDev> devList(){
		return dao.find("select * from x_dev order by d_time asc");
	}
	
	public Page<XDev> pageDevList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_dev order by d_time asc");
	}

}
