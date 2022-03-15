package com.test.java.datetime;

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
		int thisYear = now.get(Calendar.YEAR);
		
		int age = thisYear - birthYear + 1;
		
		System.out.printf("나이 : %d세", age);
		
	}
	
}
