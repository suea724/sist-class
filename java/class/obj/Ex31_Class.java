package com.test.java.obj;

public class Ex31_Class {

	public static void main(String[] args) {
		
		/**
		 * [자주 나오는 단어]
		 * - 객체, Object
		 * - 클래스, Class
		 * - 인스턴스, Instance
		 * - 추상화
		 * - 정보 은닉
		 * - 인터페이스
		 * - 프로퍼티, 속성, 특성
		 * - 행동
		 * - 상속
		 * 
		 * [클래스 사용]
		 * 1. 클래스 선언(정의)
		 * 	class 클래스명 {
		 * 		클래스 멤버 구현
		 * 		1) 멤버 변수
		 * 		2) 멤버 메서드
		 * }
		 * 2. 클래스 사용 -> 객체 생성
		 * 		클래스명 객체명 = new 생성자();
		 * 
		 * [자바의 자료형]
		 * 1. 기본 자료형 : 8종류
		 * 2. 참조 자료형: 기본 자료형을 조합해서 만든 것 (갯수에 제한이 없음 -> 무한대)
		 */
		
		// 요구사항: 지도에서 좌표를 저장하고 호출해서 출력하세요.
		
		// Case 1: 변수 사용
		// 간편, 즉시 생성
		// 식별자 문제 > 같은 성질의 식별자가 서로 다른 이름을 사용해야 함 > 생산성, 유지보수에 bad
		//      	> 물리적인 제약이 존재하지 않음 > 사용자 경험 근거 > 구조 불안정 
		
		// 우리집 좌표
		int x = 100;
		int y = 200;
		
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", x, y);
		
		// 마트 좌표
		int x2 = 300;
		int y2 = 400;
		
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", x2, y2);
		
		// Case 2: 배열 사용
		// 데이터 저장의 구조 생성(물리적 제약 둠) > 관리 수월(용이) > 가독성 향상
		// 동일한 성격의 데이터는 동일한 식별자를 가지게 됨 (인덱스)
		// 배열 단점 > 요소 간 성질을 구분하기 힘듦 (누가 x? 누가 y?) > 배열에는 서로 다른 성질의 데이터를 넣으면 안됨
		
		int[] a1 = {100, 200};
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", a1[0], a1[1]);
		
		int[] a2 = {300, 400};
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", a2[0], a2[1]);
		
		int[] score = {100, 90, 80, 70, 60}; // 어떤 점수가 어떤 점순지?
		
		// Case 3: 클래스 사용
		// 클래스의 정의를 사용하여 메모리에 실체화하는 행동
		// 객체를 생성 (***)
		// 클래스는 자료형의 역할을 한다. (참조형)
		// 가독성이 증가
		
		// 객체 생성
		Point home = new Point();
		
		// 멤버 접근 연산자 사용
		home.x = 100;
		home.y = 200;
		
		Point mart = new Point();
		mart.x = 300;
		mart.y = 400;
		
		System.out.printf("우리집은 [%d,%d]에 위치합니다.\n", home.x, home.y);
		System.out.printf("마트는 [%d,%d]에 위치합니다.\n", mart.x, mart.y);
		
		// 요구사항: 크기 저장 > 너비(width) + 높이(height)
		
		Size s1 = new Size();
		
		s1.name = "rectangle";
		s1.height = 100;
		s1.width = 200;
		
		Size s2 = new Size();
		
		s2.name = "square";
		s2.height = 50;
		s2.width = 50;
		
		// 요구사항: 성적처리 > 국영수
		Score score1 = new Score();
		
		score1.name = "Sue";
		score1.kor = 100;
		score1.eng = 100;
		score1.math = 100;
		
		Score score2 = new Score();
		score2.name = "Kim";
		score2.kor = 100;
		score2.eng = 90;
		score2.math = 80;
		
	}
}

class Score {
	
	public String name;
	public int kor;
	public int eng;
	public int math;
}

// 클래스 선언 > 이름은 파스칼 표기법
class Point {
	
	// 클래스 멤버 변수
	public int x;
	public int y;
}

class Size {
	
	public String name;
	public int width;
	public int height;
}