package com.java_config_practice.web;

public class quickSorting {

	public static void quick(int[] data, int l, int r) {
		
		/* 그림을 보면서 따라가는게 그나마 낫다*/
				
		int left = l;
		int right= r;
		int pivot = data[(l+r)/2];
		
		do {
/*			피벗보다 좌측값이 크거나 같을 때까지 계속 피벗쪽으로 움직인다.
			좌측값이 피벗이 같거나 크면 더이상 움직이지 않는다.*/
			while(data[left]<pivot) left++;
			
/*			우측값이 피벗보다 작으면 움직이고 그렇지 않음 멈춘다.*/
			while(data[right]>pivot) right--;
	
			if(left<=right) {
/*			    좌측과 우측을 바꾸고 바뀐거 다음 인덱스로 추가한다.*/
				int temp =data[left];
				data[left] = data[right];
				data[right] = temp;
				left++;
				right--;
			}
			
/*			피벗으로 나눠진 대로 각각 퀵정렬 다시한다.*/
			if(l<right) quick(data, l,right);
			if(r>left) quick(data, left, r);
			
			
		}while(left <=right);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {66, 10, 1, 34, 5, -10};
		quick(data, 0, data.length-1);
	}

}
