package com.test.java.question.method;

public class Q3 {

	public static void main(String[] args) {
		
		// 요구사항 : 숫자 1개를 전달하면 4자리로 출력하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 정수를 매개변수로 받는 메서드를 정의한다.
		 * 2. 메서드에서 자릿수를 확인해서 한자릿수일 경우 "000", 두자릿수일 경우 "00", 세자릿수일 경우 "0"을 숫자와 더해 문자열로 출력한다.
		 * 3. 네자릿수 이상일 경우 숫자를 그대로 출력한다.
		 * 4. 메인 메서드에서 메서드를 호출한다. 
		 */
		
		digit(1);
		digit(12);
		digit(321);
		digit(5678);
		digit(98765);
		
	}
	
	public static void digit(int num) {
		
		// 문제 조건에 맞게 수정
		// String zero = num < 10 ? "000" : num < 100 ? "00" : num < 1000 ? "0" : "";
		// System.out.printf("%d -> %s\n", num, zero + num);
		
		System.out.printf("%d -> %04d\n", num, num);
		
	}

}
