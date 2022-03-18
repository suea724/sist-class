package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Ex22_For {

	public static void main(String[] args) throws Exception {

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		 m11();
	}

	private static void m11() {

		for (int i = 0; i < 10; i++) {
			// 곱한 수는 나올 수 있는 (최소값 + 최댓값 + 1)
			// 더한 값은 최소값
			// 3 ~ 9사이의 난수값
			int num = (int) (Math.random() * 7) + 3;
			System.out.println(num);
		}
	}

	private static void m10() {

		Calendar cal = Calendar.getInstance();
		cal.set(2020, 1, 1);

		int lastDay = cal.getActualMaximum(Calendar.DATE);

		for (int i = 1; i <= lastDay; i++) {
			System.out.printf("%d년 %d월 %d일\n", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1,
					cal.get(Calendar.DATE));

			cal.add(Calendar.DATE, 1);
		}

	}

	private static void m9() {

		// 2022년 3월 1일 ~ 3월 31일까지 날짜 + 요일 출력

		for (int date = 1; date <= 31; date++) {

			String day = getDay(date);

			System.out.printf("2022년 3월 %02d일 %s요일\n", date, day);
		}

	}

	private static String getDay(int date) {

		switch (date % 7) {

			case 1:
				return "화";
			case 2:
				return "수";
			case 3:
				return "목";
			case 4:
				return "금";
			case 5:
				return "토";
			case 6:
				return "일";
			default:
				return "월";
		}

	}

	private static void m8() throws Exception {

		// 요구사항 : 짝수만 누적
		int sum = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {

			System.out.print("숫자 입력 : ");
			int num = Integer.parseInt(reader.readLine());

			if (num == 0) {
				break;
			}

			if (num % 2 == 1) {
				continue;
			}

			sum += num;
		}
		System.out.println("최종 합 : " + sum);

	}

	private static void m7() throws Exception {

		// 요구사항 : 사용자 입력 숫자 > 누적 > 횟수를 사용자 마음대로
		int sum = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (;;) {

			System.out.print("숫자 입력 : ");
			int num = Integer.parseInt(reader.readLine());

			if (num == 0) {
				break;
			}

			sum += num;
		}
		System.out.println("최종 합 : " + sum);

	}

	private static void m6() {

		// 무한 루프
		// for (;;) {
		//
		// }

		// 무한 루프 + 루프 변수 활용
		// for (int i = 0; ; i++) {
		// System.out.println(i);
		// }

		// 엄밀히 따지면 int의 범위는 -21억까지므로 21억 바퀴 돌기 때문에 무한 루프는 아님
		// for (int i = 0; i < 10; i--) {
		// System.out.println("안녕하세요" + i);
		// }

		// 루프 탈출하는 방법
		for (int i = 1; i <= 10; i++) {

			System.out.println(i);

			if (i == 5) {
				break; // if문 제외한 나머지 제어문을 탈출하는 역할
			}

		}
		System.out.println();


		for (int i = 1; i <= 10; i++) {

			if (i == 5) {
				continue; // 하던 일을 멈추고 제어의 처음으로 돌아가세요 (증감문으로)
			}

			System.out.println(i);
		}

	}

	private static void m5() throws Exception {

		// 단을 입력받아서 그 단의 구구단 출력
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단 : ");
		int dan = Integer.parseInt(reader.readLine());

		for (int i = 1; i < 10; i++) {
			System.out.printf("%d X %d = %2d\n", dan, i, dan * i);
		}
		System.out.println();

	}

	private static void m4() throws Exception {

		// 요구사항 : 1 ~ 10까지의 합
		int sum = 0;

		for (int i = 1; i <= 10; i++) {
			sum += i;
		}

		System.out.println(sum);

		// 요구사항 : 사용자의 숫자를 입력받아 10번 더한 값 구하기

		sum = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {

			System.out.print("숫자 입력 : ");
			int inputNum = Integer.parseInt(reader.readLine());

			sum += inputNum;
		}

		System.out.println(sum);
	}

	private static void m3() {

		// 요구사항 : 숫자 1 ~ 10 출력
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1);
		}
		System.out.println();

		for (int i = 2; i < 10; i = i + 2) { // 10까지 2의 배수 출력
			System.out.println(i);
		}
		System.out.println();

		for (int i = 7; i <= 100; i += 7) { // 100까지 7의 배수 출력
			System.out.println(i);
		}
		System.out.println();
	}

	private static void m2() {

		for (int i = 3; i <= 7; i++) { // 5번 수행
			System.out.println("안녕하세요.");
		}

		for (int i = 10; i > 5; i--) { // 5번 수행
			System.out.println("실행문");
		}
	}

	private static void m1() {

		// 요구사항 : "안녕하세요" 5번 출력

		// i : 루프 변수
		// i = 0 : 초기식 > for문에 처음 진입할 때 단 1회만 실행
		// i < 5 : 조건식 (boolean) > 반복의 유무 결정
		// i ++ : 증감식 > 조건식의 변화 유발

		// 반복문 > loop (iteration)
		for (int i = 0; i < 5; i++) {
			System.out.println("안녕하세요.");
		}

	}



}
