package com.test.java.obj.stereo;

public class Ex55_Generic {

	public static void main(String[] args) {

		// Item is a raw type. References to generic type Item<T> should be parameterized
		Item i1 = new Item();
		
		/**
		 * 제네릭 클래스 올바른 사용법
		 * 	- 자료형 인자로 값형을 사용할 수 없음 > 참조형(클래스)만 사용 가능
		 *	- 각 자료형의 WrapperClass 적어줌 
		 */
		Item<String> i2 = new Item<String>();
		i2.c = "문자열";
		
		Item<Integer> i3 = new Item<Integer>();
		i3.c = 50;
		
		Pen<String> p1 = new Pen<>();
		p1.a = "문자열";
		p1.test("문자열");
		String res = p1.get();
		
		Cup<String, Integer> c1 = new Cup<>("문자열", 100);
		Cup<Double, Boolean> c2 = new Cup<>(10.0, false);
		
		System.out.println(c1.getA());
		System.out.println(c1.getB());
		
	}

}

/**
 * [제네릭 클래스]
 *	- T : 타입 변수
 *		- 보통 대문자로 한글자만 적음
 *		- 자료형을 저장하는 변수
 *		- e.g. T = Integer
 *
 *	- <> : 인자 리스트 역할
 *		- 보통 인자는 1-2개
 *		- 3개 이상은 잘 사용안함
 *
 *	- 자료형이 컴파일 타임에 결정되는 것이 아니라, 런타임에 결정할 수 있음
 *	- 더 유연해짐.
 */

class Item<T> {
	
	public int a;
	public int b;
	public T c; // 클래스 설계시에는 자료형이 결정되지 않음. 객체 생성 시 결정
	
}

class Pen<T> {
	
	public T a; // 멤버변수의 자료형
	
	public void test(T a) { // 매개변수의 자료형
		
		T b; // 지역 변수 사용은 비권장
	}
	
	public T get() { // 반환타입의 자료형
		return a;
	}
}

class Cup<T, U> {
	
	public T a;
	public U b;
	
	public Cup(T a, U b) {
		this.a = a;
		this.b = b;
	}
	
	public T getA() {
		return a;
	}
	
	public U getB() {
		return b;
	}
}
