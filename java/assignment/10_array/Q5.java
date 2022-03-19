package com.test.java.question.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {

	// 요구사항: 1~20 사이의 난수를 담고 있는 배열을 생성하고 배열을 탐색하여 범위를 만족하는 숫자만 출력
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 범위: ");
		int max = Integer.parseInt(reader.readLine());
		
		System.out.print("최소 범위: ");
		int min = Integer.parseInt(reader.readLine());
		
		int[] randArr = new int[20];
		String result = "원본: ";
		
		// 20개의 난수 생성해서 배열에 저장
		for(int i = 0 ; i < 20 ; i ++) {
			
			randArr[i] = (int)(Math.random() * 20) + 1;
			
			// 마지막 수 일때 문자열 연산안하고 break
			if (i == randArr.length-1) {
				result += randArr[i];
				break;
			}
			result += randArr[i] + ", ";
		}
		
		System.out.println(result);
		findElement(randArr, max, min);
		
	}
	
	// 범위 안에 있는 숫자 출력
	public static void findElement(int[] arr, int max, int min) {
		
		String result = "결과: ";
		
		for (int i = 0 ; i < arr.length ; i ++) {
			
			// 범위 사이의 값이면
			if (arr[i] >= min && arr[i] <= max) {
				
				result += arr[i] + ", ";
			}
		}
		
		System.out.println(result + "\b\b");
	}
	
}
