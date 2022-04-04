package com.test.java.io.question;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Q10 {
	
	// 요구사항: 아래의 조건에 따라 파일을 폴더별로 분류/이동하시오.
	// 1차 : 직원 이름으로 폴더 생성
	// 2차 : 년도별로 폴더 생성
	// 3차 : 각 파일을 직원 > 년도 폴더에 이동
	
	// split, contains?
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_디렉토리_문제\\직원";
		File dir = new File(PATH);
		
		HashMap<String, Set<String>> map = new HashMap<>(); // 이름, 각 이름이 가지고 있는 연도 Set 가지는 맵
		 
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File f : list) {
				
				String name = f.getName().split("_")[0];
				
				if (f.getName().contains(name)) {
					 
					if (map.get(name) == null) { // value Set 없으면 생성
						map.put(name, new HashSet<>());
					}
					
					String year = f.getName().split("_")[1];
					
					// key가 name인 value Set에 연도 추가하고 다시 map에 넣어주기
					Set<String> yearSet = map.get(name);
					yearSet.add(year);
					map.put(name, yearSet);
					
				}
				
				 System.out.println(map);
				
			}
			
			Iterator<String> itr = map.keySet().iterator(); // 이름 iterator
			
			while(itr.hasNext()) {
				
				String name = itr.next();
				
				File subdir = new File(PATH + "\\" + name); // 각 이름 폴더 생성
				subdir.mkdir();
				
				Iterator<String> itr2 = map.get(name).iterator(); // 각 이름의 연도 iterator
				
				while (itr2.hasNext()) {
					
					String year = itr2.next();
					File subsubdir = new File(subdir.getAbsolutePath() + "\\" + year); // 각 이름 폴더 안에 연도 폴더 생성
					
					subsubdir.mkdir();
				}
				
			}
			
			System.out.println("분류가 완료되었습니다.");
			
		} else {
			System.out.println("올바르지 않은 경로입니다.");
		}
	}

}
