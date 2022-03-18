package com.test.java;

public class Ex25_NestedLoop {

	public static void main(String[] args) {

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		m6();

	}

	private static void m6() {
		
		// 별찍기
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 점점 감소
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = i ; j < 5 ; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 점점 증가
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j <= i ; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		// 오른쪽에 붙은 별
		for (int i = 0 ; i < 5 ; i ++) {
			
			for (int j = 0 ; j < 4-i ; j++) {
				System.out.print(" ");
			}
				
			
			for (int j = 0 ; j <= i ; j ++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		
	}

	private static void m5() {

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {

				// break, continue는 자신이 직접 포함된 제어문만 탈출
				if (j == 5) {
					break;
				}
				System.out.printf("i: %d, j: %d\n", i, j);
			}
		}
	}

	private static void m4() {

		for (int i = 2; i <= 9; i++) {
			System.out.printf("====%d단=====\n", i);

			for (int j = 1; j <= 9; j++) {
				System.out.printf("%d X %d = %d\n", i, j, i * j);
			}
		}
	}

	private static void m3() {

		// 지역 변수 : 메서드와 *제어문* 내에서 선언한 변수

		if (true) {
			int a = 10;
			System.out.println(a);
		}

		if (true) {
			int a = 10;
			System.out.println(a);
		}

	}

	private static void m2() {

		// 학교 (학년도 추가 가능)
		for (int i = 1; i <= 10; i++) {
			for (int j = 1; j <= 30; j++) {
				System.out.printf("%d반 %d번 학생\n", i, j);
			}
		}

	}

	private static void m1() {

		// 3중 for문
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					System.out.printf("i: %d, j: %d, k: %d\n", i, j, k);
				}
			}
		}

	}



}
