package com.test.java;

public class Ex23_For_Calendar {
	
	public static void main(String[] args) {
		m1();
	}
	
	private static void m1() {
			
			// 달력 만들기
			
			// 1. 월의 마지막 일
			// 2. 월의 1일의 요일
			
			int year = 2022;
			int month = 3;
			
			int lastDay = getLastDay(year, month);
			int day = 2; 
			
			System.out.println("===========================================");
			System.out.printf("		%d년 %d월\n", year, month);
			System.out.println("===========================================");
			System.out.println("[일]\t[월]\t[화]\t[수]\t[목]\t[금]\t[토]");
			System.out.println("===========================================");
			
			for (int i = 0 ; i < day ; i ++) {
				System.out.println("\t");
			}
			
			for (int i = 1 ; i <= lastDay ; i ++) {
				System.out.printf("%d\t", i);
				
				// 토요일 개행
				if ((i + day) % 7 == 0) {
					System.out.println();
				}
			}
			
		}
		
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
	
//	private static int getDayOfWeek(int year, int month) {
//		
//			if (date % 7 == 0) {
//				return "월";
//			} else if (date % 7 == 1) {
//				return "화"; 
//			} else if (date % 7 == 2) {
//				return "수";
//			} else if (date % 7 == 3) {
//				return "목";
//			} else if (date % 7 == 4) {
//				return "금";
//			} else if (date % 7 == 5) {
//				return "토";
//			} 
//			return "일";
//		}
//	}
	
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
