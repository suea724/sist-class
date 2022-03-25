package com.test.java.obj.question.q4.packer;

class Eraser {
	
	private String size;
	
	public void setSize(String size) {
		
		if (size == "Large" || size == "Medium" || size == "Small" ) {
			this.size = size;
		} else {
			System.out.println("유효하지 않은 지우개 크기입니다.");
		}
	}
	
	public String info() {
		return String.format("%s 사이즈 지우개입니다.", size);
	}

}
