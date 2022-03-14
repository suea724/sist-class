package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q6 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 : 국어, 영어, 수학 점수를 전달하면 '합격' 혹은 '불합격'이라는 단어를 반환하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 세 점수를 매개변수로 받는 메서드를 정의한다.
		 * 2. 합격하기 위해서는 세 점수의 평균점수가 60점 이상인 동시에 모든 과목이 40점 이상이어야 하므로 
		 * 조건들을 and로 묶고, 삼항 연산자를 이용해 String으로 결과를 받는다.
		 * 3. 받은 결과를 반환한다.
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 : ");
		int korScore = Integer.parseInt(reader.readLine());

		System.out.print("영어 : ");
		int engScore = Integer.parseInt(reader.readLine());
		
		System.out.print("수학 : ");
		int mathScore = Integer.parseInt(reader.readLine());
		
		System.out.println(test(korScore, engScore, mathScore));
		
	}

	public static String test(int kor, int eng, int math) {
		
		int averageScore = (kor + eng + math) / 3;
		
		String fail = "불합격입니다.";
		String pass = "합격입니다.";
		
		// 조건 수정
		// 삼항 연산자 조건식 묶어서 사용하는 것이 가독성 측면에서 좋고, 연산식이 짧아짐
		String res = averageScore < 60 ? fail : (kor < 40 || eng < 40 || math < 40) ? fail : pass; 
		return res;
	}
}
