package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Q5 {
	
	// 이름을 입력받아 회원 주문 정보를 검색 후 출력하시오.
	
	public static void main(String[] args) {
		
		final String MEMBER_PATH = "D:\\suea7\\class\\파일_입출력_문제\\검색_회원.dat";
		final String ORDER_PATH = "D:\\suea7\\class\\파일_입출력_문제\\검색_주문.dat";
		
		StringBuilder builder = new StringBuilder("====================구매 내역===================\n");
		builder.append("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]\n");
		
		try {
			
			// 회원 파일
			File mFile = new File(MEMBER_PATH);
			BufferedReader mReader = new BufferedReader(new FileReader(mFile));
			
			// 주문 파일
			File oFile = new File(ORDER_PATH);
			BufferedReader oReader = new BufferedReader(new FileReader(oFile));
			
			// 이름 입력 받기
			Scanner scanner = new Scanner(System.in);
			System.out.print("이름: ");
			String inputName = scanner.nextLine();
			
			// 회원 id, address 저장할 변수
			String memberId = "";
			String address = "";
			
			String mLine, oLine = null;
			
			/* 회원 id, address 저장 */
			
			while((mLine = mReader.readLine()) != null) {
				
				if (mLine.contains(inputName)) { // 검색 회원이 존재하면 아이디와 이름 저장
					memberId = mLine.split(",")[0];
					address = mLine.split(",")[2];
				}
				
			}
			
			HashMap<String, Integer> map = new HashMap<>(); // key: 상품, value: 개수
			
			/* 회원이 주문한 상품 알아내기 */
			
			while((oLine = oReader.readLine()) != null) {
				
				String item = oLine.split(",")[1];
				String orderId = oLine.split(",")[3];
				
				if (memberId.equals(orderId)) { // 회원의 id와 주문의 고객 id가 같으면
					map.put(item, 0); 
				}
				
			}
			
			/* 각 item에 대해 개수 세기 */
			
			Set<String> set = map.keySet(); // 주문한 상품
			Iterator<String> itr = set.iterator();
			
			while(itr.hasNext()) {
				
				oReader = new BufferedReader(new FileReader(oFile)); // 루프 돌릴때마다 열어줘야 함
				String item = itr.next();
				
				while((oLine = oReader.readLine()) != null) {
					
					String orderId = oLine.split(",")[3];
					
					if(oLine.contains(item) && orderId.equals(memberId)) { // 고객과 회원 id가 일치하고, 각 item을 포함하고 있으면 count ++
						map.put(item, map.get(item)+1);
					}
				}
				
				String str = String.format("%4s\t%s\t%s\t%4d\t%s\n", memberId, inputName, item, map.get(item), address);
				builder.append(str);
			}
			
			System.out.println(builder);
			
			scanner.close();
			mReader.close();
			oReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
