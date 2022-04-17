package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailContent;

public class SearchContent {
	
	public static void searchContent() {
		
		System.out.print("\t\t\t\t\t\t 검색할 내용을 입력해주세요.:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DetailContent.detail(input);
		
	}

}
