package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Ex61_HashSet {

	public static void main(String[] args) {
		
		/**
		 * [Set]
		 *  - 순서가 없는 데이터 집합 
		 *  - 식별자가 없음 > 방과 방을 구분할 수 없다. 
		 *  - 데이터 중복을 허용하지 않는 자료구조. (**************)
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		m5();
	}

	private static void m5() {
		
		// set은 식별자가 없어서 순회할 방법이 없기 때문에, Iterator 객체를 사용함.
		
		HashSet<String> set = new HashSet<>();
		
		set.add("마우스");
		set.add("키보드");
		set.add("아이패드");
		set.add("모니터");
		set.add("노트북");
		
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	private static void m4() {
		
		// p1과 p3의 상태가 동일, 하지만 다른 객체!
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("아무개", 25);
		Person p3 = new Person("홍길동", 20);
		
		// 모든 참조형 비교 equals() > 문자열 포함
		System.out.println(p1.equals(p3)); 
		
		System.out.println(p1.hashCode()); 
		System.out.println(p3.hashCode()); 
		
		// 객체로 비교하지 않고, 상태로 비교하고 싶으면? > hashCode(), equals() 오버라이딩
		
		// HashSet이 중복값을 체크할 때, hashCode()와 equals() 메서드를 사용
		HashSet<Person> set = new HashSet<>();
		
		set.add(new Person("홍길동", 20)); // 상태 중복
		set.add(new Person("아무개", 25));
		set.add(new Person("김김김", 28));
		set.add(new Person("홍길동", 20)); // 상태 중복 > 입력안됨 
		
		System.out.println(set);
	}

	private static void m3() {
		
		// Set은 객체를 취급할 때 메모리의 생성된 인스턴스를 구분함.
		
		HashSet<Person> set = new HashSet<>();
		
		set.add(new Person("홍길동", 20)); // 데이터 중복
		set.add(new Person("아무개", 25));
		set.add(new Person("김김김", 28));
		set.add(new Person("홍길동", 20)); // 데이터 중복 > 입력O
		
		Person p = new Person("하하하", 26);
		
		set.add(p); // 객체 중복
		set.add(p); // 객체 중복 > 입력X
		
		// => 홍길동 vs 하하하 : new 호출 횟수 차이 (객체 생성 횟수)
		
		Person p2 = new Person("하하하", 26);
		
		System.out.println(p.hashCode()); 
		System.out.println(p2.hashCode());
		
		// => 다른 해시 코드 값을 가짐
		
		System.out.println(set);
	}

	private static void m2() {
		
		// 로또 번호 > 중복되지 않는 난수 생성
		
		// Case 1. ArrayList
		ArrayList<Integer> lotto = new ArrayList<>();
		
		for (int i = 0 ; i < 6 ; i ++) {
			
			boolean flag = false;
			int n = (int)(Math.random() * 45) + 1;
			
			for (int j = 0 ; j < i ; j ++) {
				if (lotto.get(j) == n) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				lotto.add(n);
			} else {
				i--;
			}
		}
		
		System.out.println(lotto);
		
		// Case 2. HashSet => 쉬움!
		HashSet<Integer> lotto2 = new HashSet<>();
		
		while(lotto2.size() < 6) {
			int n = (int)(Math.random() * 45) + 1;
			lotto2.add(n);
		}
		
		System.out.println(lotto2);
		
	}

	private static void m1() {
		
		HashSet<String> set = new HashSet<>();
		
		// 요소 추가
		set.add("사과");
		set.add("바나나");
		set.add("복숭아");
		
		// 요소 개수
		System.out.println(set.size());
		
		// 덤프
		System.out.println(set);
		
		// 중복된 요소를 추가한다면? > 안들어감
		set.add("바나나");
		System.out.println(set);
		
		// 요소 삭제
		set.remove("사과");
		System.out.println(set);
		
	}

}

class Person {
	
	private String name;
	private int age;
	
	public Person() {
		this("", 0);
	}
	
	public Person(String name, int age) {
		
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return String.format("[name=%s, age=%s]", name, age);
	}
	
	@Override
	public int hashCode() {
		
		// 원래는 자신의 메모리 주솟값을 반환
		
		// p1 > "홍길동", 20 > "홍길동20" > 100 
		// p2 > "아무개", 25 > "아무개25" > 200 
		// p3 > "홍길동", 20 > "홍길동20" > 100
		// => 같은 문자열일 때, 문자열의 hashCode값은 같음 (문자열 리터럴은 유일)
		
		return (name + age).hashCode();
	}	
	
	@Override
	public boolean equals(Object obj) {
		
		// 문자열의 hashCode값 비교
		return (this.hashCode() == obj.hashCode());
	}

}