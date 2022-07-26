package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	// Main > Controller (주 업무 통제)
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/aop/memo.xml");

		// 주 업무 객체
		// Memo memo = new MemoImpl();
		
		// 스프링을 통해 주 업무 객체 생성
		Memo memo = (Memo) context.getBean("memo");
		
		// 메모 쓰기
		memo.add("스프링 AOP 수업중");
		
		// 메모 읽기
		try {
			String txt = memo.read(15);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 메모 수정하기
		boolean result = memo.edit(5, "수정한 내용입니다.");
		
		// 메모 삭제하기
		result = memo.del(5);
	}
	

}
