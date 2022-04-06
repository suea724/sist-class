package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Q7 {
	
	// 직원들의 지각과 조퇴를 카운트하시오. 출근: 오전 9시, 퇴근 오후 6시
	
	/**
	 * HashMap 두 개 사용하는 방법도 있음
	 */
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\출결.dat";
		Set<String> nameSet = new HashSet<>(); // 이름 저장할 set
		StringBuilder builder = new StringBuilder("[이름]\t[지각]\t[조퇴]\n");
		
		try {
			
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = null;
			
			while((line = reader.readLine()) != null) {
				nameSet.add(line.split(",")[1]); // 이름 저장
			}
			
			Iterator<String> itr = nameSet.iterator();
			
			while(itr.hasNext()) { // set 루프 돌리기
				
				String name = itr.next();
				reader = new BufferedReader(new FileReader(file)); // 한 직원씩 루프 돌때마다 reader 새로 열기 > 안하면 아래 루프 조건 실행X
				
				// 각 직원의 지각, 조퇴 카운트
				int lateCnt = 0;
				int earlyCnt = 0;
				
				line = null;
				
				while((line = reader.readLine()) != null) {
					
					if (line.contains(name)) { // 이름이 포함되어 있으면
						
						String[] arrivedTime = line.split(",")[2].split(":"); // 출근 시간 시, 분 나눠서 저장
						String[] leavingTime = line.split(",")[3].split(":"); // 퇴근 시간 시, 분 나눠서 저장
						
						int arrivedHour = Integer.parseInt(arrivedTime[0]);
						int arrivedMin = Integer.parseInt(arrivedTime[1]);
						int leavingHour = Integer.parseInt(leavingTime[0]);
						
						if (arrivedHour >= 9 && arrivedMin > 0) { // 지각인 경우
							lateCnt ++;
						}
						
						if (leavingHour < 18) { // 조퇴인 경우
							earlyCnt ++;
						}
						
					}
					
				}
				
				builder.append(String.format("%s\t%3d회\t%3d회\n", name, lateCnt, earlyCnt));
			}
			
			reader.close();
			System.out.println(builder);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
