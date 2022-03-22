package com.test.java;

import java.util.Arrays;

public class Ex27_Array {

	public static void main(String[] args) {
		
		/**
		 * Array 정렬
		 */

		// m1();
		// m2();
		// m3();
		m4();
	}

	private static void m4() {
		
		// JDK 라이브러리가 제공해주는 메서드를 사용해서 정렬
		
		int[] nums = {5, 3, 1, 4, 2};
		String[] nameArr = {"유재석", "박명수", "하하", "정형돈", "노홍철"};
		
		// 오름차순 정렬
		
		System.out.println(Arrays.toString(nums));
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		System.out.println(Arrays.toString(nameArr));
		Arrays.sort(nameArr);
		System.out.println(Arrays.toString(nameArr));
		
	}

	private static void m3() {

		// 문자열 비교 정렬

		String[] nameArr = {"유재석", "박명수", "하하", "정형돈", "노홍철"};

		for (int i = 0; i < nameArr.length - 1; i++) {

			for (int j = 0; j < nameArr.length - 1 - i; j++) {

				// compareTo 메서드 사용
				if (nameArr[j].compareTo(nameArr[j + 1]) > 0) {

					String temp = nameArr[j];
					nameArr[j] = nameArr[j + 1];
					nameArr[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(nameArr));
	}

	private static void m2() {

		// 정렬
		// 1. 숫자 > 우위 비교
		// 2. 문자(열) > 문자 코드값으로 비교
		// 3. 날짜 > 과거 vs 미래 > tick

		String[] nameArr = {"유재석", "박명수", "하하", "정형돈", "노홍철"};

		// 참조형은 산술 연산자로 비교 불가 (주솟값끼리 연산 불가)
		// nameArr[0] > nameArr[1]
		System.out.println(nameArr[0].charAt(0));
		System.out.println(nameArr[1].charAt(0));
		System.out.println(nameArr[2].charAt(0));

		String name1 = "가가가";
		String name2 = "나나나";

		String result = "";

		for (int i = 0; i < 3; i++) {

			char c1 = name1.charAt(i);
			char c2 = name1.charAt(i);

			if (c1 < c2) {
				result = name1;
				break; // for문 탈출, 다음 글자는 비교할 필요 없음
			} else if (c1 < c2) {
				result = name2;
				break;
			}
		}

		System.out.println(result);

		// JDK 문자열 비교 메서드
		// 양수면
		System.out.println(name1.compareTo(name2));

	}

	private static void m1() {

		// 버블 정렬
		int[] nums = {5, 3, 1, 4, 2};
		int temp;

		// (갯수 - 1)번의 과정 필요
		for (int i = 0; i < nums.length - 1; i++) { // N Cycle

			for (int j = 0; j < nums.length - i - 1; j++) { // N Step

				if (nums[j] > nums[j + 1]) { // 오름차순
					// if (nums[j] < nums[j+1]) { 내림차순

					temp = nums[j];
					nums[j] = nums[j + 1];
					nums[j + 1] = temp;
				}

			}
			System.out.println(Arrays.toString(nums)); // 정렬중
		}

		System.out.println();
		System.out.println(Arrays.toString(nums)); // 정렬 후

	}

}
