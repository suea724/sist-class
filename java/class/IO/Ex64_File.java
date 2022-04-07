package com.test.java.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex64_File {

	public static void main(String[] args) {
		
		/**
		 * 자원의 경로 표현법
		 * 1. 절대 경로
		 * 	- 기준점 : 절대 위치
		 * 	- e.g. A5열에 앉아 있는 사람
		 * 	- C:\class:\java\data.txt > 드라이브로부터 시작
		 * 
		 * 2. 상대 경로
		 * 	- 기준점 : 상대 위치
		 * 	- e.g. 내 앞에 앉아 있는 사람
		 * 	- .\data.txt > .(현재 위치)으로 시작 
		 * 
		 * 파일 수정하기(****)
		 * 	- 파일 입출력(스트림)에는 수정이라는 행동이 없음
		 * 	- 덮어쓰기로 구현한다.
		 */
		
		// m1();
		// m2();
		// m3();
		m4();
	}

	private static void m4() {
		
		// readLine를 통한 프로그램과 데이터 파일 간 교환 시, 시간 오래걸림 (CPU,메모리 <-> HDD)
		// ArrayList를 통해 데이터에 접근하면, 시간 매우 빠름 (메모리 <-> 메모리)
		// => 데이터 파일을 읽어 조작하는 작업이 많은 경우, readline을 처음에 한번만 사용하여 ArrayList에 담아놓고 조작하는 것이 훨씬 효율적이다!
		
		ArrayList<User> list = new ArrayList<>();
		
		// Call by reference > 참조형 객체의 주소가 넘어감
		load(list);
		
		for(User user : list) {
			System.out.printf("%s. %s(%s세)\n"
								, user.getId()
								, user.getName()
								, user.getAge());
		}
		
		System.out.println();
		
		for(User user : list) {
			
			if(user.getAge() >= 22) {
				System.out.printf("%s. %s(%s세)\n"
									, user.getId()
									, user.getName()
									, user.getAge());
			}
		}
		
		// 데이터 수정
		// - 나이가 많은 사람을 표시
		// - 홍길동 > 홍길동(*)
		for(User user : list) {
			
			if(user.getAge() >= 22) {
				user.setName(user.getName() + "(*)");
			}
		}
		
		// 데이터 삭제
		list.remove(2);
		
		// 메모리(배열) > 텍스트 파일(디스크) 반영
		save(list);
		
	}

	private static void save(ArrayList<User> list) {
		
		try {
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.MEMBER));
			
			for (User user : list) {
				
				String str = String.format("%s,%s,%d\n", user.getId(), user.getName(), user.getAge());
				writer.write(str);
			}
			
			writer.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void load(ArrayList<User> list) { // 얕은 복사
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				String id = temp[0];
				String name = temp[1]; 
				int age = Integer.parseInt(temp[2]);  
				
				User user = new User(id, name, age);
				list.add(user);
			}
			reader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		try {
			
			// 데이터 파일 구조 > Scheme(스키마)
			// 1,홍길동,20 > 번호, 이름, 나이 > CSV
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
			}
			
			// System.out.println(reader.readLine()); // EOF > null
			
			reader.close();
			System.out.println();
			
			// 22살 이상 회원만 출력
			
			// 스트림 객체 다시 생성 > 생성 직후 커서는 BOF에 위치
			reader = new BufferedReader(new FileReader(Data.MEMBER));
			
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				
				if (Integer.parseInt(temp[2]) >= 22) {
					System.out.printf("%s. %s(%s세)\n", temp[0], temp[1], temp[2]);
				}
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		// 파일 수정
		// 1. 기존 내용 출력 > 읽기
		// 2. 내용의 일부 수정
		// 3. 저장
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader(Data.EDIT));
			
			// 현재 내용 출력
			System.out.println("[현재 내용]");
			
			String line = null;
			
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			
			reader.close();
			
			// 수정할 내용 입력받음
			Scanner scanner = new Scanner(System.in);
			
			System.out.println("[수정 내용]");
			String input = scanner.nextLine();
			
			// 덮어쓰기
			BufferedWriter writer = new BufferedWriter(new FileWriter(Data.EDIT));
			
			writer.write(input);
			writer.close();
			
			System.out.println("수정 완료");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {
		
		// 읽고 쓰는 파일의 위치
		// 1. 프로젝트 폴더 외부
		// 2. 프로젝트 폴더 내부 > 관리 용이
		
		try {
			
			File file = new File(".\\data\\data.txt"); // 현재 폴더(프로젝트 루트) > 상대 경로 > .\\ 생략 가능!
			
			System.out.println(file.getAbsolutePath()); // 절대 경로
			System.out.println(file.getPath());	// File 생성 때 입력한 path 그대로 출력
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			writer.write("테스트");
			
			writer.close();
			
			System.out.println("종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class User {
	
	private String id;
	private String name;
	private int age;
	
	public User(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, age=%s]", id, name, age);
	}
	
}