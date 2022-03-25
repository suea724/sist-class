package com.test.java.obj.question.q4.packer;

class Packer {
	
	public static int pencilCount = 0;
	public static int eraserCount = 0;
	public static int ballPointPenCount = 0;
	public static int rulerCount = 0;
	
	public void packing(Pencil pencil) {
		System.out.printf("포장 전 검수: %s\n", pencil.info());
		pencilCount++;
		System.out.println("포장을 완료했습니다.");
	}
	
	public void packing(Eraser eraser) {
		System.out.printf("포장 전 검수: %s\n", eraser.info());
		System.out.println("포장을 완료했습니다.");
		eraserCount++;
	}
	
	public void packing(BallPointPen ballPointPen) {
		System.out.printf("포장 전 검수: %s\n", ballPointPen.info());
		System.out.println("포장을 완료했습니다.");
		ballPointPenCount++;
	}
	
	public void packing(Ruler ruler) {
		System.out.printf("포장 전 검수: %s\n", ruler.info());
		System.out.println("포장을 완료했습니다.");
		rulerCount++;
	}
	
	public void countPacking(int type) {
		
		System.out.println("=========================");
		System.out.println("	포장 결과");
		System.out.println("=========================");
		
		switch(type) {
			
			case 0:
				System.out.printf("연필: %d회\n", pencilCount);
				System.out.printf("지우개: %d회\n", eraserCount);
				System.out.printf("볼펜: %d회\n", ballPointPenCount);
				System.out.printf("자: %d회\n", rulerCount);
				break;
			case 1:
				System.out.printf("연필: %d회\n", pencilCount);
				break;
			case 2:
				System.out.printf("지우개: %d회\n", eraserCount);
				break;
			case 3:
				System.out.printf("볼펜: %d회\n", ballPointPenCount);
				break;
			case 4:
				System.out.printf("자: %d회\n", rulerCount);
		}
		
		System.out.println();
	}
	
}
