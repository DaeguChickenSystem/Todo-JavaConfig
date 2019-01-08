package com.java_config_practice.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;


@Service("authService")
public class AuthServiceImp implements AuthService {

	@Override
	public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("Auth", "True");
		return "Success";
	}

}
