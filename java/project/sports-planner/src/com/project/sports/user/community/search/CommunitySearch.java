package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.output.Output;
import com.project.sports.user.community.OutCommunityMenu;

public class CommunitySearch {
	
	
	public static void searchMenu() {
		
		boolean SearchFlag = true;
		Scanner sc = new Scanner(System.in);
		
		while(SearchFlag) {
			System.out.println();			
			OutCommunityMenu.outSearchMenu();
			String inMenu = sc.nextLine();
			
			if (inMenu.equals("1")) { //말머리 검색
				SearchSubject.searchSubject();
			} else if(inMenu.equals("2")) { // 제목 검색
				SearchTitle.searchTitle();
			} else if(inMenu.equals("3")) { // 작성자 검색
				SearchId.searchId();
			} else if(inMenu.equals("4")) { // 본문 내용 검색
				SearchContent.searchContent();
			} else if(inMenu.equals("5")) { // 댓글 작성자 검색
				SearchCommentId.searchCommenId();
			} else if(inMenu.equals("6")) { // 댓글 내용 검색
				SearchCommentContent.searchCommentContent();
			} else if(inMenu.equals("0")) {
				return;
			} else {
				OutCommunityMenu.outMenuError();
//				OutCommunityMenu.outContinuMsg();
//				sc.nextLine();				
				
				continue;
			}
			
			
		}
		
		
		
	}
	
	
}
