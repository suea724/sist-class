package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex21_Switch {

	public static void main(String[] args) throws Exception {

		// m1();
		// m2();
		// m3();
		m4();

	}

	private static void m1() {

		// 요구사항 : 숫자를 1개 입력받아 한글로 출력하시오
		int num = 3;

		// if문으로 구현
		// 매번 조건을 만족하는 상황 검사
		if (num == 1) {
			System.out.println("하나");
		} else if (num == 2) {
			System.out.println("둘");
		} else if (num == 3) {
			System.out.println("셋");
		} else {
			System.out.println("나머지 숫자");
		}


		// switch문으로 구현
		// 조건으로 값을 사용
		// 조건값과 같은 값을 가지는 case로 점프
		// 조건: 값 > 정수, 문자열, 열거형 (enum)
		switch (num) {
			case 1: // Label(위치를 표시)
				System.out.println("하나");
				break;
			case 2:
				System.out.println("둘");
				break;
			case 3:
				System.out.println("셋");
				break;
			default:
				System.out.println("나머지 숫자");
				break;
		}

	}

	private static void m2() throws Exception {

		// 요구사항 : 자판기
		// 메뉴 출력 > 음료 선택 > 가격 출력

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("====================");
		System.out.println("         자판기");
		System.out.println("====================");
		System.out.println("1. 콜라");
		System.out.println("2. 사이다");
		System.out.println("3. 비타 500");
		System.out.println("--------------------");
		System.out.print("선택(번호 입력): ");

		String sel = reader.readLine();

		// if (sel.equals("1")) {
		// System.out.println("800원입니다.");
		// } else if (sel.equals("2")) {
		// System.out.println("700원입니다.");
		// } else if (sel.equals("2")) {
		// System.out.println("500원입니다.");
		// }
		//
		// switch (sel) {
		// case "1":
		// System.out.println("700원입니다.");
		// break;
		// case "2":
		// System.out.println("600원입니다.");
		// break;
		// case "3":
		// System.out.println("500원입니다.");
		// break;
		// }

		// 만약 콜라와 사이다의 가격이 꼭 같아야 한다면?

		if (sel.equals("1") || sel.equals("2")) {
			System.out.println("800원입니다.");
		} else if (sel.equals("3")) {
			System.out.println("500원입니다.");
		}

		switch (sel) {
			case "1": // 제어가 아래로 내려가서 case "2"의 break문 만나면 나감
			case "2":
				System.out.println("800원입니다.");
				break;
			case "3":
				System.out.println("500원입니다.");
				break;
		}
	}

	private static void m3() throws Exception {

		// 요구사항 : 사용자가 월을 입력하면 해당 월의 마지막 일을 구하시오.

		int lastDay = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("월 입력 : ");
		String month = reader.readLine();

		switch (month) {

			case "1":
			case "3":
			case "5":
			case "7":
			case "8":
			case "10":
			case "12":
				lastDay = 31;
				break;
			case "4":
			case "6":
			case "9":
			case "11":
				lastDay = 30;
				break;
			case "2":
				lastDay = 28;
				break;
		}

		System.out.printf("입력한 %s월의 마지막 날짜는 %d일입니다. ", month, lastDay);
	}

	public static void m4() throws Exception {

		// 요구사항 : 인터넷 쇼핑몰 > 상품 구매 > 옵션(패키지)
		// 1. 노트북 + 메모리카드 + 마우스패드
		// 2. 노트북 + 메모리카드
		// 3. 노트북

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("선택 : ");
		
		String input = reader.readLine();
		
		// 유지 보수시 편리!
		switch(input) {
			case "1": 
				System.out.println("마우스패드");
			case "2":
				System.out.println("메모리카드");
			case "3":
				System.out.println("노트북");
				break;
		}

	}


}
