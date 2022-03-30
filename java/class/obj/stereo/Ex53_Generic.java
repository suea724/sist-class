package com.test.java.obj.stereo;

public class Ex53_Generic {

	public static void main(String[] args) {
		
		/**
		 * [제네릭, Generic]
		 * 1. 제네릭 클래스
		 * 2. 제네릭 메서드
		 */
		
		// 요구사항: 클래스 설계
		// 1. 멤버 변수 선언 > int
		// 2. 멤버 변수를 중심으로 여러가지 행동을 하는 메서드 선언
		
		WrapperInt n1 = new WrapperInt(10);
		System.out.println(n1);
		System.out.println((int)n1.getData() * 2);
		
		// 추가사항: String 중심으로하는 클래스를 따로 생성
		WrapperString s1 = new WrapperString("홍길동");
		System.out.println(s1);
		System.out.println(s1.getData().length());
		
		// 추가사항: boolean 중심으로하는 클래스를 따로 생성
		WrapperBoolean b1 = new WrapperBoolean(true);
		System.out.println(b1);
		System.out.println(b1.getData() == true ? "참" : "거짓");
		
		System.out.println();
		
		// 낭비.. 현실성 떨어짐.. 
		// <해결>
		// 1. Object 클래스 > 오래된 방식
		// 2. 제네릭 클래스 > 최신 방식
		// => 두가지 방식 모두 사용함!!
		
		// Object로 해결하기 -> 다운 캐스팅 필요함
		WrapperObject n2 = new WrapperObject(20);
		System.out.println(n2);
		System.out.println((int)n2.getData() * 2);
		
		WrapperObject s2 = new WrapperObject("아무개");
		System.out.println(s2);
		System.out.println(((String)s2.getData()).length());
		
		WrapperObject b2 = new WrapperObject(false);
		System.out.println(b2);
		System.out.println((boolean)b2.getData() == true ? "참" : "거짓");
		
		System.out.println();
		
		// 제네릭 클래스로 해결하기 -> 다운 캐스팅없이 바로 사용가능
		// 범용 클래스 역할 + 전용 클래스의 편리한 사용법
		Wrapper<Integer> n3 = new Wrapper<>(30);
		System.out.println(n3);
		System.out.println(n3.getData() * 2);
		
		Wrapper<String> s3 = new Wrapper<>("하하하");
		System.out.println(s3);
		System.out.println(s3.getData().length());
		
		Wrapper<Boolean> b3 = new Wrapper<>(false);
		System.out.println(b3);
		System.out.println(b3.getData() == true ? "참" : "거짓");
		
	}

}

class WrapperInt {
	
	private int data; // 클래스의 중심이 되는 데이터
	
	public WrapperInt(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return String.format("data = %s", data);
	}
	
}

class WrapperString {
	
	private String data; // 클래스의 중심이 되는 데이터
	
	public WrapperString(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("data = %s", data);
	}
	
}

class WrapperBoolean {
	
	private boolean data; // 클래스의 중심이 되는 데이터
	
	public WrapperBoolean(boolean data) {
		this.data = data;
	}
	
	public boolean getData() {
		return data;
	}
	
	public void setData(boolean data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("data = %s", data);
	}
	
}

class WrapperObject {
	
	private Object data; // 클래스의 중심이 되는 데이터
	
	public WrapperObject(Object data) {
		this.data = data;
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("data = %s", data);
	}
	
}

class Wrapper<T> {
	
	private T data;
	
	public Wrapper(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return String.format("data = %s", data);
	}
	
}
