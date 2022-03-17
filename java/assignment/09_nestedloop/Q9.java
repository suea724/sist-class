package com.test.java.question.nestedloop;

public class Q9 {
	
	// 1 ~ n0 합 출력
	
	public static void main(String[] args) {
		
		int sum = 0;
		
		// 10부터 100까지 10씩 증가
		for(int i = 10 ; i <= 100 ; i += 10) {
			// 1부터 i까지 증가시키면서 누적
			for (int j = 1 ; j <= i ; j ++) {
				sum += j;
			}
			System.out.printf("1 ~ %3d : %4d\n", i, sum);
			// sum 초기화
			sum = 0;
		}
	}
	
	

}
