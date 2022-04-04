package com.test.java.io.question;

import java.io.File;
import java.util.Scanner;

public class Q1 {
	
	// 요구사항: 파일의 경로를 입력받아 파일 정보를 출력하시오.
	// 조건: 파일 크기 단위 변환 출력(소수이하 1자리까지) : B, KB, MB, GB, TB
	
	public static void main(String[] args) {
		
		// D:\suea7\class\3조_코드리뷰.txt
		// D:\Program Files\TeamViewer\TeamViewer.exe
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("파일 경로: ");
		
		String path = scanner.nextLine();
		File file = new File(path);
		
		if (file.exists()) {
			
			String fileName = file.getName();
			String extension = fileName.substring(fileName.lastIndexOf('.')+1);
			long length = file.length();
			
			System.out.printf("파일명: %s\n", fileName);
			System.out.printf("종류: %s 파일\n", extension);
			System.out.printf("파일 크기: %s\n", getSize(length));
			
		} else {
			System.out.println("파일 경로가 올바르지 않습니다.");
		}
		
	}
	
	private static String getSize(long length) {
		
		int num = 0; // 루프 변수
		double temp = length;
		
		while (temp > 1024) {
			temp = temp / 1024.0;
			num ++; // 나눈 횟수만큼 카운트
		}
		
		switch(num) {
			
			case 0:
				return String.format("%.2fB", temp);
			case 1:
				return String.format("%.2fKB", temp);
			case 2:
				return String.format("%.2fMB", temp);
			case 3:
				return String.format("%.2fGB", temp);
			case 4:
				return String.format("%.2fTB", temp);
			default:
				return null;
			
		}
		
	}
	
}
