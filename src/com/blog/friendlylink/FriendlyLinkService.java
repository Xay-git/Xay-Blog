package com.blog.friendlylink;

import java.util.List;

import com.blog.model.XFriendlylink;
import com.jfinal.plugin.activerecord.Page;

public class FriendlyLinkService {
	public static final XFriendlylink dao = new XFriendlylink().dao();
	
	public List<XFriendlylink> linkList(){
		return dao.find("select * from x_friendlyLink order by x_linkId asc");
	}
	
	public Page<XFriendlylink> pageList(int pageNumber, int pageSize){
		return dao.paginate(pageNumber, pageSize, "select *","from x_friendlyLink order by x_linkId asc");
	}
	
	public XFriendlylink selectFile(String fileName){
		return dao.findFirst("select x_linkImgSrc from x_friendlyLink where x_linkImgSrc = ?",fileName);
	}
	
	
	
}
