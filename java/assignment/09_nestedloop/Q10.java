package com.test.java.question.nestedloop;

public class Q10 {
	
	// n1 ~ n0 합출력
	
	public static void main(String[] args) {
			
			int sum = 0;
			
			// 10부터 100까지 10씩 증가
			for(int i = 10 ; i <= 100 ; i += 10) {
				// i-9부터 i까지 증가시키면서 누적
				for (int j = i - 9 ; j <= i ; j ++) {
					sum += j;
				}
				System.out.printf("%2d ~ %3d : %4d\n", i - 9, i, sum);
				// sum 초기화 (누적방지)
				sum = 0;
			}
		}

}
