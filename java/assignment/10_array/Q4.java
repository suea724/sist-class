package com.test.java.question.array;

public class Q4 {
	
	// 요구사항: 1~20 사이의 난수를 담고 있는 배열을 생성하고 최대값과 최소값을 출력하시오.
	
	public static void main(String[] args) {
		
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
		// 배열 정렬
		bubbleSortArr(randArr);
		
		// 맨 앞에 있는 수는 최솟값, 맨 뒤에 있는 수는 최댓값
		System.out.printf("최댓값: %d\n", randArr[randArr.length-1]);
		System.out.printf("최솟값: %d\n", randArr[0]);
		
	}
	
	// 오름차순 버블 정렬
	public static int[] bubbleSortArr(int[] arr) {
		
		for (int i = 0 ; i < arr.length-1 ; i ++) {
			
			for (int j = 0 ; j < arr.length-i-1 ; j ++) {
				
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1]; 		
					arr[j+1] = temp;		
				}
			}
		}
		return arr;
	}

}
