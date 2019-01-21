package com.java_config_practice.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java_config_practice.service.AuthService;
import com.java_config_practice.service.AuthServiceImp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AuthController {
	
	
	AuthService authService = new AuthServiceImp();

  @RequestMapping(value="/loginProcess", method = RequestMethod.POST)
  @ResponseBody
  public Map login(Model model, HttpServletRequest request, @RequestParam Map<String, Object> param) {   	  	
  	Map result = new HashMap();
  	result.put("result", authService.login(request, (HashMap) param));


    return result;
  }

    
}