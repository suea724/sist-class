package com.test.java.question.multidimensionarray;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {

	public static void main(String[] args) throws Exception {
		
		String[][] score = new String[10][3];
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("국어 점수: ");
		int korScore = Integer.parseInt(reader.readLine());
		System.out.print("수학 점수: ");
		int mathScore = Integer.parseInt(reader.readLine());
		System.out.print("영어 점수: ");
		int engScore = Integer.parseInt(reader.readLine());
		
		// 각 점수가 유효하면
		if (isScoreValid(korScore, engScore, mathScore)) {
			
			scoreGraph(score, korScore,0);
			scoreGraph(score, mathScore,1);
			scoreGraph(score, engScore,2);
			
			// 출력
			printGraph(score);
			
		} else { // 점수가 유효하지 않으면
			System.out.println("점수는 0과 100 사이의 값을 가져야 합니다.");
		}
			
	}

	// 배열 출력부
	private static void printGraph(String[][] score) {
		
		for (int i = 0 ; i < 10 ; i ++) {
			
			for (int j = 0 ; j < 3 ; j ++) {
				
				System.out.print(score[i][j]);
			}
			System.out.println();
		}
		System.out.println("국어\t영어\t수학");
	}

	// 
	private static void scoreGraph(String[][] score, int subjectScore, int colNum) {
		
		for (int i = 0 ; i < 10 - subjectScore/10 ; i ++) {
			score[i][colNum] = "\t";
		}
		
		for (int i = 0 ; i < subjectScore/10 ; i ++) {
			score[9-i][colNum] = " ■\t";
		}
	}
	
	public static boolean isScoreValid(int kor, int eng, int math) {
		
		boolean isKorNotValid = kor < 0 || kor > 100; 
		boolean isEngNotValid = eng < 0 || eng > 100; 
		boolean isMathNotValid = math < 0 || math > 100; 
		
		if (isKorNotValid || isEngNotValid || isMathNotValid) {
			return false;
		} 
		
		return true;
	}
}
