package com.test.java.obj.stereo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex56_Exception {

	public static void main(String[] args) {
		
		/**
		 * [예외, Exception]
		 * 	- 컴파일 타임에 발견 X, 실행 중에 발견 O
		 * 	- 런타임 오류
		 *  - 개발자가 미리 예측할 수도, 못할 수도 있음
		 *  - 프로그램 자체 문제 또는 외부 환경에 의해 발생하는 문제
		 *  
		 * [예외 처리, Exception Handling]
		 * 	1. 전통적인 방식
		 * 		- 제어문 사용(조건문)
		 * 		- 참 블럭에 비즈니스 코드가 있는 것이 좋음!
		 * 		
		 *  2. 전용 처리 방식
		 *  	- try-catch (finally)문 사용
		 *  	- try문에 비즈니스 코드, catch문에 예외 처리 코드 작성
		 *  
		 * [if문 vs try문]
		 * 	- if문 : 사전에 미리 검사해서 사고가 나지 않도록 처리
		 * 	- try문 : 일단 실행하면서 에러가 나면 그때 처리
		 * 
		 * [Exception e]
		 *  - 예외 객체
		 *  - 예외가 발생한 상황에 대한 정보를 알려줌
		 *  
		 * [예외 미루기]
		 * 	- 해당 영역에서 예외 처리를 할만한 상황이 안되면 호출하는 곳에 예외처리의 책임을 떠넘길 수 있다.
		 */
		
		// m1();
		// m2();
		// m3();
//		 try {
//			 m4();
//		 } catch (Exception e) {
//			 e.printStackTrace();
//		 }
		m5();
		
	}

	private static void m5() {
		
		/* 예외 던지기 */
		
		// 요구사항 : 숫자 입력 > 반드시 짝수만 입력, 홀수 들어오면 에러
		
		int num = 9;
		
		try {
			if (num % 2 != 0) { 
				throw new Exception("홀수를 입력하면 안됩니다."); // 강제로 에러 발생시킴, 오류 메세지 넣어줄 수 있음
			}
			System.out.println("업무 코드");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void m4() throws Exception {
		
		/* 예외 미루기 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// Unhandled exception type IOException
		String input = reader.readLine();
	}

	private static void m3() {
		
		/* 예외 종류별로 처리하기 */
		
		try {
			int num = 10;
			System.out.println(100 / num);
			// 에러 발생 시 throw new ArithmeticException -> catch문의 매개변수로 들어감
			
			int[] nums = {10, 20, 30};
			System.out.println(nums[2]);
			
			Parent p = new Parent();
			Child c;
			c = (Child)p;
			
//		} catch(Exception e) {
//			- 모든 예외를 한번에 처리
//			- 어떤 종류의 예외든 같은 예외 처리 방식 적용 
//		}
		
		// 각 오류에 대해 다른 예외 처리
		// try문에서 들어오는 Exception 객체를 차례로 비교
		} catch(ArithmeticException e) {
			System.out.println("0으로 나누기");
			
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("인덱스 오류");
			
		} catch(ClassCastException e) {
			System.out.println("형변환 오류");
			 
		} catch(Exception e) { // 나머지 예외 처리, catch문의 맨 마지막 위치에 있어야 함
			// Exception: 모든 예외 클래스의 부모 클래스
			e.printStackTrace();
		}
		
	}

	private static void m2() {
		
		/* Exception 객체의 역할 */
		
		// try-catch문 여러개를 병렬적으로 사용하면 코드의 가독성 매우 떨어짐
		int num = 10;
		
		try {
			System.out.println(100 / num);
		} catch(Exception e) {
			System.out.println("0으로 나누기");
		}
		
		int[] nums = {10, 20, 30};
		
		try {
			System.out.println(nums[0]);
		} catch(Exception e) {
			System.out.println("인덱스 오류");
		}
		
	}

	private static void m1() {
		
		// 요구사항 : 숫자를 입력받아 연산을 하시오.
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("숫자 입력: ");
		
		// [전통적인 방식]
		// 참 블럭에 비즈니스 코드가 들어있는 것이 가독성이 높음!
		// if (num != 0) {
		// // 비즈니스 코드
		// System.out.printf("100 / %d = %d\n", num, 100 / num);
		// } else {
		// // 예외 처리 코드
		// System.out.println("0은 입력할 수 없습니다.");
		// }
		
		// [전용처리 방식]
		// try문에 비즈니스 코드, catch문에 예외 처리 코드 작성
		// 1. try문의 코드를 실행 > 문제 없으면 빠져나감 (catch문 실행x)
		// 2. 예외 발생 시 남아있는 업무 코드의 실행 중단
		// 3. catch문으로 이동
		
		// try문 영역 > 예외가 발생할 것 같다고 예측이 가능한 최소한의 영역에만 적용
		
		try {
			int num = scanner.nextInt(); // 0일 경우 오류
			System.out.printf("100 / %d = %d\n", num, 100 / num);
			
		} catch (InputMismatchException e) {
			System.out.println("int 범위를 넘은 값은 입력할 수 없습니다.");
			System.out.println(e.getMessage()); // 예외 발생 원인 출력
			e.printStackTrace(); // 예외 발생했을 때 그대로 출력해줌
			
		} catch (ArithmeticException e){
			System.out.println("0은 입력할 수 없습니다.");
			System.out.println(e.getMessage());
			e.printStackTrace();
			
		} 
		
	}

}

class Parent {
	
	public int a;
	public int b;
	
}

class Child extends Parent {
	
	public int c;
	public int d;
	
}
