package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		String yearType;
		
		// 문자열을 선언하고 if문에서 문자열의 값을 설정하고 마지막에 출력문을 한번만 사용하는게 좋을지,
		// 각 조건마다 출력문을 사용하는 것이 좋을지 논의하였다.
		// 문자열의 값을 설정하고 마지막에 출력문을 한번만 사용하는 것이 더 간편한 것 같다.
		// if-else 병렬로 배치하지 않고 중첩해서 배치 하는 것이 조건의 각 분기를 쉽게 알 수 있는 것 같다.
		if (year % 4 == 0) {
			
			if (year % 100 == 0) {
				
				if (year % 400 == 0) {
					yearType = "윤년";
				} else {
					yearType = "평년";
				}
			} else {
				yearType = "윤년";
			}
		} else {
			yearType = "평년";
		}
		
		System.out.printf("%d년은 \'%s\'입니다.", year, yearType);
		
		// if (year % 4 != 0) {
		// yearStr = "평년";
		// } else {
		// if (year % 100 != 0) {
		// yearStr = "윤년";
		// } else {
		// if (year % 400 == 0) {
		// yearStr = "윤년";
		// } else {
		// yearStr = "평년";
		// }
		// }
		// }
		
		
		// if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
		// yearStr = "윤년";
		// } else {
		// yearStr = "평년";
		// }
		
	}
}
