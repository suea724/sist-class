package com.test.java.question.nestedloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q3 {
	
	// 별찍기 - 3
	
	public static void main(String[] args) throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("행 수 입력: ");
		int inputNum = Integer.parseInt(reader.readLine());
		
		for (int i = 0 ; i < inputNum ; i ++) {
			
			for (int j = inputNum - 1 ; j > i ; j --) {
				System.out.print(" ");
			}
			
			for (int j = 0 ; j < i + 1 ; j ++) {
				System.out.print("*");
			}
			
			for (int j = 0 ; j < i ; j ++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
