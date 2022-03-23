package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9 {
	
	// 요구사항: 금지어를 마스킹 처리 하시오.
	// 금지어 : 바보, 멍청이
	// 금지어 글자수에 따라 마스킹 문자 입력
	
	public static void main(String[] args) throws Exception {
		
		String[] forbidden = {"바보", "멍청이"};
		String[] masking = {"**", "***"};
		int idx = -1;
		int cnt = 0;
		String res = ""; // 문자열 임시 저장 변수
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String input = reader.readLine();
		res = input;
		
		for (int i = 0 ; i < forbidden.length ; i ++) {
			
			idx = input.indexOf(forbidden[i]); // 금지어 인덱스
			
			if (idx == -1) { // 금지어가 없을 때
				break;
			}
			
			while (idx > -1) { // 금지어 없을 때까지 마스킹 & 횟수 세기
				
				idx = input.indexOf(forbidden[i], idx + forbidden[i].length()-1);
				res = res.replace(forbidden[i], masking[i]); 
				cnt ++; 
			}
		}
		
		System.out.println(res);
		System.out.printf("금지어를 %d회 마스킹했습니다.\n", cnt);
		
	}
}
