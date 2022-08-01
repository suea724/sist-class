package com.test.spring;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Check {
	
	// ���� �۾��� ���� �Ǵ� �󼼺��⿡ ����
	@Pointcut("execution(public String com.test.spring.BoardController.add*(..)) || execution(public String com.test.spring.BoardController.view(..))")
	public void pc1() {
		
	}
	
	@Before("pc1()")
	public void check(JoinPoint joinPoint) {
		HttpSession session = (HttpSession) joinPoint.getArgs()[0];
		HttpServletResponse response = (HttpServletResponse) joinPoint.getArgs()[1];
		
		// �α��� ���� ������ ��� list�� ��������
		if (session.getAttribute("auth") == null) {
			
			try {
				response.sendRedirect("/spring/list");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	

}
