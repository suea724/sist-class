package com.test.java.datetime;

import java.util.Calendar;

public class Q1 {
	
	// 요구사항 : 현재 시간을 출력하는 메서드 선언하시오.
	
	public static void main(String[] args) {
		
		nowTime();
	}
	
	public static void nowTime() {
		
		Calendar now = Calendar.getInstance();
		
		String am_pm = now.get(Calendar.AM_PM) == 0 ? "오전" : "오후";
		int hour = now.get(Calendar.HOUR);
		int hourOfDay = now.get(Calendar.HOUR_OF_DAY);
		int min = now.get(Calendar.MINUTE);
		int sec = now.get(Calendar.SECOND);
		
		System.out.printf("현재 시간 : %d시 %02d분 %d초\n", hourOfDay, min, sec);
		System.out.printf("현재 시간 : %s %d시 %02d분 %d초\n", am_pm, hour, min, sec);
		
	}

}
