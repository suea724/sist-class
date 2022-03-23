package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4 {
	
	// 요구사항: 파일명 10개를 입력받아 각 확장자별로 총 개수를 출력하시오. (대소문자 구분없이)
	
	/**
	 * 1. 제한된 확장자 리스트를 배열에 담아놓는다.
	 * 2. 사용자의 입력을 10번 받아 배열에 담아 놓는다. (ToLowerCase() 사용)
	 * 3. count 변수 (또는 배열?)를 선언해 각 확장자의 갯수를 저장한다.
	 * 4. 출력
	 */
	
	public static void main(String[] args) throws Exception {
		
		int[] exCount = new int[5]; // 각 확장자 갯수 저장
		String[] files = new String[10]; // 입력받은 파일 저장
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0 ; i < 10 ; i ++) {
			System.out.print("파일명: ");
			files[i] = reader.readLine();
		}
		
		for (int i = 0 ; i < files.length ; i ++) {
			
			/**
			 * - split()을 사용할 수도 있지만 배열을 하나 더 선언해야 하는 불편함이 있음
			 */
			// beginIndex "." 다음부터, 소문자로 비교
			switch (files[i].substring(files[i].lastIndexOf(".") + 1).toLowerCase()) {
				
				case "mp3":
					exCount[0] += 1;
					break;
				case "jpg":
					exCount[1] += 1;
					break;
				case "java":
					exCount[2] += 1;
					break;
				case "hwp":
					exCount[3] += 1;
					break;
				case "doc":
					exCount[4] += 1;
					
			}
		}
		
		System.out.printf("mp3: %d개\n", exCount[0]);
		System.out.printf("jpg: %d개\n", exCount[1]);
		System.out.printf("java: %d개\n", exCount[2]);
		System.out.printf("hwp: %d개\n", exCount[3]);
		System.out.printf("doc: %d개\n", exCount[4]);
		
	}
}
