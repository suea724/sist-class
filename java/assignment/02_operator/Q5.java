package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {

	// 5번 문제
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("사용자가 페달을 밟은 횟수 : ");
		int pedalCount = Integer.parseInt(reader.readLine());
		
		System.out.printf("사용지가 총 %,d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedalCount, pedalCount * 3.141576317383404 * 0.6604);
		
	}

}
