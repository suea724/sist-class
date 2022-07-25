package com.test.spring.aop;

import java.time.LocalDateTime;

// 보조 업무 객체
public class Logger {
	
	public void log() {
		LocalDateTime now = LocalDateTime.now();
		System.out.printf("[LOG > %tF %tT] \n", now, now);
	}
}
