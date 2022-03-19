package com.test.java.question.whileloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {
	
	// 요구사항: 숫자를 N개 입력받아 아래와 같이 출력하시오.
	// 조건
	// - 누적값이 100을 넘어가는 순간 루프를 종료하시오.
	// - 짝수는 더하고 홀수는 빼시오.
	
	/**
	 * 1. 누적변수 선언, 출력할 문자열 변수 선언
	 * 2. 반복문 조건 -> 누적값 1000이 넘으면 탈출
	 * 3. 반복문 안에서 입력값 홀짝 구분하는 조건문 추가 
	 * 4. 빠져나와서 결과 출력
	 */

	public static void main(String[] args) throws Exception{
		
//		whileSum();
		forSum();
	}
	
	public static void whileSum() throws Exception {
		
		int sum = 0;
		String str = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (sum < 100) {
			
			System.out.print("숫자 입력: ");
			int inputNum = Integer.parseInt(reader.readLine());
			
			// 짝수일 때
			if (inputNum % 2 == 0) {
				
				// 짝수일때 첫번째 숫자이면 문자열 연산 생략
				if (sum == 0) {
					sum += inputNum;
					str += inputNum;
					continue;
				}
				
				sum += inputNum;
				str += " + " + inputNum;
				
			// 홀수일 때	
			} else {
				sum -= inputNum;
				str += " - " + inputNum;
			}
				
		}
		
		System.out.printf(str + " = %d", sum);
	}
	
	public static void forSum() throws Exception {
		
		int sum = 0;
		String str = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for ( ; ; ) {
			
			System.out.print("숫자 입력: ");
			int inputNum = Integer.parseInt(reader.readLine());
			
			// 짝수일 때
			if (inputNum % 2 == 0) {
				
				// 짝수일때 첫번째 숫자이면 문자열 연산 생략
				if (sum == 0) {
					sum += inputNum;
					str += inputNum;
					continue;
				}
				
				sum += inputNum;
				str += " + " + inputNum;
				
			// 홀수일 때	
			} else {
				sum -= inputNum;
				str += " - " + inputNum;
			}
			
			if (sum > 100) {
				break;
			}
			
		}
		
		System.out.printf(str + " = %d", sum);
	}

}
