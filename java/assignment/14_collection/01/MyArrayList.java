package com.test.java.collection.question.arraylist;

import java.util.Arrays;

/* ArrayList와 동일한 동작을 하는 클래스를 선언하시오. (String) */

class MyArrayList {

	private String[] list; // ArrayList의 내부 배열
	private int index; // 가장 중요!

	public MyArrayList() { // default 생성자 
		index = 0;
	}
	
	public MyArrayList(int size) { // 사이즈 입력받는 생성자
		index = 0;
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
		
		if (list[index].equals(value)) { // index 위치의 값이 value면
			index ++;
			return true;
		}
		
		return false; // [반환에서 try-catch문 사용]
				
	}

	private void doublingList() {
		
		String[] temp = new String[list.length * 2]; // 더블링된 길이의 임시 배열
		
		for (int i = 0 ; i < index ; i ++) {
			temp[i] = list[i];
		}
		
		list = temp;
		
	}
	
	public String get(int index) {
		
		throwIndexError(index);
		
		return list[index];
	}
	
	private boolean validIndex(int index) {
		
		if (index >= 0 && index < this.index) { // 요소가 있는 위치의 인덱스까지 
			return true; 
		} 
		
		return false;
	}
	
	private void throwIndexError(int index) {
		
		if (!validIndex(index)) {
			throw new IndexOutOfBoundsException("요소가 있는 위치의 인덱스를 입력해야함.");
		}
	}
	
	public int size() {
		return index;
	}
	
	public String set(int index, String value) {
		
		throwIndexError(index);
		
		String temp = list[index];
		list[index] = value;
		return temp; // 수정 전 값 리턴
	}
	
	public String remove(int index) {
		
		throwIndexError(index);
		
		String temp = list[index]; 
		
		for (int i = index ; i < this.index-1 ; i ++) {
			list[i] = list[i+1];
		}
		list[this.index-1] = null;
		this.index --;
		return temp; // 제거 되는값 반환
	}
	
	public boolean add(int index, String value) { 
		
		throwIndexError(index);
		
		if (this.index == list.length) { // 배열이 꽉찬 경우
			doublingList();
		}
		
		for (int i = this.index-1 ; i >= index ; i --) { 
			list[i+1] = list[i];
		}
		
		list[index] = value;
		
		if (list[index].equals(value)) {
			this.index ++;
			return true;
		}
		
		return false;
	}
	
	public int indexOf(String value) {
		
		for (int i = 0 ; i < this.index ; i ++) {
			if (list[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public int lastIndexOf(String value) {
		
		for (int i = this.index-1 ; i >= 0  ; i --) {
			if (list[i].equals(value)) {
				return i;
			}
		}
		return -1;
	}
	
	public void clear() {
		
		// for문으로 null 값 설정해주기 > 시간 오래걸리지만 가비지 X
		// 같은 길이의 새로운 배열 할당하기 > 메모리 낭비 발생하지만 빠름 
		// index만 0으로 설정해주기 > 초기화에서 index == 0 조건 필요함 > 속도 빠르고 비용 저렴
		
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
	public String toString() { // null 값도 출력
		return Arrays.toString(list);
	}

//	@Override
//	public String toString() { // ArrayList와 똑같이 출력	
//		StringBuilder sb = new StringBuilder("[");
//		
//		for (int i= 0 ; i < index ; i ++) {
//			
//			sb.append(list[i]);
//			
//			if (i == index - 1) {
//				break;
//			}
//			sb.append(", ");
//		}
//		
//		sb.append("]");
//		return sb.toString();
//	}

}
