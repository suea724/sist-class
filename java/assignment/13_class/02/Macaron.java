package com.test.java.obj.question.q2;

class Macaron {

	private String[] colors = {"red","blue","yellow","white","pink","purple","green","black"};
	private String color;
	private int size;
	private int thickness;
	
	public int getSize() {
		return size;
	}
	
	public void setSize() {
		size = (int)(Math.random() * 10) + 5;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor() {
		color = colors[(int)(Math.random() * 8)];
	}
	
	public int getThickness() {
		return thickness;
	}
	
	public void setThickness() {
		thickness = (int)(Math.random() * 19) + 1;
	}
}
