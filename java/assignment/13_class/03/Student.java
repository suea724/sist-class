package com.test.java.obj.question.q3;

class Student {
	
	/**
	 * 생성자 오버로딩을 구현하시오.
		- Student
			- 학생 클래스
			- 상태
				- name: 이름
				- age: 나이
				- grade: 학년
				- classNumber: 반
				- number: 번호
			- 행동
				- public Student()
					- 기본 생성자
					- 이름("미정"), 나이(0), 학년(0), 반(0), 번호(0)
				- public Student(String name, int age, int grade, int classNumber, int number)
					- 생성자 오버로딩
				- public Student(String name, int age)
					- 생성자 오버로딩
				- public Student(int grade, int classNumber, int number)
					- 생성자 오버로딩
				- String info()
					- 이름(나이 : 0세, 학년 : 0, 반 : 0, 번호 : 0)
	 */

	private String name;
	private int age;
	private int grade;
	private int classNumber;
	private int number;
	
	public Student() {
		this("미정", 0, 0, 0, 0);
	}
	
	public Student(String name, int age) {
		this(name, age, 0, 0, 0);
	}
	
	public Student(int grade, int classNumber, int number) {
		this("미정", 0, grade, classNumber, number);
	}
	
	public Student(String name, int age, int grade, int classNumber, int number ) {
		
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.classNumber = classNumber;
		this.number = number;
	}
	
	// 형식문자의 형식에 맞게 자동으로 형변환이 이루어진다! => toString()을 따로 사용해주지 않아도 자동으로 실행됨
	
	public String info() {
		return String.format("%s(나이: %s, 학년: %s, 반: %s, 번호: %s)"
				, this.name
				, this.age == 0 ? "미정" : Integer.toString(this.age) + "세"
				, this.grade == 0 ? "미정" : Integer.toString(this.grade)
				, this.classNumber == 0 ? "미정" : Integer.toString(this.classNumber)
				, this.number == 0 ? "미정" : Integer.toString(this.number)); 
	}
}
