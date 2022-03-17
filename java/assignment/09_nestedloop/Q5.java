package com.test.java.question.nestedloop;

public class Q5 {
	
	// 구구단을 출력하시오.
	
	public static void main(String[] args) {
		
		// 2 ~ 5단
		for (int i = 1 ; i <= 9 ; i ++) {
			
			for (int j = 2 ; j <= 5 ; j ++) {
				
				System.out.printf("%d X %d = %d\t", j, i, j * i);
				
			}
			// n * j 출력 후 개행
			System.out.println();
		}
		
		System.out.println();
		
		// 6 ~ 9단
		for (int i = 1 ; i <= 9 ; i ++) {
			
			for (int j = 6 ; j <= 9 ; j ++) {
				
				System.out.printf("%d X %d = %d\t", j, i, j * i);
				
			}
			// n * j 출력 후 개행
			System.out.println();
		}
			
	}

}
