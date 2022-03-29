package com.test.java.obj.cast;

import java.util.Calendar;

public class Ex47_Cast {

	public static void main(String[] args) {
		
		/**
		 * [형변환, Type Casting]
		 * 1. 값형 형변환, ValueType 
		 * 		- 값형끼리 형변환 (boolean 제외)
		 * 
		 * 2. 참조형 형변환, Reference Type Casting
		 * 		- 참조형끼리(클래스간) 형변환
		 * 		- 상속관계의 클래스간 형변환 > 직계끼리만 가능(형제지간은 X)
		 * 
		 * 		1. 업캐스팅, Up Casting
		 * 			- 암시적인 형변환
		 * 			- 자식 클래스 -> 부모 클래스
		 * 			- 100% 가능, 매우 안전
		 * 
		 * 		2. 다운캐스팅, Down Casting
		 * 			- 명시적인 형변환
		 * 			- 부모 클래스 -> 자식 클래스
		 * 			- 100% 불가능, 런타임 오류 발생
		 * 			- 업캐스팅 후 다시 본인 타입으로 형변환하는 경우 가능
		 */
		
		System.out.printf("%s\n", "문자열");
		
		// 자동으로 toString() 호출 => 형식문자 사용할 때
		// 1. Wrapper Class
		// 2. 참조형 변환
		// 3. toString() 호출
		
		System.out.printf("%d\n", 10);
		System.out.printf("%s\n", 10); 
		
		System.out.printf("%b\n", true);
		System.out.printf("%s\n", true);
		
		System.out.printf("%c\n", 'A');
		System.out.printf("%s\n", 'A');
		System.out.printf("%c\n", 65);
		
		System.out.println();
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 10;
		c1.b = 20;
		c1.c = 30;
		c1.d = 40;
		
		Parent p2;
		Child c2;
		
		c2 = new Child();
		
		// 복사
		// Parent = Child (업캐스팅, 암시적 형변환)
		// 100% 가능, 아주 안전한 형변환
		p2 = c2;
		// p2 = (Parent)c2;
		
		// 복사 + 형변환 > 완료되었는지 검증 > 복사된 참조 변수에 대해 모든 멤버 접근 테스트
		// 안보이는 c와 d는 중요하지 않음
		p2.a = 10;
		p2.b = 20;
//		
//		System.out.println(p2.a);
//		System.out.println(p2.b);
//		
//		Parent p3;
//		Child c3;
//		
//		p3 = new Parent();
//		
//		// 복사
//		// Child = Parent (다운 캐스팅, 명시적 형변환)
//		// 에러
//		// 원인 > 아예 불가능한 작업으로 취급
//		c3 = (Child)p3;
//		
//		// 검증 > 복사본이 사용에 문제가 없는지?
//		c3.a = 10;
//		c3.b = 10;
//		c3.c = 10;
//		c3.d = 10;
//		
//		// Parent로부터 물려받은 변수
//		System.out.println(c3.a); // O
//		System.out.println(c3.b); // O
//		
//		// Child가 직접 생성한 변수
//		System.out.println(c3.c); // X
//		System.out.println(c3.d); // X 
		
		Parent p4;
		Child c4;
		
		c4 = new Child();
		
		p4 = c4; // Child -> Parent > 업 캐스팅
		
		Child c5;
		
		c5 = (Child)p4; // 다시 Parent -> Child > 다운 캐스팅
		
		c5.a = 100;
		c5.c = 200;
		
		System.out.println(c5.a);
		System.out.println(c5.c);
		
	}

}

class Parent {
	
	public int a;
	public int b;
	
}

class Child extends Parent {
	
	public int c;
	public int d;
	
}
