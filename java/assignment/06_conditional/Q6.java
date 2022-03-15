package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {

	public static void main(String[] args) throws Exception{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("문자 : ");
			char alpha = reader.readLine().charAt(0);
			
			boolean isLower = (alpha >= 'a' && alpha <= 'z');
			boolean isUpper = (alpha >= 'A' && alpha <= 'Z');
			
			if(isLower || isUpper) {
				
				if(isLower) {
					System.out.printf("\'%c\'의 대문자는 \'%c\'입니다.",alpha, alpha - 32);
				} else if(isUpper) {
					System.out.printf("\'%c\'의 소문자는 \'%c\'입니다.",alpha, alpha + 32);
				}	
			} else {
				System.out.println("영문자만 입력하시오.");
			}
			
	}
}
