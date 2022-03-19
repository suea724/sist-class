package com.test.java.question.forloop;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q9 {

	public static void main(String[] args) throws Exception{
		
		// 1 ~ 10의 랜덤한 수
		int randomNum = (int)(Math.random() * 10) + 1;
		// 시도 횟수 복사할 변수
		int tryTime = 0;
		
		System.out.println("컴퓨터가 1~10 사이의 숫자를 1개 생각했습니다.\n");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		// 반복문
		for (int i = 1 ; i <= 10 ; i ++) {
			
			System.out.print("숫자 입력 : ");
			int inputNum = Integer.parseInt(reader.readLine());
			
			// 입력받은 수와 랜덤한 수가 같으면
			if (inputNum == randomNum) {
				
				// 횟수 복사
				tryTime = i;
				System.out.println("맞았습니다.\n");
				break;
			
			// 입력받은 수와 랜덤한 수가 다르면	
			} else {
				
				tryTime = i;
				System.out.println("틀렸습니다.\n");
			}
		}
		
		System.out.printf("컴퓨터가 생각한 숫자는 %d입니다.\n", randomNum);
		System.out.printf("정답을 맞추는데 시도한 횟수는 %d회입니다.\n", tryTime);
		System.out.println();
		System.out.println("프로그램을 종료합니다.");
		
	}

}
