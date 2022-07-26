package com.test.spring.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;

// ���� ���� ��ü
public class Logger {
	
	public void log() {
		LocalDateTime now = LocalDateTime.now();
		System.out.printf("[LOG > %tF %tT] \n", now, now);
	}
	
	public void time(ProceedingJoinPoint jp) {
		
		long begin = System.nanoTime();
		System.out.println("[LOG] ����� �����մϴ�.");
		
		try {
			jp.proceed(); // �� ������ ����
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		
		System.out.println("[LOG] ����� �����մϴ�.");
		System.out.printf("[LOG] %dns \n", end - begin);
		
	}
	
	public void history(Object memo) {
		System.out.println("[LOG] �б� ���: " + memo);
	}
	
	public void check(Exception e) {
		System.out.println("[LOG] ���� �߻� " + e.getMessage());
	}
}
