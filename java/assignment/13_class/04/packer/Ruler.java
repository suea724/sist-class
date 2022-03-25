package com.test.java.obj.question.q4.packer;

class Ruler {
	
	private int length;
	private String shape;
	
	public void setLength(int length) {
		if (length == 30 || length == 50 || length == 100 ) {
			this.length = length;
		} else {
			System.out.println("유효하지 않은 자 길이입니다.");
		}
	}

	public void setShape(String shape) {
		if (shape.equals("줄자") || shape.equals("운형자") || shape.equals("삼각자") ) {
			this.shape = shape;
		} else {
			System.out.println("유효하지 않은 자 형태입니다.");
		}
	}

	public String info() {
		return String.format("%dcm %s입니다.", length, shape);
	}

}
