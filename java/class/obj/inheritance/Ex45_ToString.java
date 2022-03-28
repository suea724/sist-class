package com.test.java.obj.inheritance;

import java.util.Calendar;
import java.util.Date;

public class Ex45_ToString {

	public static void main(String[] args) {
		
		/**
		 * [Object.toString()]
		 * - 모든 객체는 toString() 소유
		 * - 자식 클래스에서 그대로 사용하지 않음 > 반드시 오버라이딩해서 사용
		 * - 자신이 소유한 데이터(멤버 변수)의 값을 문자열로 돌려주는 코드 > 덤프(dump)
		 * - 이클립스에서 자동 생성 기능 사용할 수 있음
		 * - 형식은 중요하지 않음 > 개발자만 보는 정보
		 */
		
		Time t1 = new Time(2, 30);
		System.out.println(t1.getHour());
		System.out.println(t1.getMin());
		
		System.out.println(t1.info()); // 객체의 상태를 한방에 확인
		
		Time t2 = new Time(5, 10);
		
		Date now = new Date();
		Calendar now2 = Calendar.getInstance();
		
		// 객체 내부 데이터 출력 > 객체의 toString()값 호출
		System.out.println(now);
		// System.out.println(now.toString());
		System.out.println(now2);
		// System.out.println(now2.toString());
		
		// 객체의 주솟값 출력
		System.out.println(t1); // com.test.java.obj.inheritance.Time@7c30a502 > 메모리 주소: hashCode
		System.out.println(t2); // com.test.java.obj.inheritance.Time@49e4cb85 > 메모리 주소: hashCode
		// = System.out.println(t2.toString()); // Object.toString() 상속
		
	}

}

// 클래스 = 멤버변수 + 생성자 + Getter/Setter + toString() 재정의
class Time {
	private int hour;
	private int min;
	
	public Time(int hour, int min) {
		this.hour = hour;
		this.min = min;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}
	
	public String info() {
		return String.format("%02d:%02d", hour, min);
	}

	// 이클립스 toString() 오버라이드 자동생성 기능 사용
	@Override
	public String toString() {
		return String.format("Time [hour=%s, min=%s]", hour, min);
	}

	// // info보다 공식적인 메서드
	// @Override
	// public String toString() { // 객체의 데이터를 알아볼 수 있게 문자열로 만들기
	// return String.format("%02d:%02d", hour, min);
	// }
	
}