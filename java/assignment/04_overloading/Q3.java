package com.test.java.question.overloading;

public class Q3 {

	public static void main(String[] args) {
		
		// 요구사항 : 인자로 받은 숫자들 중 양수의 갯수를 반환하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 매개변수로 들어오는 메서드를 각각 5개 만든다.
		 * 2. 삼항 연산자를 이용해서 양수이면 1, 음수이면 0을 반환하도록 하여 양수의 개수를 저장한다.
		 * 3. 출력문에서 갯수를 출력한다.
		 */
		
		int count;
		count = positive(10);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30, 40);
		System.out.printf("양수 : %d개\n", count);
		
		count = positive(10, 20, -30, 40, 50);
		System.out.printf("양수 : %d개\n", count);
	}
	
	public static int positive(int num1) {
		
		int isNum1Positive = num1 > 0 ? 1 : 0;
		return isNum1Positive;
	}
	
	public static int positive(int num1, int num2) {
		
		int isNum1Positive = num1 > 0 ? 1 : 0;
		int isNum2Positive = num2 > 0 ? 1 : 0;
		return isNum1Positive + isNum2Positive;
	}
	
	public static int positive(int num1, int num2, int num3) {
		
		int isNum1Positive = num1 > 0 ? 1 : 0;
		int isNum2Positive = num2 > 0 ? 1 : 0;
		int isNum3Positive = num3 > 0 ? 1 : 0;
		return isNum1Positive + isNum2Positive + isNum3Positive;
	}
	
	public static int positive(int num1, int num2, int num3, int num4) {
		
		int isNum1Positive = num1 > 0 ? 1 : 0;
		int isNum2Positive = num2 > 0 ? 1 : 0;
		int isNum3Positive = num3 > 0 ? 1 : 0;
		int isNum4Positive = num4 > 0 ? 1 : 0;
		return isNum1Positive + isNum2Positive + isNum3Positive + isNum4Positive;
	}
	
	public static int positive(int num1, int num2, int num3, int num4, int num5) {
		
		int isNum1Positive = num1 > 0 ? 1 : 0;
		int isNum2Positive = num2 > 0 ? 1 : 0;
		int isNum3Positive = num3 > 0 ? 1 : 0;
		int isNum4Positive = num4 > 0 ? 1 : 0;
		int isNum5Positive = num5 > 0 ? 1 : 0;
		return isNum1Positive + isNum2Positive + isNum3Positive + isNum4Positive + isNum5Positive;
	}

}
