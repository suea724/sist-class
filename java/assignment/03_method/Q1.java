package com.test.java.question.method;

public class Q1 {
	
	// 요구사항 : 인삿말을 출력하는 메소드 3개를 선언하시오.
	
	/**
	 * 설계
	 * 1. 각 문자열을 찍는 메서드를 정의한다.
	 * 2. 메인 메서드에서 각 메서드를 호출한다.
	 */
	
	public static void main(String[] args) {
		
		hello();
		introduce();
		bye();
	}
	
	public static void hello() {
		System.out.println("안녕하세요.");
	}
	
	public static void introduce() {
		System.out.println("저는 홍길동입니다.");
	}
	
	public static void bye() {
		System.out.println("안녕히 가세요.");
	}
	

}
