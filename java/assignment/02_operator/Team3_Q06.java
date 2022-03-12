package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q06 {

	public static void main(String[] args) throws Exception {
		
		// 6번 문제
		//요구사항 : 사용자의 한달 수입을 입력받아 세후 금액을 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("한달 수입 금액(원): ");
		int income = Integer.parseInt(reader.readLine());
		
		double tax = income * 0.033; 
		double afterTax = income - tax; 
						
		System.out.printf("세후 금액(원) : %,.0f원 \n세금(원) : %,.0f원\n", afterTax, tax );
//		System.out.printf("세후 금액(원) : %,.0f원\n", income * (1 - 0.033));
//		System.out.printf("세금(원) : %,.0f원\n", income * 0.033);
		
		/**
		 * 변수로 따로 선언하니까 각 연산식이 의미하는 내용을 명확히 알기 쉬워졌다.
		 */
	
		
	}
}
