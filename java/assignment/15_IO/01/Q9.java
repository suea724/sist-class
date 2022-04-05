package com.test.java.io.question.q1;

import java.io.File;
import java.util.ArrayList;

public class Q9 {
	
	// 요구사항: 폴더 내의 모든 파일들을 찾아 크기를 비교하고, 크기가 큰 순으로 정렬하시오.
	
	// 자식 폴더내의 파일도 모두 검색하시오.
	// 부모 자식 폴더에 상관없이 파일을 한번에 비교하시오.
	// 재귀메서드 > 모든 파일 알아내서 ArrayList에 추가 > length로 정렬해서 출력
	
	static ArrayList<File> list = new ArrayList<>(); // 모든 파일을 저장할 리스트
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_디렉토리_문제\\크기 정렬";
		
		File dir = new File(PATH);
		
		if (dir.exists()) {
			addFiles(dir);
		} else {
			System.out.println("올바르지 않은 경로입니다.");
		}
		
		bubbleSort(list); // 정렬
		
		System.out.println("[파일명]\t\t\t\t[크기]\t  [파일이 들어있는 폴더]");
		
		for (File f : list) {
			System.out.printf("%-25s\t%5dKB\t\t%3s\n", f.getName(), (f.length()/1024), f.getParentFile().getName());
		}
		
	}

	private static void bubbleSort(ArrayList<File> list) {
		 
		for (int i = 0 ; i < list.size()-1 ; i ++) {
			
			for (int j = i ; j >= 0 ; j --) {
				
				if (list.get(j+1).length() > list.get(j).length()) {
					File temp = list.get(j+1);
					list.set(j+1, list.get(j));
					list.set(j, temp);
				}
			}
		}
	}

	private static void addFiles(File dir) { // 리스트에 파일 추가
		
		File[] files = dir.listFiles();
		
		for (File f : files) {
			
			if (f.isDirectory()) { // 폴더 없을 때까지 재귀호출
				addFiles(f);
			} else {
				list.add(f);
			}
		}
	}

}
