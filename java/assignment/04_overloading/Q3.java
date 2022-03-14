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
	
	// 양수의 개수를 입력받는 변수를 각각 선언하면 선언해야 할 변수의 양도 많아지고 차지하는 메모리도 많아진다.
	// count 변수를 하나 선언하고 할당 연산자(+=)를 사용하면 코드도 간결해지고 변수 양도 줄어든다.
	public static int positive(int num1) {
		
		int count = 0;
		count += num1 > 0 ? 1 : 0;
		return count;
	}
	
	public static int positive(int num1, int num2) {
		
		int count = 0;
		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;
		return count;
	}
	
	public static int positive(int num1, int num2, int num3) {
		
		int count = 0;
		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;
		count += num3 > 0 ? 1 : 0;
		return count;
	}
	
	public static int positive(int num1, int num2, int num3, int num4) {
		
		int count = 0;
		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;
		count += num3 > 0 ? 1 : 0;
		count += num4 > 0 ? 1 : 0;
		return count;
	}
	
	public static int positive(int num1, int num2, int num3, int num4, int num5) {
		
		int count = 0;
		count += num1 > 0 ? 1 : 0;
		count += num2 > 0 ? 1 : 0;
		count += num3 > 0 ? 1 : 0;
		count += num4 > 0 ? 1 : 0;
		count += num5 > 0 ? 1 : 0;
		return count;
	}

}
