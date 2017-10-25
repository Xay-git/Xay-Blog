package com.blog.common;

import com.blog.interceptor.UserInterceptor;
import com.blog.model._MappingKit;
import com.blog.route.AdminRoute;
import com.blog.route.FrontRoute;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.core.JFinal;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.render.ViewType;
import com.jfinal.template.Engine;

public class BlogConfig extends JFinalConfig {

	/**
	 * 特别注意：Eclipse 之下建议的启动方式
	 */
	public static void main(String[] args) {
		JFinal.start("WebRoot", 83, "/", 5);
	}

	/**
	 * 配置常量
	 */
	@Override
	public void configConstant(Constants me) {
		// TODO Auto-generated method stub
		me.setDevMode(true);
		PropKit.use("config.properties");
		me.setViewType(ViewType.FREE_MARKER);
	}

	/**
	 * 配置路由
	 */
	@Override
	public void configRoute(Routes me) {
		// TODO Auto-generated method stub
		me.add(new FrontRoute());
		me.add(new AdminRoute());
	}

	/**
	 * 配置插件
	 */
	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub
		DruidPlugin druid = createDruidPlugin();
		me.add(druid);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druid);
		_MappingKit.mapping(arp);
		me.add(arp);

	}

	/**
	 * 配置拦截器
	 */
	@Override
	public void configInterceptor(Interceptors me) {
		// TODO Auto-generated method stub
        me.add(new UserInterceptor() );
	}

	/**
	 * 配置Handler
	 */
	@Override
	public void configHandler(Handlers me) {
		// TODO Auto-generated method stub
		me.add(new ContextPathHandler("ctx"));

	}

	/**
	 * 配置模板
	 */
	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub
	}

	public static DruidPlugin createDruidPlugin() {
		return new DruidPlugin(PropKit.get("jdbcUrl"), PropKit.get("user"), PropKit.get("password").trim());
	}

}
