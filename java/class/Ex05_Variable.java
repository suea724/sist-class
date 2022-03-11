package com.test.java;

public class Ex05_Variable {
	
	public static void main(String[] args) {
		
		// 정수
		byte b1;
		b1 = 10;
		
		b1 = 127;
//		b1 = 128;

		b1 = -128;
//		b1 = -129;
		
		b1 = Byte.MAX_VALUE;
		System.out.println(b1);
		
		b1 = Byte.MIN_VALUE;
		System.out.println(b1);
		
		short s1;
		s1 = Short.MAX_VALUE;
		System.out.println(s1);
		
		s1 = Short.MIN_VALUE;
		System.out.println(s1);
		
		int n1;
		n1 = Integer.MAX_VALUE;
		System.out.println(n1);
		
		n1 = Integer.MIN_VALUE;
		System.out.println(n1);
		
		long l1;
		l1 = Long.MAX_VALUE;
		System.out.println(l1);
		l1 = Long.MIN_VALUE;
		System.out.println(l1);
		
		l1 = 2300000000L;	// 21억(int의 범위)을 넘으면 Long형 리터럴로 대입
		l1 = 10L; 			// int 범위의 리터럴을 Long형으로 선언하는 것은 자유
		
		// 실수
		float f1;
		f1 = 3.14f;
		System.out.println(f1);
		
		double d1;
		d1 = 3.14;
		System.out.println(d1);
		
		f1 = 123.1234567890123456789012345678901234567890f;	// 소수 이하 5자리
		d1 = 123.1234567890123456789012345678901234567890d;	// 소수 이하 14자리
		
		System.out.println(f1);
		System.out.println(d1);
		
		f1 = 123456789012345678901234567890123456789f;
		d1 = 123456789012345678901234567890123456789f;
		System.out.println(f1);
		System.out.println(d1);
		
		char c1;
		c1 = 'A';
		System.out.println(c1);
	
		
	}

}
