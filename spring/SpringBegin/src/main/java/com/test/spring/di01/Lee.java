package com.test.spring.di01;

public class Lee {
	
	// DI 구현
	// 1. 생성자
	// 2. Setter
	
	// 의존 객체
	private Brush brush;
	
	// 외부에서 제공 > 생성자 
	public Lee(Brush brush) {
		this.brush = brush;
	}
	
	public void run() {
		
		// 의존 객체 생성 X 
		// Brush brush = new Brush();
		brush.draw();
	}

}
