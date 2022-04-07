package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

public class Dummy {

	public static void main(String[] args) {
		
		try {
			// 데이터 생성용
			//createStudent();
			createScore();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void createStudent() throws Exception {
		
		// 학생.txt 구조
		// 번호, 이름, 나이, 성별, 주소
		// 1,홍길동,15,서울시 강남구 역삼동
		
		Random rnd = new Random();
		// System.out.println(rnd.nextInt(10) + 1); // 1~10
		
		// 파일 경로가 올바르게 작성된건지 확인
		File file = new File(DataPath.STUDENT);
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.STUDENT));
		
		int size = 20;
		
		String[] name1 = {"김","이","박","최","안","한","고","정"};
		String[] name2 = {"수","권","원","미","성","진","은","희","효","준","재","아","유"};
		String[] address1 = {"경기도","서울시","부산시","제주시","대구시"};
		String[] address2 = {"군포시","강동구","중구","은평구","강북구"};
		String[] address3 = {"역삼동","대치동","압구정동","등촌동","도마교동"};
 		
		for (int i = 0 ; i < size ; i ++) {
			
			int seq = i + 1;
			String name = name1[rnd.nextInt(name1.length)]
					+ name2[rnd.nextInt(name2.length)]
					+ name2[rnd.nextInt(name2.length)];
			
			int age = rnd.nextInt(3) + 14;
			int gender = rnd.nextInt(2) + 1;
			
			String address = address1[rnd.nextInt(address1.length)]
					+ " "
					+ address2[rnd.nextInt(address1.length)]
					+ " "
					+ address3[rnd.nextInt(address2.length)]
					+ " "
					+ (rnd.nextInt(30) + 1) + "번지";
			
			writer.write(String.format("%d,%s,%d,%d,%s\n",
											seq,
											name,
											age,
											gender,
											address));
		}
		
		writer.close();
		
		System.out.println("생성 완료");
		
	}

	private static void createScore() throws Exception {
		
		// 학생 20명 > 성적 3회 분량
		
		Random rnd = new Random();
		String temp = "";
		
		for (int i = 0 ; i < 3 ; i ++) {
			
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.STUDENT));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String seq = line.split(",")[0];
				
				int kor = rnd.nextInt(51) + 50;
				int eng = rnd.nextInt(51) + 50;
				int math = rnd.nextInt(51) + 50;
				
				temp += String.format("%s,%d,%d,%d\n", seq,kor,eng,math);
			}
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.SCORE));
		writer.write(temp);
		writer.close();
		
	}

}
