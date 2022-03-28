package com.test.java.obj.inheritance;

import java.util.Calendar;

public class Ex46_Final {

	public static void main(String[] args) {
		
		/**
		 * [final 키워드]
		 * 1. 변수에 적용 (지역변수 + 멤버변수) (******)
		 * 		- 값을 초기화 이후에 변경할 수 없다.
		 * 		- 상수
		 * 2. 메서드에 적용
		 * 		- 상속 시 재정의(Override)를 할 수 없다.
		 * 		- 프로그램의 안정성 문제
		 * 3. 클래스에 적용
		 * 		- 상속이 불가능하다.
		 * 
		 * => 한번 결정하면 바꿀 수 없다.
		 */
		
		final int b = 20; // 상수는 선언과 동시에 초기화를 해주는 것을 권장
		
		final int c; // 선언과 초기화를 따로 할 수 있지만 권장하지 않음! > 변수 같다..
		c = 30;
		
		final double PI = 3.14; // 상수명은 모두 대문자로 작성 (******)
		
		Calendar now = Calendar.getInstance();
		System.out.println(now.get(Calendar.YEAR)); // 캘린더 상수 사용
		
		// 객체 상수 > 메모리 낭비
		User u1 = new User();
		System.out.println(u1.GENDER);
		
		User u2 = new User();
		System.out.println(u2.GENDER);
		
		User u3 = new User();
		System.out.println(u3.GENDER);
		
		// final static 상수 
		System.out.println(User.NUM); // 3
		System.out.println(Calendar.YEAR); // 1
		
		// Member m1 = new Member();
		// System.out.println(m1.a);
		// System.out.println(Member.b);
		
		System.out.println(Member.b); // 0
		
		Member m1 = new Member();
		
		System.out.println(Member.b); // 20 > 객체를 생성해야 초기화가 되고 객체가 생성될 때마다 값이 reset됨 (!!!)
	}

}

/* final 변수 */

class User {
	
	// 객체 변수의 역할: 객체 각각의 자신의 저장 공간을 가지고 자신만의 데이터를 저장하기 위함 > 객체의 상태 > 객체를 구분
	// 객체 멤버 상수는 잘 사용하지 않음 (static과 유사) > 메모리 낭비가 될 수 있음
	public int age;
	public final int GENDER = 2;
	public static final int NUM = 3; // static 상수 > 메모리 낭비 X
	
	public User() {
		this.age = 0;
	}
}

class Member {
	
	public int a;
	public static int b;
	
	// 생성자 > 객체 생성자 > 객체 변수만 초기화
	public Member() {
		this.a = 10;
		// Member.b = 20; // 정적 변수를 생성자에서 초기화하면 안됨 (변화는 가능 e.g. count++)
	}
	
	// 생성자 > 정적 생성자 > 정적 멤버만을 초기화
	static {
		Member.b = 20;
	}
	
}

/* final 메서드 */

class FinalParent {
	
	public final void test() {
		System.out.println("메서드");
	}
}

class FinalChild extends FinalParent {
	
	// 오버라이딩 불가
	// @Override
	// public void test() {
	// System.out.println("Overrided");
	// }
}

/* final 클래스 */

// 자식 포기
// 터미널 클래스
// 리프 노드
final class FinalUser {
	
}

//class FinalUserAdmin extends FinalUser {
//	
//}