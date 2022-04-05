package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Ex63_File {

	public static void main(String[] args) {
		
		/**
		 * 1. 파일/디렉토리 조작
		 * 
		 * 2. 파일 입출력
		 * 	- 자바 프로그램 <-> 저장 장치 간 데이터 교환
		 * 	- 메모장
		 * 
		 * [저장 장치(HDD, SSD)]
		 * 	- 데이터를 1, 0으로 저장
		 * 	- 데이터의 자료형 존재 X
		 * 
		 * [인코딩, Encoding]
		 * 	- 문자 코드(응용 프로그램의 데이터)를 부호화(1,0) 시키는 작업
		 * 	- 자바 "홍길동" > 텍스트 파일 "1010100010010"
		 * 
		 * [디코딩, Decoding]
		 * 	- 부호 데이터를 문자코드를 변환하는 작업
		 *  - 텍스트 파일 "1010100010010" > 자바 "홍길동"
		 *  
		 * [인코딩/디코딩 규칙]
		 * 	- 저장 장치 또는 네트워크 상에서 데이터를 표현하는 규칙
		 * 	1. ISO-8859-1
		 *  2. EUC-KR
		 *  3. ANSI
		 *  4. MS949
		 *  5. UTF-8
		 *  6. UTF-16
		 *  
		 *  - ANSI(ISO-8859-1, EUC-KR, MS949) > 똑같은 규칙을 가짐
		 *   1) 영어(숫자, 특수문자, 서유럽문자): 1byte
		 *   2) 한글(한자, 일본어 등 영어가 아닌 문자): 2byte
		 *   
		 *  - UTF-8 >> **이 인코딩 사용 (국제 표준)**
		 *   1) 영어: 1byte
		 *   2. 한글: 3byte
		 *   
		 *  - UTF-16
		 *   1) 영어: 2byte
		 *   2) 한글: 2byte
		 *   
		 * [파일 입출력]
		 * 	- 파일 쓰기 객체 > FileWriter or BufferedWriter
		 * 	- 파일 읽기 객체 > BufferedReader
		 * 		=> 가장 Best
		 *  
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		m8();
	}

	private static void m8() {
		
		try {
			
			// 파일을 바로 읽지 않고 File 객체 생성
			File file = new File("D:\\suea7\\class\\java\\JavaTest\\src\\com\\test\\java\\Ex29_String.java");
			
			if (file.exists()) {
				
				BufferedReader reader = new BufferedReader(new FileReader(file));
				
				String line = "null";
				int n = 1; // 줄번호
				
				while ((line = reader.readLine()) != null) {
					System.out.printf("%03d: %s\n", n, line);
					n ++;
				}
				
				reader.close();
				
			} else {
				System.out.println("읽을 파일이 존재하지 않습니다.");
			}
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m8");
			e.printStackTrace();
		}
	}

	private static void m7() {
		
		// 파일 읽기
		
		try {
			
			BufferedReader reader 
				= new BufferedReader(new FileReader("D:\\suea7\\class\\java\\file\\TODO.txt"));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m7");
			e.printStackTrace();
		}
	}

	private static void m6() {
		
		// FileReader > 파일 입력 스트림 객체
		
		try {
			
			FileReader reader = new FileReader("D:\\suea7\\class\\java\\file\\TODO.txt");
			
			int code = -1;
			
			while((code = reader.read()) != -1) {
				System.out.print((char)code);
			}
			
			reader.close();
			
		} catch (Exception e) {
			System.out.println("Ex63_File.m6");
			e.printStackTrace();
		}
	}

	private static void m5() {
		
		// FileInputStream > 파일 입력 스트림 객체
		// 바이트 단위 입력 > 역시 한글 깨짐
		
		try {
			
			FileInputStream fis 
				= new FileInputStream("D:\\suea7\\class\\java\\file\\data.txt");
			
			// int code = fis.read();
			// System.out.println(code);
			//
			// code = fis.read();
			// System.out.println(code);
			
			int code = -1;
			
			while ((code = fis.read()) != -1) { // 한글자씩 읽음
				System.out.print((char)code);
			}
			
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m4() {
		
		// 파일 쓰기
		
		try {
			
			// 전용 도구
			// - 파일 대상 입출력 도구
			// - FileReader, FileWriter
			
			// 범용 도구
			//	- 설정에 따라 다양한 소스를 입출력할 수 있는 도구 > 콘솔, 파일, ..
			// 	- BufferedReader, BufferedWriter
			
			// 보조 스트림 > 사용법 통일
			BufferedWriter writer 
				= new BufferedWriter(new FileWriter("D:\\suea7\\class\\java\\file\\list.txt"));
			
			writer.write("안녕하세요.");
			writer.newLine();
			writer.write("홍길동입니다.");
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		// 메모장 쓰기 > 콘솔 버전
		
		try {
			
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("저장할 파일명: ");
			String fileName = scanner.nextLine();
			
			FileWriter writer 
				= new FileWriter("D:\\suea7\\class\\java\\file\\" + fileName + ".txt");
			
			boolean loop = true;
			
			while(loop) {
				
				System.out.print("입력: ");
				
				String line = scanner.nextLine();
				
				if (line.equals("exit")) {
					break;
				}
				writer.write(line + "\n");
			}
			
			// 자원 해제 코드, Clean-up Code
			scanner.close();
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		// FileWriter > 출력 스트림 객체
		
		try {
			
			FileWriter writer = new FileWriter("D:\\suea7\\class\\java\\file\\member.txt");
			
			writer.write("홍길동\n");
			writer.write("아무개\n");
			writer.write("하하하\n");
			
			// 스트림은 재사용할 수 없음 > 스트림이 닫히면 사용 불가
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {
		
		// 파일 입출력 > 스트림(도구) 생성 필요
		// 쓰기 > 파일 출력
		
		try {
			File file = new File("D:\\suea7\\class\\java\\file\\data.txt");
			
			// FileOutputStream > 출력 스트림 객체
			// 단점: 바이트 단위 쓰기(1 byte) > 한글 깨짐, 사용 불편
			
			// 1. 생성 모드(덮어쓰기), Create Mode > 훨씬 많이 사용!
			//	- *기본 방식*
			// 	- 파일이 존재하지 않으면 자동으로 생성함
			// 	- 항상 파일을 덮어쓰기 함
			
			// 2. 추가 모드, Append Mode
			//	- 스트림 객체 생성자에서 지정 > true
			//	- 파일이 존재하지 않으면 자동으로 생성함
			//	- 파일이 존재하면 기존 내용을 그대로 두고, 추가로 데이터 저장
			
			// 스트림 열기
			FileOutputStream fos = new FileOutputStream(file);
			// FileOutputStream fos = new FileOutputStream(file, true); > append mode
			
			fos.write(65); // 문자코드 값
			fos.write(66);
			fos.write(67);
			fos.write(68);
			fos.write(69);
			fos.write(70);
			fos.write(71);
			// fos.write('가'); > 한글은 3 byte > 깨짐!
			
			// 스트림 닫기
			// 안하면? > 저장이 안됨, 잠긴 파일이 됨 (사용 중인 상태로 남음)
			fos.close();
			
			System.out.println("종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
