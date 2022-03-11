package com.test.java.question.method;

public class Q2 {

	// 요구사항 : 이름을 전달하면 이름뒤에 '님'을 붙여서 반환하는 메소드를 선언하시오.
	
	/**
	 * 설계
	 * 1. 문자열인 이름을 매개변수 입력받아 "님"이라는 문자열을 더해 반환하는 메서드를 정의한다.
	 * 2. 메인 함수에 String 타입으로 result 변수를 선언해 메서드의 반환 값을 받는다.
	 * 3. 메서드의 반환값을 변수에 저장하고 printf문을 사용해 결과를 출력한다.
	 */
	
	public static void main(String[] args) {
		
		String result = getName("홍길동");
		System.out.printf("고객: %s\n", result);
		
		result = getName("아무개");
		System.out.printf("고객: %s\n", result);
	
	}
	
	public static String getName(String name) {
		return name + "님";
	}

}
