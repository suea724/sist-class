package com.test.java.question.nestedloop;

public class Q12 {
	
	// 피보나치 수열과 합 구하기
	
	public static void main(String[] args) {
		
		// 총 합을 더할 누적 변수
		int total = 0;
		
		int num1 = 0;
		int num2 = 1;
		
		String str = ""; 
		
		while(true) {
			
			// 첫번째 숫자일 때
			if (total == 0) {
				// num2 더하기
				str += num2 + " + ";
			// 나머지 숫자	
			} else {
				
				str += num1 + " + ";
				str += num2 + " + ";
				
			}
			
			// num1, num2에 각각 더한값을 넣어줌
			num1 = num1 + num2;
			num2 = num1 + num2;
			
			// 기준 값인 num1을 더함 (맨 처음 num2값은 0이라서 상관없음)
			total += num1;
			
			// 기준값인 num1이 100이 넘으면 while문 탈출
			if (num1 > 100) {
				str += "\b\b = " + total;
				break;
			}
			
		}
		
		System.out.println(str);
			
		
	}

}
