package com.test.java.obj.question.q4.packer;

class BallPointPen {
	
	private double thickness;
	private String color;

	public void setThickness(double thickness) {
		
		if (validThickness(thickness)) {
			this.thickness = thickness;
		} else {
			System.out.println("유효하지 않은 볼펜 심 두께입니다.");
		}
	}

	public void setColor(String color) {
		
		if (validColor(color)) {
			this.color = color;
		} else {
			System.out.println("유효하지 않은 볼펜 색상입니다.");
		}
	}
	
	private boolean validThickness(double thickness) {
		
		double t = thickness;
		if (t == 0.3 || t == 0.5 || t == 0.7 || t == 1 || t == 1.5) {
			return true;
		}
		return false;
	}
	
	private boolean validColor(String color) {
		
		switch(color) {
			case "red":
			case "blue":
			case "green":
			case "black":
				return true;
		}
		return false;
	}

	public String info() {
		return String.format("%s 색상 %.1fmm 볼펜입니다.", color, thickness);
	}

}
