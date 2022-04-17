package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailCommentId;

public class SearchCommentContent {
	
	public static void searchCommentContent() {
		
		
		System.out.print("\t\t\t\t\t\t 검색할 댓글내용을 입력해주세요.:");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		DetailCommentId.detail(input);
	}

}
