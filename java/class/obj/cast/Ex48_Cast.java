package com.test.java.obj.cast;

public class Ex48_Cast {

	public static void main(String[] args) {
		
		/* 업캐스팅 + 다운캐스팅 > 언제? 왜? 사용하는지 
		 * 
		 * [instanceof 연산자]
		 * - A instanceof B
		 * - 2항 연산자
		 * - A라는 객체가 B라는 자료형의 객체인가?
		 * - A를 B로 형변환 할 수 있는가?
		 * */
		
		// 내가 가지고 있는 마우스들 > 배열로 관리!
		G304 m1 = new G304("광", 45000, 5, 12000);
		G304 m2 = new G304("광", 38000, 4, 8000);
		
		G102 m3 = new G102("광", 28000, 8000, "검정");
		G102 m4 = new G102("광", 25000, 5000, "노랑");
		G102 m5 = new G102("광", 26000, 7000, "분홍");
		
		M331 m6 = new M331("광", "검정", 33000, 10000);
		M331 m7 = new M331("광", "파랑", 32000, 9000);
		
		/* 각 마우스 기종별로 따로 배열 만들기 */
		// for문은 여러번 돌지만, 다운캐스팅 작업이 발생하지 않음
		G304[] mlist1 = {m1, m2};
		G102[] mlist2 = {m3, m4, m5};
		M331[] mlist3 = {m6, m7};
		
		for (int i = 0 ; i < mlist1.length ; i ++) {
			mlist1[i].click();
			mlist1[i].clean();
		}
		System.out.println();
		
		for (int i = 0 ; i < mlist2.length ; i ++) {
			mlist2[i].click();
			mlist2[i].check();
		}
		System.out.println();
		
		for (int i = 0 ; i < mlist3.length ; i ++) {
			mlist3[i].click();
			mlist3[i].charge();
		}
		System.out.println();
		
		/* 서로 다른 자료형의 객체를 부모 클래스로 업 캐스팅(추상화)해서 한 배열에서 관리 */
		// -> 자식 클래스의 고유 기능을 사용해야 할 때 부모 참조 변수로는 접근이 불가능
		// -> 이때 각각 원래 자료형으로 돌려서 고유 기능 사용 > 다운 캐스팅
		// for문은 한번 돌지만, 다운캐스팅 작업이 추가로 발생한다는 단점
		Mouse[] mouseList = {m1, m2, m3, m4, m5, m6, m7};
		
		for (int i = 0 ; i < mouseList.length ; i ++) {
			
			mouseList[i].click(); // 호출시 자식 클래스에서 오버라이딩된 메서드 호출
			
			if (mouseList[i] instanceof G304) {
				((G304)mouseList[i]).clean(); // 형변환한 결과를 괄호로 묶으면 메서드 사용 가능
				
			} else if (mouseList[i] instanceof G102) {
				((G102)mouseList[i]).check();
				
			} else if (mouseList[i] instanceof M331) {
				(((M331)mouseList[i])).charge();
			}
			
		}
		
	}

}

// 마우스의 부모 클래스
class Mouse {
	
	public void click() {
		
	}
	
}

class G304 extends Mouse {
	
	private String type;
	private int price;
	private int buttons;
	private int dpi;
	
	public G304(String type, int price, int buttons, int dpi) {
		
		this.type = type;
		this.price = price;
		this.buttons = buttons;
		this.dpi = dpi;
	}

	@Override
	public String toString() {
		return String.format("G304 [type=%s, price=%s, buttons=%s, dpi=%s]", type, price, buttons,
				dpi);
	}
	
	public void click() {
		System.out.printf("클릭합니다. %d, %d \n", price, dpi);
	}
	
	public void clean() {
		System.out.println("광센서를 자동으로 세척합니다.");
	}
}

class G102 extends Mouse {
	
	private String type;
	private int price;
	private int dpi;
	private String color;
	
	public G102(String type, int price, int dpi, String color) {
		
		this.type = type;
		this.price = price;
		this.dpi = dpi;
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("G102 [type=%s, price=%s, dpi=%s, color=%s]", type, price, dpi, color);
	}
	
	public void click() {
		System.out.printf("Click %s\n", color);
	}
	
	public void check() {
		System.out.println("현재 DPI를 체크합니다.");
	}
	
}

class M331 extends Mouse {
	
	private String type;
	private String color;
	private int price;
	private int dpi;
	
	public M331(String type, String color, int price, int dpi) {
		
		this.type = type;
		this.color = color;
		this.price = price;
		this.dpi = dpi;
	}
	
	@Override
	public String toString() {
		return String.format("M331 [type=%s, color=%s, price=%s, dpi=%s]", type, color, price, dpi);
	}
	
	public void click() {
		System.out.printf("클릭!! %s\n", type);
	}
	
	public void charge() {
		System.out.println("충전합니다.");
	}
}