package com.test.java.obj.stereo;

public class Ex50_Interface {

	public static void main(String[] args) {
		
		/**
		 * [다중 상속]
		 * - 부모 클래스를 두 개 이상 가지는 경우
		 * - 자식 클래스가 복잡해짐 + 모호성
		 * - 자바에서는 클래스간 다중 상속을 지원하지 않음, only 단일 상속만 가능
		 * - 인터페이스에 한해서는 하나의 클래스가 여러 인터페이스를 구현할 수 있음
		 */
		
	}

}
// 규격(제약) + 역할!
interface Father {
	public void earnMoney();
	public void protectFamily();
}

interface Man {
	public void shave();
	public void lowVoice();
}

interface Manager {
	public void signOff();
	public void manageEmployee();
}

interface CafeOwner {
	public void open();
	public void close();
	public void makeCoffee();
}

// 하나의 클래스는 여러 역할을 수행할 수 있다!
// 각 객체가 역할을 수행하는 방법은 다를 수 있다. > 객체의 성격 결정
// 다른 객체끼리의 협력에도 인터페이스가 필요 > 혼동 막고, 사용법을 표준화
class Person1 implements Father, Man, CafeOwner {
	
	// CafeOwner

	@Override
	public void open() {
		
	}

	@Override
	public void close() {
		
	}

	@Override
	public void makeCoffee() {
		
	}

	// Man
	
	@Override
	public void shave() {
		
	}

	@Override
	public void lowVoice() {
		
	}

	// Father
	
	@Override
	public void earnMoney() {
		
	}

	@Override
	public void protectFamily() {
		
	}
	
}

class Person2 implements Manager, Man {

	@Override
	public void shave() {
		
	}

	@Override
	public void lowVoice() {
		
	}

	@Override
	public void signOff() {
		
	}

	@Override
	public void manageEmployee() {
		
	}
	
}