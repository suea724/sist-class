package com.test.java.obj.stereo;

public class Ex51_Abstract {

	public static void main(String[] args) {
		
		/**
		 * 1. 클래스
		 * 		- 실체화 가능 > 객체 생성 가능
		 * 		- 구현된 멤버를 가진다. > 멤버 변수와 구현부를 가지는 멤버 메서드
		 * 
		 * 2. 인터페이스
		 * 		- 실체화 불가능 > 객체 생성 불가
		 * 		- 추상 멤버를 가짐 > 추상 메서드 (+ 자바에는 상수 등 더 들어갈 수 있는게 있긴함)
		 * 		- 클래스의 부모 역할 > 표준화 (사용법 강제 통일) + 역할
		 * 		- 인터페이스는 추상 메서드만 상속
		 * 
		 * 3. 추상 클래스
		 * 		- 실체화 불가능 > 객체 생성 불가
		 * 		- 클래스와 인터페이스의 중간 > 구현된 멤버를 가지면서 추상 멤버도 가진다.
		 * 		- 인터페이스처럼 상속을 할 때 사용함
		 * 		- 상속시 추상 메서드와 함께 멤버변수까지 상속 
		 * 
		 * [사용빈도]
		 * - 인터페이스 >>>>>>>>> 추상클래스 (제약 심함)
		 *  
		 */
		
		// KeyBoard k1 = new KeyBoard(); 추상 메서드 존재 > 실체화 불가능
		
		K8 k1 = new K8();
		k1.charge();
		k1.info();
		
	}

}

abstract class KeyBoard {
	
	private int price;
	public String color;
	
	public void info() {
		System.out.println(this.color);
		System.out.println(this.price);
	}
	
	// 추상 멤버 > abstract 키워드 생략 불가능
	public abstract void charge();
}

class K8 extends KeyBoard {
	
	public K8() {
		this.color = "white";
	}
	
	@Override
	public void charge() {
		System.out.println(this.color + "색상 키보드를 충전합니다.");
	}
}