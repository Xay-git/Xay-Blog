package com.blog.route;

import com.blog.article.ArticleMangeController;
import com.blog.dev.DevMangeController;
import com.blog.friendlylink.FriendlyMangeController;
import com.blog.index.AdminController;
import com.blog.tips.TipsMangeController;
import com.blog.type.TypeMangeController;
import com.blog.user.UserInfoController;
import com.jfinal.config.Routes;


public class AdminRoute extends Routes{

	@Override
	public void config() {
		// TODO Auto-generated method stub
		 add("admin", AdminController.class, "/admin");
		 add("articleMange", ArticleMangeController.class, "/admin/view/article");
		 add("typeMange", TypeMangeController.class, "/admin/view/type");
		 add("tipsMange", TipsMangeController.class, "/admin/view/tips");
		 add("devMange", DevMangeController.class, "/admin/view/dev");
		 add("friendlyMange", FriendlyMangeController.class, "/admin/view/friendly");
		 add("userInfoMange", UserInfoController.class, "/admin/view/user");
	
	}

}
