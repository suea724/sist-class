package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex11_Test {

	public static void main(String[] args) throws Exception {
		
		/**
		 * 문자 하나를 입력받아 대문자인지, 소문자인지 또는 다른 문자인지 판단하는 프로그램
		 */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("영문자를 입력하세요");
		String input = reader.readLine();
		
		if(input.length() > 1) {
			System.out.println("하나의 문자만 입력해주세요.");
		} else if (input.length() == 0) {
			System.out.println("문자를 입력해주세요.");
		} else {
			// String의 첫번째 글자를 char로 바꿔줌
			char c = input.charAt(0);
			// char를 int로 형변환 해줘도 되지만 char는 내부적으로 숫자로 이루어져 있어서 우위 비교 가능
			if(c >= 'a' && c <= 'z') {
				System.out.println("소문자 입니다.");
			} else if(c >= 'A' && c <= 'Z') {
				System.out.println("대문자 입니다.");
			} else {
				System.out.println("알파벳이 아닙니다.");
			}
		}
	
	}
		
}
