package com.test.java.obj.question.q2;

class Box {

	// check 메서드로 요소 하나씩 체크
	// list는 dump 마카롱 프린트
	
	private Macaron[] list = new Macaron[10];
	
	public void cook() {
		
		// 마카롱의 상태가 결정되는 것은 Setter에서 하는 것보다 메서드 안에서 해주는 것이 좋다.
		String[] colors = {"red","blue","yellow","white","pink","purple","green","black"};
		
		for (int i = 0 ; i < list.length ; i ++) {
			
			Macaron m = new Macaron();
			// color의 length를 수정할 경우 변경하지 않아도 됨 (유지보수성 증가)
			int n =  (int)(Math.random() * colors.length); 
			m.setColor(colors[n]);
			
			n = (int)(Math.random() * 11) + 5;
			m.setSize(n);
			
			n = (int)(Math.random() * 20) + 1;
			m.setThickness(n);
			
			list[i] = m;
		}
		
		// (10개 -> list.length)로 바꾸는 것이 좋음 (유지보수성)
		System.out.println("마카롱을 "+ list.length +"개 만들었습니다.");
		System.out.println();
	}
	
	public void check() {
		
		int pass = 0;
		int fail = 0;
		
		for (int i = 0 ; i < list.length ; i ++) {
			
			if (validMacaron(list[i])) {
				pass ++;
			} else {
				fail ++;
			}
		}
		
		System.out.println("[박스 체크 결과]");
		System.out.printf("QC 합격 개수: %d개\n", pass);
		System.out.printf("QC 불합격 개수: %d개\n", fail);
		System.out.println();
	}
	
	private boolean validMacaron(Macaron macaron) { // 개별 마카롱 유효성 체크
		
		if (macaron.getSize() < 8 || macaron.getSize() > 14 
				|| macaron.getThickness() < 3 || macaron.getThickness() > 18 
				|| macaron.getColor().equals("black")) {
			return false;
		}
		return true;
	}
	
	public void list() {
		
		System.out.println("[마카롱 목록]");
		for (int i = 0 ; i < list.length ; i ++) {
			
			Macaron m = list[i];
			
			System.out.printf("%d번 마카롱: %dcm(%s, %dmm): %s\n" 
					, i+1, m.getSize(), m.getColor(), m.getThickness()
					, (validMacaron(m) ? "합격" : "불합격") );
		}
		System.out.println();
	}
}
