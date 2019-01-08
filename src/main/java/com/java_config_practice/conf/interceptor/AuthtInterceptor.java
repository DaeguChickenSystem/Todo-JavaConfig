package com.java_config_practice.conf.interceptor;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler ) throws Exception {
     
    	HttpSession session = request.getSession();
        Object obj = session.getAttribute("Auth");
        
        String url = request.getServletPath();
        if(url.equals("/") && obj ==null ) {
        	response.sendRedirect("/login");        
        	return false;
        }else if(url.equals("/login") && obj!=null) {
           	response.sendRedirect("/main");        
        	return false;        	
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        long startTime = (Long) request.getAttribute("startTime");
//        request.removeAttribute("startTime");
//        long endTime = System.currentTimeMillis();
//        modelAndView.addObject("handlingTime", endTime - startTime);
    }
}
