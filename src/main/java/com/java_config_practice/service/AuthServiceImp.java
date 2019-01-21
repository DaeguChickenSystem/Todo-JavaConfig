package com.java_config_practice.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.java_config_practice.domain.Member;


@Service("authService")
public class AuthServiceImp implements AuthService {

	List members = new LinkedList();
	@Override
	public String login(HttpServletRequest request, HashMap<String, String> param) {
        HttpSession session = request.getSession();
        duplicateCheck(param);
        session.setAttribute("Auth", "True");
        session.setAttribute("connectedId", param.get("id"));
        
		return "Success";
	}
	
	public boolean duplicateCheck(Map data) {
	    	
		Member member = new Member();
		member.setId((String)data.get("id"));
		members.add(member);
		return true;
		
	}

}
