package com.test.java.lambda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class Ex73_Lambda {

	public static void main(String[] args) {
		
		// 익명 객체 활용하는 곳 == 람다식 활용하는 곳
		
		Random rnd = new Random();
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		for(int i = 0 ; i < 10 ; i ++) {
			nums.add(rnd.nextInt(20) + 1);
		}
		
		System.out.println(nums);
		
		/* 오름차순 정렬 */
		
		// Comparator 익명 객체 사용
		nums.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
		});
		System.out.println(nums);

		// 람다식 사용
		nums.sort((o1, o2) -> o2 - o1);
		System.out.println(nums);
		
		
		try {
			
			BufferedReader reader = new BufferedReader(new FileReader("data\\user.txt"));
			
			ArrayList<User> list = new ArrayList<>();
			String line = null;
			
			// 자바의 데이터 타입 > Strong Type > 엄격한 자료형 사용
			while((line = reader.readLine()) != null) {
				
				String[] temp = line.split(",");
				String[] ctemp = temp[4].split("-");
				
				Calendar c = Calendar.getInstance();
				
				c.set(Integer.parseInt(ctemp[0])
						,Integer.parseInt(ctemp[1])
						,Integer.parseInt(ctemp[2]));
				
				User user = new User(temp[0]
						, temp[1]
						, Integer.parseInt(temp[2])
						, temp[3]
						, c);
				
				list.add(user);
			}
			System.out.println(list);
			
			// 8개의 객체 > 정렬!
			Collections.sort(nums); // ArrayList<Integer>
			// Collections.sort(list); // ArrayList<User> 비교 기준이 없음
			
			// 람다식으로 Comparator 구현해주기
			// 객체 배열 > 숫자 멤버 정렬
			list.sort((u1, u2) -> u2.getAge() - u1.getAge());
			System.out.println(list);
			
			// 객체 배열 > 문자 멤버 정렬
			list.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
			System.out.println(list);
			
			// 객체 배열 > 날짜 멤버 정렬
			list.sort((u1, u2) -> u1.getHireDate().compareTo(u2.getHireDate()));
			System.out.println(list);
			
			// 객체 배열 > 직급 정렬(부장 - 차장 - 과장 - 대리 - 사원) => Comparator 따로 구현해야 함
//			list.sort((u1, u2) -> {
//				if (u1.getPosition().equals("부장") && u2.getPosition().equals("차장")) {
//					return -1;
//				} else if (u1.getPosition().equals("부장") && u2.getPosition().equals("과장")) {
//					return -1;
//				}
//			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

class User {
	
	private String seq;
	private String name;
	private int age;
	private String position;
	private Calendar hireDate;
	
	public User(String seq, String name, int age, String position, Calendar hireDate) {
		this.seq = seq;
		this.name = name;
		this.age = age;
		this.position = position;
		this.hireDate = hireDate;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
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

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return String.format("[seq=%s, name=%s, age=%s, position=%s, hireDate=%tF]\n", seq, name,
				age, position, hireDate);
	}
	
}