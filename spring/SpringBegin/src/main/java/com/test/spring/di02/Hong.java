package com.test.spring.di02;

public class Hong {
	
	private Pen pen;
	
	// 생성자 주입
	public Hong(Pen pen) {
		this.pen = pen;
	}

	public void run() {
		pen.write();
	}
}
