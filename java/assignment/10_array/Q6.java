package com.test.java.question.array;

public class Q6 {
	
	// 요구사항: 중복되지 않는 임의의 숫자 6개를 만드시오.(로또)

	public static void main(String[] args) {
		
		long begin = System.nanoTime();
		
		// 길이가 6인 배열 선언
		int[] lottoArr = new int[6];
		
		// 랜덤 숫자 생성
		int randNum = (int)(Math.random() * 6) + 1;
		// 첫번째 요소에 랜덤 숫자
		lottoArr[0] = randNum;
		// 중복된 숫자가 있는지 확인하기 위한 변수
		boolean isDuplicate = false;
		
		// 1 ~ 배열의 길이만큼
		for (int i = 1 ; i < lottoArr.length ; i ++) {
			
			// 랜덤 숫자 생성
			randNum = (int)(Math.random() * 6) + 1;
			
			// i자리의 위치에 랜덤 숫자가 들어가도 될지 i-1부터 0까지 중복 검사
			
			/**
			 * - continue를 사용해도 루프 변수값은 증가하기 때문에 1을 빼주어야 해주어야 한다.
			 * - 랜덤한 수를 검사하고 요소 입력 부분에서 조건 처리를 해주어야 한다.
			 * - 몇번 실행되는지 정확하지 않을 때는 while문을 사용하는 것이 좋다.
			 */
			
//			for (int j = 0 ; j < i ; j ++) {
//				
//				// 중복된 값이 있으면
//				if (lottoArr[j] == randNum) {
//					randNum = (int)(Math.random() * 6) + 1;
//					i--;
//					continue;
//				} 
//			}
			
			for (int j = 0 ; j < i ; j ++) {
				
				// 중복된 값이 있으면
				if (lottoArr[j] == randNum) {
					isDuplicate = true;
					i--;
					break;
				} 
			}
			
			// 중복된 값이 없을 때에만 입력
			if (!isDuplicate) {
				lottoArr[i] = randNum;
			}
			
			// 초기화
			isDuplicate = false;
		}
		
		// 정렬 후 출력
		bubbleSort(lottoArr);
		System.out.println(dump(lottoArr));
		
		long end = System.nanoTime();
		System.out.println(end - begin);
	}
	
	public static String dump(int[] list) {
		
		String result = "[";
		
		for (int i = 0 ; i < list.length ; i ++) {
			
			if(i == list.length - 1) {
				result += list[i];
				break;
			}
			
			result += list[i] + ",";
		}
		
		result += "]";
		return result;
	}
	
	public static int[] bubbleSort(int[] arr) {
		
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
