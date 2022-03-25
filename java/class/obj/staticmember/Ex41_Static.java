package com.test.java.obj.staticmember;

public class Ex41_Static {
	
	public static void main(String[] args) {
		
		// 요구사항
		// 1. 펜을 생산하시오.
		// 2. 생산된 펜의 개수를 세시오

		/* Case 1 */ 
		// - Pen과 count간의 관계 약함 > 가독성이 낮음 (이름이 상관이 없음)
		// - 오차 발생 가능성 (count++ 누락시) 
		
		// int count = 0;
		//
		// Pen p1 = new Pen("monami", "black");
		// count++;
		//
		// Pen p2 = new Pen("monami", "black");
		// count++;
		//
		// Pen p3 = new Pen("monami", "black");
		// count++;
		//
		// System.out.println("볼펜 개수: " + count);
		
		/* Case 2 */
		// - count 변수를 객체 변수로 설정 > count 변수와 Pen의 관계를 강하게 연결 > 결합 > 가독성은 높아짐
		// Pen p1 = new Pen("monami", "black");
		// p1.count ++;
		//
		// Pen p2 = new Pen("monami", "black");
		// p1.count ++;
		//
		// Pen p3 = new Pen("monami", "black");
		// p1.count ++;
		//
		// // p1이라는 하나의 객체가 모든 펜들의 개수를 세는 공통적인 값을 대표로 저장할 이유가 없음
		// System.out.println("볼펜 개수: " + p1.count);
		
		/* Case 3 */
		// - Pen과 count 변수의 관계가 명확
		// - 소재 분명 > 여러 곳 > 유일 > 변수 딱 1개
		// Pen p1 = new Pen("monami", "black");
		// Pen.count ++;
		//
		// Pen p2 = new Pen("monami", "black");
		// Pen.count ++;
		//
		// Pen p3 = new Pen("monami", "black");
		// Pen.count ++;
		//
		// System.out.println("볼펜 개수: " + Pen.count);
		
		/* Case 4 */
		// - 생성자에서 객체 생성하는 동시에 count 증가
		// - 가장 이상적인 방법
		// - count ++ 누락 방지
		 Pen p1 = new Pen("monami", "black");
		 Pen p2 = new Pen("monami", "black");
		 Pen p3 = new Pen("monami", "black");
		 
		 System.out.println("볼펜 개수: " + Pen.count);
				
	}

}

class Pen {
	
	private String model;
	private String color;
	public static int count = 0; // 공용 데이터
	
	public Pen(String model, String color) {
		this.model = model;
		this.color = color;
		Pen.count ++;
	}
	
	public String dump() {
		return String.format("{ model: %s, color: %s }", model, color);
	}
}

//class Pen {
//	
//	private String model;
//	private String color;
//	public int count = 0;
//	
//	public Pen(String model, String color) {
//		this.model = model;
//		this.color = color;
//	}
//	
//	public String dump() {
//		return String.format("{ model: %s, color: %s }", model, color);
//	}
//}

