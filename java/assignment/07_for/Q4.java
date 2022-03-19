package com.test.java.question.forloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q4 {
	
	// 요구사항 : 입력 횟수(N)와 숫자 N개를 입력받아 짝수의 합과 홀수의 합을 각각 출력하시오.

	public static void main(String[] args) throws Exception{
			
			int evenCount = 0, oddCount = 0;
			int evenSum = 0, oddSum = 0;
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("입력 횟수 : ");
			int time = Integer.parseInt(reader.readLine());
			
			for (int i = 0 ; i < time ; i ++) {
				
				System.out.print("숫자 : ");
				int num = Integer.parseInt(reader.readLine());
				
				if (num % 2 == 0) {
					
					evenCount ++;
					evenSum += num;
					
				} else {
					
					oddCount++;
					oddSum += num;
				}
				
			}
			
			System.out.printf("짝수 %d개의 합 : %d\n", evenCount, evenSum);
			System.out.printf("홀수 %d개의 합 : %d\n", oddCount, oddSum);
			
		}

}
