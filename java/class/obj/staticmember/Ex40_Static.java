package com.test.java.obj.staticmember;

public class Ex40_Static {

	public static void main(String[] args) {
		
		/**
		 * [static 키워드]
		 * - 클래스 멤버에 붙이는 키워드 (***)
		 * 	- 멤버 변수
		 * 	- 멤버 메서드
		 * - 클래스에도 붙일 수는 있음 (자주 사용은 X)
		 * 
		 * [메모리]
		 * - Stack: 지역변수 저장
		 * - Heap: 참조변수가 가리키는 인스턴스가 저장되는 곳
		 * - Static 영역: 모든 static 키워드가 붙은 멤버가 생성되는 곳
		 * 		- static 변수 > 하나만 생성되며 각 객체가 재사용함
		 * 		- static 메서드
		 * 
		 * [클래스 로딩, Class Loading] (메인 메서드 실행 전에 일어남)
		 * - 해당 프로그램을 실행하기 전에 클래스의 정의를 미리 읽어서 메모리에 얹는 작업
		 * - 설계도를 미리 읽어서 언제든지 사용 가능하도록 메모리에 올려놓는 작업
		 * - 클래스 로딩과정에서 발견되는 모든 static 멤버(변수, 메서드)는 메모리에 구현된다.(********)
		 * 	=> 정적 멤버 로딩 (클래스 이름)
		 * 
		 * [클래스 멤버 변수]
		 * - 객체변수 + 정적변수
		 * <객체 변수>
		 * 		- 각 개인이 각자 저장할 데이터를 저장하는 변수
		 * 		- 나만의 데이터(****) > 개인의 특성(****)
		 * <정적 변수>
		 * 		- 하나의 클래스로부터 만들어진 모든 객체가 공통으로 가지는 데이터를 저장하는 변수
		 * 		- 모든 객체의 공통된 특성(****)
		 */
		
		// static 메서드는 접근할 때 클래스명을 사용 (물리적인 구조 때문)
		Student.setSchool("역삼중학교");
		
		// "역삼중학교" > 성질이 동일한 데이터 중복 > 메모리 낭비!!
		Student s1 = new Student();
		s1.setName("홍길동");
		s1.setAge(15);
		// s1.setSchool("역삼중학교");
		System.out.println(s1.info());
		
		Student s2 = new Student();
		s2.setName("아무개");
		s2.setAge(14);
		// s2.setSchool("역삼중학교");
		System.out.println(s2.info());
		
		Student s3 = new Student();
		s3.setName("테스트");
		s3.setAge(16);
		// s3.setSchool("역삼중학교");
		System.out.println(s3.info());
	}
}

class Student {
	
	// 클래스 멤버 변수 = 객체 변수 + 정적 변수
	
	// 객체 변수
	private String name;
	private int age;
	
	// 정적 변수, static 변수, 클래스 변수, 공유 변수
	// 메모리에서 static 영역(정적 공간)에 생성됨 
	private static String school; 
	
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
	
	// 기존 Getter, Setter
//	public String getSchool() {
//		return school;
//	}
//	
//	public void setSchool(String school) {
//		this.school = school;
//	}
	
	// static 키워드, 클래스 이름으로 변수 참조
	public static String getSchool() {
		return school;
	}
	
	public static void setSchool(String school) {
		Student.school = school;
	}
	
	public String info() {
		return String.format("이름: %s, 나이: %d, 학교: %s", this.name, this.age, Student.school);
	}
}

// 역삼중학교 학생
//class Student {
//	
//	private String name;
//	private int age;
//	private String school;
//	
//	public String getName() {
//		return name;
//	}
//	
//	public void setName(String name) {
//		this.name = name;
//	}
//	
//	public int getAge() {
//		return age;
//	}
//	
//	public void setAge(int age) {
//		this.age = age;
//	}
//	
//	public String getSchool() {
//		return school;
//	}
//	
//	public void setSchool(String school) {
//		this.school = school;
//	}
//	
//	public String info() {
//		return String.format("이름: %s, 나이: %d, 학교: %s", this.name, this.age, this.school);
//	}
//	
//}
