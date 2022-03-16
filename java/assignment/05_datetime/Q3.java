package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q3 {
	
	// 요구사항 : 태어난 년도를 입력하면 나이를 출력하시오.
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("태어난 년도 : ");
		int birthYear = Integer.parseInt(reader.readLine());
		
		Calendar now = Calendar.getInstance();
		
		// 입력 받은 연도를 밀리세컨 단위로 바꿔서 연산할 수 있지만 코드가 길고 복잡해진다.
		// get 메서드로 올해 년도를 가져와 연도끼리 연산하면 계산식이 쉽고 깔끔해진다.
		int thisYear = now.get(Calendar.YEAR);
		
		int age = thisYear - birthYear + 1;
		
		System.out.printf("나이 : %d세", age);
		
	}
	
}
