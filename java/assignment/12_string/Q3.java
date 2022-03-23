package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	// 요구사항: 숫자를 입력받아 각 자릿수의 수의 합을 구하시오.
	
	/**
	 * 1.split() 메서드를 이용해 빈 문자열 기준으로 자른다.
	 * 2.for문 안에서 split()으로 생성한 배열의 요소들을 parseInt()를 사용해 정수화한다.
	 * 3.정수화한 값을 누적변수에 더한다.
	 */
	
	public static void main(String[] args) throws Exception {
		
		int sum = 0;
		StringBuilder res = new StringBuilder();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		String input = reader.readLine();
		
		String[] digits = input.split(""); // 빈 문자열 기준으로 split
		
		for (int i = 0 ; i < digits.length ; i ++) {
			
			if (i == digits.length-1) { // 마지막 요소일 경우
				
				res.append(digits[i]);
				sum += Integer.parseInt(digits[i]);
				break;
			}
			
			sum += Integer.parseInt(digits[i]); // 숫자로 바꿔 누적
			res.append(digits[i]); // 문자열 연산
			res.append(" + ");
		}
		
		System.out.printf("결과: %s = %d", res, sum);
	}
}
