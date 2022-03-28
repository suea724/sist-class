package com.test.java.obj.question.q4.barista;

class Americano {
	
	private int bean;
	private int water;
	private int ice;
	
	public Americano(int bean, int water, int ice) {
		
		if (bean > 0 && water > 0 && ice > 0) {
			
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
			
		} else {
			System.out.println("입력 값이 잘못되었습니다.");
		}
		
	}

	public void drink() {
		System.out.printf("원두 %dg, 물 %dml, 얼음 %d개로 만들어진 아메리카노를 마십니다.\n", bean, water, ice);
	}
}
