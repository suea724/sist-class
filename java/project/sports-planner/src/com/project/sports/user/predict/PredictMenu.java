package com.project.sports.user.predict;

import java.util.Scanner;
import com.project.sports.output.Output;

public class PredictMenu {

	//메인메뉴>승부예측의 첫화면 - 메뉴선택기능
	public static void selectPredictMenu() {
		
		Scanner sc = new Scanner(System.in);
	
		boolean selectPredictMenuFlag = true;
		while(selectPredictMenuFlag) {
			
			//메뉴 출력
			Print.predictMenu(); //메뉴 출력 1. 승부예측하기 2. 예측 결과 보기
			Output.input();
			
			String input = sc.nextLine(); //메뉴 입력받기 1.승부예측하기 2. 예측결과 보기
			
			if(input.equals("1")) { //1. 승부예측하기
				
				PredictFunction.selectWinTeamFlag = true;
				PredictFunction.predictFunctionFlag = true;
				PredictFunction.selectPredictGame = true;
				PredictFunction.predictFunction();
				
			} else if(input.equals("2")) { //2. 예측 결과보기
				
				PredictResult.predictResult();
				
			} else if(input.equals("0")) {
				selectPredictMenuFlag = false;
				Output.backMsg();
			} else {
				//유효성 검사
			}
		}
		
		
	}
}
