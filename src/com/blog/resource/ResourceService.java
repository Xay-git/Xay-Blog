package com.blog.resource;

import java.util.List;

import com.blog.model.XResource;

public class ResourceService {
	public static final XResource dao = new XResource().dao();
	
	public List<XResource> resourceList(){
		return dao.find("select * from x_resource order by r_id asc");
	}
}
