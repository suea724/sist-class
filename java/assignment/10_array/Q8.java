package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8 {
	
	// 배열의 요소를 삭제하시오.

	public static void main(String[] args) throws Exception {

		int[] arr = {5, 6, 1, 3, 2, 8, 7, 4, 10, 9};
//		int[] arr = {5, 6, 1, 3, 2, 0, 0, 0, 0, 0};

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("삭제 위치: ");
		int index = Integer.parseInt(reader.readLine());

		System.out.println("원본: " + dump(arr));
		System.out.println("결과: " + dump(deleteElementArr(arr, index)));

	}

	/**
	 * shift 하는 방법이 흔한 방법이지만, 삭제할 위치부터의 값을 복사하여 다른 배열에 복사해놓고 입력하는 방법도 있다!
	 */
	public static int[] deleteElementArr(int[] arr, int index) {

		// 마지막 원소 바로 앞부터 값이 제거될 자리까지 뒤 값을 앞자리에 넣음 (left shift)
		for (int i = index ; i < arr.length-1; i ++) {
			
			arr[i] = arr[i+1];
			
			// 마지막 바로 앞 요소면 다음 값에 0 -> 그냥 마지막 요소에 0으로 초기화해주면 됨
			if(i == arr.length - 2) {
				arr[i+1] = 0;
			}

		}

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
