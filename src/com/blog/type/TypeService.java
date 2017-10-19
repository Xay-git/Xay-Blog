package com.blog.type;

import java.util.List;

import com.blog.model.XTypenav;
import com.jfinal.plugin.activerecord.Page;

public class TypeService {
	public static final XTypenav dao = new XTypenav().dao();
	
	public List<XTypenav> typeNavList(){
		return dao.find("select * from x_typeNav");
	}
	
	public Page<XTypenav> pagetypeNavList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_typeNav");
	}
	
	public boolean deleteTypeById(int id){
		return dao.deleteById(id);
	}

}
