package com.test.java.question.multidimensionarray;

public class Q3 {

	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		// i와 j 위치 바꿈
		// 열이 바깥 for문, 행이 안쪽 for문
		for (int j = 0 ; j < 5 ; j ++) {
			for (int i = 0 ; i < 5 ; i ++) {
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
