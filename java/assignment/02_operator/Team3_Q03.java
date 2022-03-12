package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q03 {

	public static void main(String[] args) throws Exception {
		
		// 3번 문제
		// 요구사항 : 사각형의 너비와 높이를 입력받아 넓이와 둘레를 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("너비(cm) : ");
		int width = Integer.parseInt(reader.readLine());
//		String input = reader.readLine();
//		int width = Integer.parseInt(input);
//		input 변수를 따로 만들고 이를 int로 치환하는 것을 두 단계로 나누는 것보다 직관적이고 깔끔함
		 
		
		System.out.print("높이(cm) : ");
		int height = Integer.parseInt(reader.readLine());
		
		System.out.printf("사각형의 넓이는 %d㎠ 입니다.\n", width * height);
		System.out.printf("사각형의 둘레는 %dcm 입니다.\n", 2 * (width + height));
//		System.out.printf("사각형의 둘레는 %dcm 입니다.\n", 2 * width + 2 * height));
//		둘레 공식에 따라 표현할 수도 있지만 최대한 계산식을 깔끔하게 만드는 것이 좋다.
//		출력문에서 출력할 때 연산식이 너무 길어지거나 연산식의 결과를 재사용해야 할때는 변수로 선언하자
		
	}
}


