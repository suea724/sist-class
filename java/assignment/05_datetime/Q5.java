package com.test.java.datetime;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Calendar;

public class Q5 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("아빠 생일(년): ");
		int fBirthYear = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(월): ");
		int fBirthMonth = Integer.parseInt(reader.readLine());
		System.out.print("아빠 생일(일): ");
		int fBirthDate = Integer.parseInt(reader.readLine());
		
		System.out.print("딸 생일(년): ");
		int dBirthYear = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(월): ");
		int dBirthMonth = Integer.parseInt(reader.readLine());
		System.out.print("딸 생일(일): ");
		int dBirthDate = Integer.parseInt(reader.readLine());
		
		Calendar fBirthDay = Calendar.getInstance();
		fBirthDay.set(fBirthYear, fBirthMonth, fBirthDate);
		
		Calendar dBirthDay = Calendar.getInstance();
		dBirthDay.set(dBirthYear, dBirthMonth, dBirthDate);
		
		long dBirthDayTick = dBirthDay.getTimeInMillis();
		long fBirthDayTick = fBirthDay.getTimeInMillis();
		long birthDiff = (dBirthDayTick - fBirthDayTick) / 1000 / 60 / 60 / 24;
		System.out.printf("아빠는 딸보다 총 %,d일을 더 살았습니다.", birthDiff);
	}

}
