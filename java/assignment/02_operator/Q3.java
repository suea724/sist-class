package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {

	// 3번 문제
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("너비(cm) : ");
		int width = Integer.parseInt(reader.readLine());
		System.out.print("높이(cm) : ");
		int height = Integer.parseInt(reader.readLine());
		
		System.out.printf("사각형의 넓이는 %d㎠ 입니다.\n", width * height);
		System.out.printf("사각형의 둘레는 %d㎠ 입니다.\n", 2 * (width + height));
		
	}

}
