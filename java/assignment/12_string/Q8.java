package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8 {
	
	// 요구사항: 영단어를 입력받아 분리하시오.
	// 합성어를 입력한다.
	// 합성어는 파스칼 표기법으로 입력한다.
	// 출력은 각 단어를 공백으로 구분한다.
	
	public static void main(String[] args) throws Exception {
		
		// TODO 마지막 단어 처리

		StringBuilder res = new StringBuilder();
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("단어: ");
		String word = reader.readLine();
		
		int idx = 0; // 전 인덱스를 담을 변수
		
		for (int i = 1 ; i < word.length() ; i ++) {
			
			if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
				
				// lastIndexOf
				
				res.append(word.substring(idx, i) + " ");
				idx = i; // 이전 인덱스 저장
				
//				if (i == word.lastIndexOf(word.charAt(i))) {
//					System.out.println(i);
//				}
			}
		}
		
		System.out.println(res);
		
	}
}
