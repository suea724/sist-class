package com.test.spring.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;

// 보조 업무 객체
public class Logger {
	
	public void log() {
		LocalDateTime now = LocalDateTime.now();
		System.out.printf("[LOG > %tF %tT] \n", now, now);
	}
	
	public void time(ProceedingJoinPoint jp) {
		
		long begin = System.nanoTime();
		System.out.println("[LOG] 기록을 시작합니다.");
		
		try {
			jp.proceed(); // 주 업무가 실행
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		long end = System.nanoTime();
		
		System.out.println("[LOG] 기록을 종료합니다.");
		System.out.printf("[LOG] %dns \n", end - begin);
		
	}
	
	public void history(Object memo) {
		System.out.println("[LOG] 읽기 기록: " + memo);
	}
	
	public void check(Exception e) {
		System.out.println("[LOG] 예외 발생 " + e.getMessage());
	}
}
