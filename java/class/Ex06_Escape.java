package com.test.java;

public class Ex06_Escape {

	public static void main(String[] args) {
		
		String msg = "안녕하세요.\r홍길동";
		
		System.out.println(msg);
		
		System.out.println("하나\r\n둘\n셋");
		
		System.out.println("하나\t둘\t셋\t넷");
		
		System.out.println("홍길동: \"안녕하세요\"");
		
		int a = 10;
		int b = 20;
		
		System.out.printf("%d + %d = %d", a,b,a+b);
		
		
	}

}
