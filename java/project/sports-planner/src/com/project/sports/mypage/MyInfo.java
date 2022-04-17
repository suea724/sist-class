package com.project.sports.mypage;

import java.util.Scanner;
import com.project.sports.user.Output;

public class MyInfo {
	
	public static void MyInfoMenu() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			Output.myInfoMenu();
			String input = sc.nextLine();
			if (input.equals("1")) {
				MyInfoEdit.myInfoEdit();
			} else if (input.equals("2")) {
				MyTicketing.myTicketing();
			} else if (input.equals("3")) {
				MyPoint.myPoint();
			} else if (input.equals("4")) {
				DeleteUser.deleteUser();
				return;
			} else if (input.equals("0")) {
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}

}
