package com.test.java.obj.question.q4.packer;

class Pencil {
	
	private String hardness;
	
	public void setHardness(String hardness) {
		
		if(validHardness(hardness)) {
			this.hardness = hardness;
		} else {
			System.out.println("유효하지 않은 흑연 등급입니다.");
		}
	}
	
	private boolean validHardness(String hardness) {
		
		switch(hardness) {
			case "4B":
			case "3B":
			case "2B":
			case "B":
			case "HB":
			case "H":
			case "2H":
			case "3H":
			case "4H":
				return true;
		}
		return false;
	}
	
	public String info() {
		return String.format("%s 진하기 연필입니다.", hardness);
	}

}
