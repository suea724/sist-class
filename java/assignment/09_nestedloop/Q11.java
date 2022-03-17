package com.test.java.question.nestedloop;

public class Q11 {
	
	// 등차수열
	
	public static void main(String[] args) {
			
			// 누적변수
			int sum = 0;
			String str = "";
			
			int i;
			int j = 1;
			
			// 증감식; j++을 i에 더함
			for (i = 1 ; i < 100 ; i += j++) {
				
				str += i + " + ";
				sum += i;
			}
			
			System.out.print(str + " = ");
			System.out.println(sum);
		}

}
