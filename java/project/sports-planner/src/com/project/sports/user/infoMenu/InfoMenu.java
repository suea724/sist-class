package com.project.sports.user.infoMenu;

import java.util.Scanner;
import com.project.sports.output.Output;

public class InfoMenu {
	
	public static void selectInfo () {
		
	
		
	Scanner sc = new Scanner(System.in);
	boolean selectInfoFlag = true;
	
	while(selectInfoFlag) {	//메인메뉴에서 정보를 눌렀을때
			
			InfoOutput.teamList();
			InfoOutput.infoMenu(); //정보 메뉴 보여주기

			String input = sc.nextLine(); // 정보 메뉴 번호 입력받기
	
			if(input.equals("1")) { //1. 팀 상세보기
				//팀 상세보기
				TeamDetail.teamDetailInfo();
				
			} else if(input.equals("2")) { //2.선수 검색
				//선수 검색
				PlayerDetail.playerSearch();
				
			}else if(input.equals("0")){
				
				Output.backMsg();
				selectInfoFlag = false;
				
			} else { //유효성검사
				
			}
		}
	}
}
