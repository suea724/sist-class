package com.test.java.student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		/**
		 * [학생 관리 프로그램]
		 * 	- 프로젝트 가이드
		 * 	- 파일 입출력 + 컬렉션
		 * 	- 기본 행동 : 생성하기(Create), 읽기(Read), 수정하기(Update), 삭제하기(Delete) > CRUD
		 * 		- 학생 정보 추가 (C)
		 * 		- 학생 정보 목록 보기 (R)
		 * 			- 학생 정보 상세 보기 (R)
		 * 			- 학생 정보 수정하기 (U)
		 * 			- 학생 정보 삭제하기 (D)
		 * 	- 업무별 > 클래스 분배 > 업무별 담당 클래스
		 * 
		 *  - 데이터 설계
		 *  	- 정보 수집 > 이름, 나이, 성별, 주소, 국어 점수, 영어 점수, 수학 점수
		 *  	- 분류 > 개인 정보 (이름, 나이, 성별, 주소), 성적 (국어 점수, 영어 점수, 수학 점수)
		 *  	- 파일 > 학생.txt, 성적.txt
		 *  	- 학생.txt 구조
		 *  		- 번호, 이름, 나이, 성별, 주소
		 *  		- 1,홍길동,15,서울시 강남구 역삼동
		 *  	- 성적.txt 구조
		 *  		- 학생 번호,국어,영어,수학
		 *  		- 1,100,90,80
		 *  	- 학생.txt <-> (시험) <-> 성적.txt
		 *  
		 *  - 데이터 파일 + 데이터 생성
		 *  
		 *  - 클래스
		 *  	- 파일 경로 > DataPath.java
		 *  - 순서도
		 *  	1. 타이틀
		 *  	2. 메인 메뉴
		 *  	3. 선택
		 *  		- 각각의 기능 실행
		 *  		- 종료 > 2번으로 돌아가기
		 * 		4. 종료 	
		 */
		
		boolean loop = true;
		
		Work work = new Work();
		Data.load();
		
		while(loop) {
			
			Output.title();
			Output.mainmenu();
			
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine();
			
			switch (input) {
				
				case "1":
					work.add(); // 업무 위임
					break;
				case "2":
					work.list();
					break;
				case "3":
					work.search();
					break;
				case "4":
					loop = false;
					Output.close();
					break;
				default:
					System.out.println("다시 입력해주세요");
			} 
			
			Data.save();
		}
	}

}
