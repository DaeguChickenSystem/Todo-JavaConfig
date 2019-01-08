package com.java_config_practice.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImp implements MemberService {


	public String[] member = {"호날두","메시","손흥민","박지성","박주영","이청용"};
	
	@Override
	public String search(String pattern) {
		// TODO Auto-generated method stub
		String name = "";
		for(int i=0; i<member.length; i++) {
			if(bmMatch(member[i], pattern) != -1)
				
			name= member[i];
		}
		return name;
	}
	
	public int bmMatch(String txt, String pat) {
		int pt;
		int pp;
		int result = -1;
		int txtLen = txt.length();
		int patLen = pat.length();
		int[] skip = new int[Character.MAX_VALUE + 1];
		
		// 건너뛰기 표 만들기
		for(pt = 0; pt<= Character.MAX_VALUE; pt++)
			skip[pt] = patLen;
		for(pt = 0; pt < patLen - 1; pt++)
			skip[pat.charAt(pt)] = patLen -pt -1;
		
		while(pt < txtLen) {
			pp = patLen -1;
			
			while(txt.charAt(pt) == pat.charAt(pp)) {
				skip[pat.charAt(pt)] = patLen - pt -1;
			
			
			while(pt<txtLen) {
				pp = patLen -1;
				
				while(txt.charAt(pt)== pat.charAt(pp)) {
					if(pp==0)
						result = pt;
					pp--;
					pt--;
				}
				pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen -pp;
			}
			result =  -1;
				
			}
		}
		return result;
	}

}
