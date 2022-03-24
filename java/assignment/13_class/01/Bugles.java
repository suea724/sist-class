package com.test.java.obj.question;

import java.util.Calendar;

class Bugles {
	
	private int price;
	private int weight;
	private Calendar creationTime;
	private int expiration;
	
	public void setWeight(int weight) {
		
		if (weight == 300 || weight == 500 || weight == 850) {
			this.weight = weight;
		} else {
			System.out.println("용량이 유효하지 않습니다.");
		}
	}
	
	public int getPrice() {
		
		switch (weight) {
			case 300:
				price = 850;
				break;
			case 500:
				price = 1200;
				break;
			case 850:
				price = 1950;
				break;
		}
		return price;
	}
	
	// 생산 일자
	public void setCreationTime(String creationTime) {
		
		String[] splited = creationTime.split("-");
		
		this.creationTime = Calendar.getInstance();
		
		this.creationTime.set(Calendar.YEAR,Integer.parseInt(splited[0]));
		this.creationTime.set(Calendar.MONTH,Integer.parseInt(splited[1])-1);
		this.creationTime.set(Calendar.DATE,Integer.parseInt(splited[2]));
	}
	
	// 
	public int getExpiration() {
		
		Calendar now = Calendar.getInstance(); // 현재
		int t = (int)((now.getTimeInMillis() - creationTime.getTimeInMillis()) / 1000 / 60 / 60 / 24); // 현재 - 생산일자
		
		switch (weight) {
			case 300: // 유통기한 7
				expiration = 6 - t;
				break;
			case 500: // 유통기한 10
				expiration = 9 - t;
				break;
			case 850: // 유통기한 15
				expiration = 14 - t;
		}
		return expiration;
	}
	
	public void eat() {
		
		if (getExpiration() > 0) {
			System.out.println("과자를 맛있게 먹습니다.");
		} else {
			System.out.println("유통기한이 지나 먹을 수 없습니다.");
		}
		System.out.println();
	}

}
