package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex26_Array {

	public static void main(String[] args) throws Exception {
		
		/**
		 * Array
		 */

		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		m10();
		
	}

	private static void m10() {
		
		// 1~10 사이의 난수
		// 배열 안의 상태 > 확인
		int[] ns = new int[10];
		
		for (int i = 0 ; i < ns.length ; i ++) {
			ns[i] = (int)(Math.random() * 10) + 1;
		}
		
		System.out.println(dump(ns));
		System.out.println(Arrays.toString(ns)); 
	}
	
	// 배열의 상태를 문자열로 바꿔서 반환 > 덤프
	public static String dump(int[] arr) {
		
		String txt = "[";
		
		for (int i = 0 ; i < arr.length ; i ++) {
			
			if (i == arr.length - 1) {
				txt += arr[i];
				break;
			}
			
			txt += arr[i] + ", ";
		}
		
		txt += "]";
		
		return txt;
	}

	private static void m9() {

		// 배열 초기화 리스트
		int[] ns1 = new int[5];
		printArray(ns1);

		// 사용자 초기화
		ns1[0] = 100;
		ns1[1] = 90;
		ns1[2] = 80;
		ns1[3] = 70;
		ns1[4] = 60;
		printArray(ns1);

		int[] ns2 = new int[] {100, 90, 80, 70, 60};
		printArray(ns2);

		int[] ns3 = {100, 90, 80, 70, 60};
		printArray(ns3);

		String[] nameArray = {"홍길동", "아무개", "키키키"};
		printArray(nameArray);

	}

	private static void m8() {

		// 배열의 생성 직후 상태
		// 자동으로 초기화 됨

		int[] ns = new int[3];
		printArray(ns);
	}

	private static void m7() {

		int[] ns = new int[3];

		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;

		// 깊은 복사
		// 새로운 배열 생성
		int[] copy;
		copy = new int[ns.length];

		// 값형 복사 (요소끼리 복사)
		for (int i = 0; i < ns.length; i++) {
			copy[i] = ns[i];
		}

		printArray(ns);
		printArray(copy);

		ns[0] = 1;

		printArray(ns);
		printArray(copy);
	}

	public static void printArray(int[] ns) {

		for (int i = 0; i < ns.length; i++) {
			System.out.printf("[%d] : %d\n", i, ns[i]);
		}
		System.out.println();
	}

	public static void printArray(String[] ns) {

		for (int i = 0; i < ns.length; i++) {
			System.out.printf("[%d] : %s\n", i, ns[i]);
		}
		System.out.println();
	}

	private static void m6() {

		int a = 10; // 값형 : 값형 자체에 바로 데이터가 저장
		int b;

		// 값형 복사 > 공간이 가지는 값이 복사됨
		b = a;

		// 원본 수정해도 복사본 영향 X -> side effect X
		a = 20;

		System.out.println("a: " + a);
		System.out.println("b: " + b);

		int[] ns = new int[3]; // 참조형 : 데이터가 저장되어 있는 힙메모리의 주솟값이 저장

		ns[0] = 10;
		ns[1] = 20;
		ns[2] = 30;

		// ns 첫번째 요소의 주솟값
		System.out.println(ns);

		int[] copyNs;

		// 배열(참조형) 복사 > 주솟값이 복사됨
		copyNs = ns;
		System.out.println("복사 후 ns: " + ns[0]);
		System.out.println("복사 후 copyNs: " + copyNs[0]);

		// ns의 원본 수정하면 복사본에 영향 > side effect O > 주의!
		ns[0] = 30;

		// 배열 복사 시 각 데이터가 아닌 주솟값만 복사됨
		// 원본의 값을 변경하면 복사한 배열의 값도 변경됨
		// 두 배열은 같은 주솟값을 공유
		// 원본에서 데이터를 변경하면 힙 메모리의 공유하고 있는 데이터를 변경
		// 복사한 배열에도 반영됨
		System.out.println("값 변경 후 ns: " + ns[0]);
		System.out.println("값 변경 후 copyNs: " + copyNs[0]);

	}

	private static void m5() throws Exception {

		// 정적 할당 -> 컴파일 할 때 이미 배열의 길이가 정해짐
		int[] nums = new int[3];

		// 동적 할당 -> 컴파일 할 때 배열의 길이를 모름 > 런타임때 정해짐

		// 배열 길이 입력받아 할당
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("배열의 길이 입력: ");
		int length = Integer.parseInt(reader.readLine());

		int[] nums2 = new int[length];
		System.out.println(nums2.length);
	}

	private static void m4() {

		// 각 자료형 > 배열
		// 정수 배열(byte, int)
		byte[] list1 = new byte[3];
		list1[0] = 10;
		System.out.println(list1[0]);

		long[] list2 = new long[3];
		list2[0] = 2100000000000L;
		System.out.println(list2[0]);

		// 실수 배열(double)
		double[] list3 = new double[3];
		list3[0] = 3.14;
		System.out.println(list3[0]);

		// 문자 배열(char)
		char[] list4 = new char[3];
		list4[0] = 'A';
		System.out.println(list4[0]);

		// 논리 배열(boolean)
		boolean[] list5 = new boolean[3];
		list5[0] = true;
		System.out.println(list5[0]);

		// 문자열 배열(String) -> 참조형 변수
		String[] list6 = new String[3];
		list6[0] = "안녕하세요";
		System.out.println(list6[0]);
	}

	private static void m3() {

		int[] kors = new int[3];

		kors[0] = 100;
		kors[1] = 90;
		kors[2] = 80;

		// java.lang.ArrayIndexOutOfBoundsException
		// kors[3] = 70;

		for (int i = 0; i < kors.length; i++) {
			System.out.printf("kor[%d] = %d\n", i, kors[i]);
		}
	}

	private static void m2() {

		int[] korScore = new int[100];

		korScore[0] = 100;
		korScore[1] = 80;
		korScore[2] = 90;

		int total = korScore[0] + korScore[1] + korScore[2];
		double avg = total / korScore.length; // property, field

		for (int i = 0; i < korScore.length; i++) {
			total += korScore[i];
		}

	}

	private static void m1() {

		// 요구사항: 학생 3명의 국어점수 관리 > 총점, 평균

		int[] scoreList = {100, 80, 50};
		int sum = 0;

		for (int i = 0; i < scoreList.length; i++) {
			sum += scoreList[i];
		}

		System.out.println("총점: " + sum);
		System.out.println("평균: " + sum / 3.0);
	}

}
