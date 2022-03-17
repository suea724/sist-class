package com.test.java.question.whileloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q5 {
	
	// 자판기 프로그램
	
	/**
	 * 설계
	 * 1. 무한루프 안에서 자판기 프로그램을 출력한다.
	 * 2. 금액을 입력하면 음료를 선택한 번호를 입력받는다.
	 * 3. 각 음료에 대해 가격을 계산하여 출력한다.
	 * 4. 엔터를 입력하면 다시 무한루프로 돌아온다.
	 * 
	 */
	
	public static void main(String[] args) throws Exception{
		
//		whileBendingMachine();
		forBendingMachine();
	}
		

	
	public static void whileBendingMachine() throws Exception{
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 무한 루프
		boolean loop = true;
		while (loop) {
			
			//라벨 출력
			System.out.println("=======================");
			System.out.println("\t자판기");
			System.out.println("=======================");
			System.out.println("1. 콜라: 700원");
			System.out.println("2. 사이다: 600원");
			System.out.println("3. 비타500: 500원");
			System.out.println("-----------------------");
			System.out.print("금액 투입(원): ");
			int inputMoney = Integer.parseInt(reader.readLine());
			System.out.println("-----------------------");
			
			System.out.print("음료 선택(번호): ");
			
			String selNum = reader.readLine();
			
			switch (selNum) {
				
				case "1":
					coke(inputMoney);
					break;
				case "2":
					cider(inputMoney);
					break;
				case "3":
					vita(inputMoney);
					break;
				default:
					System.out.println("1 ~ 3 사이의 번호를 입력해주세요.");
				
			}
			
			System.out.println("계속하시려면 엔터를 입력하세요.");
			reader.readLine();
		}
	}
	
	public static void forBendingMachine() throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
		boolean loop = true;
		for (; loop ;){
			
			System.out.println("=======================");
			System.out.println("\t자판기");
			System.out.println("=======================");
			System.out.println("1. 콜라: 700원");
			System.out.println("2. 사이다: 600원");
			System.out.println("3. 비타500: 500원");
			System.out.println("-----------------------");
			System.out.print("금액 투입(원): ");
			int inputMoney = Integer.parseInt(reader.readLine());
			System.out.println("-----------------------");
			
			System.out.print("음료 선택(번호): ");
			
			String selNum = reader.readLine();
			
			// 선택 번호에 따라 각 함수 실행
			switch (selNum) {
				
				case "1":
					coke(inputMoney);
					break;
				case "2":
					cider(inputMoney);
					break;
				case "3":
					vita(inputMoney);
					break;
				default: // 유효성 검사
					System.out.println("1 ~ 3 사이의 번호를 입력해주세요.");
				
			}
			
			System.out.println("계속하시려면 엔터를 입력하세요.");
			reader.readLine(); // 엔터 들어오면 루프 처음으로
		}
	}
	
	public static void coke(int money) {
		
		if (money >= 700) {

			System.out.println("+ 콜라를 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n",money - 700);
			System.out.println();
			
		} else { // 금액 부족시 예외처리
			System.out.println("금액이 부족합니다.");
		}
	}

	public static void cider(int money) {
		
		if (money >= 600) {
			
			System.out.println("+ 사이다를 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n",money - 600);
			System.out.println();
			
		} else {
			System.out.println("금액이 부족합니다.");
		}
		
	}
	public static void vita(int money) {
		
		if (money >= 700) {
			
			System.out.println("+ 비타500을 제공합니다.");
			System.out.printf("+ 잔돈 %d원을 제공합니다.\n",money - 500);
			System.out.println();
			
		} else {
			System.out.println("금액이 부족합니다.");
		}
	}
	
}
