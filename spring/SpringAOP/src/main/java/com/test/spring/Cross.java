package com.test.spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// ���� ���� ��ü
@Aspect // ���� ���� ��ü�� �ڰ� �Ҵ�
@Component // <bean>
public class Cross {
	
	// �־��� ���� > ����Ʈ�� ����
	@Pointcut("execution(public String com.test.spring.AOPController.test())")
	public void pc1() {
		// ������ > ���� X
	}
	
	// ���� ���� ���� + �־��� ����
	@After("pc1()")
	public void m1() {
		System.out.println("���� ����");
	}
	
	@Before("pc1()")
	public void m2() {
		System.out.println("���� ����2");
	}
}
