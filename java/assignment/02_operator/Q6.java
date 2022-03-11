package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {

	// 6번 문제
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("한달 수입 금액(원) : ");
		int income = Integer.parseInt(reader.readLine());
		
		System.out.printf("세후 금액(원) : %,.0f원\n", income * (1 - 0.033));
		System.out.printf("세금(원) : %,.0f원\n", income * 0.033);
		

	}

}
