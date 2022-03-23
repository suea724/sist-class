package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {
	
	// 요구사항: 문장을 입력받아 역순으로 출력하시오.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("문장 입력: ");
		String statement = reader.readLine();
		
		System.out.print("역순 결과: \"");
		
		// 문장 마지막 위치부터 감소시키면서 문자 출력
		for (int i = statement.length()-1 ; i >= 0 ; i --) {
			
			System.out.print(statement.charAt(i));
		}
		
		System.out.print("\"");
		
	}
}
