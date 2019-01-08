package com.java_config_practice.controller;

public class MathDumb {

    public static int solution(int[] answers) {
        int[] answer = {};
        
        int[][] arr = {{1,2,3,4,5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int s1, s2, s3 = 0; 
        int rslt[] = {0,0,0};
        for(int i=0; i<3; i++) {
    	   for(int j: answers) {
    		 if(j==(arr[0][i]%(arr.length+1))) {
    			 rslt[i]+=1;
    		 }   
    	   }
       }
    	   /*세번씩 포문을 돈다
    answer의 사이즈 만큼 포문을 돈다
    첫번째 포문의 순서대로 비교한다
        맞을 때마다 ++ 한다
     비교한다*/
       for(int i=0; i<3;i++) {
    	   if(i!=2) {
    	   if(rslt[i]>rslt[i+1]) {
    		   int tmp =rslt[i];
    		   rslt[i]= rslt[i+1];
    		   rslt[i+1]=tmp;
    	   }
    	   }
       }
        return rslt[2];
    }
	
    public void quicksorting() {
   
    	
    	
    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] answer = {1,2,3,4,3,1,2,3,4,2,1,2,2,3,4,6,5};
		System.out.println(solution(answer));
		
	}

}
