package com.test.java;

public class Ex09_Casting {
	
	public static void main(String[] args) {
		
		byte b1;	// 1칸
		short s1;	// 2칸
		
		b1 = 10;
		s1 = b1; 	// s1 = (short) b1;
		
		System.out.println(s1);
		
		byte b2;	// 1칸
		short s2;	// 2칸
		
		s2 = 128;
		b2 = (byte)s2;	
		
		System.out.println(b2);
		
		int n1 = 1000;
		float n2;
		
		n2 = n1; 	// 암시적 형변환
		System.out.println(n2);
		
		n1 = (int)n2;	// 명시적 형변환 : float 범위 > int 범위 (불안전)
		
		char c1;
		short r1;
		
		c1 = 'A';
		r1 = (short)c1;
		System.out.println(r1);
		
		char c2= (char)r1;
		System.out.println(c2);
		
		char c3;
		int a3;
		
		c3 = 'A';
		a3 = c3;
		
		System.out.println(a3);
		
		c3 = (char)a3;
		System.out.println(c3);
		
		char c4 = '가';
		short r4;
		
		r4 = (short)c4;
		System.out.println(r4);
		
		int a4 = (int)c4;
		System.out.println(a4);
		
		// 알파벳 대문자
		System.out.println((int)'A');	// 65
		System.out.println((int)'Z');	// 65 + 25 = 90
		
		// 알파벳 소문자
		System.out.println((int)'a');	// 97
		System.out.println((int)'z');	// 97 + 25 = 122
		
		// 숫자
		System.out.println((int)'0');	// 48
		System.out.println((int)'1');	// 49
		System.out.println((int)'9');	// 57
		
		// 한글(가~힣)
		System.out.println((int)'가');
				
	}

}
