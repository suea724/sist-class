package com.test.java.obj.question.q4.barista;

class Espresso {
	
	private int bean;
	
	public Espresso(int bean) {
		this.bean = bean;
		
		Coffee.bean += bean;
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		
		Coffee.espresso ++;
	}

	public void drink() {
		System.out.printf("원두 %dg으로 만들어진 에스프레소를 마십니다.\n", bean);
	}
	
}
