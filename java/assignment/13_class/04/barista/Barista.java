package com.test.java.obj.question.q4.barista;

class Barista {
	
	// espresso
	public Espresso makeEspresso(int bean) {
		Espresso espresso = new Espresso(bean);
		return espresso;
	}
	
	public Espresso[] makeEspressoes(int bean, int count) {
		
		Espresso[] espressoes = new Espresso[count];
		
		for (int i = 0 ; i < count ; i ++) {
			espressoes[i] = new Espresso(bean);
		}
		return espressoes;
	}
	
	// latte
	public Latte makeLatte(int bean, int milk) {
		Latte latte = new Latte(bean, milk);
		return latte;
	}
	
	public Latte[] makeLattes(int bean, int milk, int count) {
		
		Latte[] lattes = new Latte[count];
		
		for (int i = 0 ; i < count ; i ++) {
			lattes[i] = new Latte(bean, milk);
		}
		return lattes;
	}
	
	// americano
	public Americano makeAmericano(int bean, int water, int ice) {
		Americano americano = new Americano(bean, water, ice);
		return americano;
	}
	
	public Americano[] makeAmericanos(int bean, int water, int ice, int count) {
		
		Americano[] americanos = new Americano[count];
		
		for (int i = 0 ; i < count ; i ++) {
			americanos[i] = new Americano(bean, water, ice);
		}
		return americanos;
	}
	
	// 결과
	public void result() {
		System.out.println("============================");
		System.out.println("	판매결과");
		System.out.println("============================");
		System.out.println();
		
		System.out.println("----------------------------");
		System.out.println("	음료 판매량");
		System.out.println("----------------------------");
		System.out.printf("에스프레소: %d잔\n", Coffee.espresso);
		System.out.printf("아메리카노: %d잔\n", Coffee.latte);
		System.out.printf("라떼: %d잔\n", Coffee.americano);
		
		
		System.out.println("----------------------------");
		System.out.println("	원자재 소비량");
		System.out.println("----------------------------");
		System.out.printf("원두: %dg\n", Coffee.bean);
		System.out.printf("물: %,dml\n", Coffee.water);
		System.out.printf("얼음: %d개\n", Coffee.ice);
		System.out.printf("우유: %,dml\n", Coffee.milk);
		
		System.out.println("----------------------------");
		System.out.println("	매출액");
		System.out.println("----------------------------");
		System.out.printf("원두: %,d원\n", Coffee.beanTotalPrice);
		System.out.printf("물: %,d원\n", Coffee.waterTotalPrice);
		System.out.printf("얼음: %,d원\n", Coffee.iceTotalPrice);
		System.out.printf("우유: %,d원\n", Coffee.milkTotalPrice);
		
	}
	

}
