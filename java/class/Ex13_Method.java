package com.test.java;

public class Ex13_Method {

	public static void main(String[] args) {
		
		hello("홍길동");
		hello("아무개");
		
		System.out.println(getNum());
		checkAge(20);
		System.out.println(checkAge2(10));
		
		score(100, 100, 100);
		
		checkNumber(10);
		checkNumber(-5);
		
	}
	
	public static void hello(String name) {
		System.out.println( name + "님 안녕하세요.");
	}
	
	public static void checkAge(int age) {
		
		String result = age >= 19 ? "성인" : "미성년자";
		System.out.printf("%d세는 %s 입니다.\n", age, result);
	}
	
	public static String checkAge2(int age) {
		return (age >= 19) ? "성인" : "미성년자";
	}
	
	// 팀 작업시 사용할 수 있는 주석
	
	/**
	 * 성적을 처리합니다. 
	 * @param kor 국어
	 * @param eng 영어
	 * @param math 수학
	 */
	
	public static void score(int kor, int eng, int math) {
		
		System.out.println("국어 : " + kor);
		System.out.println("영어 : " + eng);
		System.out.println("수학 : " + math);
		System.out.println("총점 : " + (kor + eng + math));
	}
	
	public static void checkNumber(int num) {
		
		String result = num > 0 ? "양수" : num < 0 ? "음수" : "0";	// 3항 연산자 한줄에 여러 조건 포함 가능
		System.out.printf("%d = %s\n", num, result);
	}
	
	public static int getNum() {
		return 10;
	}

}

