package com.test.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// ��Ʈ�ѷ� ����
// 1. Controller �������̽� ����
// 2. ������̼� ���

@Controller(value="/ex03.do")
public class Ex03Controller {
	
	// ��û �޼��� @RequestMapping
//	@RequestMapping
//	public String test() {
//		return "ex03";
//	}
	
	// ��û �޼��尡 void�� ��� �ּҿ� ������ �̸��� JSP�� �ڵ����� ã���ش�. > ���� ������� ����(������ ���� �Ұ�)
	@RequestMapping
	public void test() {
		System.out.println("test");
	}
}
