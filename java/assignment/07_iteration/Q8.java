package com.test.java.question.loop;

public class Q8 {
	
	// 서기 1년 1월 1일부터 오늘까지 며칠째인지 합을 구하시오.

	public static void main(String[] args) {
		
		System.out.printf("%d년 %d월 %d일은 %,d일째 되는 날이고 %s요일입니다.",2022, 3, 16, calcDays(2022,3,16), getDay(16));
		
	}

	// 날짜 계산 함수
	public static int calcDays(int year, int month, int date) {
		
		int dayCount = 0;
		
		// 1년 1월 1일 ~ 2022년 1월 1일 (윤년 계산)
		for (int i = 1 ; i < year ; i ++) {
			
			if (i % 4 == 0) {
				
				if (i % 100 == 0) {
					
					if (i % 400 == 0) {
						dayCount += 366;
					} else {
						dayCount += 365;
					}
				} else {
					dayCount += 366;
				}
			} else {
				dayCount += 365;
			}
		}
		
		// 1월 1일 ~ 2월 28일까지 일의 간격
		for (int i = 0 ; i < month - 1 ; i ++ ) {
			
			switch (month) {
				case 1:
				case 3:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12:
					dayCount += 30;
					break;
				case 2:
					dayCount += 27;
					break;
				case 4:
				case 6:
				case 9:
				case 11:
					dayCount += 29;
					break;
				
			}
		}
		
		// 1일 ~ 16일까지 일의 간격
		dayCount += date - 1;
		
		return dayCount;
	}
	
	// 요일 구하는 함수
	public static String getDay(int date) {
		
		if (date % 7 == 0) {
			return "월";
		} else if (date % 7 == 1) {
			return "화"; 
		} else if (date % 7 == 2) {
			return "수";
		} else if (date % 7 == 3) {
			return "목";
		} else if (date % 7 == 4) {
			return "금";
		} else if (date % 7 == 5) {
			return "토";
		} 
		return "일";
	}
}
	
