package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {

	// 2번 문제
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 : ");
		String input1 = reader.readLine();
		
		System.out.print("두번째 숫자 : ");
		String input2 = reader.readLine();
		
		if(input1.matches("^[0-9]*$") && input2.matches("^[0-9]*$")) {
			
			int num1 = Integer.parseInt(input1);
			int num2 = Integer.parseInt(input2);
			
			System.out.printf("%,d + %,d = %,d\n", num1, num2, num1 + num2);
			System.out.printf("%,d - %,d = %,d\n", num1, num2, num1 - num2);
			System.out.printf("%,d * %,d = %,d\n", num1, num2, num1 * num2);
			System.out.printf("%,d / %,d = %,.1f\n", num1, num2, (double)num1 / num2);
			System.out.printf("%,d %% %,d = %,d\n", num1, num2, num1 % num2);
			
		} else {
			System.out.println("다시 입력해주세요.");
		}
		
	}

}
