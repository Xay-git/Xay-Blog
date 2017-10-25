package com.blog.user;

import java.util.List;

import com.blog.model.XUserinfo;

public class UserInfoService {
public static final XUserinfo dao = new XUserinfo().dao();
	
	public List<XUserinfo> userInfoList(){
		return dao.find("select * from x_userInfo;");
	}
	
	public XUserinfo userInfo(){
		return dao.findFirst("select * from x_userInfo where i_userName = ?","xay");
	}
}
