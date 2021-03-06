package com.test.java.question.forloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {
	
	// 요구사항 : 아래와 같이 출력하시오.
	// 입력 > 시작 숫자: 1 , 종료 숫자: 10
	// 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10 = -5

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
		int flag = 1;
		
		// 반복문
		for (int i = firstNum ; i <= lastNum ; i ++) {
			
			// 마지막 숫자일 때 반복문 탈출. 아래 조건 검사 X
			if (i == lastNum) {
				
				// 마지막 숫자일때 홀수번째 숫자이면 lastNum을 더하고 짝수일때는 뺌
				sum += (flag == 1) ? lastNum : -lastNum ;
				str += i + " = ";
				break;
			}
			
			// 홀수번째 숫자일 때
			if (flag == 1) {
				
				sum += i;
				str += i + " - ";
				
			} else { // 짝수번째 숫자일 때
				
				sum -= i;
				str += i + " + ";
			}
			
			flag *= -1;
			
		}
			
		// 반복문 빠져나오면 결과 문자열 더해서 출력
		System.out.printf(str + "%d", sum);
		
	}

}
