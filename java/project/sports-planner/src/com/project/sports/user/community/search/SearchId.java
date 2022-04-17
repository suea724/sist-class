package com.project.sports.user.community.search;

import java.util.Scanner;
import com.project.sports.user.community.DetailId;

public class SearchId {
	
	public static void searchId() {
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\t 검색하실 아이디를 입력해 주세요.:");
		String id = sc.nextLine();
		DetailId.detail(id);
	}

}
