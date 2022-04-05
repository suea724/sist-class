package com.test.java.io.question.q1;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

public class Q7 {
	
	// 요구사항: MusicA 폴더와 MusicB 폴더를 서로 비교해서 양쪽 폴더에 모두 존재하는 파일만을 출력하시오.
	
	static int count = 0;
	
	public static void main(String[] args) {
		
		final String PATH_A = "D:\\suea7\\class\\파일_디렉토리_문제\\동일 파일\\MusicA";
		final String PATH_B = "D:\\suea7\\class\\파일_디렉토리_문제\\동일 파일\\MusicB";
		
		// 각 폴더의 File 객체 생성
		File dirA = new File(PATH_A);
		File dirB = new File(PATH_B);
		
		if (dirA.exists() && dirB.exists()) {
			
			File[] listA = dirA.listFiles();
			File[] listB = dirB.listFiles();
			
//			HashSet을 사용할 수 있음 > retainAll() 메서드 사용 > 교집합
//			- HashSet에서는 집합 관련 연산 메서드를 제공함
//			- addAll(): 합집합, removeAll(): 차집합
			
//			Set<File> set1 = new HashSet<>();
//			Set<File> set2 = new HashSet<>();
//			
//			
//			for (File f : listA) {
//				set1.add(f);
//			}
//			
//			for (File f : listB) {
//				set2.add(f);
//			}
//			
//			System.out.println(set1.retainAll(set2));
//			System.out.println(set1);
			
			
			for (int i = 0 ; i < listA.length ; i ++) {
				
				for (int j = 0 ; j < listB.length ; j ++) {
					
					if (listA[i].getName().equals(listB[j].getName())) { // 이름 비교
						System.out.println(listA[i].getName());
						break; // 중복값 찾고 break
					}
				}
			}
			
		} else {
			System.out.println("두 경로를 올바르게 입력해주세요.");
		}
		
	}

}
