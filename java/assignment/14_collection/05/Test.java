package com.test.java.collection.question.set;

public class Test {
	
	public static void main(String[] args) {
		
		//배열 생성
		MySet set = new MySet();

		//추가
		System.out.println("======add() 결과======");
		set.add("홍길동");
		set.add("아무개");
		set.add("하하하");
		set.add("하하하"); // 중복값
		System.out.println(set);

		//개수
		System.out.println("======size() 결과======");
		System.out.println(set.size());

		//삭제
		System.out.println("======remove() 결과======");
		set.remove("아무개");
		System.out.println(set);

		//개수
		System.out.println(set.size());

		System.out.println("======next() 결과======");
		//탐색 + 읽기
		while (set.hasNext()) {
		      System.out.println(set.next());
		}

		//초기화
		System.out.println("======clear() 결과======");
		set.clear();
		System.out.println(set.size());
		System.out.println(set);
		
		
	}

}
