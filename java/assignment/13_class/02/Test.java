package com.test.java.obj.question.q2;

public class Test {

	public static void main(String[] args) {
		
		Box box1 = new Box();
		
		box1.cook();
		box1.check();
		box1.list();
		
		Refrigerator r = new Refrigerator();

		Item item1 = new Item();
		item1.setName("김치");
		item1.setExpiration("2022-4-8");
		r.add(item1);//냉장고에 넣기

		Item item2 = new Item();
		item2.setName("깍두기");
		item2.setExpiration("2022-4-1");
		r.add(item2);//냉장고에 넣기

		Item item3 = new Item();
		item3.setName("멸치볶음");
		item3.setExpiration("2022-4-3");
		r.add(item3);//냉장고에 넣기
		
		System.out.println();

		Item item4 = r.get("깍두기");//냉장고에서 꺼내기
		System.out.printf("%s의 유통기한 : %s\n", item4.getName(), item4.getExpiration());

		System.out.printf("냉장고 안의 총 아이템 개수 : %d개\n", r.count());
		System.out.println();

		r.listItem();
		
	}

}
