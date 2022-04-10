package com.test.java.collection;

import java.util.Arrays;
import java.util.Comparator;

public class Ex66_Sort {

	public static void main(String[] args) {
		
		
		/**
		 * [배열 or ArrayList]
		 *  - 오름차순 정렬, 내림차순 정렬
		 *  1. 직접 구현 > 정렬 알고리즘 구현
		 *  2. JDK 제공 기능
		 * 
		 */
		
		// Arrays.sort(arr);
		
		// 오름차순 정렬
		Integer[] arr = {1,5,3,6,7,10,2};
		System.out.println(Arrays.toString(arr));
		
		// 내림차순 정렬 > 지원 X > 직접 구현(반조립)
		// 두번째 매개변수: Comparator 구현 객체 > 재사용되지 않음 > 익명 클래스(1회용 클래스)를 만들자!
		Arrays.sort(arr, new MyComparator());
		System.out.println(Arrays.toString(arr));
		
		MyComparator mc = new MyComparator();
		System.out.println(mc.compare(10, 20)); // 필요없는 메서드,,
		
		// 두번째 매개변수에 익명 클래스 사용
		Arrays.sort(arr, new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1 - o2;
			}
			
		});
		
		System.out.println(Arrays.toString(arr));
		
	}

}

class MyComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		// o1 vs o2
		// 오름차순
		// 1. o1이 더 크면 > 양수 반환
		// 2. o2가 더 크면 > 음수 반환
		// 3. 같으면 0 반환 > 0 반환
		
		// 내림차순
		// 1. o1이 더 크면 > 음수 반환
		// 2. o2가 더 크면 > 양수 반환
		// 3. 같으면 0 반환 > 0 반환
		
		return o2 - o1;
	}
	
}
