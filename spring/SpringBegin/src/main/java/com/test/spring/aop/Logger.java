package com.test.spring.aop;

import java.time.LocalDateTime;

// ���� ���� ��ü
public class Logger {
	
	public void log() {
		LocalDateTime now = LocalDateTime.now();
		System.out.printf("[LOG > %tF %tT] \n", now, now);
	}
}
