package com.blog.resource;

import java.util.List;

import com.blog.model.XResource;
import com.jfinal.plugin.activerecord.Page;

public class ResourceService {
	public static final XResource dao = new XResource().dao();
	
	public List<XResource> resourceList(){
		return dao.find("select * from x_resource order by r_id asc");
	}
	
	public Page<XResource> pageResource(int pageNumber, int pageSize){
		return dao.paginate(pageNumber,pageSize,"select *","from x_resource order by r_id asc");
	}
}
