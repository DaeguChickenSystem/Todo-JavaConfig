package com.java_config_practice.controller;

import java.util.PriorityQueue;
import java.util.Queue;

public class spicyScore {

	  public static int solution(int[] scoville, int K) {
	        int answer = 0;
	        int s1, s2, tmp, time =0;
	        Queue<Integer> que = new PriorityQueue <Integer>(scoville.length);
	        
	        
	        for(int scr: scoville) {
	        que.offer(scr);	
	        }
	        while(que.size()>1) {
	         if(que.peek() >= K) {
	        	 break;
	         }
	         s1= que.poll();
	         s2= que.poll();
	         tmp = s1 +(s2*2);
	         que.offer(tmp);
	         answer++;
	         
	        }
	        
	        System.out.println(answer);
	        return answer;
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int score = 7;
		
		solution(scoville, score);
	}

}
