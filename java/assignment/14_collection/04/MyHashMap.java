package com.test.java.collection.question.hashmap;

import java.util.ArrayList;

public class MyHashMap {
	
	private ArrayList<Data> list;
	
	public MyHashMap() {
		list = new ArrayList<Data>();
	}
	
	public String put(String key, String value) {
		
		// 요소를 수정하는 경우 원래 value 반환, 추가하는 경우 null 반환
		int idx = findByKey(key);
		
		if(idx > -1) { // 요소가 있을 때
			
			Data data = list.get(idx); // key에 해당하는 요소
			String temp = data.getValue(); 
			data.setValue(value);
			
			return temp; // 원래 value 값
		}
		
		list.add(new Data(key, value)); // 데이터 없으면 추가
		
		return null;	
	}
	
	public String get(String key) {
		
		int idx = findByKey(key);
		
		if(idx > -1) {
			return list.get(idx).getValue();
		}
		
		return null;
	}
	
	private int findByKey(String key) { // key에 해당하는 요소의 위치 반환
		
		for (int i = 0 ; i < list.size() ; i ++) {
			
			Data data = list.get(i);
			
			if (data.getKey().equals(key)) {
				return i;
			}
		}
		return -1;
	}
	
	private int findByValue(String value) { // value에 해당하는 요소 위치 반환
		
		for (int i = 0 ; i < list.size() ; i ++) {
			
			Data data = list.get(i);
			
			if (data.getValue().equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public int size() {
		return list.size();
	}
	
	public String remove(String key) {
		
		 int idx = findByKey(key);
		 String temp = list.get(idx).getValue(); // 삭제하기 전 값
		 list.remove(idx);
		 
		 return temp;
	}
	
	public boolean containsKey(String key) {
		
		if(findByKey(key) > -1) {
			return true;
		}
		return false;
	}
	
	public boolean containsValue(String value) {
		
		if(findByValue(value) > -1) {
			return true;
		}
		return false;
	}
	
	public void clear() {
		list.clear();
	}
	
	public void trimToSize() {
		list.trimToSize();
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder("{");
		
		for (int i = 0 ; i < list.size() ; i ++) {
			
			sb.append(String.format("%s=%s", list.get(i).getKey(), list.get(i).getValue()));
			
			if(i == list.size() - 1 ) {
				break;
			}
			
			sb.append(", ");
		}
		
		sb.append("}");
		return sb.toString();

	}
}
