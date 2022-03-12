package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q01 {

	public static void main(String[] args) throws Exception {
		
		// 1번 문제
		// 요구사항 : 태어난 년도를 입력받아 나이를 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("출생 년도를 입력하세요. : ");
		int birthYear = Integer.parseInt(reader.readLine());

		int age = 2022 - birthYear + 1;
		System.out.printf("나이 : %d세", age);
//		System.out.printf("나이 : %d세", 2022 - birthYear + 1); 
//		프린트문에서 직접 계산 하는 것보다 변수를 따로 빼놓는 것이 가독성 측면에서 좋음 
		
		/*
		 * 더 생각해볼 것
		 * 숫자가 아닌 값을 입력하면? 삼항연산자 활용
		 * 올바른 값이 아닌 걸 입력하면? 삼항연산자 활용
		 * 올해가 2022년이 아니라면? 입력값으로 태어난 년도와 함께 올해 년도를 입력받는다.
		 */
	}
}
