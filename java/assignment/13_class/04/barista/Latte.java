package com.test.java.obj.question.q4.barista;

class Latte {
	
	private int bean;
	private int milk;
	
	public Latte(int bean, int milk) {
		 
		if (bean > 0 && milk > 0) {
			
			this.bean = bean;
			this.milk = milk;
			
			Coffee.bean += bean;
			Coffee.milk += milk;
			
			Coffee.beanTotalPrice += bean * Coffee.beanUnitPrice;
			Coffee.milkTotalPrice += milk * Coffee.milkUnitPrice;
			
			Coffee.latte ++;
			
		} else {
			System.out.println("입력 값이 잘못되었습니다.");
		}
		
	}

	public void drink() {
		System.out.printf("원두 %dg, 우유 %dml으로 만들어진 라떼를 마십니다.\n", bean, milk);
	}
}
