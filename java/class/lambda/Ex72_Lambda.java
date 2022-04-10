package com.test.java.lambda;

public class Ex72_Lambda {

	public static void main(String[] args) {
		
		/**
		 * [람다식, Lambda Expression]
		 * 	- 함수형 프로그래밍 방식을 지원하는 표현식
		 * 	- 람다식을 사용하면 코드가 간결해진다.
		 *  - 자바 > 컬렉션(배열) 조작을 위해 제공
		 *  - 자바의 메서드 표현
		 *  - 람다는 매개변수를 가지는 코드 블럭이다. (= 메서드)
		 *  - 자바의 람다식은 인터페이스를 사용해서 만든다. (***********)
		 *  - 자바의 람다식은 익명 객체를 만드는 방법을 간소화시킨 기술이다. (********)
		 *  
		 * [람다식 형식]
		 * 	- 인터페이스 변수 = 람다식;
		 * 	- e.g. MyInterface m1 = () -> {};
		 * 	- (매개변수) -> {실행코드};
		 * 		- a. (매개변수): 메서드의 매개변수 리스트와 동일
		 * 		- b. -> : 화살표(Arrow), 코드블럭 호출 역할
		 * 		- c. {실행코드} : 메서드의 구현부와 동일
		 */
		
		// 요구사항: MyInterface를 구현한 객체를 생성하시오.
		
		// Case 1. 인터페이스를 구현한 클래스의 객체 생성 
		MyInterface m1 = new MyClass();
		m1.test();

		// Case 2. 익명 객체 생성
		MyInterface m2 = new MyInterface() {
			
			@Override
			public void test() {
				System.out.println("익명 클래스 객체에서 구현한 메서드");
			}
		};
		m2.test();
		
		// Case 3. 람다식
		// - 람다식 == 메서드 (**인터페이스로부터 상속받아 재정의한 메서드**)
		// - 1회용 객체 생성
		MyInterface m3 = () -> {System.out.println("람다식으로 만든 객체에서 구현한 메서드");};
		m3.test();
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		// 익명 객체의 추상 메서드 형식에 따라..
	
		/* 매개변수와 반환값이 없는 추상 메서드 */
		
		NoParameterNoReturn pr1 = new NoParameterNoReturn() {
			
			@Override
			public void call() {
				System.out.println("pr1");
			}
		};
		
		pr1.call();
		
		NoParameterNoReturn pr2 = () -> {System.out.println("pr2");};
		pr2.call();
		
		// 실행 블럭 내에 문장이 한줄이면 중괄호 생략 가능
		NoParameterNoReturn pr3 = () -> System.out.println("pr3");
		pr3.call();
		System.out.println();
		
		/* 매개변수가 있고, 반환값이 없는 추상 메서드 */
		ParameterNoReturn pr4 = (int num) -> {System.out.println(num);};
		pr4.call(100);
		pr4.call(200);
		pr4.call(300);
		System.out.println();
		
		// 매개변수가 하나이면 자료형과 괄호를 생략할 수 있다.
		// 괄호 생략은 매개변수가 하나일 때만 가능!! **
		ParameterNoReturn pr5 = num -> System.out.println(num);
		pr5.call(100);
		pr5.call(200);
		pr5.call(300);
		System.out.println();
		
		/* 매개변수 여러 개이고, 반환값이 없는 추상 메서드 */
		MultiParameterNoReturn pr6 = (String name, int age) -> System.out.println(name + "," + age);
		pr6.call("수아", 26);
		
		// 자료형 생략 가능
		MultiParameterNoReturn pr7 = (name, age) -> System.out.println(name + "," + age);
		pr7.call("수아", 26);
		System.out.println();
		
		/* 매개변수가 없고, 반환값이 있는 추상 메서드 */
		NoParameterReturn pr8 = () -> {return 10;};
		System.out.println(pr8.call());
		
		// 실행문에 return문 하나만 존재하면, 중괄호와 return 키워드 생략 가능! 
		NoParameterReturn pr9 = () -> 20;
		System.out.println(pr9.call());
		
	}

}

interface MyInterface {
	void test();
}

class MyClass implements MyInterface {

	@Override
	public void test() {
		System.out.println("실명 클래스 객체에서 구현한 메서드");
	}
	
}

interface NoParameterNoReturn {
	void call();
}

interface ParameterNoReturn {
	void call(int num);
}

interface MultiParameterNoReturn {
	void call(String name, int age);
}

interface NoParameterReturn {
	int call();
}