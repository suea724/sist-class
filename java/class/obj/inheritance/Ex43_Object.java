package com.test.java.obj.inheritance;

public class Ex43_Object {

	public static void main(String[] args) {
		
		/**
		 * [Object 클래스]
		 * - 모든 클래스의 근원 클래스, root class
		 * - 사용자가 만드는 모든 클래스는 자동으로 Object 클래스를 상속받음
		 * - Object의 멤버는 모든 클래스에게 상속됨 > 모든 클래스에게 필요한 공통 기능 구현해놓음
		 */
		
		Test t1 = new Test();
	}

}

class Test extends Object {
	public int a;
	public int b;
}

class Other extends Test { 
	public int c;
	public int d;
}