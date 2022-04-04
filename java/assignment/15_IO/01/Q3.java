package com.test.java.io.question;

import java.io.File;
import java.util.Scanner;

public class Q3 {
	
	// 요구사항: 지정한 파일을 다른 폴더로 이동하고, 이동한 파일과 동일한 파일명의 파일이 존재하는 경우 중복 처리하시오.
	
	// D:\class\java\file\AAA\test.txt → D:\class\java\file\BBB\test.txt 로 이동하는 것이 목적
	// BBB 폴더에 이미 test.txt가 있을 경우 덮어쓰거나(y) 작업을 취소(n) 하시오.
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		String originPath = "D:\\suea7\\class\\java\\file\\aaa\\test.txt"; // 지정 파일 경로
		String destPath = "D:\\suea7\\class\\java\\file\\bbb\\test.txt"; // 이동할 파일 경로
		
		// 각 객체 생성
		File originFile = new File(originPath);
		File newFile = new File(destPath);
		
		if (originFile.exists()) {
			
			System.out.println("파일 이동을 실행합니다.");
			boolean res = originFile.renameTo(newFile);
			
			if (res == false) { // 이동 실패의 경우
				
				System.out.print("같은 이름을 가지는 파일이 이미 존재합니다. 덮어쓸까요? (y/n) ");
				String answer = scanner.nextLine();
				
				if (answer.equals("y") || answer.equals("Y")) {
					
					newFile.delete(); // 이동할 경로의 파일 삭제
					originFile.renameTo(newFile); // 파일 이동
					
				} else if(answer.equals("n") || answer.equals("N")) {
					System.out.println("작업을 취소합니다.");
					return;
					
				} else {
					System.out.println("다시 입력해주세요.");
				}
				
			}
			
		} else {
			System.out.println("이동할 파일이 존재하지 않습니다.");
		}
		
	}
	
}
