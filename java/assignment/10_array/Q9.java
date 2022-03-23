package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9 {
	
	// 배열의 요소를 순차적으로 2개씩 더한 결과를 배열로 생성한 뒤 출력하시오.

	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("배열 길이: ");
		int length = Integer.parseInt(reader.readLine());

		int[] randomArr = randomArr(length);
		
		System.out.println("원본: " + dump(randomArr));
		System.out.println("결과: " + dump(sumArr(randomArr)));
		
	}

	// 길이를 입력받아 난수 배열 반환하는 함수 (원본 배열)
	public static int[] randomArr(int length) {

		int[] arr = new int[length];
		
		for (int i = 0 ; i < arr.length ; i ++) {
			// 1 ~ 9 랜덤 숫자 배열
			arr[i] = (int)(Math.random() * 9) + 1;
		}
		
		return arr;
		
	}
	
	// 결과 배열
	public static int[] sumArr(int[] arr) {
		
		// 길이가 짝수일 때
		if (arr.length % 2 == 0) {
			
			int[] res = new int[arr.length / 2];
			
			// 루프 변수 두개 선언, i는 마지막 원소까지 2씩 증가, j는 1씩 증가
			for(int i = 0, j = 0 ; i < arr.length-1 ; i += 2) {
				
				res[j++] = arr[i] + arr[i+1];
			}
			
			return res;
			
			
		// 길이가 홀수일 때
		} else {
			
			// 결과 배열은 원본 배열 길이의 반 + 1
			int[] res = new int[arr.length / 2 + 1];
			
			// i는 마지막 전전 원소까지 2씩 증가
			
			/**
			 * for (int i = 0 ; i < arr.length i ++) {
			 * 		arr[i] = arr[2 * i] + arr[2 * i + 1];
			 * }
			 * 
			 * 루프 변수 두개를 사용하지 않고 하나만 사용해서 건너뛰는 방법도 있다. 
			 */
			
			for(int i = 0, j = 0 ; i < arr.length-2 ; i += 2) {
				
				res[j++] = arr[i] + arr[i+1];
				
				// j가 마지막 요소일 때 원본 인덱스의 값 복사
				if (j == arr.length / 2) {
					res[j] = arr[arr.length-1];
				}
			}
			return res;
		}
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
