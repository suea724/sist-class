package com.test.java.question.loop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q2 {
	
	// 요구사항 : 시작 숫자, 종료 숫자, 증감치를 입력받아 숫자를 순차적으로 출력하시오.

	public static void main(String[] args) throws Exception{
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("시작 숫자 : ");
			int firstNum = Integer.parseInt(reader.readLine());
			
			System.out.print("종료 숫자 : ");
			int lastNum = Integer.parseInt(reader.readLine());
			
			System.out.print("증감치 : ");
			int numVar = Integer.parseInt(reader.readLine());
			
			if (numVar >= 0) {
				
				for (int i = firstNum ; i <= lastNum ; i += numVar) {
					System.out.println(i);
				}
			} else {
				
				for (int i = firstNum ; i >= lastNum ; i += numVar)
					System.out.println(i);
			}
			
		}

}
