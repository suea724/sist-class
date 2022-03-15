package com.test.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex20_If {

	public static void main(String[] args) throws Exception {

		// m1();
		// m2();
		// m3();
		m4();
	}

	private static void m1() {

		boolean flag = false;

		if (flag) {
			System.out.println("참입니다.");
		}

		int n = 10;

		if (n > 0) {
			System.out.println("양수입니다.");
		} else if (n < 0) {
			System.out.println("음수입니다.");
		} else {
			System.out.println("0입니다");
		}

		System.out.println("프로그램 종료");
	}

	private static void m2() throws Exception {

		// 요구사항 : 나이를 입력받아 성인, 미성년자 출력하기
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("나이 : ");
		int age = Integer.parseInt(reader.readLine());
		
		String result;
		
		if (age >= 19) {
			result = "성인";
		} else {
			result = "미성년자";
		}
		
		System.out.println(result);
	}
	
	private static void m3() throws NumberFormatException, IOException {
		
		// 보기 > 선택
		int sum = 0;
		System.out.println("Q. 무슨 색을 좋아합니까?");
		System.out.println("1. 검정색");
		System.out.println("2. 노란색");
		System.out.println("3. 파란색");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("선택 : ");
		int input1 = Integer.parseInt(reader.readLine());
		
		if (input1 == 1) {
			sum = 10;
		} else if (input1 == 2) {
			sum = 5;
		} else {
			sum = 3;
		}
		
		System.out.println("Q. 어떤 언어를 선호합니까?");
		System.out.println("1. Java");
		System.out.println("2. C#");
		System.out.println("3. C++");
		
		System.out.print("선택 : ");
		int input2 = Integer.parseInt(reader.readLine());
		
		if (input2 == 1) {
			sum += 10;
		} else if (input2 == 2) {
			sum += 3;
		} else {
			sum += 7;
		}
		
		System.out.println("완료되었습니다.");
		System.out.print("[결과] ");
		
		if (sum > 15) {
			System.out.println("진취적인 개발자");
		} else if (sum <= 15 && sum >= 10) {
			System.out.println("평범한 개발자");
		} else {
			System.out.println("다른 일 알아보세요~!");
		}
		
	}
	
	private static void m4() throws Exception {
		
		// 성적 입력받아 합격, 불합격 통보
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("성적: ");
		int score = Integer.parseInt(reader.readLine());
		
		// 점수 범위 0 ~ 100 > 유효성 검사
		// 동급이 아닌 조건이 섞여있음
		// if문, else if문 > 성적 처리
		// else > 유효성 검사
		if(score >= 60 && score <= 100) {
			System.out.println("합격");
		} else if (score >= 0 && score < 60){
			System.out.println("불합격");
		} else { 
			System.out.println("0과 100 사이의 값으로 입력해주세요!");
		}
		
		// 유효성 검사 따로 성적 처리 따로 (성격에 따라 조건 구분) 
		// 더 좋은 코드!
		// 중첩 조건문
		if (score >= 0 && score <= 100) { // 선조건
			
			if(score >= 60) {
				System.out.println("합격");
			} else {
				System.out.println("불합격");
			}
		} else {
			System.out.println("0과 100 사이의 값으로 입력해주세요!");
		}
	}
	
	private static void m5() {

	}

}
