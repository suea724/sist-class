package com.test.java;

public class Ex16_Swap {

	public static void main(String[] args) {
		
		// int 타입 swap 호출
		int a = 10;
		int b = 20;
		
		swap(a, b);
		
		// String 타입 swap 호출
		String s1 = "홍길동";
		String s2 = "아무개";
		
		swap(s1, s2);
		
		// boolean 타입 swap 호출
		boolean b1 = true;
		boolean b2 = false;
		
		swap(b1, b2);
		
		// 비트 연산자를 사용한 swap > 정수값에만 사용 가능 (잘 안쓰임)
		int c = 10;
		int d = 20;
		
		System.out.printf("c: %d, d: %d\n", c, d);
		
		c = c ^ d;
		d = c ^ d;
		c = c ^ d;
		
		System.out.printf("c: %d, d: %d\n", c, d);
	}

	// int 타입 swap 정의
	public static void swap(int a, int b) {
		
		System.out.printf("a = %d, b = %d\n", a, b);
		
		int temp;
		temp = a;
		a = b;
		b = temp;
		
		System.out.printf("a = %d, b = %d\n", a, b);
	}

	// String 타입 swap 정의
	public static void swap(String s1, String s2) {
		
		System.out.printf("s1 = %s, s2 = %s\n", s1, s2);
		
		String temp;
		temp = s1;
		s1 = s2;
		s2 = temp;
		
		System.out.printf("s1 = %s, s2 = %s\n", s1, s2);
	}

	// boolean 타입 swap 정의
	public static void swap(boolean b1, boolean b2) {
		
		System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
		
		boolean temp;
		temp = b1;
		b1 = b2;
		b2 = temp;
		
		System.out.printf("b1 = %b, b2 = %b\n", b1, b2);
	}
}