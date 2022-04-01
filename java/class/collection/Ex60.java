package com.test.java.collection;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex60 {

	public static void main(String[] args) {
		
		/* ArrayList + HashMap */
		
		// 학생 성적 처리
		// - 학생(국어, 영어, 수학) * N명
		// - 국어, 영어, 수학 > 한곳에 저장할 자료형
		// => 배열 or ArrayList vs HashMap vs 클래스
		
		// Case 1. Array(or ArrayList)
		// - 루프 사용 가능
		// - 비용 낮음
		// - but 가독성 문제 > 과목 식별할 때 인덱스를 사용
		int[] score = new int[3];
		
		score[0] = 100;
		score[1] = 90;
		score[2] = 80;
		
		// Case 2. HashMap
		// - 가독성 높음 > 과목을 이름(key)로 식별
		// - 비용 낮음 > 틀이 없음
		HashMap<String, Integer> scoreMap = new HashMap<>();
		
		scoreMap.put("국어", 100);
		scoreMap.put("영어", 90);
		scoreMap.put("수학", 80);
		
		HashMap<String, Integer> scoreMap2 = new HashMap<>();
		
		// 위험 > 오타 가능성!!
		scoreMap2.put("국어", 100);
		scoreMap2.put("영어", 90);
		scoreMap2.put("수학", 80);
		
		// Case 3. Class
		// - 가독성 높음, HashMap과 유사
		// - 멤버에 루프 적용 불가능, HashMap과 유사
		// - 비용 높음
		// - 여러 개 만들 때(재사용시) 유용
		Score scoreObject = new Score();
		
		scoreObject.setKor(100);
		scoreObject.setEng(90);
		scoreObject.setKor(80);
		
		Score scoreObject2 = new Score();
		
		// 안전 > 틀이 있음
		scoreObject2.setKor(100);
		scoreObject2.setEng(90);
		scoreObject2.setKor(80);
		
		// 학생 3명 > 점수 리스트, 각각 HashMap으로 점수 저장
		ArrayList<HashMap<String, Integer>> list 
							= new ArrayList<HashMap<String, Integer>>();
		
		HashMap<String, Integer> score1 = new HashMap<>();
		score1.put("국어", 100);
		score1.put("영어", 90);
		score1.put("수학", 80);
		
		HashMap<String, Integer> score2 = new HashMap<>();
		score2.put("국어", 50);
		score2.put("영어", 60);
		score2.put("수학", 70);
		
		HashMap<String, Integer> score3 = new HashMap<>();
		score3.put("국어", 70);
		score3.put("영어", 80);
		score3.put("수학", 90);
		
		list.add(score1);
		list.add(score2);
		list.add(score3);
		System.out.println(list);
		
		// +@ 클래스에 HashMap을 사용하는 방법
		Student2 s1 = new Student2(100, 90, 80);
		Student2 s2 = new Student2(80, 90, 100);
		
		System.out.println(s1.getMap());
		System.out.println(s2.getMap());
		
	}

}

class Score {
	
	private int kor;
	private int eng;
	private int math;
	
	public int getKor() {
		return kor;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
}

// +@ 클래스에 HashMap을 사용하는 방법
class Student2 {
	
	private final HashMap<String, Integer> map = new HashMap<>();
	
	public Student2(int kor, int eng, int math) {
		
		map.put("국어", kor);
		map.put("영어", eng);
		map.put("수학", math);
	}

	public HashMap<String, Integer> getMap() {
		return map;
	}
	
}
