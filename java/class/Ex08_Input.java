package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex08_Input {
	
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("입력 : ");
		String str = reader.readLine();
		System.out.printf("입력한 내용 : [%s]\n", str);
		
		System.out.print("나이 : ");
		String age = reader.readLine();
		System.out.printf("나이는 %s살 입니다.\n", age);
		
	}
	
}
