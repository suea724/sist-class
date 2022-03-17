package com.test.java.question.nestedloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8 {
	
	// 요구사항: 숫자를 2개 입력받아 각각의 약수와 두 숫자의 공약수를 구하시오.
	// TODO 중첩 for문 써보기
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자: ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자: ");
		int num2 = Integer.parseInt(reader.readLine());
		
		getDivisor(num1);
		getDivisor(num2);
		getCommonDivisor(num1, num2);
		
	}

	// 약수 구하는 함수
	private static void getDivisor(int num) {
		
		// 출력할 문자열 선언
		String str = String.format("%d의 약수: ", num);
		
		// 입력 숫자 만큼
		for (int i = 1 ; i <= num ; i ++) {
			
			// 약수일때 문자열에 저장
			if(num % i == 0) {
				
				if (num == i) {
					str += i;
					
				} else {
					str += i + ", ";
				}
				
			}
		}
		System.out.println(str);
	}
	
	// 공약수 구하는 함수
	private static void getCommonDivisor(int num1, int num2) {
		
		String str = String.format("%d와 %d의 공약수: ", num1, num2);
		
		// 조건은 어느 숫자가 들어와도 상관 없음
		for (int i = 1 ; i <= num1 ; i ++) {
			
			// 두 숫자로 나누어 떨어지면 문자열 추가
			if (num1 % i == 0 && num2 % i == 0) {
				
					str += i + ", ";
			}
			
		}
		
		System.out.println(str);
			
	}			
}
