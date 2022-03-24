package com.test.java.obj.question.q2;

class Box {

	// check 메서드로 요소 하나씩 체크
	// list는 dump 마카롱 프린트
	
	private Macaron[] list = new Macaron[10];
	
	public void cook() {
		
		for (int i = 0 ; i < list.length ; i ++) {
			Macaron m = new Macaron();
			m.setColor();
			m.setSize();
			m.setThickness();
			list[i] = m;
		}
		
		System.out.println("마카롱을 10개 만들었습니다.");
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
