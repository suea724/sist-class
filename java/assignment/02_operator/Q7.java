package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {

	// 7번 문제
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 입력 : ");
		int alpha = reader.readLine().charAt(0);
		
		if(alpha >= 97 && alpha <= 122) {
			System.out.printf("소문자 \'%c\'의 대문자는 \'%c\'입니다.", alpha, alpha-32);
		} else if (alpha >= 65 && alpha <= 90) {
			System.out.printf("대문자 \'%c\'의 소문자는 \'%c\'입니다.", alpha, alpha+32);
		} else {
			System.out.println("다시 입력해주세요.");
		}
	}

}
