package com.test.java;

public class Ex18_RecursiveMethod {

	public static void main(String[] args) {

		// Stackoverflow Exception 발생
		// m1();
		
		int n = 4;
		int result = m2(n);
		System.out.println(result);
		
		// 팩토리얼
		// 4! = 4 * 3 * 2 * 1
		
		n = 4;
		result = factorial(n); //4!
		
		System.out.printf("%d! = %d\n", n, result);
		
	}
	
	public static int factorial(int n) {
		
		return (n == 1) ? 1 : n * factorial(n - 1);
	}
	
	public static int m2(int n) {
		
		System.out.println(n);
		int result = (n == 1) ? 1 : m2(n - 1);
		return result;
	}

	// Recursive method
	public static void m1() {

		System.out.println("안녕하세요");
		System.out.println("홍길동입니다.");

		// Recursive call
		m1();
	}
}
