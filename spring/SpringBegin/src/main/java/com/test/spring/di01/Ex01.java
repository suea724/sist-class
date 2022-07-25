package com.test.spring.di01;

public class Ex01 {
	
	public static void main(String[] args) {
		
		// - Ex01이 Pen을 의존(사용)한다.
		// - Pen은 Ex01의 의존 객체
		Pen pen = new Pen();
		pen.write();
		
		// Brush는 Ex01의 의존 객체
		Brush brush = new Brush();
		brush.draw();
		
		// Ex01 <- (의존관계) -> Hong(의존객체) <-> (의존관계) > Pen(의존객체)
		Hong hong = new Hong();
		hong.run();
		
		// 의존 주입
		Brush b = new Brush();
		
		Lee lee = new Lee(b);
		lee.run();
	}

}
