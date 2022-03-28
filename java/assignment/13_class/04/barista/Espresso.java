package com.test.java.obj.question.q4.barista;

class Espresso {
	
	private int bean;
	
	public Espresso(int bean) {
		
		if (bean > 0) {
			this.bean = bean;
			
			Coffee.bean += bean;
			Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
			
			Coffee.espresso ++;
			
		} else {
			System.out.println("입력 값이 잘못되었습니다.");
		}
		
	}
	
	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", bean);
	}
	
}
