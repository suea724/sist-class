package com.test.java.obj.constructor;

public class Ex39_Constructor {

	public static void main(String[] args) {
		
		/**
		 * - 생성자에서도 유효성 검사해줄 수 있음
		 */
		
		Developer d1 = new Developer();
		d1.info();
		
		Developer d2 = new Developer("sue");
		d2.info();
		
		Developer d3 = new Developer("sue", "java");
		d3.info();
		
	}

}

class Developer {
	
	private String name;
	private String language;
	
	/**
	 * [생성자를 오버로딩(여러 개 생성)하게 되면]
	 * - 생성자 3개 모두 비슷한 일을 하고 있음 => 중복코드 발생
	 * - A가 할 수 있는 일은 B가 할 수 있고, A,B가 할 수 있는 일은 C가 할 수 있음 => A와 B에서 C를 호출
	 * - 생성자끼리는 서로 메서드처럼 호출이 가능 => 중복 코드를 줄일 수 있다! > this()
	 */

	// A
	public Developer() {
		// this.name = "익명";
		// this.language = "없음";
		this("익명", "없음"); /* C 생성자 호출 */ 
	}
	
	// B
	public Developer(String name) {
		// this.name = name;
		// this.language = "없음";
		
		this(name, "없음"); /* C 생성자 호출 */
	}
	
	// 오버로딩 안됨 > 매개변수 타입과 갯수가 같은 메서드가 동시에 존재할 수 없음!
	// public Developer(String language) {
	//
	// }
	
	// C
	public Developer(String name, String language) {
		this.name = name;
		this.language = language;
	}
	
	public void info() {
		System.out.println("이름: " + this.name);
		System.out.println("언어: " + this.language);
		System.out.println();
	}
}