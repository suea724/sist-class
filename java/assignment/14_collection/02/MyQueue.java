package com.test.java.collection.question.queue;

import java.util.Arrays;

/* Queue와 동일한 동작을 하는 클래스를 선언하시오. (String) */

class MyQueue {
	
	private String[] list;
	private int index;
	
	public MyQueue() {
		index = 0;
	}
	
	public MyQueue(int size) {
		index = 0;
		list = new String[size];
	}
	
	public boolean add(String value) {
		
		if(list == null) {
			list = new String[4];
		}
		
		if(index == list.length) {
			doublingList();
		}
		
		list[index] = value;
		
		if(list[index] == value) {
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
	
	public String poll() {
		
		String temp = list[0]; 
		
		for (int i = 0 ; i < index ; i ++) { // left shift
			list[i] = list[i+1];
		}
		
		list[index] = null; // 마지막 요소 제거
		index--;
		
		return temp; // 0번째 위치의 값 리턴
	}
	
	public int size() {
		return index;
	}
	
	public String peek() {
		return list[0];
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
