package com.java_config_practice.web;

import java.util.HashMap;
import java.util.Map;

public class racing {

	public static void main(String[] args) {
	     
		String[] participant =	{"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		String answer= (String)solution(participant, completion);
		System.out.println(answer);
		
	
		
		

	}
	 public static String solution(String[] participant, String[] completion) {
	      
       
	     String answer = "";
	     
	     for(int i =0;i<=participant.length-1;i++){
	        boolean check=true;        
	        int j = 0;
	        while(j<=completion.length-1){
	            if(completion[j].equals(participant[i])) { 
	                check = false;
	                break;	           
                }
	            j++; 
	        }
	     
	        if(check) { 
	        	answer = participant[i];
	        	break;
	        }
	    
         }
	         

	        return answer;
	    }
	
	
}
