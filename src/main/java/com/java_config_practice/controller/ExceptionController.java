package com.java_config_practice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionController {

	private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);
	
	
  
    @ExceptionHandler(Exception.class)  
    public ModelAndView handleException(Exception e){
    	logger.info(e.toString());
    	String defaultErrorPage = "/common/500";
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("errMsg", e.getMessage());
		modelAndView.setViewName(defaultErrorPage);
    	return modelAndView;
    			
    	
    }  

	
}
