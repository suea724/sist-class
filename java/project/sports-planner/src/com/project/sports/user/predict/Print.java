package com.project.sports.user.predict;

import com.project.sports.output.Output;

public class Print {

	public static void predictMenu() {
		System.out.println("\t\t\t\t\t ┌──────────────────────────────────┐");
		System.out.println("\t\t\t\t\t │          1. 승부 예측하기	    │");
		System.out.println("\t\t\t\t\t │          2. 예측 결과 보기	    │");
		System.out.print("\t\t\t\t\t │\t    ");
		Output.back();
		System.out.print("\t    	    │\n");
		System.out.println("\t\t\t\t\t └──────────────────────────────────┘");
	}
	
}
