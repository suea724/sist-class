package com.test.java.question.conditional;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {

	// 요구사항 : 숫자 5개를 입력받아 짝수와 홀수의 개수를 출력하시오.
	// 조건 : 1 ~ 10 사이의 정수만 입력받으시오.
	
	public static void main(String[] args) throws Exception{
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("숫자 입력 : ");
			int num1 = Integer.parseInt(reader.readLine());
			
			System.out.print("숫자 입력 : ");
			int num2 = Integer.parseInt(reader.readLine());
			
			System.out.print("숫자 입력 : ");
			int num3 = Integer.parseInt(reader.readLine());
			
			System.out.print("숫자 입력 : ");
			int num4 = Integer.parseInt(reader.readLine());
			
			System.out.print("숫자 입력 : ");
			int num5 = Integer.parseInt(reader.readLine());
			
			int evenCount = 0;
			int oddCount = 0;
			
			// 변수명은 각각 따로 특별한 역할이 없기 때문에 넘버링 적용
			boolean isNum1Valid = (num1 >= 1 && num1 <= 10);
			boolean isNum2Valid = (num2 >= 1 && num2 <= 10);
			boolean isNum3Valid = (num3 >= 1 && num3 <= 10);
			boolean isNum4Valid = (num4 >= 1 && num4 <= 10);
			boolean isNum5Valid = (num5 >= 1 && num5 <= 10);
			
			if (isNum1Valid && isNum2Valid && isNum3Valid && isNum4Valid && isNum5Valid) {
				
				if (num1 % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				
				if (num2 % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				
				if (num3 % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				
				if (num4 % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				
				if (num5 % 2 == 0) {
					evenCount++;
				} else {
					oddCount++;
				}
				
				System.out.printf("짝수는 %d개 홀수는 %d개 입력했습니다.\n", evenCount, oddCount);
				
				if (evenCount > oddCount) {
					System.out.printf("짝수가 홀수보다 %d개 더 많습니다.\n", evenCount - oddCount);
				} else if (evenCount < oddCount) {
					System.out.printf("짝수가 홀수보다 %d개 더 많습니다.\n", oddCount - evenCount);
				}
				
			} else {
				System.out.println("다시 입력해주세요.");
			}
			
	}
	
}
