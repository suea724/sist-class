package com.test.java;

import java.util.Calendar;
import java.util.Date;

public class Ex19_DateTime {
	
	/**
	 * 1. 현재 시각 만들기 > getInstance() + get()
	 * 2. 특정 시각 만들기 > set()
	 * 3. 시각 + 시간 = 시각 > add()
	 * 4. 시각 - 시간 = 시각 > add()
	 * 5. 시각 - 시각 = 시간 > getTimeInMillis()
	 * 6. 시간 + 시간 = 시간
	 * 7. 시간 - 시간 = 시간
	 *
	 */

	public static void main(String[] args) {
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		m8();
	}
	
	private static void m1() {
		
		// 현재는 잘 안쓰임
		Date date = new Date();
		System.out.println(date);
	}

	private static void m2() {
		
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
	
	private static void m3() {
		
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
	
	private static void m4() {
		
		// 원하는 시각 만들기
		// 1. 현재 시각 만들기
		// 2. 원하는 시각으로 만들기
		
		// 한 단위씩 세팅
		Calendar birthday = Calendar.getInstance();
		birthday.set(Calendar.YEAR ,1997);
		birthday.set(Calendar.MONTH, 6);
		birthday.set(Calendar.DATE, 24);
		
		birthday.set(Calendar.HOUR, 10);
		birthday.set(Calendar.MINUTE, 30);
		birthday.set(Calendar.SECOND, 0);
		
		System.out.printf("%tF %tT %tA\n",birthday, birthday, birthday);
	
		Calendar christmas = Calendar.getInstance();
		
		// 한번에 여러 단위 세팅
		// christmas.set(2022, 11, 25);
		christmas.set(2022, 11, 25, 18, 0);
		System.out.printf("%tF %tT %tA\n",christmas, christmas, christmas);
		
	}
	
	private static void m5() {
		
		// 시각 + 시간
		// 시각 - 시간
		
		Calendar now = Calendar.getInstance();
		// now 날짜
		System.out.printf("1일차 : %tF\n", now);
		
		now.add(Calendar.DATE, 100);
		
		System.out.printf("100일차 : %tF\n", now);
		
		// 원하는 날짜에서 100일 더하기
		Calendar birthday = Calendar.getInstance();
		birthday.set(1997, 6, 24);
		birthday.add(Calendar.DATE, 100);
		System.out.printf("내 백일 잔치: %tF\n", birthday);
		
		// 원하는 날짜에서 1년 더하기
		// 다시 날짜 세팅해야 함
		birthday.set(1997, 6, 24); 
		birthday.add(Calendar.YEAR, 1);
		System.out.printf("내 돌잔치: %tF\n", birthday);
		
		now = Calendar.getInstance();
		now.add(Calendar.DATE, -50);
		System.out.printf("%tFn", now);
		
		now = Calendar.getInstance();
		
		// 3시간 25분 뒤
		now.add(Calendar.HOUR, 3);
		now.add(Calendar.MINUTE, 25);
		System.out.printf("비타민 먹을 시간: %tT\n", now);
		
	}
	
	private static void m6() {
		
		// 시각 - 시각
		
		Calendar now = Calendar.getInstance();
		Calendar birthday = Calendar.getInstance();
		birthday.set(1997, 6, 24);
		
		// now - birthday : 내가 살아온 시간
		// 산술 연산자(-)은 값형을 대상으로 연산을 하기 때문에 사용 불가
		
		System.out.println(birthday.getTimeInMillis()); // 869706477609ms
		System.out.println(now.getTimeInMillis()); // 1647306477454ms
		System.out.println(now.getTimeInMillis() / 1000 / 60 / 60 / 24); // 1970.01.01 자정부터 며칠이 흘렀는지
		
		System.out.println((now.getTimeInMillis() - birthday.getTimeInMillis()) / 1000 / 60 / 60 / 24);
		
		// 올해 크리스마스 며칠 남았는지
		Calendar christmas = Calendar.getInstance();
		christmas.set(2022, 11, 25, 0, 0, 0);
		
		long nowTick = now.getTimeInMillis();
		long christmasTick = christmas.getTimeInMillis();
		
		System.out.println((christmasTick - nowTick) / 1000 / 60 / 60 / 24); // 284일
		
		// 18시까지 몇시간 남았는지
		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 18);
		end.set(Calendar.MINUTE, 0);
		
		long endTick = end.getTimeInMillis();
		System.out.println((double)(endTick - nowTick) / 1000 / 60 / 60); // 약 7.6시간
		
	}
	
	private static void m7() {
		
		// 2시간 30분 + 10분 = 2시간 40분
		// 특정 자료형이 존재하지 않음
		
		int hour = 2;
		int min = 30;
		
		min += 10;
		
		System.out.printf("%d시간 %d분\n", hour, min);
		
		// 2시간 30분 + 40분 = 3시간 10분
		hour = 2;
		min = 30;
		
		min += 40;
		
		hour = hour + (min / 60);
		min = min % 60;
		System.out.printf("%d시간 %d분\n", hour, min);
		
	}
	
	private static void m8() {
		
		// 현재 시각의 tick
		Calendar now = Calendar.getInstance();
		System.out.println(now.getTimeInMillis()); // 1647308014664
		
		System.out.println(System.currentTimeMillis()); // 1647308014779
	}

}
