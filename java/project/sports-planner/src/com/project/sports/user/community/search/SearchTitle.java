package com.project.sports.user.community.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.project.sports.input.Post;
import com.project.sports.main.Data;
import com.project.sports.output.Output;
import com.project.sports.user.community.DetailId;
import com.project.sports.user.community.DetailTitle;

public class SearchTitle {
	
	public static void searchTitle() { // 제목으로 검색하기
		
		Scanner sc = new Scanner(System.in);
		System.out.print("\t\t\t\t\t\t 검색하실 제목을 입력해 주세요.:");
		String id = sc.nextLine();
		DetailTitle.detail(id);
		
		
	}

}
