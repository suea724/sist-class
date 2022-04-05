package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Q4 {
	
	// 이름을 입력받아 회원 정보를 검색 후 출력하시오.
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\단일검색.dat";
		
		try {
			
			// 읽을 파일
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// 찾을 이름 입력 받기
			Scanner scanner = new Scanner(System.in);
			System.out.print("입력: ");
			String inputName = scanner.nextLine();
			
			String line = null;
			boolean hasMember = false; // 검색 회원 존재 여부 체크
			
			while((line = reader.readLine()) != null) {
				
				if (line.contains(inputName)) { // 전체 라인 돌면서 검색된 이름 포함하면 로직 시작
					
					line = line.replace(", ", ","); // 콤마 뒤에 띄어쓰기 없도록
					
					String id = line.split(",")[0];
					String address = line.split(",")[2];
					String phoneNum = line.split(",")[3];
					
					System.out.printf("[%s]\n", inputName);
					System.out.printf("번호: %s\n", id);
					System.out.printf("주소: %s\n", address);
					System.out.printf("전화: %s\n", phoneNum);
					
					hasMember = true;
					break;
				}
			}
			
			if (!hasMember) { // 루프 다 돌고나서도 회원이 존재하지 않으면
				System.out.println(inputName + " 회원이 존재하지 않습니다.");
			}
			
			reader.close();
			scanner.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
