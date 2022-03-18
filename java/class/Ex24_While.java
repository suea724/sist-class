package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Ex24_While {

	public static void main(String[] args) throws Exception {

		// m1();
		// m2();
		// m3();
		// m4();
		m5();
	}

	private static void m5() {
		
		int num = 100;
		
		do {
			System.out.println(num);
			num ++;
			
		} while (num < 10);
	}

	private static void m4() throws Exception {

		// 프로젝트 적용
		// 루프 : 메뉴 출력 > 선택 > 실행 > 다시 메뉴로 돌아가기
		// 학생 관리 시스템

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		boolean loop = true;
		while (loop) {

			System.out.println("========================");
			System.out.println("	학생 관리 시스템");
			System.out.println("========================");
			System.out.println("1. 학생 등록하기");
			System.out.println("2. 학생 목록보기");
			System.out.println("3. 학생 성적처리");
			System.out.println("4. 학생 상담일지");
			System.out.println("5. 프로그램 종료");
			System.out.print("선택: ");

			String sel = reader.readLine();

			switch (sel) {

				case "1":
					System.out.println("학생 등록하기");
					break;
				case "2":
					System.out.println("학생 목록보기");
					break;
				case "3":
					System.out.println("학생 성적처리");
					break;
				case "4":
					System.out.println("학생 상담일지");
					break;
				default:
					loop = false;
			}

		}
	}

	private static void m3() {

		// 구구단

		int dan = 5;
		int n = 1;

		while (n <= 9) {
			System.out.printf("%d X %d = %d\n", dan, n, dan * n);
			n++;
		}

	}

	private static void m2() {

		// 누적

		// 1 ~ 100 사이의 값 누적하기

		int sum = 0;
		int n = 1;

		while (n <= 100) {

			sum += n;

			n++;
		}

		System.out.println(sum);

	}

	private static void m1() {

		// 요구사항: 1 ~ 10까지 출력

		int num = 1; // 초기식

		while (num <= 10) { // 조건식
			System.out.println(num++); // 증감식
		}
	}

}
