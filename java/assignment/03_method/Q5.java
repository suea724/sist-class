package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {

	public static void main(String[] args) throws Exception{
		
		// 요구사항 : 숫자를 전달하면 '짝수' 혹은 '홀수' 라는 단어를 반환하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 정수를 매개변수로 받는 메서드를 정의한다.
		 * 2. 메서드에서 넘어온 값이 짝수인지, 홀수인지 구분한다. > 삼항 연산자, % 사용
		 * 3. 메서드의 반환값을 변수에 저장하고 printf문을 사용해 결과를 출력한다.
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("숫자: ");
		int n = Integer.parseInt(reader.readLine());
		
		String result = getNumber(n);
		System.out.printf("입력하신 숫자 '%d는(은) '%s'입니다.\n", n, result);
	}

	public static String getNumber(int num) {

		return ((num % 2) == 0) ? "짝수" : "홀수";
	}
	
}
