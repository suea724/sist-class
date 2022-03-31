package com.test.java.question.collection;

/* ArrayList와 동일한 동작을 하는 클래스를 선언하시오. (String) */

class MyArrayList {

	private String[] list; // ArrayList의 내부 배열
	private int index; // 가장 중요!

	public MyArrayList() { // default 생성자 
		this.index = 0;
	}
	
	public MyArrayList(int size) { // 사이즈 입력받는 생성자
		this.index = 0;
		list = new String[size];
	}

	public boolean add(String value) {
		
		if (list == null) { // 할당받은 배열이 없을때
			list = new String[4];
		}
		
		if (index == list.length) { // 배열이 꽉 찼을때
			doublingList();
		}
			
		list[index] = value;
		index ++;
		return true;
	
	}

	private void doublingList() {
			
		String[] temp = new String[index]; // 기존 값 복사할 임시 배열
		
		for (int i = 0 ; i < index ; i ++) {
			temp[i] = list[i];
		}
		
		list = new String[list.length * 2]; // 더블링 길이의 배열 선언
		
		for (int i = 0 ; i < index ; i ++) {
			list[i] = temp[i];
		}
	}
	
	public String get(int index) {
		return list[index];
	}
	
	public int size() {
		return index;
	}
	
	public String set(int index, String value) {
		
		String temp = list[index];
		list[index] = value;
		return temp; // 수정 전 값 리턴
	}
	
	public String remove(int index) { 
		
		String temp = list[index]; 
		
		for (int i = index ; i < list.length-1 ; i ++) {
			list[i] = list[i+1];
		}
		this.index --;
		return temp; // 제거 되는값 반환
	}
	
	public boolean add(int index, String value) { 
		
		if (this.index == list.length) { // 배열이 꽉찬 경우
			doublingList();
		}
		
		for (int i = this.index-1 ; i >= index ; i --) { 
			list[i+1] = list[i];
		}
		
		list[index] = value;
		this.index ++;
		return true;
	}
	
	public int indexOf(String value) {
		
		for (int i = 0 ; i < list.length ; i ++) {
			if (list[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(String value) {
		
		for (int i = list.length-1 ; i >= 0  ; i ++) {
			if (list[i] == value) {
				return i;
			}
		}
		return -1;
	}
	
	public void clear() {
		// for문으로 null 값 설정해주기 or 같은 길이의 새로운 배열 할당하기
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
		StringBuilder sb = new StringBuilder("[");
		
		for (int i= 0 ; i < index ; i ++) {
			
			sb.append(list[i]);
			
			if (i == index - 1) {
				break;
			}
			sb.append(", ");
		}
		
		sb.append("]");
		return sb.toString();
	}

	
}
