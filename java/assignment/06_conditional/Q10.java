package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q10 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년 : ");
		int year = Integer.parseInt(reader.readLine());
		
		System.out.print("월 : ");
		int month = Integer.parseInt(reader.readLine());
		
		System.out.print("일 : ");
		int date = Integer.parseInt(reader.readLine());
		
		Calendar cal = Calendar.getInstance();
		cal.set(year, month - 1, date);
		int calDay = cal.get(Calendar.DAY_OF_WEEK);
		
		// 평일
		if ( calDay > 1 && calDay < 7 ) {
			
			System.out.println("입력하신 날짜는 \'평일\'입니다.");
			System.out.println("해당 주의 토요일로 이동합니다.");
			
			// 토요일로 이동하는 연산식 세 종류
			// 1. if문을 사용해서 각 요일 별로 조건을 두어 add 함수를 사용해서 이동한다.
			// 2. if문을 사용하지 않고, (7 - 입력받은 날짜의 요일)을 더해준다.
			// 3. Calendar의 set 함수를 사용하여 바로 그 주의 토요일로 이동한다.
			cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
			System.out.printf("이동한 날짜는 \'%tF\'입니다.", cal);
		
		// 주말
		} else {
			
			System.out.println("입력하신 날짜는 \'휴일\'입니다.");
			System.out.println("결과가 없습니다.");
		}
	}
}
