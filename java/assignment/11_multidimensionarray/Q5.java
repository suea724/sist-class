//package com.test.java.question.multidimensionarray;
//
//public class Q5 {
//	
//	// (0,0) (1,1) (1,2) (1,3) (2,0~4) 
//	
//	public static void main(String[] args) {
//		
//		int[][] nums = new int[5][5];
//		int n = 1;
//		
//		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
//		for (int i = 0 ; i < 5 ; i ++) {
//			
//			if (i < 3) {
//				
//				for (int j = 0 ; j < 2*i + 1 ; j ++) {
//					nums[i][j+(2-i)] = n;
//					n++;
//				}
//				
//			} else {
//				
//				//  i = 2일때 j 5번. i = 3일때 j 3번. i = 4일때 j 1번
//				for (int j = 4 ; j > 0 ; j ) {
//					nums[i][j] = n;
//					n++;
//				}
//			}
//			
//		}
//		
////		for (int i = 3 ; i < 5 ; i ++) {
////			for (int j =  ; j >  ; j --) {
////				nums[i][j] = n;
////				n++;
////			}
////		}
//		
//		// 데이터 출력 > 수정 금지
//		for (int i = 0 ; i < 5 ; i ++) {
//			for (int j = 0 ; j < 5 ; j ++) {
//				System.out.printf("%5d", nums[i][j]);
//			}
//			System.out.println();
//		}
//	}
//
//}
