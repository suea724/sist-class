package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Q5 {
	
	// 이름을 입력받아 회원 주문 정보를 검색 후 출력하시오.
	
	public static void main(String[] args) {
	
		final String MEMBER_PATH = "D:\\suea7\\class\\파일_입출력_문제\\검색_회원.dat";
		final String ORDER_PATH = "D:\\suea7\\class\\파일_입출력_문제\\검색_주문.dat";
		
		StringBuilder builder = new StringBuilder("====================구매 내역===================\n");
		builder.append("[번호]\t[이름]\t[상품명]\t[개수]\t[배송지]\n");
		boolean hasMember = false;
		
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
			
			String mLine, oLine = null;
			
			while((mLine = mReader.readLine()) != null) {
				
				if (mLine.contains(inputName)) { // 검색 회원이 존재하면 아이디와 이름 저장
					
					hasMember = true;
					
					String memberId = mLine.split(",")[0];
					String address = mLine.split(",")[2];
					
					while((oLine = oReader.readLine()) != null) {
						
						String item = oLine.split(",")[1];
						String count = oLine.split(",")[2];
						String orderId = oLine.split(",")[3];
						
						if (memberId.equals(orderId)) { // 회원의 id와 주문의 고객 id가 같으면
							String str = String.format("%4s\t%s\t%s\t%s\t%s\n", memberId, inputName, item, count, address);
							builder.append(str);
						}
						
					}
				}
				
			}
			
			if (hasMember) {
				System.out.println(builder);
			} else {
				System.out.println(inputName + " 회원이 존재하지 않습니다.");
			}
			
			scanner.close();
			mReader.close();
			oReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

