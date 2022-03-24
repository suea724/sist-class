package com.test.java.obj.question.q2;

class Refrigerator {
	
	private Item[] items = new Item[100];
	int cnt = 0;
	
	public void add(Item item) {
		
		if (cnt == items.length) { // 꽉 찬 경우
			System.out.println("냉장고 안이 꽉 찼습니다.");
			return;
		}
		
		items[cnt] = item;
		System.out.printf("'%s'를 냉장고에 넣었습니다.\n", item.getName());
		cnt++;
	}
	
	public Item get(String name) {
		
		for (int i = 0 ; i < cnt; i ++) {
			if (items[i].getName().equals(name)) {
				
				Item findItem = items[i]; // 복사해놓음
				
				for (int j = i ; i < items.length ; i ++ ) {
					items[j] = items[j+1];
				}
				cnt--;
				return findItem;
			}
		}
		return null;
	}
	
	public int count() {
		return cnt;
	}
	
	public void listItem() {
		
		System.out.println("[냉장고 아이템 목록]");
		
		for (int i = 0 ; i < cnt ; i ++) {
			System.out.printf("%s(%s)\n", items[i].getName(), items[i].getExpiration());
		}
	}

}
