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
	
	public static void main(String[] args) throws Exception {
		
		String[] operators = {"+", "/", "*", "-", "%"};
		
		int operand1 = 0;
		int operand2 = 0;
		int res = 0;
		String[] operands; // 피연산자가 저장될 배열
		boolean hasOperator = false; // 연산자 포함 여부
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("입력: ");
		String input = reader.readLine();
		
		String temp = input.replace(" ", ""); // 입력의 공백을 제거한 임시 변수
		
		for (int i = 0 ; i < operators.length ; i ++) {
			
			if (temp.contains(operators[i])) { // 연산자를 포함할 경우
				
				hasOperator = true;
				
				// 정규식의 이스케이프 문자 중 하나 [+], [*]
				// +, * 기호는 바로 split 할 경우 java.util.regex.PatternSyntaxException 발생
				operands = temp.split("[" + operators[i] + "]"); 
				
				if (operands.length < 2 || operands[0].equals("")) {
					System.out.println("피연산자가 부족합니다.");
					break;
				}
				
				// String 피연산자 -> int 피연산자
				operand1 = Integer.parseInt(operands[0]); 
				operand2 = Integer.parseInt(operands[1]);
				
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
				
		} // for
		
		if (hasOperator == false) { // for문 돌고 나서도 hasOperator가 false이면 연산자 오류
			System.out.println("연산자가 올바르지 않습니다.");
		}
	}

}
