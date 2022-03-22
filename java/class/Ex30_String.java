package com.test.java;

public class Ex30_String {

	public static void main(String[] args) {

		/**
		 * 1. 메모리의 공간은 한번 할당되면 더이상 늘리거나 줄일 수 없다.
		 * 2. 문자열은 불변이다 > 한번 만들어진 문자열을 절대 수정할 수 없다.
		 * 3. 문자열은 참조형이다.
		 */

		// m1();
		m2();

	}

	private static void m2() {

		// String vs StringBulider : 문자열

		String s1 = "홍길동"; // 문자열 리터럴 사용할 수 있음
		// String s1 = String("홍길동");

		StringBuilder s2 = new StringBuilder("홍길동");


		// StringBuilder: 기존의 String에 비해 수정하기 용이함
		
		// 일반적인 문자열은 String 사용
		// 하드한 수정작업은 StringBuilder 사용
		
		long begin = System.nanoTime();
		
		String txt1 = "홍길동";
		
		for (int i = 0 ; i < 100000 ; i ++) {
			txt1 += "."; // 수정작업
		}
		
		long end = System.nanoTime();
		
		System.out.println(txt1.length());
		System.out.println(end-begin); // 5280909100ns
		
		System.out.println();
		
		begin = System.nanoTime();
		
		StringBuilder txt2 = new StringBuilder("홍길동");
		
		for (int i = 0 ; i < 100000 ; i ++) {
			txt2.append("."); // 가비지 발생 안함
		}
		
		end = System.nanoTime();
		
		System.out.println(txt2.length());
		System.out.println(end-begin); // 2104500ns 속도 매우 빠름
		
		
	}

	private static void m1() {
		// 모든 값형은 어떤 데이터를 넣더라도 공간의 크기가 불변이다.

		int n1 = 10; // 4byte
		int n2 = 20; // 4byte

		n1 = 1000000000; // 4byte

		String s1 = "홍길동";
		String s2 = "아무개";

		s1 = "홍길동안녕하세요."; // 메모리 주솟값이 교환됨

		// 코드상의 모든 문자열 리터럴은 메모리(힙)에 새로 생성된다.
		s1 = "참";

		/**
		 * 자바 자료형
		 * 1. 값형
		 * - 값이 변경되어도 공간의 크기는 변화가 없음
		 * 2. 참조형
		 * - 값이 변경되면 공간의 크기 변함
		 * => 면접 질문으로 나올 수 있음
		 */

		int a = 10; // 4byte
		int b = 20; // 4byte
		int c = 30; // 4byte

		int[] alist = new int[3]; // 12byte
		int[] blist = new int[5]; // 20byte
		int[] clist = new int[10]; // 40byte

		// 같은 지역(메서드)에 한해 같은 리터럴은 새로 만들지 않고 재사용함 => 문자열 공간을 효율적으로 사용
		String m1 = "홍길동";
		String m2 = "홍길동";
		String m3 = "홍길동";

		m1 = "홍길남";
		// m2, m3에는 반영되지 않음

		/* 문자열을 대상으로 피해야 하는 행동 */
		// 1. 문자열의 잦은 수정
		// 2. 큰 문자열의 수정

		String txt1 = "홍길동";

		// 누적 > 계속 새로운 문자열이 생기고 참조가 끊기고 다시 연결되는 과정이 반복
		// 참조가 끊기면 남은 문자열은 garbage로 남음
		// 자바 VM에 있는 garbage collector가 일정 주기로 메모리에서 안쓰는 데이터를 비움
		// 하지만 프로그램이 무거워질 수 있음
		for (int i = 0; i < 100; i++) {
			txt1 = txt1 + "님";
		}

		System.out.println(txt1);
	}

}
