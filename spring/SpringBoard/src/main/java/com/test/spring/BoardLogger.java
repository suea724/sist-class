package com.test.spring;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardLogger {
	
	// 모든 페이지(URL) > 로그 기록
	
	@Pointcut("execution(public * com.test.spring.BoardController.*(..))")
	public void pc1() {
		
	}
	
	@After("pc1()")
	public void log(JoinPoint joinPoint) {

		HttpServletRequest req = null;
		HttpSession session = null;
		
		// pointcut의 request, session 객체 가져와서 정보 가져옴
		for (Object obj : joinPoint.getArgs()) {
			if (obj instanceof HttpServletRequest) {
				req = (HttpServletRequest) obj;
			} else if (obj instanceof HttpSession) {
				session = (HttpSession) obj;
			}
		}
		
		if (req != null && session != null) {
			
			// 언제? 누가? 접속했는지?
			Calendar now = Calendar.getInstance();
			
			System.out.printf("[LOG][%tF %tT - %s] %s \n", now, now, session.getAttribute("auth") != null ? session.getAttribute("auth") : "익명", req.getRequestURI());
			
		}
	}
}
