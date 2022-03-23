package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {
	
	// 요구사항: 이메일 주소를 입력받아 아이디와 도메인을 각각 추출하시오.
	// split or indexOf ? charAt?
	
	/**
	 * 1. indexOf()를 사용해 '@'기호의 위치를 찾고 substring으로 문자를 추출한다.
	 * 2. split()을 사용해 아이디와 도메인을 배열로 받는다. > 0번째 요소, 1번째 요소
	 */
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("이메일: ");
		String email = reader.readLine();
		
		// indexOf()
//		int idx = email.indexOf('@');
//		String id = email.substring(0,idx);
//		String domain = email.substring(idx+1);
//		
//		System.out.printf("아이디: %s\n", id);
//		System.out.printf("도메인: %s\n", domain);
		
		// split()
		String[] emailArr = email.split("@");
		System.out.printf("아이디: %s\n", emailArr[0]);
		System.out.printf("도메인: %s\n", emailArr[1]);
		
	}

}
