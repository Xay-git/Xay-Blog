package com.blog.interceptor;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;

public class UserInterceptor implements Interceptor {
    @Override
	public void intercept(Invocation inv) {
        System.out.println("我是全局拦截器！");
		inv.invoke();

	}

}
