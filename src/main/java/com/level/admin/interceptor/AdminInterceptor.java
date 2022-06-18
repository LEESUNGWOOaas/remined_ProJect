package com.level.admin.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.level.common.util.BaseUtil;
import com.level.common.util.SessionUtil;

@Component
public class AdminInterceptor extends HandlerInterceptorAdapter {
	/*
	 * public boolean preHandle(HttpServletRequest request,HttpServletResponse
	 * response,Object handler)throws Exception { System.out.println("interceptor");
	 * if(!SessionUtil.isLogin()){ if(BaseUtil.isAjax(request))
	 * response.sendError(999); else
	 * response.sendRedirect(request.getContextPath()+"/admin/login");
	 * 
	 * return false; }
	 * 
	 * return true; }
	 */

}
