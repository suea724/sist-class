package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	// 요구사항 : 문자 1개를 입력받아 아래와 같이 출력하시오.
	// f, F → Father
	// m, M → Mother
	// s, S → Sister
	// b, B → Brother
	// 유효성 검사를 하시오.(위의 문자가 아닌 문자는 예외 처리)
	

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("문자: ");
		char input = reader.readLine().charAt(0);
		
		boolean isF = input == 'f' || input == 'F';
		boolean isM = input == 'm' || input == 'M';
		boolean isS = input == 's' || input == 'S';
		boolean isB = input == 'b' || input == 'B';
		
		if (isF || isM || isS || isB) {
			
			if (isF) {
				System.out.println("Father");
			} else if (isM) {
				System.out.println("Mother");
			} else if (isS) {
				System.out.println("Sister");
			} else {
				System.out.println("Brother");
			}
			
		} else {
			System.out.println("입력한 문자가 올바르지 않습니다.");
		}
		
	}

}
