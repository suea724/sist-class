package com.test.java.io.question;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Q5 {
	
	// 요구사항: 이미지 파일이 있다. 확장자별로 파일이 몇개 있는지 세시오.
	
	public static void main(String[] args) {
		
		String PATH = "D:\\suea7\\class\\파일_디렉토리_문제\\확장자별 카운트";
		File dir = new File(PATH);
		
		HashMap<String, Integer> resMap = new HashMap<>();
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			
			for (File f : list) { 
				String extension = f.getName().substring(f.getName().lastIndexOf("."));
				resMap.put(extension, 0); // 확장자=0 으로 초기값 저장
			}
			
			Set<String> set = resMap.keySet(); // {.gif, .jpg, .png}
			Iterator<String> itr = set.iterator();
			
			while(itr.hasNext()) { // keySet 루프 돌리기
				
				String key = itr.next();
				
				for (File f : list) {
					if (f.getName().endsWith(key)) { // 파일의 확장자와 keySet의 원소가 같으면 value ++
						resMap.put(key, resMap.get(key)+1);
					}
				}
				
				System.out.printf("*%s : %d개\n", key, resMap.get(key));
			}
			
			// System.out.println(resMap);
			
		}
	}

}
