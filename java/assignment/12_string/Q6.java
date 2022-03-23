package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {
	
	// 요구사항: 주민 등록 번호 유효성 검사를 하시오.
	// 조건: '-'의 입력 유무 상관없이 검사하시오.
	// 앞번호: 년 월 일 뒷번호: 홀수 - 남자, 짝수 - 여자(0~9), **마지막 숫자는 가상(계산) **
	// 마지막 번호: 유효 번호
	// 1. 각 번호에 2,3,4,5,6,7,8,9,2,3,4,5,6 를 곱해서 다 더함
	// 2. 11로 나눈 나머지를 11에서 뺌..
	// 나머지가 0이거나 1인경우에는? 11 -> 1, 10 -> 0
	// 일단 문제풀때는 유효 번호만 검사하깅..
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("주민등록번호: ");
		String regNum = reader.readLine();
		
		if (regNum.contains("-")) { // 하이픈 포함한 경우
			
			if (regNum.length() != 14) { // 길이가 14자리가 아닌 경우 예외처리
				System.out.println("길이가 올바르지 않은 주민등록번호입니다.");
				
			} else {
				regNum = regNum.split("-")[0] + regNum.split("-")[1]; // 하이픈 제외 주민등록번호 합치기
				checkValidation(regNum);
			}
			
		} else { // 하이픈 포함하지 않은 경우
			
			if (regNum.length() != 13) {
				System.out.println("길이가 올바르지 않은 주민등록번호입니다.");
			} else {
				checkValidation(regNum);
			}
		}
	}

	private static void checkValidation(String regNum) {
		
		int temp = 0;
		
		for (int i = 0 ; i < 12 ; i ++) { // 각 번호에 곱해서 더한 값 **12자리까지!**
			
			if (i >= 0 && i < 8) {
				temp += Integer.parseInt(regNum.substring(i, i + 1)) * (i + 2) ; // 2 ~ 9
			}
			else {
				temp += Integer.parseInt(regNum.substring(i, i + 1)) * (i - 6) ; // 2 ~ 6
			}
		}
		
		int rem = 11 - (temp % 11);
		temp = (rem == 11) ? 1 : rem == 10 ? 0 : rem;
		
		if (Integer.parseInt(regNum.substring(regNum.length()-1)) == temp) { // 주민번호 마지막 숫자 연산값과 비교
			System.out.println("올바른 주민등록번호입니다.");
		} else {
			System.out.println("올바르지 않은 주민등록번호입니다.");
		}
	}
}
