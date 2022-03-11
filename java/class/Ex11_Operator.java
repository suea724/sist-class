package com.test.java;

public class Ex11_Operator {
	
	public static void main(String[] args) {
		
		/**
		 * 산술 연산자
		 */
		int a = 10;
		int b = 3;
		
		System.out.printf("%d + %d = %d\n", a, b, a + b);
		System.out.printf("%d - %d = %d\n", a, b, a - b);
		System.out.printf("%d * %d = %d\n", a, b, a * b);
		System.out.printf("%d / %d = %d\n", a, b, a / b);
		System.out.printf("%d %% %d = %d\n", a, b, a % b);
		
		System.out.println(10 / 3);			// int / int = int
		System.out.println(10.0 / 3.0);		// double / double = double
		System.out.println(10.0 / 3);		// double / int = double
		System.out.println(10 / 3.0); 		// int / double = double
		
		int c = 1000000000;
		int d = 2000000000;
		
		// 에러가 안나서 더 위험함..
		System.out.println(c + d);
		System.out.println((long)c + d);
		
		byte b1 = 10;
		byte b2 = 20;
		
		// byte, short의 연산 결과는 int
		byte b3 = (byte)(b1 + b2);
		
		System.out.printf("%d > %d = %b\n", a, b, a > b);
		System.out.printf("%d >= %d = %b\n", a, b, a >= b);
		
		System.out.printf("%d <= %d = %b\n", a, b, a <= b);
		System.out.printf("%d < %d = %b\n", a, b, a < b);
		
		System.out.printf("%d == %d = %b\n", a, b, a == b);
		System.out.printf("%d != %d = %b\n", a, b, a != b);
		
		boolean f1 = false;
		boolean f2 = true;
		
		System.out.println(f1 || f2);
		System.out.println(f1 && f2);
		
		// 연산의 진행방향, 우선순위
		System.out.println(100 + 200 + 300);		// 600
		System.out.println(100 + 200 + "300");		// 300300
		System.out.println(100 + "200" + 300);		// 100200300
		System.out.println("100" + 200 + 300);		// 100200300
		System.out.println("100" + (200 + 300));	// 100500
		
		/**
		 * 비교연산자
		 */
		int num1 = 100;
		int num2 = 100;
		int num3 = 200;
		int num4 = 50;
		num4 += 50;
		
		String name1 = "홍길동";
		String name2 = "홍길동";
		String name3 = "아무개";
		String name4 = "홍";
		name4 += "길동";
		
		System.out.println(num1 == num2);
		System.out.println(num2 == num3);
		System.out.println(num1 == num4);
		System.out.println();
		
		System.out.println(name1 == name2);
		System.out.println(name2 == name3);
		System.out.println(name4);
		System.out.println(name1 == name4); 		// 문자열 비교(==) : false
		System.out.println(name1.equals(name4)); 	// 문자열 비교(equals) : true
		System.out.println(!name1.equals(name4)); 	// 문자열 비교(not equals) : false
		
		System.out.println();
		
		/**
		 *  증감 연산자
		 */
		int n = 10;
		int result = 10 + ++n; 			// 가독성 낮음
		
		System.out.println(result);		// result = 21, n = 11
		
		n = 10;
		result = 10 + n++;				// 가독성 낮음
		System.out.println(result);		// result = 20, n = 10
		System.out.println(n);			// n = 11
		
		// 가독성 더 높은 표현 방법 : 한줄에 다른 연산자와 사용하지 않는 것이 좋음
		n = 10;

		n++;
		result = 10 + n;
		
		result = 10 + n;
		n++;
		
		/**
		 *  조건 연산자
		 */
		boolean flag = false;
		int num = flag ? 10 : 20;
		System.out.println(num);
		
		int age = 25;
		String str = age > 19 ? "통과" : "거절";
		System.out.println(str);
		
		String color = "노랑";
//		color = "주황"; 			// 재고 없음
		String fresult = (color.equals("검정") || color.equals("노랑") || color.equals("파랑")) ? "재고 있음" : "재고 없음";
		System.out.println(fresult);
		
		n = 10;
		
		System.out.println(n % 2 == 0 ? "짝수" : "홀수");
	}

}
