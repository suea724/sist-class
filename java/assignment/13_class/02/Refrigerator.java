package com.test.java.obj.question.q2;

class Refrigerator {
	
	private Item[] items = new Item[100];
	int cnt = 0; // = 배열 length
	
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
		
		// 배열의 모든 요소를 검사하는 것 보다는 배열이 들어있는 요소의 갯수만큼 for문을 돌리는 것이 효율적이다.
		for (int i = 0 ; i < cnt; i ++) {
			if (items[i].getName().equals(name)) {
				
				Item findItem = items[i]; // 복사해놓음
				
				for (int j = i ; i < items.length ; i ++ ) { // delete
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
		
		// 배열의 모든 요소를 검사하는 것 보다는 배열이 들어있는 요소의 갯수만큼 for문을 돌리는 것이 효율적이다.
		for (int i = 0 ; i < cnt ; i ++) {
			System.out.printf("%s(%s)\n", items[i].getName(), items[i].getExpiration());
		}
	}

}
