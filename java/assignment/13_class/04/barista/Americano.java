package com.test.java.obj.question.q4.barista;

class Americano {
	
	private int bean;
	private int water;
	private int ice;
	
	public Americano(int bean, int water, int ice) {
		
		this.bean = bean;
		this.water = water;
		this.ice = ice;
		
		Coffee.bean += bean;
		Coffee.water += water;
		Coffee.ice += ice;
		
		Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
		Coffee.waterTotalPrice += (int)(water * Coffee.waterUnitPrice);
		Coffee.iceTotalPrice += ice * Coffee.iceUnitPrice;
		
		Coffee.americano ++;
	}

	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n", bean, water, ice);
	}
}
