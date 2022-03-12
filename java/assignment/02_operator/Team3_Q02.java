package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q02 {

	public static void main(String[] args) throws Exception {
		
		// 2번 문제
		// 요구사항 : 숫자 2개를 입력받아 아래의 연산식을 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("첫번째 숫자: ");
		String input1 = reader.readLine();	
		int num1 = Integer.parseInt(input1);
		
		System.out.print("두번째 숫자: ");
		String input2 = reader.readLine();	
		int num2 = Integer.parseInt(input2);
		
		System.out.printf("%d + %d = %,d\n", num1, num2, num1 + num2);	
		System.out.printf("%d - %d = %,d\n", num1, num2, num1 - num2);	
		System.out.printf("%d * %d = %,d\n", num1, num2, num1 * num2);	
		System.out.printf("%d / %d = %.1f\n", num1, num2, (double)num1 / num2);
		System.out.printf("%d %% %d = %,d\n", num1, num2, num1 % num2);	
		
		/**
		 * printf문 안에서 형변환을 하는 것이 좋은지 double 변수를 밖에서 만들고 출력하는 것이 좋은지에 대해 논의
		 * > 따로 변수를 만들지 않으면 메모리를 추가적으로 사용하지 않기 때문에 프린트문 안에서 형변환 하는 것이 좋음
		 * > 연산 길이가 길어지면 변수를 따로 선언하는 것이 가독성 측면에서 좋음
		 * 
		 * 변수와 산술기호 사이, 콤마 뒤에는 띄어쓰기를 하는 것이 가독성이 높음
		 * 
		 * 변수명은 직관적인 것이 이해하기 쉬움 ex) input, num ..
		 */
		
		//더 생각해볼 것
		//1. 숫자가 아닌 값을 입력하면? > 삼항연산자 활용
		//2. 나눗셈의 결과가 정수일때, 소수 이하의 표시를 표시안하려면..? > %.0f / 처음부터 int값으로 받기
		
	}
}
