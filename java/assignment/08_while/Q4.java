package com.test.java.question.whileloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4 {

	// 요구사항: 최대 9자리 정수를 입력받아 각자리의 홀수 숫자합과 짝수 숫자합을 구하시오.

	public static void main(String[] args) throws Exception {

		int num = 1;
		int oddSum = 0;
		int evenSum = 0;

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 입력: ");
		int inputNum = Integer.parseInt(reader.readLine());

		// 9자리까지
		while (num <= 9) {

			// 각 자릿수의 숫자 구하기 단계
			// inputNum % Math.pow(10, num)로 첫번째 자리에 각 자리의 숫자가 오도록 조정 -> 일의 자리부터 원래 숫자까지
			// 9자리 미만의 숫자가 들어오면 나머지 자리는 0
			// 각각 x.xxx 형태의 double로 만들어서 int로 변환 (소수점 버림)
			int digit = (int) (inputNum % Math.pow(10, num) * Math.pow(10, 1 - num));
			System.out.println(digit);

			 if (digit % 2 == 0) {
			 evenSum += digit;
			 } else {
			 oddSum += digit ;
			 }
			
			num++;
		}

		System.out.printf("짝수 합: %d\n", evenSum);
		System.out.printf("홀수 합: %d\n", oddSum);

	}

}
