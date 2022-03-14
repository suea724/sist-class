package com.test.java;

public class Ex15_Overloading {

	public static void main(String[] args) {
		
		drawLine();
		
		// 선의 모양을 다르게 만들 수 있음
		drawLine("*");
		drawLine("+");
		
	}

	public static void drawLine() {
		System.out.println("==============================");
	}
	
	public static void drawLine(String s) {
		for(int i = 0 ; i < 31 ; i ++) {
			System.out.print(s);
		}
		System.out.println();
	}
	
	public static void test() {
		
	}
	
	
	public static void test(int n) {
		
	}
	
	// 매개변수 이름이 달라도 오버로딩 불가
	// public static void test(int m) {
	//
	// }
	
	public static void test(String s) {
		
	}
	
	public static void test(int n, int m) {
		
	}

	// 반환값이 달라도 오버로딩 불가
	// public static int test() {
	//
	// }
}
