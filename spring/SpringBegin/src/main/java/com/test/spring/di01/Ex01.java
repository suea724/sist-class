package com.test.spring.di01;

public class Ex01 {
	
	public static void main(String[] args) {
		
		// - Ex01�� Pen�� ����(���)�Ѵ�.
		// - Pen�� Ex01�� ���� ��ü
		Pen pen = new Pen();
		pen.write();
		
		// Brush�� Ex01�� ���� ��ü
		Brush brush = new Brush();
		brush.draw();
		
		// Ex01 <- (��������) -> Hong(������ü) <-> (��������) > Pen(������ü)
		Hong hong = new Hong();
		hong.run();
		
		// ���� ����
		Brush b = new Brush();
		
		Lee lee = new Lee(b);
		lee.run();
	}

}
