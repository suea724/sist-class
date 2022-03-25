package com.test.java.obj.question.q3;

class Student {

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
	
	public String info() {
		return String.format("%s(나이: %s, 학년: %s, 반: %s, 번호: %s)"
				, this.name
				, this.age == 0 ? "미정" : Integer.toString(this.age) + "세"
				, this.grade == 0 ? "미정" : Integer.toString(this.grade)
				, this.classNumber == 0 ? "미정" : Integer.toString(this.classNumber)
				, this.number == 0 ? "미정" : Integer.toString(this.number)); 
	}
}
