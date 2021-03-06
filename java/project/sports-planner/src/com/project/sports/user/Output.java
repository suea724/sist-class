package com.project.sports.user;

public class Output {
	
	public static void input() {
		
		System.out.print("\t\t\t\t\t\t 메뉴 번호 : ");
	}
	
	public static void back() {
		System.out.print("0. 뒤로가기");
	}
	
	public static void startMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 로그인	            │");
		System.out.println("\t\t\t\t\t │            2. 회원가입		    │");
		System.out.println("\t\t\t\t\t │       3. 아이디/비밀번호 찾기	    │");
		System.out.println("\t\t\t\t\t │            4. 프로그램 종료	    │");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
	}
public static void loginMenu() {
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │             1. 회원		    │");
		System.out.println("\t\t\t\t\t │             2. 관리자	   	    │");
		System.out.print("\t\t\t\t\t │\t       "); back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		input();
	}
	
	public static void myPageMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 내 정보	            │");
		System.out.println("\t\t\t\t\t │            2. 마이팀		    │");
		System.out.print("\t\t\t\t\t │\t      "); back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		input();
	}
	
	public static void myPageMyTeam() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 마이팀 검색	    │");
		System.out.println("\t\t\t\t\t │            2. 마이팀 추가	    │");
		System.out.println("\t\t\t\t\t │            3. 마이팀 삭제	    │");
		System.out.print("\t\t\t\t\t │\t      "); back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		input();
		
	}
	
	public static void myPagePlayer() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │	   페이지 변경 <,> 입력	    │");
		System.out.println("\t\t\t\t\t │            1. 선수 정보  	    │");
		System.out.print("\t\t\t\t\t │\t      "); back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		input();
	}
	
	public static void myInfoMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 개인 정보 수정	    │");
		System.out.println("\t\t\t\t\t │            2. 나의 예매내역	    │");
		System.out.println("\t\t\t\t\t │            3. 포인트		    │");
		System.out.println("\t\t\t\t\t │            4. 회원 탈퇴	    	    │");
		System.out.print("\t\t\t\t\t │\t      "); back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		
		input();
		
	}
	
	

}
