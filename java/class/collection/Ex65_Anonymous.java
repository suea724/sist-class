package com.test.java.collection;

public class Ex65_Anonymous {

	public static void main(String[] args) {
		
		// 클래스 관련 but Collection 사용 시 사용함
		
		/*
		 * [익명 객체, Anonymous Object]
		 *  - 익명 클래스, Anonymous Class
		 *  - 이름없는 클래스(객체)
		 *  - 반드시 인터페이스가 필요함! (자바 특성)
		 *  
		 * [사용 이유]
		 * 	- 모든 코드를 통틀어 단 1개의 객체가 필요한 경우
		 * 	- 클래스를 선언하면 객체 N개를 생성하는 것이 좋음
		 * 	- 1회용 객체 생성 > 익명 클래스 역할
		 */
		
		// 요구사항: 인터페이스를 구현한 클래스의 객체 생성
		// 1. 본인 타입으로 참조 변수 만들기
		BBB b1 = new BBB();
		b1.aaa();
		b1.bbb();
		
		System.out.println();
		
		// 2. 부모 타입(인터페이스)으로 참조 변수 만들기 > *실무*
		// - 업캐스팅
		AAA b2 = new BBB();
		b2.aaa(); 
		// b2.bbb(); > 자식 클래스에서 정의한 메서드 접근 불가
		((BBB)b2).bbb(); // 자식 클래스 메서드 접근시 다운 캐스팅 필요
		
		System.out.println();
		
		// 3.
		// AAA b3 = new AAA();
		// b3.aaa(); // 불가능 > 구현부가 없는 메서드
		
		/* 익명 클래스 */
		
		AAA b3 = new AAA() {

			@Override
			public void aaa() {
				System.out.println("익명 클래스 추상 메서드 구현");
			}
			
			// 익명 객체는 자신의 멤버를 만들지 않음! > 부모 인터페이스 참조 변수 통해서 호출 불가 + 다운 캐스팅 불가
//			public void ccc() {
//				System.out.println("자신만의 메서드 구현");
//			}
			
		};
		
		b3.aaa();
		
		// b2 vs b3
		// - 공통점: AAA 인터페이스를 구현한 클래스의 객체
		b2.aaa();
		b3.aaa();
		
		// - 차이점: b2 > 일반 클래스의 객체 > 다운캐스팅 가능
		//		   b3 > 익명 클래스의 객체 > 다운캐스팅 불가 (이름이 없어서)
		((BBB)b2).bbb();
		
	}

}

interface AAA {
	void aaa();
}

class BBB implements AAA {

	@Override
	public void aaa() {
		System.out.println("추상 메서드 구현");
	}
	
	public void bbb() {
		System.out.println("자신만의 메서드 구현");
		
	}
	
}
