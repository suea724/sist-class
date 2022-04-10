package com.test.java.collection;

import java.util.TreeMap;

public class Ex71_TreeMap {

	public static void main(String[] args) {
		
		// Tree + Map
		// - 이진트리 구조의 Map
		// - 자동정렬 + 범위 검색(추출) 용이
		
		TreeMap<String, String> map = new TreeMap<>();
		
		map.put("white", "하양");
		map.put("black", "검정");
		map.put("yellow", "노랑");
		map.put("red", "빨강");
		map.put("green", "초록");
		
		System.out.println(map.size());
		System.out.println(map); // key 기준으로 정렬
		
		System.out.println(map.firstKey());
		System.out.println(map.firstEntry()); // 첫 key=value 한쌍
		
		System.out.println(map.lastKey());
		System.out.println(map.lastEntry()); // 마지막 key=value 한쌍
		
		System.out.println(map.headMap("m"));
		System.out.println(map.tailMap("m"));
		System.out.println(map.subMap("r", "y"));
		
		/**
		 * 공통 > 길이 가변
		 * 
		 * List
		 * 1. ArrayList : 배열이 필요할 때, 삽입/삭제 속도 느림
		 * 2. LinkedList : ArrayList 대체재, 삽입/삭제 속도 빠름
		 * 3. Stack : 스택 구조
		 * 4. Queue : 큐 구조
		 * 
		 * Set
		 * 5. HashSet : 중복값 배제한 집합이 필요할 때
		 * 6. TreeSet : Set의 정렬이 필요할 때
		 * 
		 * Map
		 * 7. HashMap : key=value 배열이 필요할 때
		 * 8. TreeMap : Map의 key에 대한 정렬이 필요할 떄
		 */
	}

}
