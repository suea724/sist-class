package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q04 {

	public static void main(String[] args) throws Exception {
		
		// 4번 문제
		
		//요구사항 : 섭씨 온도를 입력받아서 화씨 온도로 변환하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("섭씨(℃) : ");
		double celsius = Double.parseDouble(reader.readLine());		
		
		System.out.printf("섭씨%.1f℃는 화씨 %.1f℉ 입니다.\n", celsius, celsius * 1.8 + 32);
		
	}
}
