package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex59_HashMap {

	public static void main(String[] args) {

		/**
		 * [ArrayList vs HashMap]
		 * 
		 * ArrayList
		 * 	- 요소 접근 > index 사용
		 * 	- 순서가 있는 데이터 집합 > index == 요소의 순서 (***********)
		 * 	- 스칼라 배열(Scalar Array)
		 * 	- 요소끼리 구분 불편함 > 식별자만 가지고 판단 힘듦 > 식별자가 숫자
		 * 	- 요소 일괄 접근 가능 > for문 사용
		 * 	- 데이터 중복 허용
		 * 
		 * HashMap
		 * 	- 요소 접근 > key 사용
		 * 	- 순서가 없는 데이터 집합 > index X 
		 * 	- 요소끼리 구분 용이 > 식별자 자체가 의미있는 단어
		 * 	- 요소 일괄 접근 불가능 > 루프X
		 *  - 요소 > 키(key) + 값(value) > 키와 값을 한쌍으로 갖는 데이터 구조 (***********)
		 *  - 키(key)는 유일, 값(value)는 중복 가능
		 *  - 데이터 중복 허용
		 *  - 사전(dictionary) 구조
		 */
		
		// <Key, Value>
		HashMap<String, Integer> map = new HashMap<>();
		
		// 요구사항: 점수 입력
		
		// 1. 요소 추가 > V put(K key, V value)
		map.put("국어", 100 );
		map.put("영어", 90 );
		map.put("수학", 80 );
		System.out.println(map);
		
		// 2. 요소 개수 > int size()
		System.out.println("size = " + map.size());
		
		// 3. 요소 읽기 > V get(K key)
		System.out.println("국어 점수 = " + map.get("국어"));
		System.out.println("영어 점수 = " + map.get("영어"));
		System.out.println("수학 점수 = " + map.get("수학"));
		
		System.out.println(map.get("과학")); // null 값 반환, 에러X
		
		// 4. + @ 일괄 탐색
		map.forEach((key, value) -> System.out.printf("%s=%d\n", key, value));
		
		// 5. 요소 수정 > V put(K key, V value) > key 값은 유일
		map.put("국어", 90);
		System.out.println(map);
		
		// 6. 요소 검색 > boolean containsKey(K key)
		//			  > boolean containsValue(V value)
		System.out.println(map.containsKey("과학"));
		System.out.println(map.containsValue(90));
		
		// 7. 요소 삭제 > V remove(K key)
		map.remove("영어");
		System.out.println(map);
		
		// 8. 모든 키 출력 > KeySet
		System.out.println(map.keySet());
		
		// 9. 초기화
		map.clear();
		System.out.println(map.isEmpty());
		
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("빨강");
		a1.add("파랑");
		a1.add("노랑");
		System.out.println(a1.get(0));
		
		HashMap<String, String> a2 = new HashMap<>();
		a2.put("Red", "빨강");
		a2.put("Yellow", "노랑");
		a2.put("Blue", "파랑");
		
	}

}
