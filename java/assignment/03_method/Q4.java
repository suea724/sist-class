package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 : 숫자를 2개 입력받아 연산식을 반환하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 두 정수를 매개변수로 받아 연산을 수행하는 메서드를 각각 정의한다.
		 * 2. 메서드 정의시 연산식과 결과를 String 타입으로 반환한다. > 형식 지정자 사용
		 * 3. 메인 메서드에서 메서드를 호출한다.
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자 : ");
		int n1 = Integer.parseInt(reader.readLine());
		
		System.out.print("두번째 숫자 : ");
		int n2 =Integer.parseInt(reader.readLine());
		
		String result = add(n1, n2); 
		System.out.println(result);

		result = subtract(n1, n2);
		System.out.println(result);

		result = multiply(n1, n2);
		System.out.println(result);

		result = divide(n1, n2);
		System.out.println(result);

		result = mod(n1, n2);
		System.out.println(result);
		
	}	// main
	
	public static String add(int num1, int num2) {
		
		String res = String.format("%d + %d = %d", num1, num2, num1 + num2);
		return res;
	}
	
	public static String subtract(int num1, int num2) {
		
		String res = String.format("%d - %d = %d", num1, num2, num1 - num2);
		return res;
	}
	
	public static String multiply(int num1, int num2) {
		
		String res = String.format("%d * %d = %d", num1, num2, num1 * num2);
		return res;
	}
	
	public static String divide(int num1, int num2) {
		
		String res = String.format("%d / %d = %.1f", num1, num2, (double)num1 / num2);
		return res;
	}
	
	public static String mod(int num1, int num2) {
		
		String res = String.format("%d %% %d = %d", num1, num2, num1 % num2);
		return res;
	}
	

}
