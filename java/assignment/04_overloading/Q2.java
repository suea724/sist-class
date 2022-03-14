package com.test.java.question.overloading;

public class Q2 {

	public static void main(String[] args) {
		
		// 요구사항 : 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");

	}
	
	public static void position(String employee1) {
		
		System.out.printf("사원 : %s\n", employee1);
		System.out.println();
	}
	
	public static void position(String employee1, String employee2) {
		
		System.out.printf("사원 : %s\n대리 : %s\n", employee1, employee2);
		System.out.println();
	}
	
	public static void position(String employee1, String employee2, String employee3) {
		
		System.out.printf("사원 : %s\n대리 : %s\n과장 : %s\n", employee1, employee2, employee3);
		System.out.println();
	}
	
	public static void position(String employee1, String employee2, String employee3, String employee4) {
		
		System.out.printf("사원 : %s\n대리 : %s\n과장 : %s\n부장 : %s\n", employee1, employee2, employee3, employee4);
		System.out.println();
	}

}
