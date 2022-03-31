package com.test.java.collection.question.arraylist;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		/*  ArrayList */
		ArrayList<String> list2 = new ArrayList<>();
		
		// 요소 추가
		list2.add("홍길동");
		list2.add("아무개");
		list2.add("호호호");
		list2.add("하하하");
		
		// toString() & size() 확인
		System.out.println(list2);
		System.out.println(list2.size());
		
		// 요소 가져오기
		for (int i = 0 ; i < list2.size() ; i ++) {
			System.out.println(list2.get(i));
		}
		
		// list2.get(6); IndexOutOfBoundsException
		
		// 요소 수정
		System.out.println(list2.set(0, "우하하"));
		System.out.println(list2);
		
		// 원하는 위치에 요소 추가
		list2.add(1, "김김김");
		System.out.println(list2);
		
		// indexOf
		if (list2.indexOf("홍길동") > -1) {
			System.out.println("홍길동 있음");
		} else {
			System.out.println("홍길동 없음");
		}
		
		// 초기화
		list2.clear();
		System.out.println(list2.size());
		System.out.println(list2);
		
		System.out.println();
		
		/* MyArrayList */
		MyArrayList list = new MyArrayList();
		
		// 요소 추가
		list.add("홍길동");
		list.add("아무개");
		list.add("호호호");
		list.add("하하하");
		
		// toString() & size() 확인
		System.out.println(list);
		System.out.println(list.size());
		
		// list.get(6); //ArrayIndexOutOfBoundsException

		// 요소 가져오기
		for (int i = 0 ; i < list.size() ; i ++) {
			System.out.println(list.get(i));
		}
		
		// 요소 수정 
		System.out.println(list.set(0, "우하하"));
		System.out.println(list);
		
		// 원하는 위치에 요소 추가
		list.add(1, "김김김");
		System.out.println(list);
		
		// 요소 개수에 맞는 배열
		list.trimToSize();
		System.out.println(list);
		
		// indexOf
		if (list.indexOf("홍길동") > -1) {
			System.out.println("홍길동 있음");
		} else {
			System.out.println("홍길동 없음");
		}
		
		// 초기화
		list.clear();
		System.out.println(list.size());
		System.out.println(list);
		
	}

}
