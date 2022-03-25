package com.test.java.obj.constructor;

public class Ex37_Constructor {

	/**
	 * [생성자]
	 * - 특수한 목적을 가지는 메서드
	 * - 객체 멤버(변수)를 초기화하는 역할을 가지는 메서드
	 * - 일반 메서드처럼 마음대로 호출할 수 없음
	 * - 객체가 생성될 때 딱 한번만 호출
	 * - 클래스 이름과 동일한 이름을 가짐 
	 * 
	 * [new, 객체 생성 연산자]
	 * - new로 인스턴스를 만듦. 생성된 인스턴스의 변수 값은 모두 null
	 * - 생성자가 호출될 때 값이 들어감
	 */
	
	public static void main(String[] args) {
		
		User u1 = new User();
		
		System.out.println(u1.getName());
		System.out.println(u1.getAge());
		System.out.println(u1.getId());
		System.out.println(u1.isFlag());
		
		Cup c1 = new Cup();
//		c1.setColor("white");
//		c1.setOwner("미정");
		
		Cup c2 = new Cup();
//		c2.setColor("white");
//		c2.setOwner("미정");
// 		=> 생성자를 사용하면 반복이 줄고, 안정적임
		
		c1.info();
		c2.info();
		
		// Setter 역할 > 객체 정보 수정
		c1.setColor("black");
		c1.setOwner("sue");
		
	}
	
}

class User {
	
	private String name;
	private String id;
	private int age;
	private boolean flag;
	
	// 생성자 > 객체 정보 초기화
	// 1. 메서드명 == 클래스명
	// 2. 반환값 명시 X, 생성자 반환값을 가질 수 없음
	// 3. return문을 가질 수 없다.
	// 4. 구현부에는 해당 클래스의 멤버를 초기화하는 코드를 작성해야 함 (***)
	
	public User() {
		
//		this.name = null;
//		this.id = null;
//		this.age = 0;
//		this.flag = false;
		
		// 초기값 세팅
		this.name = "익명";
		this.age = -1;
		this.flag = true;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}

class Cup {
	
	private String color;
	private String owner;
	
	// 기본 생성자는 개발자가 작성하지 않으면 자동으로 생성됨
	// 기본 생성자는 개발자가 작성하면 자동으로 생성되지 않음
	// 관습 > 객체 생성시 초기화가 돼있을거라고 기대함
	// 개발자가 기본 생성자 생성 후 일부 멤버를 초기화를 하지 않아도 자동으로 초기화 코드가 작성됨.
	// 결론 = 객체의 멤버 변수는 반드시 초기화 과정을 거치게 된다.
	public Cup() {
		this.color = "white";
		this.owner = "미정";
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public String getOwner() {
		return owner;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public void info() {
		System.out.printf("색상: %s, 소유주: %s\n", this.color, this.owner);
	}
	
}
