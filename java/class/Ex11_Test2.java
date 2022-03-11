package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Test2 {

	public static void main(String[] args) throws Exception {

		/**
		 * 정규표현식(regex) 사용해서 문자열의 대소문자 여부 구분 
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("영문자를 입력하세요");
		String input = reader.readLine();
		
		if(input.matches("^[A-Z]*$")) {
			System.out.println("대문자로 이루어진 문자 입니다.");
		} else if(input.matches("^[a-z]*$")) {
			System.out.println("소문자로 이루어진 문자 입니다.");
		} else if (input.matches("^[a-zA-Z]*$")) {
			System.out.println("대문자와 소문자로 이루어진 문자입니다.");
		}
		else {
			System.out.println("영문자가 아닙니다.");
		}
		
	}

}
