package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {
	
	// 요구사항: 숫자를 5개 입력받아 배열에 담은 뒤 역순으로 출력하시오.

	public static void main(String[] args) throws Exception {
		
		// 배열 선언
		int[] nums = new int[5];
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 숫자 5개 입력 받기
		for (int i = 0 ; i < 5 ; i ++) {
			System.out.print("숫자: ");
			nums[i] = Integer.parseInt(reader.readLine());
		}
		
		// 배열 값 역순 출력
		for (int i = 4 ; i >= 0 ; i --) {
			
			System.out.printf("nums[%d] = %d\n", i, nums[i]);
		}
		
	}

}
