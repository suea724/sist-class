package com.test.spring.di02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex02 {
	
	public static void main(String[] args) {
		
		// m1();
		m2();
	}

	private static void m2() {
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/di02/di02.xml");
		
		Hong hong = (Hong) context.getBean("hong");
		hong.run();
		
		Lee lee = (Lee) context.getBean("lee");
		lee.run();
	}

	private static void m1() {
		
		// ������ ȯ�� > ��ü ���� + �Ҹ� > ������ ���� => ���� XML �ʿ�
		
		// Pen ��ü ����
		Pen p1 = new Pen();
		p1.write();
		
		// XML ���� �б� > �ν� > ȣ��
		ApplicationContext context = new ClassPathXmlApplicationContext("./com/test/spring/di02/di02.xml");
		
		// getBean() > �ĺ��� �˻� > �ش� Ŭ������ �ν��Ͻ� ���� + ��ȯ
		Pen p2 = (Pen)context.getBean("pen"); // ID�� ã��
		p2.write();
		
		Brush b1 = (Brush)context.getBean("brush");
		b1.draw();
		
		Pen p3 = (Pen)context.getBean("p1"); // Name���� ã��
		Pen p4 = (Pen)context.getBean("p2");
		Pen p5 = (Pen)context.getBean("p3");
		
		p3.write();
		p4.write();
		p5.write();
	}

}
