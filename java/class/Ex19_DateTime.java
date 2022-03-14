package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex19_DateTime {

	public static void main(String[] args) {
		
//		m1();
//		m2();
		m3();
	}
	
	public static void m1() {
		
		// 현재는 잘 안쓰임
		Date date = new Date();
		System.out.println(date);
	}
	
	public static void m2() {
		
		// Calendar는 싱글톤 객체로 생성되어 있음
		Calendar calendar = Calendar.getInstance();
		
		// 각 값이 무엇을 의미하는지 알기 어려움
		System.out.println(calendar.get(1));
		System.out.println(calendar.get(2));
		System.out.println(calendar.get(3));
		System.out.println(calendar.get(4));
		System.out.println(calendar.get(5));
		System.out.println();
		
		// 캘린더 상수 이용한 get 메서드 
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DATE));
		System.out.println(calendar.get(Calendar.HOUR)); // 시(12H)
		System.out.println(calendar.get(Calendar.MINUTE));
		System.out.println(calendar.get(Calendar.SECOND));
		System.out.println(calendar.get(Calendar.MILLISECOND));
		System.out.println(calendar.get(Calendar.AM_PM)); // 오전(0), 오후(1)

		System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 올해 1월 1일부터 경과일
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH)); // 이번달 경과일(DATE와 같음)
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 요일 : 1(일) ~ 7(토)

		System.out.println(calendar.get(Calendar.WEEK_OF_YEAR)); // 올해가 몇번째 주인지
		System.out.println(calendar.get(Calendar.WEEK_OF_MONTH)); // 올해가 몇번째 달인지

		System.out.println(calendar.get(Calendar.HOUR_OF_DAY)); // 시(24H)
		
	}
	
	public static void m3() {
		
		Calendar now = Calendar.getInstance();
		System.out.printf("오늘은 %d년 %d월 %d일 입니다.\n"
									,now.get(Calendar.YEAR)
									,now.get(Calendar.MONTH) + 1
									,now.get(Calendar.DATE));
		
		System.out.println();
		
		System.out.printf("지금은 %s %d시 %d분입니다.\n"
									,now.get(Calendar.AM_PM) == 0 ? "오전" : "오후"
									,now.get(Calendar.HOUR)
									,now.get(Calendar.MINUTE));
		
		System.out.println();
		
		// 날짜 형식 문자 사용하면 편리하게 출력할 수 있음
		// 2022-03-14
		System.out.printf("%tF\n", now);
		System.out.println();
		
		// 시, 분, 초 출력
		// 17:47:58
		System.out.printf("%tT\n", now);
		System.out.println();
		
		// 요일 출력 (localized)
		// 월요일
		System.out.printf("%tA\n", now);
		System.out.println();
	}

}
