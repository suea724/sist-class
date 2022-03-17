package com.test.java.question.loop;

public class Q7 {
	
	// 요구사항 : 누적값이 1000을 넘어가는 순간 루프를 종료하시오.

	public static void main(String[] args) {
		
		int sum = 0;
		int lastNum = 0;
		String str = "";
		
		for(int i = 1 ; ; i ++) {
			
			sum += i;
			
			// sum이 1000이 넘으면
			// i를 lastNum에 복사하고 반복문 탈출
			if (sum > 1000) {
				lastNum = i;
				break;
			}
			
			// sum이 1000이 넘지 않으면
			// 숫자와 "+" 기호 문자열 연산
			str += i + " + ";
		}

		// 반복문 빠져나오면 결과 문자열 추가해서 출력
		System.out.printf(str + "%d = %d", lastNum, sum);
	}

}
