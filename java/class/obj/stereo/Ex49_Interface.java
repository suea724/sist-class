package com.test.java.obj.stereo;

public class Ex49_Interface {

	public static void main(String[] args) {
		
		/**
		 * [StereoType]
		 * - 추상적인 자료형 (실체화하지 못하는 자료형)
		 * - Interface, Abstract Class > 클래스의 일종
		 * 
		 * [인터페이스, Interface]
		 * - 서로 비슷한 부류의 객체들의 사용법을 물리적으로 통일시키는 방법
		 * - 인터페이스는 자료형이다.
		 * - 인터페이스는 객체를 만들 수 없다. > 추상 멤버(추상 메서드)를 가지고 있기 때문에 실체화 X
		 * - 하나의 인터페이스를 구현하는 모든 클래스는 객체를 만들게 되면 공통 메서드가 존재
		 * - 제품의 규격 역할 
		 */
		
		// 다른 객체지만, 모두 마우스 범주의 객체 > 사용법이 비슷하거나 같을 것이라고 기대 > click()
		G304 m1 = new G304();
		m1.click();
		m1.click();
		m1.click();
		
		G102 m2 = new G102();
		m2.click();
		m2.click();
		m2.click();
	}

}

// 인터페이스 선언
interface Mouse {
	
	// [인터페이스 멤버 선언]
	// - 추상 메서드를 멤버로 가진다. (메서드 바디 X) *****
	// - 멤버 변수는 가질 수 없음
	// - 멤버 메서드는 가질 수 없음
	public void click();
}

class G304 implements Mouse {
	
	private String type;
	private String color;
	private int dpi;
	
	// 구현한 인터페이스의 추상 메서드를 구현해줘야 함 > 구현하지 않으면 컴파일 오류
	@Override
	public void click() {
		System.out.println("G304 클릭");
	}
}

class G102 implements Mouse {
	
	private String color;
	private int price;
	private int buttons;
	
	@Override
	public void click() {
		System.out.println("G102 클릭");
	}
}

class AAA {
	private BBB b; // 멤버변수에서 사용, 연관관계, Association, 더 강한 결합
	private int num;
	private CCC[] list = new CCC[3];
	
}

class BBB {
	
}

class CCC {
	
}

class DDD {
	
	public void test() {
		EEE e = new EEE(); // 지역변수에서 사용, 의존관계, Dependency, 더 약한 결합
	}
}

class EEE {
	
}