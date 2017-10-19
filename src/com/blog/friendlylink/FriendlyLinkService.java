package com.blog.friendlylink;

import java.util.List;

import com.blog.model.XFriendlylink;

public class FriendlyLinkService {
	public static final XFriendlylink dao = new XFriendlylink().dao();
	
	public List<XFriendlylink> linkList(){
		return dao.find("select * from x_friendlyLink order by x_linkId asc");
	}
}
