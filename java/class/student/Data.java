package com.test.java.student;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

// 파일 데이터 <-> 메모리(배열)
public class Data {
	
	// 프로그램 전역에서 사용하게 될 자원은 static으로 선언하면 편리함
	public static ArrayList<Student> slist = new ArrayList<>();
	public static ArrayList<Score> clist = new ArrayList<>();
	
	public static void load() {
		
		try {
			
			// 학생.txt
			BufferedReader reader = new BufferedReader(new FileReader(DataPath.STUDENT));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				Student student = new Student(temp[0], temp[1], temp[2], temp[3], temp[4]);
				slist.add(student);
			}
			
			reader.close();
			
			// 성적.txt
			reader = new BufferedReader(new FileReader(DataPath.SCORE));
			
			line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				Score score = new Score(temp[0],
									Integer.parseInt(temp[1]),
									Integer.parseInt(temp[2]),
									Integer.parseInt(temp[3]));
				clist.add(score);
			}
			
			reader.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void save() {
		
		// 메모리 > 파일 데이터
		try {
			
			// slist > 학생.txt
			BufferedWriter writer = new BufferedWriter(new FileWriter(DataPath.STUDENT));
			
			for(Student s : slist) {
				String line = String.format("%s,%s,%s,%s,%s\n", s.getSeq()
															,s.getName()
															,s.getAge()
															,s.getGender()
															,s.getAddress());
				writer.write(line);
			}
			
			writer.close();
			
			// clist > 성적.txt
			writer = new BufferedWriter(new FileWriter(DataPath.SCORE));
			
			for(Score s : clist) {
				String line = String.format("%s,%d,%d,%d\n", s.getSeq()
														, s.getKor()
														, s.getEng()
														, s.getMath());
				writer.write(line);
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
