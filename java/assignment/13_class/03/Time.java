package com.test.java.obj.question.q3;

class Time {
	
	/**
	 * 생성자 오버로딩을 구현하시오.
		- 2자리 출력
		- Time
			- 시간 클래스
			- 상태
				- hour: 시(0 이상 양의 정수)
				- minute: 분(0 이상 양의 정수)
				- second: 초(0 이상 양의 정수)
			- 행동
				- public Time()
					- 기본 생성자
					- 시(0), 분(0), 초(0)
				- public Time(int hour, int minute, int second)
					- 생성자 오버로딩
					- hour : 시
					- minute : 분
					- second : 초
				- public Time(int minute, int second)
					- 생성자 오버로딩
					- minute : 분
					- second : 초
				- public Time(int second)
					- 생성자 오버로딩
					- second : 초
				- String info()
					- 02:30:45
	 */
	
	// 두자리씩 출력
	// 양의 정수 -> 생성자에서 유효성 검사
	// 시간 올림
	private int hour;
	private int minute;
	private int second;
	
	public Time() {
		this(0, 0, 0);
	}
	
	public Time(int second) {
		this(0, 0, second);
	}
	
	public Time(int minute, int second) {
		this(0, minute, second);
	}
	
	public Time (int hour, int minute, int second) {
		
		if(validTime(hour, minute, second)) {
			this.second = second % 60; // 초를 60으로 나눈 나머지
			this.minute = (minute + second / 60) % 60; // (초를 60으로 나눈 몫 + minute)의 나머지
			this.hour = hour + (minute + second / 60) / 60; // (초를 60으로 나눈 몫 + minute)의 몫 + hour
		} else {
			System.out.println("시간은 양수로 입력해주세요.");
		}
		
	}
	
	// 유효성 검사 부분 추가
	private boolean validTime(int hour, int minute, int second) {
		
		if (hour < 0 || minute < 0 || second < 0) {
			return false;
		}
		
		return true;
	}
	
	public String info() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}
