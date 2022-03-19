package com.test.java.question.forloop;

public class Q8 {
	
	// 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.

	public static void main(String[] args) {
		
		// 년, 월, 일을 변수로 빼면 유지보수시 편리
		int year = 2022;
		int month = 3;
		int date = 19;
		
		String day = getDay(year, month, date);
		int total = calcDays(year, month, date);
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.",year, month, date, total, day);
		
	}

	// 날짜 계산 함수
	public static int calcDays(int year, int month, int date) {
		
		int dayCount = 0;
		
		// 2021년 12월 31일까지
		for (int i = 1 ; i < year ; i++) {
			
			if (isLeapYear(i)) {
				dayCount += 366;
			} else {
				dayCount += 365;
			}
		}
		
		// 2월까지 일수
		for (int i = 1 ; i < month ; i ++ ) {
			
			switch (i) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					dayCount += 31;
					break;
				case 2:
					dayCount += (isLeapYear(year)) ? 29 : 28;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					dayCount += 30;
					break;
				
			}
		}
		
		// 일수
		dayCount += date;
		
		return dayCount;
	}
	
	// 요일 구하는 함수
	public static String getDay(int year, int month, int date) {
		
		int dayCount = calcDays(year, month, date);
		
		if (dayCount % 7 == 1) {
			return "월";
		} else if (dayCount % 7 == 2) {
			return "화"; 
		} else if (dayCount % 7 == 3) {
			return "수";
		} else if (dayCount % 7 == 4) {
			return "목";
		} else if (dayCount % 7 == 5) {
			return "금";
		} else if (dayCount % 7 == 6) {
			return "토";
		} 
		return "일";
	}
	
	// 윤년 조건문
	public static boolean isLeapYear(int year) {
		
			if (year % 4 == 0) {
				
				if (year % 100 == 0) {
					
					if (year % 400 == 0) {
						return true;
					} else {
						return false;
					}
				} else {
					return true;
				}
			} else {
				return false;
			}
		}
	
}
	
