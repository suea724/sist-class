package com.test.java.question.overloading;

public class Q2 {

	public static void main(String[] args) {
		
		// 요구사항 : 인자로 받은 이름들을 직급 순으로 출력하는 메소드를 선언하시오.
		
		position("홍길동");
		position("홍길동", "유재석");
		position("홍길동", "유재석", "박명수");
		position("홍길동", "유재석", "박명수", "정형돈");

	}
	
	// employee1, employee2, ... 보다는 각 직급을 나타낼 수 있는 단어로 나타내는 것이 각 변수의 역할을 명확히 구분하기에 좋다. 
	public static void position(String staff) {
		
		System.out.printf("사원 : %s\n", staff);
		System.out.println();
	}
	
	public static void position(String staff, String assistManager) {
		
		System.out.printf("사원 : %s\n대리 : %s\n", staff, assistManager);
		System.out.println();
	}
	
	public static void position(String staff, String assistManager, String deptManager) {
		
		System.out.printf("사원 : %s\n대리 : %s\n과장 : %s\n", staff, assistManager, deptManager);
		System.out.println();
	}
	
	public static void position(String staff, String assistManager, String deptManager, String executiveManager) {
		
		System.out.printf("사원 : %s\n대리 : %s\n과장 : %s\n부장 : %s\n", staff, assistManager, deptManager, executiveManager);
		System.out.println();
	}

}
