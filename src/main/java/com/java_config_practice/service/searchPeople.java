package com.java_config_practice.service;

public class searchPeople {

	public String[] member = {"호날두","메시","손흥민","박지성","박주영","이청용"};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String txt = "손흥민";
		String pat = "손흥";
		
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
			System.out.println(pat.charAt(pt));
		System.out.println(skip[pat.charAt(pt)] );
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
	}

}
