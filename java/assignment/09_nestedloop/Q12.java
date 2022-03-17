package com.test.java.question.nestedloop;

public class Q12 {
	
	// 피보나치
	
	// TODO
	
	public static void main(String[] args) {
		
		int sum = 0;
		String str = "";
		
		int i = 1;
		int j = 1;
		
		for (i = 1 ; i < 100 ; i = i + j) {
			
			j ++;
			sum += i;
			
		}
		System.out.println(sum);
		
	}

}
