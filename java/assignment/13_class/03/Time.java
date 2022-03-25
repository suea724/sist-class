package com.test.java.obj.question.q3;

class Time {
	
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
		
		this.second = second % 60; // 초를 60으로 나눈 나머지
		this.minute = (minute + second / 60) % 60; // (초를 60으로 나눈 몫 + minute)의 나머지
		this.hour = hour + (minute + second / 60) / 60; // (초를 60으로 나눈 몫 + minute)의 몫 + hour
		}
	
	public String info() {
		return String.format("%02d:%02d:%02d", hour, minute, second);
	}

}
