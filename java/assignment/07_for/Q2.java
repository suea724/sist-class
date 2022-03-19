package com.test.java.question.forloop;

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
			
			// 증감치의 양수, 음수를 비교하는 방법과 시작 숫자와 종료 숫자를 비교하는 방법이 있음
			// 각 방법에 데이터 유효성 검사 부분 필요
			// 두 방법 모두 해본 결과 시작 숫자와 종료 숫자로 비교할 때 유효성 검사가 더 순서에 맞고 메세지가 간단한 것 같다.
			
			// 시작 숫자와 종료 숫자로 비교하는 방법
			if (firstNum < lastNum) {
				
				if (numVar <= 0) {
					
					System.out.println("증감치는 양수 값을 입력해주세요.");
					
				} else {
					
					for (int i = firstNum ; i <= lastNum ; i += numVar) {
						
						System.out.println(i);
					}
				}
				
			} else if (firstNum > lastNum) {

				if (numVar >= 0) {
					System.out.println("증감치는 음수 값을 입력해주세요.");
					
				} else {
					
					for (int i = firstNum ; i >= lastNum ; i += numVar) {
						System.out.println(i);
					}
				}
				
			} else {
				System.out.println("두 숫자가 같으면 계산을 할 수 없습니다.");
			}
	
			// 시작 숫자와 종료 숫자로 비교하는 방법
			// if (numVar >= 0) {
			//
			// if (firstNum >= lastNum) {
			// System.out.println("증감치가 0 또는 양수일 때 시작 숫자가 종료 숫자보다 크거나 같으면 계산을 할 수 없습니다.");
			//
			// } else {
			//
			// for (int i = firstNum ; i <= lastNum ; i += numVar) {
			// System.out.println(i);
			// }
			// }
			//
			// } else {
			//
			// if (firstNum <= lastNum) {
			// System.out.println("증감치가 음수일때 시작 숫자가 종료 숫자보다 작거나 같으면 계산을 할 수 없습니다.");
			//
			// } else {
			//
			// for (int i = firstNum ; i >= lastNum ; i += numVar) {
			// System.out.println(i);
			// }
			// }
			//
			// }
			
		}

}
