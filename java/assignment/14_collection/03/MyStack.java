package com.test.java.collection.question.stack;

import java.util.Arrays;

/* Stack과 동일한 동작을 하는 클래스를 선언하시오. (String) */

class MyStack {
	
	private String[] list;
	private int index;
	
	public MyStack() {
		index = 0;
	}
	
	public MyStack(int size) {
		index = 0;
		list = new String[size];
	}
	
	public boolean push(String value) {
		
		if (list == null) {
			list = new String[4];
		}
		
		if (index == list.length) {
			doublingList();
		}
		
		list[index] = value;
		
		if (list[index] == value) {
			index ++;
			return true;
		} 
		
		return false;
	}
	
	private void doublingList() {
		
		String[] temp = new String[list.length * 2];
		
		for (int i = 0 ; i < index ; i ++) {
			temp[i] = list[i];
		}
		
		list = temp;
	}
	
	public String pop() {
		
		String temp = list[index-1]; 
		list[index-1] = null;
		index--;
		return temp; // (개수-1)번째 값 반환
	}
	
	public int size() {
		return index;
	}
	
	public String peek() {
		 return list[index-1];
	}

	public void clear() {
		list = new String[list.length];
		index = 0;
	}
	
	public void trimToSize() {
		String[] temp = new String[index];
		
		for (int i = 0 ; i < index ; i ++) {
			temp[i] = list[i];
		}
		
		list = temp;
	}

	@Override
	public String toString() {
		return Arrays.toString(list);
	}
	
}
