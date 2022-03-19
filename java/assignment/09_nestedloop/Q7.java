package com.test.java.question.nestedloop;

public class Q7 {
	
	// 1부터 100사이의 완전수를 구하시오.
	// 완전수: 자기 자신을 제외한 나머지 약수들의 합이 자신과 동일한 수
	// TODO
	
	public static void main(String[] args) {
		
		int sum = 0;
		String str = "";
		
		int i;
		int j;
		
		// 1 ~ 100 사이의 수
		for (i = 1 ; i <= 100 ; i ++) {
			
			
			// 1 ~ i-1의 수
			for (j = 1 ; j < i ; j ++) {
 				
				// 약수이면
				if (i % j == 0) {
					
					// 누적 변수에 약수 합 저장
					sum += j;
					str += j + ", ";
				}
				
			}
			
			// 약수의 합과 수가 같으면 
			if (i == sum) {
				
				System.out.print(i + " = [");
				System.out.println(str + "\b\b]");
				
			}
			
			// 누적 변수 초기화
			sum = 0;
			str = "";
			
		}
			
	}

}
