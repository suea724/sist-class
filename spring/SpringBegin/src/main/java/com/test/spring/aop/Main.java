package com.test.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	// Main > Controller (�� ���� ����)
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/aop/memo.xml");

		// �� ���� ��ü
		// Memo memo = new MemoImpl();
		
		// �������� ���� �� ���� ��ü ����
		Memo memo = (Memo) context.getBean("memo");
		
		// �޸� ����
		memo.add("������ AOP ������");
		
		// �޸� �б�
		String txt = memo.read(5);
		
		// �޸� �����ϱ�
		boolean result = memo.edit(5, "������ �����Դϴ�.");
		
		// �޸� �����ϱ�
		result = memo.del(5);
	}
	

}
