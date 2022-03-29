package com.test.java.obj.stereo;

public class Ex52_Enum {

	public static void main(String[] args) {
		
		/**
		 * [열거형, Enumeration]
		 * - 클래스의 일종
		 * - static final 변수이기 때문에 대문자로 적어야 함
		 */
		
		// 의류 쇼핑몰 > 티셔츠 판매 > 고객이 색상을 선택
		
		// Case 1. > String 사용 > 오타 발생 가능
		String color = "발강";
		
		if (color.equals("빨강") || color.equals("검정") || color.equals("파랑")) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
		// Case 2. > enum 자료형 사용 > 선택형(선택지에 제약 존재) > 프로그램의 생산성 & 안정성 ↑
		Colors c1 = Colors.RED;
		// System.out.println(c1);
		
		if (c1 == Colors.RED || c1 == Colors.YELLOW || c1 == Colors.BLUE) {
			System.out.println("판매 가능");
		} else {
			System.out.println("재고 없음");
		}
		
	}
	
}

enum Colors {
	RED, // static final 상수
	YELLOW,
	BLUE
}

class Colors2 {
	public static final int red = 0;
	public static final int yellow = 1;
	public static final int blue = 2;
}

enum Position {
	STAFF,
	MANAGER,
	DIRECTOR
	
}

enum Gender {
	MALE,
	FEMALE
}