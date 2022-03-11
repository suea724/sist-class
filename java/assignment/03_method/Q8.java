package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 : 사과 나무가 있다. 사과 나무 씨앗을 심을 날로부터 특정 시간이 흘렀을 때 사과 총 몇개가 열리는지 구하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 맑은 날과 흐린 날의 수를 입력받는 메서드를 정의한다.
		 * 2. 맑은 날의 수와 맑은 날 사과나무 성장률을 곱하고, 흐린날에는 흐린날의 성장률을 곱해 사과나무의 길이를 구한다.
		 * 3. 사과나무의 길이가 1m이상이 되면 1을 빼고 10으로 나눠 사과의 갯수를 구한다. > 삼항 연산자, / 사용
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("맑은 날 : ");
		int sunnyDays = Integer.parseInt(reader.readLine());
		
		System.out.print("흐린 날 : ");
		int foggyDays = Integer.parseInt(reader.readLine());
		
		System.out.printf("사과가 총 %d개 열렸습니다.", getApple(sunnyDays, foggyDays));
		
	}
	
	public static int getApple(int sunny, int foggy) {
		
		int treeLength = (sunny * 5) + (foggy * 2);
		int countApple = (treeLength < 100) ? 0 : (treeLength - 100)/10;
		
		return countApple;
	}

}
