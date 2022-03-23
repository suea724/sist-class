package com.test.java.question.string;

public class Q5 {
	
	// 요구사항: 특정 단어가 문장내에 몇회 있어있는지 수를 세시오.
	// indexOf 사용 (루프)
	// replace로 풀면 쉬움
	
	/**
	 * 1.index 변수를 -1로 초기화한다. 
	 * 2.indexOf로 처음 word의 위치를 찾는다.
	 * 3.다음 indexOf의 beginIndex에는 처음 word의 위치 + 1을 해준다.
	 * 4.index가 -1보다 클때까지 루프를 돌린다. (만약 인덱스가 -1보다 클경우 count++) 
	 */
	
	public static void main(String[] args) {
		
		int cnt = 0;
		String content = "안녕~ 길동아~ 잘가~ 길동아~";
		String word = "길동";
		
		/**
		 * - replace를 사용해서 검색어를 빈 문자열로 바꾸고 ((검색할 문자열 - 빈 문자열로 교체된 문자열) / 검색어 길이)로도 갯수를 찾을 수 있다.
		 * - 또는 replace를 사용해서 다른 문자로 바꾼뒤 그 문자의 갯수를 세는 방법도 있다. 
		 */
		
		int idx = content.indexOf(word); // 처음으로 나오는 검색 단어의 인덱스
		
		if (idx == -1) { // 검색 단어가 존재하지 않을 때
			System.out.println("찾는 단어가 없습니다.");
		} else { // 검색 단어가 존재할 때
			
			while (idx > -1) { // 검색 단어가 없을 때까지
				
				cnt ++;
				// 기존의 인덱스에 검색 단어 길이 더한 값이 다음 indexOf의 beginIndex
				idx = content.indexOf(word, idx + word.length()); 
				
			}
			
			System.out.printf("\'%s\'을 총 %d회 발견했습니다.\n", word, cnt);
		}
	}
}
