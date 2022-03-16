package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q8 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("[들어온 시간]");
		
		System.out.print("시 : ");
		int enterHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int enterMinute = Integer.parseInt(reader.readLine());
		
		System.out.println();
	
		System.out.println("[나간 시간]");
		
		System.out.print("시 : ");
		int exitHour = Integer.parseInt(reader.readLine());
		
		System.out.print("분 : ");
		int exitMinute = Integer.parseInt(reader.readLine());
		
		// 팀원들은 시간의 차이를 분으로 변환하여 parkingTime에 넣었다.
		// 하지만 그렇게 할 경우 계산은 편리하게 할 수 있지만,
		// hourDiff에 대한 유효성 검사를 할 수 없다. (나간 시간이 들어온 시간보다 빠를 경우에 hourDiff는 음수)
		int minDiff = exitMinute - enterMinute;
		int hourDiff = exitHour - enterHour;
		int parkingTime = 0;
		int parkingFee = 0;
		
		// 유효성 검사 변수 설정 (H: 0 ~ 23, M: 0 ~59)
		boolean isValidHour = (enterHour >= 0 && enterHour <= 23 && exitHour >= 0 && exitHour <= 23);
		boolean isValidMinute = (enterMinute >= 0 && enterMinute <= 59 && exitMinute >= 0 && exitMinute <= 59);
		
		// 데이터 유효성 검사 + 나간 시간이 들어온 시간보다 빠르면 안됨
		if (isValidHour && isValidMinute && hourDiff >= 0) {
			
			if (hourDiff == 0 && minDiff < 30) { // 주차 시간이 30분 미만인 경우
				parkingFee = 0;
			} else if (minDiff < 0) { // 분 차이가 음수일 경우 e.g. 13:50 ~ 14:20
				parkingTime = (hourDiff - 1) * 60 + (minDiff + 60);
				parkingFee = (parkingTime - 30) / 10 * 2000;
			} else {
				parkingTime = hourDiff * 60 + minDiff;
				parkingFee = (parkingTime - 30) / 10 * 2000;
			}
			
			System.out.printf("주차 요금은 %,d원 입니다.", parkingFee);
			
		} else {
			System.out.println("시간을 다시 입력해주세요.");
		}
		
	}
}
