package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex10_Input {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("첫번째 숫자 입력 : ");
		String input1 = reader.readLine();
		System.out.print("두번째 숫자 입력 : ");
		String input2 = reader.readLine();
		
// parse: 문자열을 값형으로 바꿔줌 (형변환은 아님) -> 각 유틸 클래스마다 parse 메서드 제공
		
//		Byte.parseByte("10");
//		Short.parseShort("10");
//		Integer.parseInt("10");
//		Long.parseLong("10");
		
//		Float.parseFloat("3.14");
//		Double.parseDouble("3.14");
//		Boolean.parseBoolean("true");		
		
// String.valueOf() : 자신의 자료형을 문자열로 바꿔줌
//		String.valueOf(10);
//		String.valueOf(3.14);
//		String.valueOf(true);
		
		int num1 = Integer.parseInt(input1);
		int num2 = Integer.parseInt(input2);
		
		System.out.printf("%d + %d = %d\n", num1, num2, num1+num2);
		
	}

}
