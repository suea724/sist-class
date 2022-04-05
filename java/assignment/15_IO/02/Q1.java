package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Q1 {
	
	// 특정 이름을 찾아 다른 이름으로 변환 후 파일을 다른 이름으로 저장하시오.
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\이름수정.dat";
		final String NEW_PATH = "D:\\suea7\\class\\파일_입출력_문제\\이름수정_변환.dat";
		
		try {
			
			// 읽을 파일
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			// 출력할 파일
			File newFile = new File(NEW_PATH);
			BufferedWriter writer = new BufferedWriter(new FileWriter(newFile));
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				writer.write(line.replace("유재석", "메뚜기"));
			}
			
			reader.close();
			writer.close();
			
			// 덮어쓰기
			file.renameTo(newFile);
			file.delete();
			
			System.out.println("변환 후 다른 이름으로 저장하였습니다.");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
