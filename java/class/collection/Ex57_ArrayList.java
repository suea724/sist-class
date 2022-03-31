package com.test.java.collection;

import java.util.ArrayList;

public class Ex57_ArrayList {

	public static void main(String[] args) {
		
		/**
		 * [컬렉션, Collection]
		 * 	- JCF, Java Collection Framework
		 * 	- (향상된) 배열
		 * 	- 기존 순수 배열의 성능 향상(입출력), 사용법 개량해서 클래스로 만들어놓음
		 * 	- 내부에 순수 배열을 가지고 있음 > ArrayList 클래스의 대부분의 기능이 내부 배열을 조작하는 기능들로 구성
		 * 	- 길이 가변(!)
		 * 	- 자료구조
		 * 
		 * [ArrayList]
		 * 	- ArrayList(C) -> List(I) -> Collection(I)
		 *  - 순수 배열과 구조가 가장 유사함
		 *  - 사용 빈도가 가장 높음
		 *  - 인덱스를 사용해서 요소에 접근
		 *  
		 *  [컬렉션 종류]
		 *  1. List 계열
		 *  	- ArrayList
		 *  	- LinkedList
		 *  	- Queue
		 *  	- Stack
		 *  	- Vector (legacy)
		 *  
		 *  2. Set 계열
		 *  	- HashSet
		 *  	- TreeSet
		 *  
		 *  3. Map 계열
		 *  	- HashMap
		 *  	- TreeMap
		 *  	- Properties (legacy)
		 *  	- HashTable (legacy)
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		m6();
	}

	private static void m6() {
		
		/* ArrayList 내부 배열 조작 방식 */
		
		// ArrayList
		ArrayList<Integer> list = new ArrayList<>();
		
		// [문제 #1]
		// 1. 가비지 발생 > 비용 발생
		// 2. 배열 요소의 깊은 복사 > 비용 발생
		// => 컬렉션에 반복적으로 데이터를 넣는 행위는 프로그램을 무겁게 할 수 있음 > 가변 특성을 유지하기 위함
		
		// <해결 방법>
		// - ArrayList의 초기 길이를 지정할 수 있다. (생성시 매개변수)
		
		// [문제 #2]
		// 값이 배열의 길이를 초과하면 무조건 더블링 됨 > 배열에 남는 공간이 생김 > 메모리 낭비
		
		// <해결 방법>
		// - 데이터 갯수에 맞게 배열의 길이 조정 > trimToSize
		// - 너무 자주 사용하면 가비지 발생 > 데이터 갯수에 대해 확신이 들때만 호출
		
		// => 모든 컬렉션에도 공통으로 적용
		
		for (int i = 0 ; i < 20 ; i ++) {  
			list.add(i);
		}
		
		for (int n : list) {
			System.out.println(n);
		}
		
		System.out.println();
		
		// 순수 배열
		int[] num = new int[20];
		for (int i = 0 ; i < 20 ; i ++) {
			num[i] = i;
		}
		
		for (int n : num) {
			System.out.println(n);
		}
		
	}

	private static void m5() {
		
		ArrayList<Student> list = new ArrayList<>();
		
		for (int i = 0 ; i < 5 ; i ++) {
			
			int kor = (int)(Math.random() * 41) + 60;
			int eng = (int)(Math.random() * 41) + 60;
			int math = (int)(Math.random() * 41) + 60;
			
			Student s = new Student("학생" + (i+1) ,kor, eng, math);
			list.add(s);
		}
		
		// 성적표 출력
		System.out.println("==============================================");
		System.out.println("           	  성적표");
		System.out.println("==============================================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]\t[총점]\t[평균]");
		
		for (Student s : list) {
			
			int total = s.getKor() + s.getEng() + s.getMath();
			double avg = total / 3.0;
			
			System.out.printf("%s\t%4d\t%4d\t%4d\t%4d\t%4.1f\n",
									s.getName(),
									s.getKor(),
									s.getEng(),
									s.getMath(),
									total,
									avg);
		}
		
	}

	private static void m4() {
		
		// 배열(또는 컬렉션)의 요소
		// - 값형 데이터, 문자열
		// - 객체
		ArrayList<Cup> list = new ArrayList<>();
		
		list.add(new Cup("black", 5000));
		list.add(new Cup("blue", 3000));
		list.add(new Cup("pink", 8000));
		list.add(new Cup("orange", 5000));
		list.add(new Cup("yellow", 5000));
		
		for (Cup cup : list) {
			System.out.println(cup);
		}
		
	}

	private static void m3() {
		
		// 1차원
		ArrayList<Integer> list1 = new ArrayList<>();
		// 2차원
		ArrayList<ArrayList<Integer>> list2 = new ArrayList<ArrayList<Integer>>();
		// 3차원
		ArrayList<ArrayList<ArrayList<Integer>>> list3 = new ArrayList<ArrayList<ArrayList<Integer>>>();
		
		// 2차원 컬렉션 초기화
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list2.add(list);
	}

	private static void m2() {
	
		/* ArrayList 사용법 */
		
		ArrayList<String> list = new ArrayList<>();
		
		// 1. 요소 추가 > boolean add(T value)
		// 배열의 마지막 위치에 추가하기 > append mode
		list.add("귤");
		list.add("바나나");
		list.add("사과");
		list.add("체리");
		list.add("딸기");
		list.add("파인애플");
		
		// 2. 요소의 갯수 > int size()
		System.out.println(list.size());
		System.out.println();
		
		// 3. 요소의 접근 > T get(int index)
		System.out.println(list.get(0));
		// System.out.println(list.get(6)); IndexOutOfBoundsException
		System.out.println(list.get(list.size() - 1));
		System.out.println();
		
		// 4. 요소의 수정 > T set(int index, T newValue)
		list.set(2, "파인애플");
		System.out.println(list.get(2));
		System.out.println();
		
		// 5. 요소의 삭제 > T remove(int index)
		//			   > boolean remove(T value): 중복되는 값이 있으면 처음으로 만나는 요소만 삭제
		// 시프트 발생! > 삭제된 방 이후의 모든 요소는 left shift가 발생 (***)
		// - 순수 배열은 요소 삭제 불가능
		
		// list.remove(2);
		list.remove("파인애플");
		
		// 6. 탐색 > 루프
		for (int i = 0 ; i < list.size() ; i ++) {
			System.out.printf("list[%d] = %s\n", i, list.get(i));
		}
		System.out.println();
		
		// Enhanced for > 뒤에는 배열 혹은 컬렉션
		for (String str : list) {
			System.out.println(str);
		}
		System.out.println();
		
		// 7. 요소 추가
		// 배열의 원하는 위치에 요소를 추가 > void add(int index, T value)
		// - Insert Mode
		// 삽입된 방 이후의 모든 요소 right shift 발생 ***
		list.add(2, "망고");
		for (String str : list) {
			System.out.println(str);
		}
		
		// 8. 요소의 검색 > int indexOf(T value)
		//			   > int lastIndexOf(T value)
		// 			   > boolean contains(T value)
		System.out.println(list.indexOf("체리"));
		System.out.println(list.contains("체리"));
		System.out.println();
		
		// 9. 초기화 > void clear()
		// - 모든 요소를 삭제
		list.clear();
		System.out.println(list.size());
		
		// 10. 빈 배열 확인 > boolean isEmpty()
		System.out.println(list.isEmpty());
		
	}

	private static void m1() {
		
		/* 배열과 ArrayList 비교 */
		
		// [순수 배열]
		// 타입 O, 길이 O
		int[] nums = new int[3];
		
		// 요소 추가 > index 사용
		nums[0] = 10;
		nums[1] = 20;
		nums[2] = 30;
		
		// 요소 접근
		System.out.println(nums[0]); // 식별자[인덱스] -> 인덱서
		System.out.println(nums[1]);
		System.out.println(nums[2]);
		
		// 길이
		System.out.println(nums.length);
		System.out.println();
		
		// [컬렉션]
		// 타입 O, 길이 X > 가변
		ArrayList<Integer> list1 = new ArrayList<>();
		
		// 요소 추가 > index 사용 X > Append > 차례대로 마지막 방에 넣음
		list1.add(10);
		list1.add(20);
		list1.add(30);
		
		// 요소 접근 > 메서드 사용
		System.out.println(list1.get(0));
		System.out.println(list1.get(1));
		System.out.println(list1.get(2));
		
		// 길이
		System.out.println(list1.size());
		
	}

}

class Cup {
	
	private String color;
	private int price;
	
	public Cup(String color, int price) {
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return String.format("Cup [color=%s, price=%s]", color, price);
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

	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	
}