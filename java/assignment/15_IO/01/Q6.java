package com.test.java.io.question.q1;

import java.io.File;

public class Q6 {
	
	// 요구사항: 파일의 크기가 0byte인 파일만 삭제하시오.
	
	public static void main(String[] args) {
		
		int count = 0; // 누적 변수
		
		final String PATH = "D:\\suea7\\class\\파일_디렉토리_문제\\파일 제거";
		File dir = new File(PATH);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (int i = 0 ; i < list.length ; i ++) {
				
				if (list[i].length() == 0) { // 파일 길이가 0 이면
					list[i].delete();
					count ++;
				}
			}
			
			System.out.printf("총 %d개의 파일을 삭제했습니다.\n", count);
		}
	}

	
}
