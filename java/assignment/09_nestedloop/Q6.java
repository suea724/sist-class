package com.test.java.question.nestedloop;

public class Q6 {
	
	// 2부터 100사이의 소수를 구하시오.
	
	public static void main(String[] args) {
		
		// 루프 변수 선언
		int i;
		int j;
		
		// 출력할 문자열 선언
		String str = "";
		
		// 2 ~ 100까지의 수
		for (i = 2 ; i <= 100 ; i++) {
			
			// 2 ~ i-1 (1과 자기자신 빼고)
			for (j = 2 ; j < i ; j ++) {
			
				// 만약 2 ~ i-1의 수로 나누어지면 for문 탈출 (소수 조건 만족X)
				if (i % j == 0)  {
					break;
				} 
				
			}
			
			// 내부 for문 끝나면 소수. 문자열 저장
			if (i == j) {
				str += j + ", ";
			}
			
		}
		
		System.out.println(str);
			
	}

}
