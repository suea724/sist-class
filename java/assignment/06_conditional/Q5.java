package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		System.out.print("연산자 : ");
		char operator= reader.readLine().charAt(0);
		
		// 조건을 boolean 변수를 선언해서 설정해주면 가독성이 높고 코드 길이가 짧다.
		boolean isAsterisk = (operator ==  '*');
		boolean isSlash = (operator ==  '/');
		boolean isPlus = (operator ==  '+');
		boolean isMinus = (operator ==  '-');
		boolean isModulo = (operator ==  '%');
		
		if (isAsterisk || isSlash || isPlus || isMinus || isModulo) {
			
			if (isAsterisk) {
				System.out.printf("%d * %d = %d", num1, num2, num1 * num2);
			} else if (isSlash) {
				System.out.printf("%d / %d = %.1f", num1, num2, (double)num1 / num2);
			} else if (isPlus) {
				System.out.printf("%d + %d = %d", num1, num2, num1 + num2);
			} else if (isMinus) {
				System.out.printf("%d - %d = %d", num1, num2, num1 - num2);
			} else if (isModulo) {
				System.out.printf("%d %% %d = %d", num1, num2, num1 % num2);
			}
		} else {
			System.out.println("연산이 불가능합니다.");
		}
	}
	
}
