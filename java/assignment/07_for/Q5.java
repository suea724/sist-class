package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {
	
	// 요구사항 : 아래와 같이 출력하시오.
	// 입력 > 시작 숫자: 1 , 종료 숫자: 10
	// 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10 = 55

	public static void main(String[] args) throws Exception{
		
		// 누적 변수
		int sum = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시작 숫자 : ");
		int firstNum = Integer.parseInt(reader.readLine());

		System.out.print("종료 숫자 : ");
		int lastNum = Integer.parseInt(reader.readLine());
		
		// 빈 문자열 선언
		String str = "";
		
		// 반복문
		for (int i = firstNum ; i <= lastNum ; i ++) {
			
			sum += i;
			
			// lastNum이면 반복문 탈출
			if (i == lastNum) {
				break;
			}
			
			// lastNum 아니면 "+" 기호 문자열 연산
			str += i + " + ";
			
		}
		
		// 반복문 빠져나오면 결과 문자열 더해서 출력
		System.out.printf(str + "%d = %d", lastNum, sum);
		
	}

}
