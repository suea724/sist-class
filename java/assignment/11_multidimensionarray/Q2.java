package com.test.java.question.multidimensionarray;

public class Q2 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 25; // 초기값을 25로 설정
		
		// 다른 방법: n = 1로 넣고 인덱스 4-i, 4-j로 설정
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				nums[i][j] = n;
				n--; // 하나씩 줄어듦
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
