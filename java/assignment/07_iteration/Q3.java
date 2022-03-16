package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	// 요구사항 : 숫자 1개를 입력받아 1부터 입력한 숫자까지의 합을 출력하시오.

	public static void main(String[] args) throws Exception{
		
		int sum = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("숫자 : ");
		int num = Integer.parseInt(reader.readLine());
		
		for (int i = 1 ; i <= num ; i ++) {
			sum += i;
		}
		
		System.out.printf("1 ~ %d = %d\n", num, sum);
		
	}
}
