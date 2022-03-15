package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9 {
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("년도 입력 : ");
		int year = Integer.parseInt(reader.readLine());
		String yearStr;
		
		if (year % 4 != 0) {
			yearStr = "평년";
		} else {
			if (year % 100 != 0) {
				yearStr = "윤년";
			} else {
				if (year % 400 == 0) {
					yearStr = "윤년";
				} else {
					yearStr = "평년";
				}
			}
		}
		
		
		// if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
		// yearStr = "윤년";
		// } else {
		// yearStr = "평년";
		// }
		
		System.out.printf("%d년은 \'%s\'입니다.", year, yearStr);
		
	}
}
