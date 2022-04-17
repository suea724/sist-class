package com.project.sports.user.rank;

import com.project.sports.output.Output;

public class RankOutput {

	public static void printRankMenu() { // 순위 메인 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 개인 순위\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 연도 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
		
	}
	
	public static void printPositionMenu() { // 포지션 선택 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │              1. 타자		    │");
		System.out.println("\t\t\t\t\t │              2. 투수		    │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	public static void printBatterMenu() { // 타자 항목 선택 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │              1. 안타		    │");
		System.out.println("\t\t\t\t\t │              2. 홈런		    │");
		System.out.println("\t\t\t\t\t │              3. 타점		    │");
		System.out.print("\t\t\t\t\t │\t        "); Output.back(); System.out.print("\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	public static void printPitcherMenu() { // 투수 항목 선택 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 평균 자책\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 승수\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 탈삼진\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 이닝\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	public static void printYearMenu() { // 연도별 검색 메뉴
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 개인 순위\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
	
	public static void printYearBatterMenu() { // 연도별 개인 순위 타자 검색 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 안타\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 홈런\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 타점\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 선수 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
		
	}
	
	public static void printYearPitcherMenu() { // 투수 항목 선택 메뉴
		
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │            1. 평균 자책\t\t    │");
		System.out.println("\t\t\t\t\t │            2. 승수\t\t    │");
		System.out.println("\t\t\t\t\t │            3. 탈삼진\t\t    │");
		System.out.println("\t\t\t\t\t │            4. 이닝\t\t    │");
		System.out.println("\t\t\t\t\t │            5. 선수 검색\t\t    │");
		System.out.print("\t\t\t\t\t │\t      "); Output.back(); System.out.print("\t\t    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
		Output.input();
	}
}
