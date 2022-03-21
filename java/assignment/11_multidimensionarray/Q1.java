package com.test.java.question.multidimensionarray;

public class Q1 {

	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		boolean flag = true; // 플래그 설정
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		for (int i = 0 ; i < 5 ; i ++) {
			
			if(flag == true) { // 정방향으로 반복문 진행
				
				for (int j = 0 ; j < 5 ; j ++) {
					nums[i][j] = n;
					n++;
				}
				
				flag = false; // 돌고 나서 flag를 false로 설정
				
			} else { // flag가 false일 경우
				
				for (int j = 4 ; j >= 0 ; j --) { // 역방향으로 반복문 진행
					nums[i][j] = n;
					n++;
				}
				
				flag = true; // 돌고 나서 flag를 true로 설정
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
