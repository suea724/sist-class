package com.test.java;

public class VariableEx {
	
	public static void main(String[] args) {
		
		// byte
		byte currentTemperature = 7;
		byte minTemperature = -4;
		byte currentHour = 17;
		byte currentMinute = 33;
		System.out.println("현재 시각은 " + currentHour + "시" + currentMinute + "분 이며 현재 기온은 " + currentTemperature + "도이며 최저 기온은 " + minTemperature + "도 입니다.");
		
		byte month = 3;
		byte date = 7;
		String day = "월요일";
		System.out.println("오늘은 " + month + "월 " + date + "일 " + day + " 입니다.");
		
		byte mathScore = 98;
		byte rank = 2;
		short allStudentNum = 2000;
		System.out.println("수학 점수는 " + mathScore + "점이고 전체 학생 " + allStudentNum + "중 등수는 " + rank + "등 입니다." );
		
		byte maxFloor = 102;
		byte currentFloor = 25;
		System.out.println("건물의 최대 층은 " + maxFloor + "층이고 현재 층은 " + currentFloor + "입니다." );
		
		// short
		short birthYear = 1997;
		short thisYear = 2022;
		System.out.println("제가 태어난 해는 " + birthYear + "년이며 올해는 " + thisYear + "년 입니다.");
		
		short perfectScore = 990;
		short myToeicScore = 900;
		System.out.println("토익 만점은 " + perfectScore + "점이고 취득 점수는 " + myToeicScore + "점 입니다.");
		
		String memberGrade = "VIP";
		short mileage = 3000;
		float collectRate = 10.0f;
		System.out.println(memberGrade + "등급의 회원은 기본 마일리지 " + mileage + "와 " + collectRate + "%의 적립률이 주어집니다.");
		
		String bookName = "자바의 정석";
		short bookPrice = 30000;
		System.out.println(bookName + "의 가격은 " + bookPrice + "원 입니다.");
		
		short customerCount = 300;
		System.out.println("A카페의 하루 평균 손님 수는 " + customerCount + "명 입니다.");
		
		short taxiPrice = 3800;
		System.out.println("택시의 기본 요금은 " + taxiPrice + "원 입니다.");
		
		short coffeePrice = 4000;
		System.out.println("커피 한잔의 평균 가격은 "+ coffeePrice +" 입니다.");
		
		// long - 8
		long distanceEarthToSun = 150000000000L;
		System.out.println("지구에서 태양까지의 거리는 " + distanceEarthToSun + "m 입니다."); 
		
		String bankName = "A 은행";
		long bankMoney = 10000000000000L;
		System.out.println(bankName + "의 금고에는 " + bankMoney + "원이 있습니다.");
		
		long globalPopulation = 7900000000L;
		long vaccinatedPopulation = 4400000000L;
		System.out.println("전 세계 인구 수는 약 " + globalPopulation + "명이고 백신 접종 인구는 " + vaccinatedPopulation + "명 입니다.");
		
		long countEmail = 230000000000L;
		System.out.println("오늘 발송된 이메일 수는 " + countEmail + "개 입니다.");
		
		long countSearch = 7200000000L;
		System.out.println("오늘 발생된 검색 수는 " + countSearch + "회 입니다.");
		
		long co2Emission = 6200000000L;
		System.out.println("올해 이산화탄소 배출량은 " + co2Emission + "톤 입니다.");
		
		long covidVictim = 130000000L;
		System.out.println("코로나 발생 건수는 " + covidVictim + "건 입니다.");
		
		long earthVolume = 1083200000000L;
		double earthArea = 510065284.702;
		System.out.println("지구의 표면적은 " + earthArea +"제곱 km이며, 부피는 " + earthVolume + "세제곱 km 입니다.");
		
		long internetUsers = 5600000000L;
		System.out.println("인터넷 이용 인구 수는 " + internetUsers + "명 입니다.");
		
		// int
		int cafeCount = 83692;
		System.out.println("우리나라 카페 개수는 " + cafeCount + "개 입니다.");
		
		int width = 100;
		int height = 150;
		int squareArea = 15000;
		System.out.println("밑변의 길이가 " + width + "이고 높이가" + height + "인 정사각형의 넓이는 " + squareArea + "입니다.");
		
		String videoName = "abc";
		int viewCount = 5000000;
		int likeCount = 20000;
		int dislikeCount = 20;
		System.out.println(videoName + " 동영상의 조회수는 " + viewCount + "회이며 좋아요 개수는 " + likeCount + "개, 싫어요 개수는 " + dislikeCount + "개 입니다.");
		
		int peopleSeoul = 9700000;
		System.out.println("서울의 인구 수는 약 " + peopleSeoul + "명 입니다.");
		
		// double -> 6
		double errorPercent = 0.000000000123;
		System.out.println("A공장의 오차율은 " + errorPercent + "% 입니다.");
		
		double pi = 3.141592653589793238462643383279502884197169399375105820974944;
		System.out.println("파이는 약 " + pi + "의 값을 가집니다.");
		
		double fatRate = 20.0;
		double muscleRate = 15.5;
		System.out.println("체지방 비율은 " + fatRate + "%, 근육 비율은 " + muscleRate + "% 입니다.");
		
		double gdp = 2057447.80;
		System.out.println("국내총생산량은 " + gdp + "입니다.");
		
		double todayKospi = 2639.19;
		double highestKospi = 2647.18;
		double lowestKospi = 2605.81;
		double variance = -10.94;
		System.out.printf("오늘의 코스피 종가는 %f, 고가는 %f, 저가는 %f, 변동률은 %f 입니다.\n", todayKospi, highestKospi, lowestKospi, variance);
		
		// float, char, String
		String studentName = "Sue";
		float maxScore = 4.5f;
		float myScore = 4.0f;
		char gradeA = 'A';
		char gradeB = 'B';
		char gradeC = 'C';
		char gradeD = 'D';
		char gradeF = 'F';
		
		System.out.println("만점 " + maxScore + "점 중 " + studentName + "학생의 평점평균은 " + myScore + "점 입니다.");
		System.out.println(gradeA + "과목 : 3개 " + gradeB + "과목 : 1개 "+ gradeC + "과목 : 1개 "+ gradeD + "과목 : 0개 "+ gradeF + "과목 : 0개 입니다.");
		
		char genderWoman = 'w';
		char genderMan = 'm';
		System.out.println("여자는 " + genderWoman + "으로, 남자는 " + genderMan + "으로 나타냅니다.");
		
		char aType = 'A';
		char bType = 'B';
		char oType = 'O';
		String abType = "AB";
		System.out.printf("혈액형에는 %s형, %s형, %s형, %s형이 있습니다. \n", aType, bType, oType, abType);
		
		int balance = 5000000;
		float interestRate = 2.5f;
		String accountNumber = "1234567890";
		System.out.println(accountNumber + " 계좌의 현재 잔액은 " + balance + "원이고, 이자율은 " + interestRate + " 입니다.");
		
		float buyDollar = 1229.50f;
		float sellDollar = 1205.53f;
		System.out.println("오늘의 환율은 살 때 " + buyDollar + "원, 팔 때 " + sellDollar + "원 입니다.");
		
		float waterRatio = 70.0f;
		float seaWaterRatio = 97.3f;
		System.out.println("지구 상 물의 비율은 " + waterRatio + "%이고, 그 중 바닷물 비율은 " + seaWaterRatio + "입니다.");
		
		String memberName = "Sue";
		String homeAddress = "서울시 강남구";
		String phoneNumber = "010-0000-0000";
		String emailAddress = "aaaa@google.com";
		System.out.println(memberName + "회원의 현재 거주지는 " + homeAddress + "이며 핸드폰 번호는 " + phoneNumber + "이고, 이메일 주소는 " + emailAddress + "입니다.");
		 
		int wage = 1000000;
		float taxRate = 3.3f;
		System.out.println("월급 " + wage + "원에 대한 과세율은 " + taxRate + "%입니다.");
		
		float vaccinatedRate = 80.0f;
		System.out.println("백신 접종 비율은 " + vaccinatedRate + "% 입니다." );
		
		float expectLifeSpan = 83.5f;
		System.out.println("기대 수명은 " + expectLifeSpan + "세 입니다.");
		
		// boolean
		
		boolean isBigger = true;
		System.out.printf("\"5가 3보다 큽니다.\"라는 명제는 %b입니다.\n", isBigger);
		
		boolean correctId = true;
		boolean correctPassword = true;
		System.out.printf("아이디가 일치하는가?가 %b이고, 비밀번호가 일치하는가?가 %b이면 로그인에 성공합니다.\n", correctId, correctPassword);
		
		boolean hasAccount = true;
		boolean hasEnoughMoney = false;
		System.out.printf("계좌가 있는가?가 %b이더라도, 계좌의 충분한 돈이 있는가?가 %b이면 돈이 출금되면 안됩니다.\n",
				hasAccount, hasEnoughMoney);
		
		boolean isFull = true;
		boolean isEmpty = false;
		boolean hasEnoughSpace = false;
		System.out.printf("용량이 꽉 찼는가? %b, 용량이 비었는가? %b, 여유 공간이 있는가? %b\n", isFull, isEmpty, hasEnoughSpace);
		boolean isEven = true;
		System.out.println("\"2은 짝수이다\"라는 명제는 " + isEven + "입니다.");
		boolean isNotEven = false;
		System.out.println("\"1은 짝수이다\"라는 명제는 " + isNotEven + "입니다.");
		
	}
	
}
