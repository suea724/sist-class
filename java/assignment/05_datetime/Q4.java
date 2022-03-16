package com.test.java.question.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q4 {
	
	// 요구사항 : 남녀 커플의 이름과 만난날을 입력받아 기념일을 출력하시오.
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("남자 이름: ");
		String manName = reader.readLine();
		
		System.out.print("여자 이름: ");
		String womanName = reader.readLine();
		
		System.out.print("만난날(년): ");
		int metYear = Integer.parseInt(reader.readLine());
		System.out.print("만난날(월): ");
		int metMonth = Integer.parseInt(reader.readLine());
		System.out.print("만난날(일): ");
		int metDate = Integer.parseInt(reader.readLine());
		
		System.out.printf("\'%s\'과(와) \'%s\'의 기념일\n", manName, womanName);
		
		calcAnniversary(metYear, metMonth, metDate, 100);
		calcAnniversary(metYear, metMonth, metDate, 200);
		calcAnniversary(metYear, metMonth, metDate, 300);
		calcAnniversary(metYear, metMonth, metDate, 500);
		calcAnniversary(metYear, metMonth, metDate, 1000);
		
		// Calendar metDay = Calendar.getInstance();
		// metDay.set(metYear, metMonth - 1, metDate);
		//
		// metDay.add(Calendar.DATE, 100);
		// System.out.printf("100일 : %tF\n", metDay);
		//
		// metDay.set(metYear, metMonth - 1, metDate);
		// metDay.add(Calendar.DATE, 200);
		// System.out.printf("200일 : %tF\n", metDay);
		//
		// metDay.set(metYear, metMonth - 1, metDate);
		// metDay.add(Calendar.DATE, 300);
		// System.out.printf("300일 : %tF\n", metDay);
		//
		// metDay.set(metYear, metMonth - 1, metDate);
		// metDay.add(Calendar.DATE, 500);
		// System.out.printf("500일 : %tF\n", metDay);
		//
		// metDay.set(metYear, metMonth - 1, metDate);
		// metDay.add(Calendar.DATE, 1000);
		// System.out.printf("1000일 : %tF\n", metDay);
		
	}
	
	// 중복되는 부분을 함수로 정의하여 반복해서 코드를 작성해야 하는 과정을 줄였다. 
	public static void calcAnniversary(int metYear, int metMonth, int metDate, int days) {
		
		Calendar metCal = Calendar.getInstance();
		metCal.set(metYear, metMonth - 1, metDate);
		metCal.add(Calendar.DATE, days);
		System.out.printf("%d일 : %tF\n", days,metCal);
	}
	
}
