package com.test.java.obj;

public class Ex32_Class {

	public static void main(String[] args) {
		
		// 구분할 필요 없는 객체 -> 좋지 않은 클래스 사용법
		// 클래스에 변화를 발생시키지 않는 메서드만 있을 때 발생 
		User u1 = new User();
		u1.info();
		
		User u2 = new User();
		u2.info();
		
		User u3 = new User();
		u3.info();
		
		// 하나의 클래스로부터 만들어진 객체는 형태와 역할이 동일하다.
		// 객체의 유일성 > 객체의 상태(State, 멤버 변수)의 차이로 구분이 가능
		Member m1 = new Member();
		m1.id = "suaring";
		m1.info();
		
		Member m2 = new Member();
		m2.id = "kim";
		m2.info();
	}

}

class User {

	// 가치가 떨어지는 메서드
	public void info() {
		System.out.println("회원 정보 출력"); // 정적인 기능 (변화x)
	}
}

class Member {
	
	public String id;
	
	// 멤버 메서드 구현 시 멤버 변수를 활용해야 가치가 있음!
	void info() {
		System.out.printf("제 아이디는 %s입니다.\n", id); // 멤버 변수(상태) 활용
	}
}
