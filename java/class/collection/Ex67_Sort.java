package com.test.java.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

public class Ex67_Sort {

	public static void main(String[] args) {
		
		// m1();
		m2();
	}

	private static void m2() {
		
		ArrayList<Integer> nums = new ArrayList<>();
		
		nums.add(1);
		nums.add(6);
		nums.add(4);
		nums.add(9);
		nums.add(2);
		
		System.out.println("원래 ArrayList: " + nums);
		
		// 오름차순 정렬
		Collections.sort(nums);
		System.out.println("오름차순 정렬: " + nums);
		
		// 내림차순 정렬
		Collections.sort(nums, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		Collections.sort(nums);
		System.out.println("내림차순 정렬: " + nums);
		
		// ArrayList의 메서드 사용
		nums.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
			
		});
		
		System.out.println("ArrayList 메서드 사용: " + nums);
	}

	private static void m1() {
		
		String[] names = {"가가가", "아무개", "하하하", "다다다", "나나나"};
		
		// 기본 > 오름차순
		Arrays.sort(names);
		System.out.println(Arrays.toString(names));
		
		// 내림차순
		Arrays.sort(names, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) { 
				return o1.compareTo(o2) * -1; // 두 문자의 코드값 비교 (o1 - o2)
			}
			
		});
		System.out.println(Arrays.toString(names));
		
		Calendar[] dates = new Calendar[5];
		
		for(int i = 0 ; i < dates.length ; i ++) {
			dates[i] = Calendar.getInstance();
		}
		
		dates[0].add(Calendar.DATE, 7);
		dates[1].add(Calendar.DATE, 2);
		dates[2].add(Calendar.DATE, 1);
		dates[3].add(Calendar.DATE, 5);
		dates[4].add(Calendar.DATE, 4);
		
		for(Calendar c : dates) {
			System.out.printf("%tF\n", c);
		}
		System.out.println();
		
		// 오름차순 정렬
		Arrays.sort(dates);
		
		for(Calendar c : dates) {
			System.out.printf("%tF\n", c);
		}
		System.out.println();
		
		Arrays.sort(dates, new Comparator<Calendar>() {

			@Override
			public int compare(Calendar o1, Calendar o2) {
				
				// return (int)(o2.getTimeInMillis() - o1.getTimeInMillis());
				// => 두 값의 차이가 커지면 형변환 과정에서 데이터 손실 발생 가능!
				return o2.compareTo(o1);
			}
			
		});
		
		for(Calendar c : dates) {
			System.out.printf("%tF\n", c);
		}
		System.out.println();
	
	}

}
