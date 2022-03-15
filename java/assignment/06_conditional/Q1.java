package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {

	// 요구사항 : 숫자 2개를 입력받아 큰수와 작은수를 출력하시오.

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("첫번째 숫자 : ");
		int num1 = Integer.parseInt(reader.readLine());
		System.out.print("두번째 숫자 : ");
		int num2 = Integer.parseInt(reader.readLine());
		
		if (num1 > num2) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.두 숫자는 %d(가)이 차이가 납니다.", num1, num2, num1 - num2);
		} else if (num1 < num2) {
			System.out.printf("큰 수는 %d이고, 작은 수는 %d입니다.두 숫자는 %d(가)이 차이가 납니다.", num2, num1, num2 - num1);
		} else {
			System.out.println("두 숫자는 동일합니다.");
		}
	}

}
