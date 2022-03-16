package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {

	// 요구사항 : 여러 배달 음식을 같은 시간에 받기를 원하는 고객이 있다. 
	// 고객이 각각의 매장에 몇시에 전화를 해야 모든 음식을 같은 시간에 받을 수 있는지 알려주시오.
	
	public static void main(String[] args) throws Exception{

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("음식을 받기 원하는 시각");
		
		System.out.print("시 : ");
		int hour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int min = Integer.parseInt(reader.readLine());
		
		// Calendar 클래스의 add 함수를 사용할 수 있다.
		// Calendar 사용 시 계산은 편리하게 할 수 있지만 코드가 길다.
		// int 변수 사용 시 계산은 복잡하지만 코드가 짧다.
		// 내 코드에서는 hour가 음수가 될 가능성이 있기 때문에 hour에 대한 유효성 검사를 추가해줘야 한다.
		
		System.out.printf("짜장면 : %d시 %d분\n", min - 10 < 0 ? hour - 1 : hour, min - 10 < 0 ? (min - 10) + 60 : min - 10);
		System.out.printf("치킨 : %d시 %d분\n", min - 18 < 0 ? hour - 1 : hour, min - 18 < 0 ? (min - 18) + 60 : min - 18);
		System.out.printf("피자 : %d시 %d분\n", min - 25 < 0 ? hour - 1 : hour, min - 25 < 0 ? (min - 25) + 60 : min - 25);
	}

}