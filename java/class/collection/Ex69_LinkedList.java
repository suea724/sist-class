package com.test.java.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Ex69_LinkedList {

	public static void main(String[] args) {
		
		// m1();
		// m2();
		m3();
	}

	private static void m3() {
		
		// 인터페이스 사용 예
		// ***인터페이스로 구현한 객체는 인터페이스 타입으로 선언***
		
		// ArrayList > LinkedList로 수정
		// 1. 참조변수의 자료형 수정
		// 2. 생성자 수정 필요
		
		//ArrayList<Integer> list = new ArrayList<>();
		List<Integer> list = new LinkedList<>();
		
		for (int i = 0 ; i < 1000000 ; i ++) {
			list.add(i);
		}
		System.out.println(list.size());
		
		
		// 유지보수 or 기능 추가 > ArrayList에 취약
		for (int i = 0 ; i < 5000 ; i ++) {
			list.remove(0);
		}
		
		System.out.println(list.size());
	}

	private static void m2() {
		
		ArrayList<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		long begin = 0, end = 0;
		
		// 1. 순차적으로 데이터 추가하기
		System.out.println("[순차적으로 데이터 추가하기]");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000000 ; i ++) {
			list1.add(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("ArrayList 작업 시간 :" + (end - begin) + "ms");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000000 ; i ++) {
			list2.add(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("LinkedList 작업 시간 :" + (end - begin) + "ms");
		System.out.println();
		
		// 2. 데이터 삽입하기, Insert
		System.out.println("[데이터 삽입하기]");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000 ; i ++) {
			list1.add(0, i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("ArrayList 작업 시간 :" + (end - begin) + "ms");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000 ; i ++) {
			list2.add(0, i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("LinkedList 작업 시간 :" + (end - begin) + "ms");
		
		// 3. 중간 데이터 삭제하기
		System.out.println("[데이터 삭제하기]");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000 ; i ++) {
			list1.remove(0);
		}
		end = System.currentTimeMillis();
		
		System.out.println("ArrayList 작업 시간 :" + (end - begin) + "ms");
		
		begin = System.currentTimeMillis();
		for (int i = 0 ; i < 1000 ; i ++) {
			list2.remove(0);
		}
		end = System.currentTimeMillis();
		
		System.out.println("LinkedList 작업 시간 :" + (end - begin) + "ms");
		
		// 4. 순차적으로 데이터 삭제하기
		
		System.out.println("[순차적으로 데이터 삭제하기]");
		
		begin = System.currentTimeMillis();
		for (int i = list1.size()-1 ; i >= 0 ; i --) {
			list1.remove(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("ArrayList 작업 시간 :" + (end - begin) + "ms");
		
		begin = System.currentTimeMillis();
		for (int i = list1.size()-1 ; i >= 0 ; i --) {
			list1.remove(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("LinkedList 작업 시간 :" + (end - begin) + "ms");
	}

	private static void m1() {
		
		// ArrayList vs LinkedList
		// - 사용법 유사 > 개발자의 경험
		// - 내부 구조가 다름 > 사용 용도가 다름
		
		// ArrayList
		// - 모든 컬렉션 중에서 요소에 접근하는 속도가 가장 빠르다.
		// - 요소의 삽입/삭제에 대한 비용이 많이 든다. (shift 발생) > 느림
		
		// LinkedList
		// - 요소에 접근하는 속도가 느리다. (특히 뒤에 있는 요소일 수록)
		// - 요소의 삽입/삭제에 대한 비용이 거의 없다. (shift 발생 X) > 빠름
		
		// 물리적 구조 + 사용법 (인터페이스)
		// Array + List
		// Linked + List
		// Hash + Map
		// Tree + Map
		// Hash + Set
		// Tree + Set
		
		// LinkedList 종류
		// 1. Linked-List : 일방 통행
		// 2. Double-Linked-List : 양방향 
		// 3. Double-Circular-Linked-List : 양방향 + 처음~끝 연결 > 자바에 구현된 LinkedList 
		
		ArrayList<Integer> list1 = new ArrayList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		
		list1.add(100);
		list1.add(200);
		list1.add(300);
		
		System.out.println(list1);
		
		list2.add(100);
		list2.add(200);
		list2.add(300);
		
		System.out.println(list2);
		
	}

}
