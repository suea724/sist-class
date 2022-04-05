package com.test.java.io.question.q2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Stack;

public class Q6 {
	
	// 모든 괄호가 서로 짝이 맞는지 검사하시오.
	
	public static void main(String[] args) {
		
		final String PATH = "D:\\suea7\\class\\파일_입출력_문제\\괄호.java";
		Stack<Character> stack = new Stack<>();
		
		try {
			
			File file = new File(PATH);
			BufferedReader reader = new BufferedReader(new FileReader(file));
			
			String line = "null";
			 
			while((line = reader.readLine()) != null) {
				
				for (int i = 0 ; i < line.length() ; i ++) {
					
					char c = line.charAt(i);
					
					if (c == '{' || c == '(') { // 여는 괄호일 때 stack에 넣어놓기
						stack.push(c);
					}
					
					if (c == '}') { // 닫는 중괄호 만났을 때
						
						if (stack.peek() == '{') { // top에 여는 중괄호가 있으면 pop
							stack.pop();
						}
					}
					
					if (c == ')') { // 닫는 괄호 만났을 때
						
						if (stack.peek() == '(') { // top에 여는 괄호가 있으면 pop
							stack.pop();
						}
					}
				}
			}
			
			reader.close();
			
			if(stack.isEmpty()) { // 스택이 비었으면 괄호의 짝이 다 맞은 것
				System.out.println("올바른 소스입니다.");
			} else {
				System.out.println("올바르지 않은 소스입니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
