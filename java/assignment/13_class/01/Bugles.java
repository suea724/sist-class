package com.test.java.obj.question.q1;

import java.util.Calendar;

class Bugles {
	
	/*
		- Bugles 객체의 정보
			- 가격, 용량, 생산일자, 유통기한
			- 모든 멤버 변수의 접근 지정자는 private으로 한다.
			- 멤버 접근을 위한 Setter와 Getter를 정의한다.
				- 용량 : 쓰기 전용, 300g, 500g, 850g
				- 가격 : 읽기 전용, 850원(300g), 1200원(500g), 1950원(850g)
				- 생산일자 : 쓰기 전용(Calendar)
				- 남은유통기한 : 읽기 전용, 생산된 제품의 유통기한 기준 : 7일(300g), 10일(500g), 15일(850g)
		- Bugles 객체 메소드
			- void eat() : 과자 먹기
		- 먹을수 있는 날짜 = 유통기한 - 현재 - 제조시간
			- 5 : 먹을 수 있는 날짜가 5일 남음
			- -3 : 먹을 수 있는 날짜가 3일 지남
	 */
	
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
	// year, month, date를 각각 받아서 Calendar로 설정할 수 있게 할 수 있음
	// 호출할 때 String으로 편리하게 입력할 수 있도록 setter에서 설정해주는 것이 좋음
	public void setCreationTime(String creationTime) {
		
		String[] splited = creationTime.split("-");
		
		this.creationTime = Calendar.getInstance();
		
		this.creationTime.set(Calendar.YEAR,Integer.parseInt(splited[0]));
		this.creationTime.set(Calendar.MONTH,Integer.parseInt(splited[1])-1);
		this.creationTime.set(Calendar.DATE,Integer.parseInt(splited[2]));
	}
	
	// 유통기한
	public int getExpiration() {
		
		Calendar now = Calendar.getInstance(); // 현재
		int t = (int)((now.getTimeInMillis() - creationTime.getTimeInMillis()) / 1000 / 60 / 60 / 24); // 현재 - 생산일자
		
		// 생산일자부터 유통기한이 1일이기 때문에 계산시 1을 빼주어야 한다.
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
