package com.test.java.obj.question.q2;

import java.util.Calendar;

class Item {
	
	private String name;
	private Calendar expiration;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getExpiration() { // 2022-4-1
		return String.format("%tF", expiration);
	}
	
	public void setExpiration(String date) {
		
		expiration = Calendar.getInstance();
		String[] splited = date.split("-");
		
		expiration.set(Calendar.YEAR, Integer.parseInt(splited[0]));
		expiration.set(Calendar.MONTH, Integer.parseInt(splited[1])-1);
		expiration.set(Calendar.DATE, Integer.parseInt(splited[2]));
	}
	
}
