package com.test.java.question.method;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Q7 {

	public static void main(String[] args) throws Exception {
		
		// 요구사항 : 지하철 탑승 소요 시간을 구하시오. 지나가는 역의 개수, 환승역의 횟수, 시간대를 전달 받아 총 걸리는 시간을 반환하는 메소드를 선언하시오.
		
		/**
		 * 설계
		 * 1. 역 개수, 환승역 수, 출퇴근 시간 여부에 따른 환승 소요 시간을 매개변수로 받는 메서드를 정의한다.
		 * 2. 역의 개수에 따른 소요시간은 역의 개수(역의 개수 - 1 아닌감..)에 소요시간인 2를 곱하여 구한다.
		 * 3. 입력으로 들어오는 번호(1,2,3)에 따라 환승 소요시간을(3,4,5)로 설정한 후 환승역 횟수와 곱한다. > 삼항 연산자 사용
		 * 4. 2번과 3번 값을 더해 총 소요시간을 반환한다.
		 */
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("역의 개수 : ");
		int stationNum = Integer.parseInt(reader.readLine());

		System.out.print("환승 횟수 : ");
		int transferCount = Integer.parseInt(reader.readLine());
		
		System.out.print("시간대 (1. 평상시, 2. 출근시, 3. 퇴근시) : ");
		int time = Integer.parseInt(reader.readLine());
		
		System.out.printf("총 소요시간은 %d분 입니다.", getTime(stationNum, transferCount, time));
		
	}
	
	public static int getTime(int station, int change, int time) {
		
		int travelTime = station * 2;
		int transferTime = (time == 1) ? 3 : (time == 2) ? 4 : (time == 3) ? 5 : null;
		
		return travelTime + (transferTime * change);
		
	}
}
