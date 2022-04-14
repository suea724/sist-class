package com.test.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.test.data.Data;
import com.test.data.User;

public class Ex76_Stream {

	public static void main(String[] args) {

		/**
		 * [스트림, Stream]
		 * 	- 데이터 소스로부터 탐색/조작 가능한 도구
		 * 	- list.stream().forEach
		 * 
		 * [파이프, pipe]
		 * 	- 스트림 객체의 메서드
		 * 	1. 중간 파이프
		 * 		- 반환값 > 스트림 O
		 * 		- filter(), distinct()
		 *  2. 최종 파이프
		 *  	- 반환값 > 스트림 X > void or 다른 자료형 
		 *  	- forEach()
		 *  
		 * [필터링]
		 * 	- filter()
		 * 	- 중간 처리 파이프
		 * 	- 앞의 스트림에서 조건에 맞는 요소만 남기고 맞지 않는 요소는 버린다. > 조건에 맞는 요소만 남아있는 스트림을 반환한다.
		 * 
		 * [중복 제거]
		 * 	- distinct()
		 * 	- 중간 처리 파이프
		 * 	- 앞의 스트림에서 중복 요소를 제거 후, 유일한 요소만 남아있는 스트림을 반환
		 * 	- Set의 성질과 유사함
		 * 
		 * [처리]
		 * 	- forEach()
		 * 	- 최종 처리 파이프
		 * 	- 앞의 스트림 요소를 최종 처리하는 메서드
		 * 
		 * [매핑]
		 * 	- map(), mapXXX()
		 * 	- 중간처리 파이프
		 * 	- 변환 작업에 사용한다. (**************)
		 * 	- 앞의 스트림을 처리 후 다른 타입의 스트림을 반환한다.
		 * 
		 */
		
		// m1();
		// m2();
		// m3();
		m4();
		
	}

	private static void m4() {
		
		/* map() */
		
		List<String> list = Data.getStringList(10);
		System.out.println(list);
		
		list.stream().filter(word -> word.length() <= 3).forEach(word -> System.out.println(word));
		System.out.println();
		
		// String 스트림 -> Integer 스트림
		list.stream().map(word -> word.length()).forEach(s -> System.out.println(s));
		System.out.println();
		
		// distinct 추가
		list.stream().map(word -> word.length()).distinct().forEach(s -> System.out.println(s));
		System.out.println();
		
		String[] names = {"홍길동", "아무개", "하하하", "테스트", "홍길동", "호호호", "유재석", "박명수"};
		
		// 풀네임 -> 성 제외한 이름만 포함한 스트림으로 변환
		Arrays.stream(names).map(name -> name.substring(1)).forEach(s -> System.out.println(s));
		System.out.println();
		
		// 객체 배열
		List<User> ulist = Data.getUserList();
		ulist.stream().forEach(user -> System.out.println(user));
		
		// 객체 스트림 -> 문자열 스트림
		ulist.stream().map(user -> user.getName()).forEach(user -> System.out.println(user));
		System.out.println();
		
		List<Student> slist = new ArrayList<>();
		slist.add(new Student("가가가", 90, 80, 70));
		slist.add(new Student("나나나", 90, 70, 60));
		slist.add(new Student("다다다", 70, 60, 40));
		slist.add(new Student("라라라", 80, 90, 100));
		slist.add(new Student("마마마", 78, 92, 88));
		
		// Student 스트림 -> String 스트림
		slist.stream().map(s -> {
			int total = s.getKor() + s.getEng() + s.getMath();
			if (total >= 180) {
				return "합격";
			} else {
				return "불합격";
			}
		}).forEach(result -> System.out.println(result));
		System.out.println();
		
		// 이름과 결과를 함께 출력하고 싶으면?
		slist.stream().map(s -> {

			int total = s.getKor() + s.getEng() + s.getMath();
			Result res = null;
			
			if (total >= 180) {
				res = new Result(s.getName(), "합격");
			} else {
				res = new Result(s.getName(), "불합격");
			}
			return res;
			
		}).forEach(result -> System.out.printf("%s(%s)\n"
												, result.getName()
												, result.getResult()));
	}

	private static void m3() {
		
		/* distinct() */
		
		List<Integer> list = Data.getIntList();
		System.out.println(list.size());
		
		// 요구사항: 위의 배열에서 중복값 제거
		// Case 1. Set 사용 > for문 사용해서 복사
		Set<Integer> set = new HashSet<>();
		for (Integer n : list) {
			set.add(n);
		}
		System.out.println(set.size());
		
		// Case 2. Collection 바로 복사
		Set<Integer> set2 = new HashSet<Integer>(list);
		System.out.println(set2.size());
		System.out.println();
		
		// Case 3. 스트림 객체의 distinct() 메서드 사용
		list.stream().distinct().forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		System.out.println();
		System.out.println(list.stream().count());
		System.out.println(list.stream().distinct().count());
		
		// 문자열 중복 검사
		String[] names = {"홍길동", "아무개", "하하하", "하하하", "홍길동", "호호호"};
		Arrays.stream(names).distinct().forEach(name -> System.out.printf("%4s", name));
		System.out.println();
		System.out.println();
		
		// 객체 중복검사
		List<Cup> clist = new ArrayList<>();
		
		clist.add(new Cup(Cup.BLACK, 200));
		clist.add(new Cup(Cup.WHITE, 300));
		clist.add(new Cup(Cup.BLUE, 400));
		clist.add(new Cup(Cup.YELLOW, 500));
		clist.add(new Cup(Cup.RED, 600));
		clist.add(new Cup(Cup.BLACK, 700));
		clist.add(new Cup(Cup.WHITE, 800));
		clist.add(new Cup(Cup.BLUE, 900));
		clist.add(new Cup(Cup.YELLOW, 1000));
		clist.add(new Cup(Cup.RED, 1100));
		
		// 기본적으로 같은 자료형(클래스)의 객체가 동일한 값(상태)을 가지더라도 다른 객체이다.
		// > 두 객체는 독립적으로 존재한다. (메모리 주소가 다름)
		
		// Set, distinct() > 중복 객체 제거
		// 1. hashCode() 재정의
		// 2. equals() 재정의
		clist.stream().distinct().forEach(cup -> System.out.println(cup));
		
	}

	private static void m2() {
		
		/* filter() 문자열에 대해 여러 조건 검사 */
		
		Data.getStringList().stream().filter(word -> word.length() >= 5).forEach(word -> System.out.println(word));
		System.out.println();
		
		// 몸무게가 70kg 이상인 user만 추출
		Data.getUserList().stream()
		.filter(user -> user.getWeight() >= 70)
		.forEach(user -> System.out.println(user));
		
		System.out.println();
		
		// 몸무게가 70kg 이상이고 남자 user만 추출
		Data.getUserList().stream()
		.filter(user -> user.getWeight() >= 70)
		.filter(user -> user.getGender() == 1)
		.forEach(user -> System.out.println(user));
		
		System.out.println();
		
		// 몸무게가 70kg 이상, 키가 180cm 이상인 남자 user만 추출
		Data.getUserList().stream()
		.filter(user -> user.getWeight() >= 70)
		.filter(user -> user.getGender() == 1)
		.filter(user -> user.getHeight() >= 180)
		.forEach(user -> System.out.println(user));
		
	}

	private static void m1() {
		
		/* filter() */
		
		List<Integer> list = Data.getIntList(20);
		System.out.println(list);
		
		// 요구사항: 짝수만 출력
		
		// forEach() 메서드 사용
		list.stream().forEach( n -> {
			if (n % 2 == 0) {
				System.out.printf("%4d", n);
			}
		});
		System.out.println();
		
		// filter() 메서드 사용
		// 1. list.stream() > 20개의 숫자 탐색
		// 2. filter() - 조건 > 20개의 숫자에 대해 조건 만족하는 요소로 스트림 생성
		// 3. forEach() - 소비 > 짝수만 들어있는 Stream 소비
		list.stream().filter(num -> num % 2 == 0).forEach(num -> System.out.printf("%4d" , num));
		System.out.println();
		
		// 짝수 + 50보다 큰지 검사
		// filter 안에 두 조건
		list.stream().filter(n -> n % 2 == 0 && n > 50).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		// filter 두번 사용 > 회전수 더 많음
		list.stream().filter(n -> n % 2 == 0).filter(n -> n > 50).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
	}

}

class Cup {
	
	public static final int BLACK = 1;
	public static final int WHITE = 2;
	public static final int RED = 3;
	public static final int YELLOW = 4;
	public static final int BLUE = 5;
	
	private int color;
	private int size;
	
	public Cup(int color, int size) {
		this.color = color;
		this.size = size;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public String toString() {
		return String.format("Cup [color=%s, size=%s]", color, size);
	}
	
	// 개발자 의도대로 Cup 객체를 비교하기 위해 메서드 재정의
	
	@Override
	public int hashCode() {
		// 비교하려는 객체의 상태(멤버 변수값)를 가지고 해시코드 생성
		return ("" + color + size).hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.hashCode() == ((Cup)obj).hashCode());
	}
}

class Student {
	
	private String name;
	private int kor;
	private int eng;
	private int math;
	
	public Student(String name, int kor, int eng, int math) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	@Override
	public String toString() {
		return String.format("Student [name=%s, kor=%s, eng=%s, math=%s]", name, kor, eng, math);
	}
	
}

// Stream<Student> -> map() -> Stream<Result>
class Result {
	
	private String name;
	private String result;
	
	public Result(String name, String result) {
		this.name = name;
		this.result = result;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
}