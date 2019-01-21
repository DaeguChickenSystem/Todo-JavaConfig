package com.java_config_practice.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public interface AuthService {
	
	public String login(HttpServletRequest request, HashMap<String, String> param);
}
