package com.test.java;

public class Ex23_For_Calendar {

	public static void main(String[] args) {
			
			// 달력 만들기
			// 필요한 것
			// 1. 월의 마지막 일 -> getLastDay
			// 2. 월의 1일의 요일 -> getFirstDayOfWeek
			
			int year = 2022;
			int month = 3;
			
			int lastDay = getLastDay(year, month);
			int dayOfWeek = getFirstDayOfWeek(year, month);
			
			// System.out.printf("%,d일\n", calcDays(year, month, date));
			// System.out.printf("%s요일\n", getDayOfWeek(year, month, date));
			
			
			System.out.println("====================================================");
			System.out.printf("		     %d년 %d월\n", year, month);
			System.out.println("====================================================");
			System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
			System.out.println("====================================================");
			
			// 첫번째 요일 만큼 tab
			for (int i = 0 ; i < dayOfWeek ; i ++) {
				System.out.print("\t");
			}
			
			// 1 ~ 마지막 날짜까지
			for (int i = 1 ; i <= lastDay ; i ++) {
				
				System.out.printf("%d\t", i);
				
				// i일 까지의 총 날짜가 토요일이면 개행
				if (calcDays(year, month, i) % 7 == 6) {
					System.out.println();
				}
				
			}
			
		}

	// 서기 1년 1월 1일부터 입력 날짜까지 날짜 구하기
	private static int calcDays(int year, int month, int date) {

		int total = 0;

		for (int i = 1; i < year; i++) {
			total += isLeapYear(i) ? 366 : 365;
		}

		for (int i = 1; i < month; i++) {
			total += getLastDay(year, i);
		}

		total += date;

		return total;
	}

	// 월의 마지막 날짜 구하기
	private static int getLastDay(int year, int month) {

		switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 2:
				return isLeapYear(year) ? 29 : 28;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;

		}
		return 0;

	}

	// 요일 구하기
	private static int getFirstDayOfWeek(int year, int month) {

		// 첫번째 날짜까지의 날짜 합
		int total = calcDays(year, month, 1);
		
		return total % 7;
		
		// 서기 1년 1월 1일은 월요일
		// if (total % 7 == 1) {
		// return "월";
		// } else if (total % 7 == 2) {
		// return "화";
		// } else if (total % 7 == 3) {
		// return "수";
		// } else if (total % 7 == 4) {
		// return "목";
		// } else if (total % 7 == 5) {
		// return "금";
		// } else if (total % 7 == 6) {
		// return "토";
		// }
		// return "일";
		
		
	}

	// 윤년 검사
	private static boolean isLeapYear(int year) {

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
