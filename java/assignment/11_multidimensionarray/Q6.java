package com.test.java.question.multidimensionarray;

public class Q6 {

	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		for (int i = 0 ; i < 4 ; i ++) {
			
			for (int j = 0 ; j < 4 ; j ++) {
				
				nums[i][j] = n; // 4 X 4 배열 생성
				
				nums[4][j] += nums[i][j]; // 각 열의 합
				nums[i][4] += nums[i][j]; // 각 행의 합
				
				n++; 
			}
		}
		
		// 총합
		for (int i = 0 ; i < 4 ; i ++) {
		nums[4][4] += nums[i][4] + nums[4][i];
			
		}
		
		// 데이터 출력 > 수정 금지
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
	}
}
