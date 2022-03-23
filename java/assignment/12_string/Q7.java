package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {
	
	// 요구사항: 숫자를 입력받아 3자리마다 , 를 붙이시오.
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자: ");
		String input = reader.readLine();
		
		// 결과 출력할 StringBuilder
		StringBuilder res = new StringBuilder();
		
		// 배열 길이: 숫자의 길이를 3으로 나눈 몫 + 나머지가 1 또는 2일때 1을 더함
		String[] temp = new String[input.length() / 3 + ((input.length() % 3 >= 1) ? 1 : 0)];
		
		// i: 문자열 인덱스, j: 배열 인덱스
		// 뒤에서부터 세칸씩 자름
		for (int i = input.length(), j = 0 ; i > 0 ; i -= 3, j ++) { 
			
			// 앞에 숫자 하나 또는 두개가 남는 경우
			if (i > 0 && i < 3) {
				temp[j] = input.substring(0, i);
			} else { // 세칸씩 잘라 배열에 입력
				temp[j] = input.substring(i-3,i);
			}
		}
		
		// 역순으로 배열 요소 결과 문자열에 더하기 
		for (int i = temp.length - 1 ; i >= 0 ; i --) {
			
			res.append(temp[i]);
			
			if (i == 0) {
				break;
			}
			res.append(",");
		}
		
		System.out.println(res);
	}
}
