package com.test.java.obj.question.q2;

class Macaron {

	private String color;
	private int size;
	private int thickness;
	
	// Getter, Setter에서는 최소한의 유효성 검사만 하는 것이 좋음 -> 업무 코드 X (관습)
	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public void setThickness(int thickness) {
		this.thickness = thickness;
	}
}
