package com.test.java.question.operator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Team3_Q07 {

	public static void main(String[] args) throws Exception {
		
		// 7번 문제
		// 요구사항 : 영문 소문자를 1글자 입력받은 후 대문자로 변환해서 출력하시오.
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자 입력 : ");
		
		int lower = reader.readLine().charAt(0); 
		int upper = lower - 32;
		
		System.out.printf("소문자 \'%c\'의 대문자는 \'%c\'입니다.", lower, upper);

		char a = (char)655000000;
		System.out.println(a);
		
		/**
		 * int <-> char간 형변환에 대해 논의
		 * 형식 문자를 사용할 때는 말그대로 형식만 따지기 때문에 int를 char로 따로 형변환해주지 않아도 된다.
		 * char는 0 ~ 65535 값을 가지기 때문에 더 큰 타입인 int로의 형변환이 암시적으로 일어난다.
		 * int에서 char로 형변환 할때는 char의 범위를 넘지 않는 한 암시적 형변환이 가능하고, 범위를 넘는다면 명시적 형변환이 필요하다.
		 */

	}
}
