package com.test.java.question.whileloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {
	
	// 요구사항: 숫자를 10개 입력받아 한글로 변환 후 출력하시오.

	public static void main(String[] args) throws Exception{
		whileNumToKor();
//		forNumToKor();
	}
	
	public static void whileNumToKor() throws Exception {
		
		String str = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int loopNum = 1;
		
		while (loopNum <= 10) {
			
			System.out.print("숫자: ");
			int inputNum = Integer.parseInt(reader.readLine());
			
			// 데이터 유효성 검사
			if (inputNum >= 1 && inputNum <= 9) {
			
				switch (inputNum) {
					
					case 1:
						str += "일";
						break;
					case 2:
						str += "이";
						break;
					case 3:
						str += "삼";
						break;
					case 4:
						str += "사";
						break;
					case 5:
						str += "오";
						break;
					case 6:
						str += "육";
						break;
					case 7:
						str += "칠";
						break;
					case 8:
						str += "팔";
						break;
					default:
						str += "구";
						
				}
				
				loopNum++;
			
			// 1~9의 값이 아니면 loopNum 그대로
			} else {
				
				System.out.println("1~9 사이의 숫자를 입력해주세요.");
				continue; // while문 조건으로 다시감
			}
			
		}
		
		System.out.println(str);
		
	}
	
	public static void forNumToKor() throws Exception {
		
		String str = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0 ; i < 10 ; i ++ ) {
			
			System.out.print("숫자 입력: ");
			int inputNum = Integer.parseInt(reader.readLine());
			
			switch (inputNum) {
							
				case 1:
					str += "일";
					break;
				case 2:
					str += "이";
					break;
				case 3:
					str += "삼";
					break;
				case 4:
					str += "사";
					break;
				case 5:
					str += "오";
					break;
				case 6:
					str += "육";
					break;
				case 7:
					str += "칠";
					break;
				case 8:
					str += "팔";
					break;
				case 9:
					str += "구";
					
			}
			
		}
		System.out.println(str);
			
		
	}

}
