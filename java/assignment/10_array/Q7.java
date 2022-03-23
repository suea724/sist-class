package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {
	
	// 배열에 요소를 삽입하시오.

	public static void main(String[] args) throws Exception {

		int[] arr = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
//		int[] arr = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삽입 위치: ");
		int index = Integer.parseInt(reader.readLine());
		System.out.print("값: ");
		int value = Integer.parseInt(reader.readLine());

		System.out.println("원본: " + dump(arr));
		System.out.println("결과: " + dump(insertElement(arr, index, value)));

	}

	/**
	 * shift 하는 방법이 흔한 방법이지만, 삽입할 위치부터의 값을 복사하여 다른 배열에 복사해놓고 입력하는 방법도 있다!
	 */
	public static int[] insertElement(int[] arr, int index, int value) {

		// 마지막 원소에서부터 값이 들어갈 자리 바로 뒤까지 앞 값을 자기 자리에 넣음 (right shift)
		for (int i = arr.length - 1; i > index; i --) {
			arr[i] = arr[i-1];
		}
		// 값 넣기
		arr[index] = value;

		return arr;
	}

	// dump 메서드
	public static String dump(int[] list) {

		String result = "[";

		for (int i = 0; i < list.length; i++) {

			if (i == list.length - 1) {
				result += list[i];
				break;
			}

			result += list[i] + ",";
		}

		result += "]";
		return result;
	}

}
