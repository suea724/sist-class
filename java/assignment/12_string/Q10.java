package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q10 {
	
	// 요구사항: 입력받은 금액을 한글로 출력하시오.
	// 조건: 입력 범위(원): 0 ~ 99,999,999
	// 숫자를 몇번째 자리에서 추출했는지 알아야 함
	// 배열써서 푸는 것이 쉬움
	
	public static void main(String[] args) throws Exception {
		
		String[] units = {"만", "천", "백", "십"};
		StringBuilder res = new StringBuilder();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("금액(원): ");
		String input = reader.readLine();
		
		for (int i = 0 ; i < input.length() ; i ++) {
			
			res.append(numToKor(input.charAt(i)));
			
			// 뒤에서부터 인덱스 0, 1, 2 .. 증가
			switch ((input.length()-1-i) % 4) {
				
				case 0:
					res.append(units[0]);
					break;
				case 3:
					res.append(units[1]);
					break;
				case 2:
					res.append(units[2]);
					break;
				case 1:
					res.append(units[3]);
					break;
					
			}
		}
		
		res.replace(res.length()-1, res.length(), "원"); // 마지막 자리 replace
		System.out.printf("일금 %s\n", res);
	}
	
	public static String numToKor(char c) {
		
		if (c >= '1' && c <= '9') {
			
			switch (c) {
				case '1':
					return "일";
				case '2':
					return "이";
				case '3':
					return "삼";
				case '4':
					return "사";
				case '5':
					return "오";
				case '6':
					return "육";
				case '7':
					return "칠";
				case '8':
					return "팔";
				default:
					return "구";
			}
			
		} else {
			return "";
		}
		
	}

}
