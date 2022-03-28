package com.test.java.obj.inheritance;

public class Ex42_Inheritance {

	public static void main(String[] args) {
		
		/**
		 * [상속, Inheritance]
		 * - 부모 클래스가 가지는 멤버를(변수, 메서드) 자식 클래스에게 물려주는 행동
		 * 
		 * [상속의 이유]
		 * - 자식 클래스가 구현해야 하는 멤버(코드)를 직접 구현하지 않고, 부모에게 물려받아 자기가 직접 구현한 것 처럼 사용하기 위해서
		 * - 코드 재사용 => 비용 절감
		 * 
		 * [상속관계에 있는 클래스의 호칭]
		 * - 부모 클래스 <- 자식 클래스
		 * - 슈퍼 클래스 <- 서브 클래스
		 * - 기본 클래스 <- 확장(파생) 클래스
		 */
		
		Parent p1 = new Parent();
		p1.a = 10;
		p1.b = 20;
		
		Child c1 = new Child();
		c1.a = 30;
		c1.b = 40;
		c1.ccc();
		c1.d = 50;
		c1.eee();
		
		DDD d1 = new DDD();
		System.out.println(d1.a);
		System.out.println(d1.b);
		System.out.println(d1.c);
		System.out.println(d1.d);
		
		
	}

}

// 부모 클래스
class Parent {
	
	public int a;
	public int b;
	
	public void ccc() {
		System.out.println("부모 클래스의 메서드");
	}
}

// 자식 클래스
// 자식 클래스의 멤버가 부모 클래스의 멤버보다 많다.
class Child extends Parent {
	
	public int d;
	
	public void eee() {
		System.out.println("자식 클래스의 메서드");
	}
}

class Son extends Parent {
	
	public int f;
	public void ggg() {
		
	}
}

class Daughter extends Parent {
	
	public int h;
	public void iii() {
		
	}
}

class AAA {
	public int a = 10;
}

class BBB extends AAA {
	public int b = 20;
}

class CCC extends BBB {
	public int c = 30;
}

class DDD extends CCC {
	public int d = 40;
}
