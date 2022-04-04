package com.test.java.io.question;

import java.io.File;
import java.util.Scanner;

public class Q2 {
	
	// 요구사항: 지정한 폴더의 특정 파일(확장자)만을 출력하시오.
	// 조건: 확장자 대소문자 구분없이 검색 가능
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("폴더: ");
		String path = scanner.nextLine();
		
		System.out.print("확장자: ");
		String inputExtension = scanner.nextLine(); // 입력받은 확장자
		
		File dir = new File(path);
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File f : list) {
				String fileExtension = f.getName().substring(f.getName().lastIndexOf('.') + 1); // 파일의 확장자
				
				if (inputExtension.toUpperCase().equals(fileExtension.toUpperCase())) { // 대문자로 만들고 비교
					System.out.println(f.getName());
				}
				
			}
			
		} else {
			System.out.println("올바르지 않은 폴더 경로입니다.");
		}
		
	}

}
