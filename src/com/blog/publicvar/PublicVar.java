package com.blog.publicvar;

import com.blog.article.ArticleService;
import com.blog.dev.AdminDevService;
import com.blog.dev.DevService;
import com.blog.friendlylink.FriendlyLinkService;
import com.blog.resource.ResourceService;
import com.blog.test.TestService;
import com.blog.tips.TipsService;
import com.blog.type.TypeService;
import com.blog.user.UserInfoService;
import com.blog.user.UserService;

public class PublicVar {
	public UserService user = new UserService();
	public ArticleService article = new ArticleService();
	public UserInfoService userInfo = new UserInfoService();
	public TipsService tips = new TipsService();
	public TypeService typeNav = new TypeService();
	public DevService dev = new DevService();
	public AdminDevService adminDev = new AdminDevService();
	public FriendlyLinkService flink = new FriendlyLinkService();
	public ResourceService resource = new ResourceService();
	public TestService test = new TestService();
    
}
