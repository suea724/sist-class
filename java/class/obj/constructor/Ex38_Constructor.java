package com.test.java.obj.constructor;

public class Ex38_Constructor {

	public static void main(String[] args) {
		
		// 공산품 > 일괄적 초기화 > model(M705), price(40000)
		// 불량품 가격 D.C > 35000원
		
		// default 생성자 사용
		// Setter으로 가격 수정
		Mouse m1 = new Mouse();
		
		Mouse m2 = new Mouse();
		m2.setPrice(35000);
		
		Mouse m3 = new Mouse();
		m3.setPrice(35000);
		
		// 객체의 초기 상태는 상황에 따라 달라질 수 있다. > 오버로딩 된 생성자 사용 > 다형성
		
		Mouse m4 = new Mouse(35000); // 가격 지정 + 모델명 기본값(M705)
		
		Mouse m5 = new Mouse("A100"); // 모델명 지정 + 가격 기본값(40000)
		
		Mouse m6 = new Mouse("B123", 30000); // 둘다 지정
		
		System.out.println(m1.getModel() + " " + m1.getPrice());
		System.out.println(m2.getModel() + " " + m2.getPrice());
		System.out.println(m3.getModel() + " " + m3.getPrice());
		System.out.println(m4.getModel() + " " + m4.getPrice());
		System.out.println(m5.getModel() + " " + m5.getPrice());
		System.out.println(m6.getModel() + " " + m6.getPrice());

	}
}

class Mouse {
	
	private String model;
	private int price;
	
	public Mouse() { // 기본 생성자
		this.model = "M705";
		this.price = 40000;
	}
	
	public Mouse(int price) { // 매개변수가 하나인 생성자 > 가격
		this.model = "M705";
		this.price = price;
	}
	
	
	public Mouse(String model) { // 매개변수가 하나인 생성자 > 모델
		this.model = model;
		this.price = 40000;
	}
	
	public Mouse(String model, int price) { // 매개변수가 멤버변수의 갯수와 동일한 생성자
		this.model = model;
		this.price = price;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
}
