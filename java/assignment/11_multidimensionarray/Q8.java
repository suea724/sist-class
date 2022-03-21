package com.test.java.question.multidimensionarray;

public class Q8 {
	
	public static void main(String[] args) {
		
		int[][] nums = new int[5][5];
		int n = 1;
		int loopNum = 0; // 루프 변수
		
		while (loopNum <= 5) { // 대각선까지
			
			for (int i = 0, j = loopNum-1 ; i < loopNum ; i ++ , j --) {
				
				nums[i][j] = n;
				n++;
//				System.out.println(i + " " + j);
			}
//			System.out.println();
			
			loopNum++; // 탈출 시 loopNum = 5
			
		}
		
		loopNum = 4;
		
		while (loopNum >= 0) { // 대각선 다음부터
			
			for (int i = 5 - loopNum, j = 4 ; j > 0 && i < 5 ; i ++ , j --) {
				
				nums[i][j] = n;
				n++;
//				System.out.println(i + " " + j);
				
			}
//			System.out.println();
			loopNum--;
			
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
