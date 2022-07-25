package com.test.spring.di01;

public class Lee {
	
	// DI ����
	// 1. ������
	// 2. Setter
	
	// ���� ��ü
	private Brush brush;
	
	// �ܺο��� ���� > ������ 
	public Lee(Brush brush) {
		this.brush = brush;
	}
	
	public void run() {
		
		// ���� ��ü ���� X 
		// Brush brush = new Brush();
		brush.draw();
	}

}
