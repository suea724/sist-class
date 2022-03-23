package com.test.java.question.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q12 {
	
	// 요구사항: 연산식을 입력받아 실제 연산을 하시오.
	// 조건
	// - 산술 연산자만 구현하시오.(+, -, *, /, %)
	// - 연산식의 공백은 자유롭게 입력 가능합니다.
	// - 산술 연산자가 반드시 존재하는지 체크하시오.
	// - 피연산자의 갯수가 2개인지 체크하시오.
	
	// TODO 피연산자 부족할 때, 연산자 올바르지 않을 때 수정
	
	public static void main(String[] args) throws Exception {
		
		String[] operators = {"+", "-", "*", "/", "%"};
		
		int operand1 = 0;
		int operand2 = 0;
		int res = 0;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String input = reader.readLine();
		String temp = input.replace(" ", ""); // 입력의 공백을 제거한 임시 변수
		
		for (int i = 0 ; i < operators.length ; i ++) {
			
			if (temp.contains(operators[i])) {
				
				if (temp.split("\\" + operators[i]).length < 2) {
					System.out.println("피연산자가 부족합니다.");
					break;
				}
				
				// 역슬래시 안붙여주면 java.util.regex.PatternSyntaxException 발생
				operand1 = Integer.parseInt(temp.split("\\" + operators[i])[0]); 
				operand2 = Integer.parseInt(temp.split("\\" + operators[i])[1]);
				
				switch (operators[i]) {
					
					case "+":
						res = operand1 + operand2;
						break;
					case "-":
						res = operand1 - operand2;
						break;
					case "*":
						res = operand1 * operand2;
						break;
					case "/":
						res = operand1 / operand2;
						break;
					case "%":
						res = operand1 % operand2;
				}
				
				System.out.printf("%d %s %d = %d", operand1, operators[i], operand2, res); // 결과 출력
				break;
				
			} // if
//			else {
//				System.out.println("연산자가 올바르지 않습니다.");
//				break;
//			}
		} // for
		
	}

}
