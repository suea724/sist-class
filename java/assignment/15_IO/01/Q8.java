package com.test.java.io.question;

import java.io.File;

public class Q8 {
	
	// 요구사항: 내용물이 있는 'delete' 폴더를 삭제하시오.
	
	static int fileCnt = 0;
	static int dirCnt = 0;
	
	public static void main(String[] args) {
		
		final String PATH =  "D:\\suea7\\class\\파일_디렉토리_문제\\폴더 삭제";
		
		File dir = new File(PATH);
		
		if (dir.exists()) {
			countFiles(dir);
		} else {
			System.out.println("올바르지 않은 경로입니다.");
		}
		
	}

	private static void countFiles(File dir) {
		
		File[] list = dir.listFiles();
		 
		for (File f : list) {
			
			if (f.isDirectory()) { // 폴더일 경우 재귀호출
				
				countFiles(f);
				f.delete(); // 재귀함수 풀릴때 제거
				dirCnt ++;
				
			} else {
				f.delete();
				fileCnt ++;
			}
		}
	}

}
