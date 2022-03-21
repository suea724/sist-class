package com.test.java.question.multidimensionarray;

public class Q4 {

	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 4-i+1 ; j ++) { // 조건식 수정
				nums[i][j] = n;
				n++;
			}
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
