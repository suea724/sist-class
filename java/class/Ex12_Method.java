package com.test.java;

public class Ex12_Method {

	public static void main(String[] args) {
		
		sayHello();
		
		printNumOneToFive();
		printNumSixToTen();
		
		printKorNumOneToFive();
		printKorNumSixToTen();
	}
	
	// public		static		void		printGreeting	()	
	// 접근 지정자		정적 키워드		반환 자료형		메서드 명			인자리스트
	public static void sayHello() {
		
		System.out.println("안녕하세요");
		System.out.println();
	}
	
	public static void printNumOneToFive() {
		
		System.out.println(1);
		System.out.println(2);
		System.out.println(3);
		System.out.println(4);
		System.out.println(5);
		System.out.println();
	}
	
	public static void printKorNumOneToFive() {
		
		System.out.println("하나");
		System.out.println("둘");
		System.out.println("셋");
		System.out.println("넷");
		System.out.println("다섯");
		System.out.println();
	}
	
	public static void printNumSixToTen() {
		
		System.out.println(6);
		System.out.println(7);
		System.out.println(8);
		System.out.println(9);
		System.out.println(10);
		System.out.println();
		
	}
	
	public static void printKorNumSixToTen() {
			
		System.out.println("여섯");
		System.out.println("일곱");
		System.out.println("여덟");
		System.out.println("아홉");
		System.out.println("열");
		System.out.println();
			
		}
	
}
