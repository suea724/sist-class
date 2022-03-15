package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {

	// 요구사항 : 학생의 국어 점수를 입력받아 성적을 출력하시오.
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("점수 : ");
		int score = Integer.parseInt(reader.readLine());
			
		if (score >= 0 && score <= 100) {
			
			if (score >= 90) {
				System.out.printf("입력한 %d점은 성적 %c입니다.", score, 'A');
			} else if (score >= 80 && score <= 89) {
				System.out.printf("입력한 %d점은 성적 %c입니다.", score, 'B');
			} else if (score >= 70 && score <= 79) {
				System.out.printf("입력한 %d점은 성적 %c입니다.", score, 'C');
			} else if (score >= 60 && score <= 69) {
				System.out.printf("입력한 %d점은 성적 %c입니다.", score, 'D');
			} else {
				System.out.printf("입력한 %d점은 성적 %c입니다.", score, 'F');
			}
			
		} else {
			System.out.println("점수가 올바르지 않습니다. 0~100 사이의 값을 입력하시오.");
		}
		
	}

}
