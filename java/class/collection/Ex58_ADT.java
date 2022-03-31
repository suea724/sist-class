package com.test.java.collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex58_ADT {

	public static void main(String[] args) {
		
		/**
		 * [자료구조(컬렉션)]
		 * 	- 데이터를 저장하는 공간의 구조
		 * 	- e.g. 배열 > 선형 구조
		 * 	- 물리적인 특징, 추상적인 특징을 가지는 자료구조가 있음
		 * 
		 * [ADT]
		 * 	- Abstract Data Type, 추상 자료형
		 * 	- Stack, Queue
		 *  - 물리적인 특성을 가지는 것이 아니라, 사용법이 특성을 가짐
		 *  
		 * [Stack]
		 *  - LIFO
		 *  - e.g. 메모리 구조(Stack), 되돌리기(ctrl + z), 다시하기(ctrl + y), 뒤로가기
		 * 
		 * [Queue]
		 * 	- FIFO
		 * 	- e.g. 줄서기 
		 */
		
		 // m1();
		 m2();
	}

	private static void m2() {
		
		/* Queue(I) -> LinkedList로 구현 */
		
		Queue<String> queue = new LinkedList<>();
		
		// 1. 요소 추가 > boolean add(T value)
		queue.add("빨강"); // enqueue
		queue.add("파랑");
		queue.add("노랑");
		
		
		// 2. 요소 개수 > int size()
		System.out.println(queue.size());
		
		// 3. 요소 읽기(= 꺼내기) > T poll() > 비어있을 경우 null 반환
		System.out.println(queue.poll()); // dequeue
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); 
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); 
		System.out.println(queue.size());
		
		System.out.println(queue.poll()); 
		System.out.println(queue.size());
		
		// 4. 비어있는지? > boolean isEmpty()
		System.out.println(queue.isEmpty());
		
		// 5. 요소 확인 > T peek()
		queue.add("주황");
		System.out.println(queue.peek());
		System.out.println(queue.size());
		
		// 6. 초기화 > void clear()
		queue.clear();
		System.out.println(queue.size());
		
	}

	private static void m1() {
		
		/* Stack */
		
		Stack<String> stack = new Stack<>();
		
		// 1. 요소 추가하기 > T push(T value)
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		// 2. 요소 개수 확인 > int size()
		System.out.println(stack.size());
		
		// 3. 요소 읽기(꺼내기) > T pop()
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		System.out.println(stack.pop());
		System.out.println(stack.size());
		
		// 4. 스택이 비어있는지 확인 > boolean isEmpty()
		System.out.println(stack.isEmpty()); // stack.size == 0
		
		if(!stack.isEmpty()) {
			stack.pop();
			stack.size();
		}
		
		// 5. 요소 확인(Top 위치만 읽기, 제거 X)
		stack.push("빨강");
		stack.push("파랑");
		stack.push("노랑");
		
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
	}

}
