package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q2 {
	
	// 숫자를 한글로 바꾼 뒤 파일을 다른 이름으로 저장하시오.
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\숫자.dat";
		final String NEW_PATH = "D:\\suea7\\class\\파일_입출력_문제\\숫자_변환.dat";
		
		try {
			
			// 읽을 파일
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// 출력 파일
			File newFile = new File(NEW_PATH);
			BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				for (int i = 0 ; i < line.length() ; i ++) { // 각 문장 루프
					
					char c = line.charAt(i);
					
					if (containsNum(c)) { // 숫자를 포함하면
						line = line.replace(c, numToKor(c)); // 문자로 바꿔서 replace
					}
					
				}
				writer.write(line);
			}
			
			reader.close();
			writer.close();
			
			file.renameTo(newFile);
			// file.delete();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 숫자 포함 여부 체크
	private static boolean containsNum(char num) {
		
		switch(num) {
			
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				return true;
			default:
				return false;
				
		}
	}
	
	// 숫자를 문자로 변환
	private static char numToKor(char num) {
		
		switch(num) {
			
			case '0':
				return '영';
			case '1':
				return '일';
			case '2':
				return '이';
			case '3':
				return '삼';
			case '4':
				return '사';
			case '5':
				return '오';
			case '6':
				return '육';
			case '7':
				return '칠';
			case '8':
				return '팔';
			default:
				return '구';
		}
			
	}

}
