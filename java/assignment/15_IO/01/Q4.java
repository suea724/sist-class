package com.test.java.io.question;

import java.io.File;

public class Q4 {
	
	// 요구사항: 음악 파일이 100개 있다. 파일명 앞에 일련 번호를 붙이시오.
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_디렉토리_문제\\음악 파일";
		
		File dir = new File(PATH);
		 
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (int i = 0 ; i < list.length ; i ++) {
				
				String serialNum = String.format("[%03d]", i+1); // 3자리 형식 시리얼 넘버
				File newFile = new File(PATH + "\\" + serialNum + list[i].getName()); // 같은 Path에 시리얼 넘버가 붙은 파일 객체 생성
				list[i].renameTo(newFile);
			}
			
		} else {
			System.out.println("올바르지 않은 경로입니다.");
		}
	}

}
