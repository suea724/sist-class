package com.test.java.obj.question;

class Note {
	
	private String size;
	private String color;
	private int page;
	private String owner;
	private int price;
	
	public void setSize(String size) {
		
		if (size.equals("A3")
				||size.equals("A4")
				||size.equals("A5")
				||size.equals("B3")
				||size.equals("B4")
				||size.equals("B5")) {
			this.size = size;
		} else {
			System.out.println("크기가 유효하지 않습니다.");
		}
	}
	
	public void setColor(String color) {
		
		if (color.equals("검정색")
				||color.equals("흰색")
				||color.equals("노란색")
				||color.equals("파란색")) {
			this.color = color;
		} else {
			System.out.println("색상이 유효하지 않습니다.");
		}
	}
	
	public void setPage(int page) {
		
		if (page >= 10 && page <= 200) {
			this.page = page;
		} else {
			System.out.println("페이지 수는 10 ~ 200 사이의 값을 입력해주세요.");
		}
	}
	
	public void setOwner(String owner) {
		
		if (validOwner(owner)) {
			this.owner = owner;
		} else {
			System.out.println("소유자 이름이 올바르지 않습니다.");
		}
	}

	private boolean validOwner(String owner) {
		
		if (owner.length() < 2 || owner.length() > 5) {
			return false;
		}
		
		for (int i = 0 ; i < owner.length() ; i ++) {
			char c = owner.charAt(i);
			
			if (c < '가' || c > '힣') {
				return false;
			}
		}
		
		return true;
	}
	
	public String info() {
		
		String str = ("■■■■■■■노트 정보■■■■■■■\n");
		
		if (owner == null) {
			str += "주인없는 노트\n";
		} else {
			str += String.format("소유자: %s\n", owner);
			str += String.format("특성: %s 노트\n", property());
			str += String.format("가격: %,d원\n", calcPrice());
		}
		str += ("■■■■■■■■■■■■■■■■■■■■\n");
		
		return str;
	}

	private String property() {
		
		String str = color;
		
		if (page <= 50) {
			str += " 얇은 ";
		} else if (page >= 51 && page <= 100) {
			str += " 보통 ";
		} else {
			str += " 두꺼운 ";
		}
		str += size;
		
		return str; 
	}
	
	private int calcPrice() {
		
		price = 500;
		
		if (size.equals("A3")) {
			price += 400;
		} else if (size.equals("A4")) {
			price += 200;
		} else if (size.equals("B3")) {
			price += 500;
		} else if (size.equals("B4")) {
			price += 300;
		} else if (size.equals("B5")) {
			price += 100;
		}
		
		if (color.equals("검정색")) {
			price += 100;
		} else if (color.equals("노란색") || color.equals("파란색")) {
			price += 200;
		}
		
		price += (page - 10) * 10;
		
		return price;
	}
}
