package com.test.java.question.whileloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	// 요구사항: 사용자가 입력한 범위의 숫자까지 369 게임 과정을 출력하시오.
	
	public static void main(String[] args) throws Exception {
		
		whileThreeSixNine();
	}
	
	public static void whileThreeSixNine() throws Exception {
			
		String str = "";
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("최대 숫자: ");
		int max = Integer.parseInt(reader.readLine());
		int num = 1;
		
		while(num <= max) {
			
			// 일의 자리가 3,6,9일 경우
			boolean isThree = (num % 10 == 3);
			boolean isSix = (num % 10 == 6);
			boolean isNine = (num % 10 == 9);
			
			// 십의 자리가 3,6,9일 경우
			boolean isThirty = (num / 10 == 3);
			boolean isSixty = (num / 10 == 6);
			boolean isNinety = (num / 10 == 9);
			
			// 백의 자리가 3,6,9일 경우
			boolean isTHundred = (num / 100 == 3);
			boolean isSHundred = (num / 100 == 6);
			boolean isNHundred = (num / 100 == 9);
			
			if (isThree || isSix || isNine || isThirty || isSixty || isNinety || isTHundred || isSHundred || isNHundred) {
				
				str += "짝 ";
				
			} else {
				
				str += num + " ";
			}
			
			num++;
		}
		
		System.out.println(str);
			
	}
	
}

	

