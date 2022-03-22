package com.test.java;

public class Ex28_Array {

	public static void main(String[] args) {

		// 다차원 배열
		// 1차원 배열 -> 선형
		// 2차원 배열 -> 테이블 형태(행렬)
		// 3차원 배열 -> 테이블이 여러개 쌓여있는 모습

		// m1();
		// m2();
		// m3();
		m4();

	}

	private static void m4() {
		
		// 문제 설명
		// 5 X 5 2차원 배열
		// n은 인덱스 접근 순서
		
		int[][] nums = new int[5][5];
		int n = 1;
		
		// 데이터 입력 > 문제의 요구 사항에 따라 수정 i, j, n
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				nums[i][j] = n;
				n++;
			}
		}
		
		// 데이터 출력 > 수정 금지
		for (int i = 0 ; i < 5 ; i ++) {
			for (int j = 0 ; j < 5 ; j ++) {
				System.out.printf("%5d", nums[i][j]);
			}
			System.out.println();
		}
	}

	private static void m3() {

		/* 배열 검색 -> 반환값 : boolean, index */

		String[] member = {"홍길동", "유재석", "박나래", "정형돈", "박명수", "노홍철", "하하"};

		// 변수 값의 초기값은 실패하거나 아무일도 일어나지 않았을 때의 값을 두는 것이 좋음
		// 피해가 가장 적을 값
		boolean result = false;
		String search = "하하";

		for (int i = 0; i < member.length; i++) {
			if (member[i].equals(search)) {
				result = true;
				break; // 요소 찾고 나서 불필요한 회전 중단
			}
		}

		if (result) {
			System.out.println(search + " 발견!");
		} else {
			System.out.println(search + " 없음..");

		}

		int index = -1; // 0은 인덱스가 가질 수 있는 값이므로 절대 가질 수 없는 음수값을 넣음

		for (int i = 0; i < member.length; i++) {
			if (member[i].equals(search)) {
				index = i;
				break; // 요소 찾고 나서 불필요한 회전 중단
			}
		}

		System.out.println(search + "의 위치: " + index);

		search = "박명수";
		System.out.println(contains(member, search));
		System.out.println(indexOf(member, search));

	}

	// 메서드로 빼는 행위: 단위화, 모듈화, 기능화 -> 가독성, 재사용성
	public static boolean contains(String[] arr, String search) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(search)) {
				return true; // 메서드 자체를 탈출
			}
		}

		return false;

	}

	public static int indexOf(String[] arr, String search) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(search)) {
				return i;
			}
		}

		return -1;

	}

	private static void m2() {

		/* 다차원 배열의 초기화 리스트 */

		// 2차원 배열
		int[][] nums2 = {{10, 20, 30}, {40, 50, 60}};

		// 3차원 배열
		int[][][] nums3 = {{{10, 20, 30}, {40, 50, 60}}, {{10, 20, 30}, {40, 50, 60}}}; // 가독성 별로

	}

	private static void m1() {

		// 1차원 배열
		int[] nums1 = new int[3];

		// 2차원 배열 (테이블 구조) -> 인덱스 두개 필요
		int[][] nums2 = new int[2][3]; // 2행, 3열 (차원이 높을 수록 먼저옴)

		// 3차원 배열
		int[][][] nums3 = new int[2][2][3]; // 2면, 2행, 3열

		// 배열 요소 접근
		// 1차원 배열
		nums1[0] = 100;
		nums1[1] = 200;
		nums1[2] = 300;

		// 2차원 배열
		nums2[0][0] = 100;
		nums2[0][1] = 200;
		nums2[0][2] = 300;
		nums2[1][0] = 400;
		nums2[1][1] = 500;
		nums2[1][2] = 600;

		// 3차원 배열
		nums3[0][0][0] = 100;
		nums3[0][0][1] = 200;
		nums3[0][0][2] = 300;

		nums3[0][1][0] = 400;
		nums3[0][1][1] = 500;
		nums3[0][1][2] = 600;

		nums3[1][0][0] = 700;
		nums3[1][0][1] = 800;
		nums3[1][0][2] = 900;

		nums3[1][1][0] = 1000;
		nums3[1][1][1] = 1200;
		nums3[1][1][2] = 1300;

		/**
		 * 배열 탐색 (+조작)
		 * 1차원 배열 > 단일 for문
		 * 2차원 배열 > 2중 for문
		 * 3차원 배열 > 3중 for문
		 */

		// 1차원 배열
		for (int i = 0; i < nums1.length; i++) {
			System.out.printf("nums1[%d] = %d\n", i, nums1[i]);
		}

		System.out.println();

		// 2차원 배열
		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 3; j++) {
				// System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
				System.out.printf("%5d", nums2[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		for (int i = 0; i < nums2.length; i++) {

			for (int j = 0; j < nums2[0].length; j++) {
				// System.out.printf("nums2[%d][%d] = %d\n", i, j, nums2[i][j]);
				System.out.printf("%5d", nums2[i][j]);
			}
			System.out.println();
		}

		System.out.println();

		// 3차원 배열
		for (int i = 0; i < 2; i++) {

			for (int j = 0; j < 2; j++) {

				for (int k = 0; k < 3; k++) {

					// System.out.printf("nums3[%d][%d][%d] = %d\n", i, j, k, nums3[i][j][k]);
					System.out.printf("%5d", nums3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}

		for (int i = 0; i < nums3.length; i++) {

			for (int j = 0; j < nums3[0].length; j++) {

				for (int k = 0; k < nums3[0][0].length; k++) {

					// System.out.printf("nums3[%d][%d][%d] = %d\n", i, j, k, nums3[i][j][k]);
					System.out.printf("%5d", nums3[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}

		/* 다차원 배열의 길이 */

		// 2차원 배열
		System.out.println(nums2.length); // 행의 갯수
		System.out.println(nums2[0].length); // 열의 갯수

		System.out.println();

		// 3차원 배열
		System.out.println(nums3.length); // 면의 갯수
		System.out.println(nums3[0].length); // 행의 갯수
		System.out.println(nums3[0][0].length); // 열의 갯수
	}

}
