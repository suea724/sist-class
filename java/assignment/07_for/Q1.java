package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q1 {

	// 요구사항 : 사용자의 이름과 인사할 횟수를 입력 받아 출력하시오.
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("이름 : ");
		String name = reader.readLine();
		
		System.out.print("횟수 : ");
		int time = Integer.parseInt(reader.readLine());
		
		for (int i = 0 ; i < time ; i ++) {
			System.out.printf("%s님 안녕하세요~\n",name);
		}
		
	}

}
