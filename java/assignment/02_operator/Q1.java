package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {
	
	// 1번 문제
	
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("출생 년도를 입력하세요. : ");
		int birthYear = Integer.parseInt(reader.readLine());
		
		System.out.printf("나이 : %d세", 2022 - birthYear + 1);
	}

}
