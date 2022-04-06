package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Q3 {
	
	// 성적을 확인 후 합격자/불합격자 명단을 출력하시오.
	// 합격 조건: 3과목 평균 60점 이상
	// 과락 조건: 1과목 40점 미만
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\성적.dat";
		ArrayList<String> pass = new ArrayList<>();
		ArrayList<String> fail = new ArrayList<>();
		
		// Set 차집합 사용할 수도 있돠
		
		try {
			
			// 읽을 파일
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				// 각 라인마다 콤마 기준 split으로 나누기
				String[] temp = line.split(",");
				
				String name = temp[0];
				int kor = Integer.parseInt(temp[1]);
				int eng = Integer.parseInt(temp[2]);
				int math = Integer.parseInt(temp[3]);
				
				int avg = (kor + eng + math) / 3;
				
				if (avg >= 60 && kor > 40 && eng > 40 && math > 40) {
					pass.add(name);
				} else {
					fail.add(name);
				}
			}
			
			reader.close();
			printResult(pass, fail);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printResult(ArrayList<String> pass, ArrayList<String> fail) {
		
		System.out.println("[합격자]");
		for (String name : pass) {
			System.out.println(name);
		}
		
		System.out.println();
		
		System.out.println("[불합격자]");
		for (String name : fail) {
			System.out.println(name);
		}
		
	}

}
