package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q11 {

	// 요구사항: 입력받은 문장에서 숫자를 찾아 그 합을 구하시오.
	// 조건: 모든 숫자는 한자리 숫자로 처리한다.
	
	public static void main(String[] args) throws Exception {
		
		int sum = 0; // 누적 변수
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String input = reader.readLine();
		
		for (int i = 0 ; i < input.length() ; i ++) {
			
			// 문장의 각 문자 코드 비교
			if (input.charAt(i) >= '0' && input.charAt(i) <= '9') {
				// substring으로 문자열로 추출한뒤 parseInt (charAt 사용 시 코드값 더함)
				sum += Integer.parseInt(input.substring(i, i+1));
			}
		}
		
		System.out.printf("문장에 존재하는 모든 숫자의 합은 %s입니다.\n", sum);
		
	}

}
