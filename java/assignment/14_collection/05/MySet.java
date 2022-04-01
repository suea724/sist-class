package com.test.java.collection.question.set;

import java.util.ArrayList;

public class MySet {
	
	private ArrayList<String> list;
	private int index;
	
	public MySet() {
		list = new ArrayList<String>();
		index = -1; // hasNext(), next()에서 사용
	}
	
	public boolean add(String value) {
		
		if(findIndex(value) == -1) { // 중복값이 없으면
			
			list.add(value);
			return true;
		}
		
		return false;
	}
	
	private int findIndex(String value) {
		
		for(int i = 0 ; i < list.size() ; i ++) {
			
			String str = list.get(i);
			
			if(str.equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean remove(String value) {
		
		int idx = findIndex(value);
		
		if(idx > -1) { // 값이 있으면
			list.remove(idx);
			return true;
		} 
		
		return false;
	}
	
	public void clear() {
		list.clear();
	}
	
	public boolean hasNext() {
		
		if (index < list.size()-1) {
			return true;
		} 
		
		return false;
	}
	
	public String next() {
		return list.get(++ index);
	}

	@Override
	public String toString() {
		return list.toString();
	}
	
}
