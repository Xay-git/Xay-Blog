package com.blog.route;

import com.blog.article.ArticleMangeController;
import com.blog.dev.DevMangeController;
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
		 add("articleMange", ArticleMangeController.class, "/admin/article");
		 add("typeMange", TypeMangeController.class, "/admin/type");
		 add("tipsMange", TipsMangeController.class, "/admin/tips");
		 add("devMange", DevMangeController.class, "/admin/dev");
		 add("userInfoMange", UserInfoController.class, "/admin/user");
	
	}

}
