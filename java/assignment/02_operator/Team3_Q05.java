package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q05 {

	public static void main(String[] args) throws Exception {
		
		// 5번 문제
		
		//요구사항: 자전거가 있다. 자전거의 바퀴는 지름(직경)이 26인치이다. 사용자가 페달을 밟은 횟수를 입력하면 자전거가 총 몇 m를 달렸는지 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("사용자가 페달을 밟은 횟수: ");
		int pedal = Integer.parseInt(reader.readLine());

		final double PI = 3.14;
		final double INCH = 0.0254;
		
		double distance = pedal * INCH * (PI * 26) ;
		
		System.out.printf("사용자가 총 %d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedal, distance);
//		System.out.printf("사용지가 총 %,d회 페달을 밟아 자전거가 총 %,.3fm를 달렸습니다.", pedalCount, pedalCount * 3.141576317383404 * 0.6604);
		
		
		/**
		 * 원주율과 인치값은 변하지 않는 값이므로 final 변수를 사용함.
		 * > 변수로 인해 각 수의 역할의 파악이 더 명확해지고 계산식이 더 이해하기 쉬워짐
		 * 
		 * 연산식이 길기 때문에 출력문 밖에서 변수를 선언하고 출력함
		 */
		
	}
}
