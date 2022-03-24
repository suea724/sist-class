package com.test.java.obj.access;

import java.util.Calendar;

public class Ex35 {

	public static void main(String[] args) {
		
		Person father = new Person();
		father.setName("홍기철");
		father.setAge(50);
		father.setGender("m");
		father.setBirthday(1960, 6, 10);
		
		Person mother = new Person();
		mother.setName("호호호");
		mother.setAge(45);
		mother.setGender("f");
		mother.setBirthday(1965, 7, 20);
		
		Person hong = new Person();
		hong.setName("홍길동");
		hong.setAge(20);
		hong.setGender("m");
		
//		Calendar birthday = Calendar.getInstance();
//		birthday.set(1997, 6, 24);
//		hong.setBirthday(birthday);
		hong.setBirthday(1997, 7, 24);
		
		hong.setFather(father);
		hong.setMother(mother);
		
		hong.hello();
		hong.info();
	}

}

class Person {
	
	// 멤버변수
	// - 필드
	// - 상태
	// - 데이터
							// 도메인 > 업무 지식
	private String name;	// 이름: 한글 2~5자 이내
	private String gender;	// 성별: m, f
	private int age;		// 나이: 0~140
	
	private Calendar birthday;
	private Person father;
	private Person mother; 
	
	// 클래스 멤버 메서드
	// - 객체의 행동, 객체 자신의 데이터를 활용해서 행동
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		
		if (checkName(name)) {
			this.name = name;
		} else {
			System.out.println("올바르지 않은 이름입니다.");
		}
	}

	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		
		if (gender.equals("m") || gender.equals("f")) {
			this.gender = gender;
		}
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		
		if (age >= 0 && age <= 140) {
			this.age = age;
		} else {
			System.out.println("올바르지 않은 나이입니다.");
		}
	}
	
//	public Calendar getBirthday() {
//		return birthday;
//	}
	
//	public void setBirthday(Calendar birthday) {
//		this.birthday = birthday;
//	}
	
	public String getBirthday() {
		return String.format("%tF", birthday);
	}
	
	// 매개변수로 y,m,d 받아서 setter에서 설정해줌
	// 사용자는 직접 Calendar를 생성해서 넣어줄 필요가 없어짐
	public void setBirthday(int year, int month, int date) {
		
		Calendar birthday = Calendar.getInstance();
		birthday.set(year, month-1, date);
		
		this.birthday = birthday;
	}
	
	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	private boolean checkName(String name) {
		
		if (name.length() < 2 || name.length() > 5) {
			return false;
		} 
		
		for (int i = 0 ; i < name.length() ; i ++) {
			char c = name.charAt(i);
			if (c < '가' || c > '힣') {
				return false;
			}
		}
		
		return true;
	}
	
	public void hello() {
		System.out.printf("안녕하세요. 저는 %s입니다.\n", name);
	}
	
	public void info() {
		System.out.printf("저는 %s이고 %d살입니다. 생일은 %tF입니다.\n아빠는 %s이고 나이는 %d살입니다.\n엄마는 %s이고 나이는 %d살입니다.\n",
				gender.equals("m") ? "남자" : "여자" , age, birthday,
						father.getName(), father.getAge(), mother.getName(), mother.getAge());
	}
	
}