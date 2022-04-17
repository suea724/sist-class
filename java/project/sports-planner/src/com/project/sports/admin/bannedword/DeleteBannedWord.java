package com.project.sports.admin.bannedword;

import java.util.Scanner;
import com.project.sports.input.BannedWord;
import com.project.sports.main.Data;
import com.project.sports.output.Output;

public class DeleteBannedWord {

	public static void deleteBannedWord() {

		Scanner sc = new Scanner(System.in);
		boolean deleteNumFlag = true;

		while (deleteNumFlag) {
			System.out.println();
			System.out.print("\t\t\t\t\t삭제할 금지어의 번호를 선택하세요. (0. 뒤로가기) : ");
			String deleteNum = sc.nextLine();

			if (deleteNum.equals("")) {
				System.out.println("\t\t\t\t\t\t내용을 입력해주세요.");

			} else if (deleteNum.equals("0")) {
				Output.backMsg();
				break;

			} else { // 유효성검사

			}



			boolean deleteFlag = true;

			while (deleteFlag) {

				System.out.print("\t\t\t\t\t\t 금지어를 삭제하시겠습니까? (Y/N) : ");
				String answer = sc.nextLine().toUpperCase();

				if (answer.equals("Y")) {


					//for (BannedWord b : Data.bannedWordList) {
					for (int i=0; i<Data.bannedWordList.size(); i++) { //금지어 삭제
						
						BannedWord b = Data.bannedWordList.get(i);

						if ( b.getSeq() == AdminBannedWord.BannedWordList
								.get(Integer.parseInt(deleteNum) - 1).getSeq()) {

							//BannedWordList.remove(b);
							
							Data.bannedWordList.remove(b);

							

						}

					}
					
					System.out.println("\t\t\t\t\t\t      삭제가 완료되었습니다.");
					System.out.println("\t\t\t\t\t     엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
					Scanner scanner = new Scanner(System.in);
					scanner.nextLine();
					deleteFlag = false;
					deleteNumFlag = false;
					break;


				} else if (answer.equals("N")) {

					System.out.println("\t\t\t\t\t\t      삭제를 취소합니다.");
					System.out.println("\t\t\t\t\t     엔터(Enter)를 누르시면 이전 메뉴로 돌아갑니다.");
					Scanner scanner = new Scanner(System.in);
					scanner.nextLine();
					deleteNumFlag = false;
					deleteFlag = false;
					break;
					
					
				}

			}


		}



	}

}

