package com.test.java.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import com.test.data.Data;
import com.test.data.User;

public class Ex75_Stream {

	public static void main(String[] args) {
		
		/**
		 * [자바 스트림]
		 * 1. 입출력 스트림
		 * 	- 파일 입출력, 콘솔 입출력, 네트워크 입출력 등..
		 * 
		 * 2. 스트림
		 * 	- Java 8(JDK 1.8) 버전에서 람다식과 함께 나온 기능
		 * 	- 배열(컬렉션)의 탐색(조작) 지원 기술
		 * 	- 파일 입출력 지원
		 * 	- 디렉토리 탐색 지원
		 * 	- 익명 객체가 필요함 > 람다식을 사용할 수 있음
		 * 	- 스트림은 일회용
		 * 
		 * [배열, 컬렉션 탐색]
		 * 	1. for문 (루프 변수)
		 *  2. 향상된 for문
		 *  3. iterator
		 *  4. tmxmfla
		 *  
		 * [람다식 + 표준 API 함수형 인터페이스]
		 *  - (매개변수) -> {구현부};
		 *  - 익명 객체가 구현한 추상 메서드를 표현하는 표현식
		 *  
		 *  - 인터페이스 참조변수 = (매개변수) -> {구현부} // 정의
		 *  - 참조변수.추상메서드()
		 *  
		 * 1. Consumer
		 * 	- (매개변수) -> {구현부}
		 * 
		 * 2. Supplier
		 * 	- () -> {return 값}
		 * 
		 * 3. Function
		 * 	- (매개변수) -> {return 값}
		 * 
		 * 4. Operator
		 * 	- (매개변수) -> {return 값}
		 * 	- 매개변수와 반환값의 자료형이 동일
		 * 
		 * 5. Predicate
		 *  - (매개변수) -> {return 값}
		 *  - 반환값 boolean
		 */
		
		int[] ns = {10, 20, 30};
		int[] copyNs = ns.clone(); // 깊은 복사 메서드
		
		// m1();
		// m2();
		// m3();
		m4();
		
	}

	private static void m4() {
		
		/**
		 * 스트림 객체를 얻어오는 방법
		 * - stream() 메서드를 사용한다.
		 * 1. 배열로부터
		 * 2. 컬렉션으로부터
		 * 3. 숫자범위로부터
		 * 4. 파일로부터
		 * 5. 디렉토리로부터 
		 */
		
		// 1. 배열로부터
		int[] nums1 = {10, 20, 30, 40, 50};
		// nums1.stream()
		Arrays.stream(nums1).forEach(num -> System.out.println(num));
		System.out.println();
		
		// 2. 컬렉션으로부터
		// ArrayList
		ArrayList<Integer> nums2 = new ArrayList<>();
		nums2.add(100);
		nums2.add(200);
		nums2.add(300);
		
		nums2.stream().forEach(num -> System.out.println(num));
		
		// LinkedList
		LinkedList<Integer> nums3 = new LinkedList<>();
		nums3.add(1000);
		nums3.add(2000);
		nums3.add(3000);
		
		nums3.forEach(num -> System.out.println(num)); // stream 생략
		
		// HashSet
		HashSet<Integer> nums4 = new HashSet<>();
		nums4.add(10000);
		nums4.add(20000);
		nums4.add(30000);
		
		nums4.forEach(num -> System.out.println(num));
		
		// HashMap
		HashMap<String, Integer> nums5 = new HashMap<>();
		
		nums5.put("one", 1);
		nums5.put("two", 2);
		nums5.put("three", 3);
		
		nums5.forEach((key, value) -> System.out.println(key + "=" + value));
		
		// 3. 숫자범위로부터
		// Stream<Integer> : 범용 스트림
		// IntStream 	   : 전용 스트림
		IntStream.range(1, 10).forEach(num -> System.out.println(num));
		System.out.println();
		
		// 4. 파일로부터
		// - 스트림을 통해서 파일 읽기가 가능 (쓰기는 X)
		
		Path path = Paths.get("data\\number.txt");
		
		try {
			
			Files.lines(path).forEach(line -> System.out.println(line));
			System.out.println();
			
			// 5. 디렉토리로부터
			// - 목록 > dir.listFiles()
			Path dir = Paths.get("D:\\suea7\\class\\eclipse");
			
			Files.list(dir).forEach(p -> {
				System.out.println(p.getFileName());
			});
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private static void m3() {
		Data.getIntList().stream().forEach(num -> System.out.printf("%3d", num));
		System.out.println();
		
		Data.getStringList().stream()
			.forEach(str -> System.out.printf("%s(%d), ", str, str.length()));
		System.out.println();
	
		Data.getUserList().stream().forEach(user -> {
			System.out.println("[회원 정보]");
			System.out.println("이름: " + user.getName());
			System.out.println("나이: " + user.getAge());
			System.out.println("성별: " + (user.getGender() == 1 ? "남자" : "여자"));
		});
		System.out.println();
		
		Data.getItemList().stream().forEach(item -> {
			System.out.println(item.getName());
			System.out.println(item.getColor());
			System.out.println(item.getSize());
			System.out.println(item.getDate());
		});
	}

	private static void m2() {
		
		// 배열(컬렉션) 탐색
		List<String> list = Data.getStringList(30);
		
		// 1. for문
		for (int i = 0 ; i < list.size() ; i ++) {
			System.out.print(list.get(i) + "   ");
		}
		System.out.println();
		System.out.println();
		
		// 2. 향상된 for문
		for (String word : list) {
			System.out.print(word + "   ");
		}
		System.out.println();
		System.out.println();
		
		// 3. iterator
		Iterator<String> itr = list.iterator();
		
		while(itr.hasNext()) {
			System.out.print(itr.next() + "   ");
		}
		System.out.println();
		System.out.println();
		
		// 4. stream
		// forEach 메서드의 행동
		// 1. stream을 얻어낸 데이터 소스(list) > 요소를 하나씩 가져옴 (like 향상된 for문)
		// 2. 가져온 요소(데이터)를 Consumer의 매개변수로 전달해서 람다식(accept() 메서드)를 호출한다.
		
		// 각 요소마다 accept() 호출
		// e.g. "애플아케이드" -> c1.accept("애플아케이드"); 
		Stream<String> stream = list.stream();
		
		Consumer<String> c1 = (str) -> {System.out.println(str);};
		stream.forEach(c1); // 30회전
		stream.forEach(c1); // 0회전
		stream.forEach(c1); // 0회전
		
		Stream<String> stream2 = list.stream();
		stream2.forEach(str -> System.out.println(str));
		
		// 함수형 프로그래밍 > 메서드 체이닝 > 문장이 길다. (***)
		list.stream().forEach(str -> System.out.println(str));
	}

	private static void m1() {
		
		// 일반 배열
		int[] nums1 = Data.getIntArray();
		System.out.println(nums1.length);
		
		int[] nums2 = Data.getIntArray(10);
		System.out.println(nums2.length);
		
		// List 형식
		List<Integer> nums3 = Data.getIntList();
		System.out.println(nums3.size());
		
		List<Integer> nums4 = Data.getIntList(5);
		System.out.println(nums4.size());
		
		// 문자열
		String[] txt1 = Data.getStringArray();
		System.out.println(Arrays.toString(txt1));
		
		User[] list = Data.getUserArray(3);
		System.out.println(Arrays.toString(list));
	}
}
