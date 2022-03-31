package com.test.java.collection.question.stack;

public class Test {
	
	public static void main(String[] args) {
		
		MyStack stack = new MyStack();

		//추가
		stack.push("빨강");
		stack.push("노랑");
		stack.push("파랑");
		stack.push("주황");
		System.out.println(stack);
		stack.push("검정");
		System.out.println(stack);

		//읽기
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack);

		//개수
		System.out.println(stack.size());
		
		//확인
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.size());
		
		//크기 조절
		stack.trimToSize();
		System.out.println(stack);
		
		//초기화
		stack.clear();
		System.out.println(stack.size());
		System.out.println(stack);
	}

}
