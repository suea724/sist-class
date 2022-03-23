package com.test.java.obj.access;

public class Ex34_Access {
 
	public static void main(String[] args) {
		
		/**
		 * [접근 지정자(제어자), Access Modifier]
		 * - 클래스 멤버 또는 자체에 붙여서 사용한다.
		 * - 지역변수에는 사용 불가능
		 * - 클래스의 영역을 기준으로 외부에 해당 멤버를 노출하는 수위 결정
		 * - 멤버를 외부에 공개할지 여부를 조절
		 * 
		 * 1. public > 100% 공개
		 * 2. private > 100% 비공개
		 * 3. protected
		 * 4. default
		 * 
		 * [객체]
		 * - 내부에 여러가지 멤버 소유
		 * 
		 * [특징]
		 * - 정보 은닉화
		 * - 인터페이스: 내부와 외부가 데이터를 주고받기 위해 사용
		 * - 캡슐화
		 * 
		 * - 캡슐화 이유
		 * 		1) 외부로부터 내부 요소를 보호하기 위해서 -> 정보 은닉화
		 * 		2) 객체의 사용법을 단순화하기 위해서 
		 * 
		 * 모든 상황에서 범위가 큰 요소와 작은 요소끼리 충돌 시, 무조건 범위가 작은 요소가 우선한다.
		 * -> 멤버 변수의 scope가 지역 변수의 scope보다 작은 범위
		 * 
		 * [클래스 설계시 접근 지정자 가이드]
		 * 1. 멤버 변수 > private
		 * 2. 필요한 Getter/Setter > public
		 * 3. 불필요한 내부 멤버 메서드 > private
		 * 4. 외부 호출 멤버 메서드 > public
		 * 
		 * [Getter/Setter 역할]
		 * 1. 멤버 보호 (멤버 변수에 유효하지 않은 값이 들어가는 것을 방지)
		 * 2. 쓰기 전용, 읽기 전용 가능
		 * 3. 계산된 멤버 생성 가능
		 */
		
		Book b1 = new Book();
		b1.title = "자바의 정석";
		// b1.author = "남궁성"; 접근할 수 없음
		
//		// 멤버 변수 public으로 설정 시
//		Phone p1 = new Phone();
//		p1.model = "iphone11";
//		p1.color = "space-gray";
//		p1.price = 1500000;
//		p1.weight = 350;
//		
//		System.out.println(p1.model);
//		System.out.println(p1.color);
//		System.out.println(p1.price);
//		System.out.println(p1.weight);
//		
//		// 멤버 변수를 public으로 오픈할 때 발생할 수 있는 문제
//		// 아무런 제약 없이 변수를 읽고 수정할 수 있음
//		Phone p2 = new Phone();
//		p2.model = "13";
//		p2.color = "blue";
//		p2.price = -10;
//		p2.weight = -2000000;
//		
//		System.out.println(p2.model);
//		System.out.println(p2.color);
//		System.out.println(p2.price);
//		System.out.println(p2.weight);
		
		Phone p3 = new Phone();
		p3.setModel("iphone11 pro");
		System.out.println(p3.getModel());
		
		p3.setPrice(150000000); // 범위 초과
		System.out.println(p3.getPrice());
		
		Phone p4 = new Phone();
		p4.setModel("iphone11");
		p4.setColor("gray");
		p4.setPrice(1500000);
		p4.setWeight(300);
		
		System.out.println(p4.getModel());
		System.out.println(p4.getColor());
		System.out.println(p4.getPrice());
		System.out.println(p4.getWeight());
		
		Cup cup = new Cup();
		
		// 쓰기, 읽기 프로퍼티
		cup.setColor("brown");
		System.out.println(cup.getColor());
		
		// 쓰기 전용 프로퍼티
		cup.setWeight(500);
		// System.out.println(cup.getWeight());
		
		// 읽기 전용 프로퍼티
		// cup.setPrice(1000);
		System.out.println(cup.getPrice());
		
		System.out.println(cup.getInfo());
	}
}

class Book {
	
	public String title;
	private String author;
}

class Phone {
	
	// 1. 무조건 멤버 변수는 private으로 설정
	private String model;
	private String color;
	private int price;
	private int weight;

	// 2. public 메서드를 생성 > 리모컨 버튼 > 인터페이스 > 객체 사용법
	// Getter, Setter
	
	public void setModel(String model) {
		this.model = model; // this: 상대 표현 (객체 자신)
	}
	
	public String getModel() {
		return model;
	}
	
	public void setPrice(int price) {
		
		// 입출력 되는 데이터를 통제할 수 있음
		if (price > 0 && price <= 1500000) {
			this.price = price;
		} else {
			System.out.println("error");
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setColor(String color) {
		
		// 주관식 x > 선택 > 열거형 조건 추가 가능
		if (color.equals("black") || color.equals("gray") || color.equals("white")) {
			this.color = color;
		} else {
			System.out.println("존재하지 않는 색상입니다.");
		}
		
	}
	
	public String getColor() {
		return color;
	}
	
	public void setWeight(int weight) {
		
		if (weight > 0) {
			this.weight = weight;
		}
	}
	
	public double getWeight() { // 만약 kg으로 환산해야 한다면? 가공할 수 있음
		return calcWeight(weight);
	}
	
	// 내부 업무에 필요한 작업을 분리시키기 위해 생성한 메서드
	// public으로 설정할 경우 사용자에게 혼동을 초래할 수 있음 > 왜있지..?
	private double calcWeight(int weight) {
		return weight / 1000.0;
	}
}

// 블랙 박스: 안에서 무슨 일이 벌어지는지 모름
class Cup {
	
	private String color;
	private int weight;
	private int price = 1000;
	private String type;
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getInfo() {
		
		if (this.price < 500) {
			return "저려미 컵";
		} else if (this.price < 1000) {
			return "보통 컵";
		} else {
			return "비싸미 컵";
		}
	}
}