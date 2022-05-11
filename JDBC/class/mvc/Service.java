package com.test.java.mvc;

import java.util.ArrayList;
import java.util.Scanner;

// Address 업무 담당
// 1. 쓰기
// 2. 읽기
// 3. 수정
// 4. 삭제
public class Service {
	
	public void start() {
		
		boolean loop = true;
		
		while (loop) {
			
			View view = new View();
			view.menu();
			
			Scanner sc = new Scanner(System.in);
			
			String input = sc.nextLine();
			
			if (input.equals("1")) {
				add();
			} else if (input.equals("2")) {
				list();
			} else if (input.equals("3")) {
				edit();
			} else if (input.equals("4")) {
				del();
			} else {
				loop = false;
			}

		}
	}

	private void add() {
		
		System.out.println("[주소록 등록하기]");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		
		System.out.print("성별(m,f) : ");
		String gender = sc.nextLine();
		
		System.out.print("전화 : ");
		String tel = sc.nextLine();
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		
		// Service -> 데이터 -> DAO
		Address dto = new Address();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		// DB 담당
		DAO dao = new DAO();
				
		int result = dao.add(dto); // 성공 1, 실패 0
		
		if (result == 1) {
			System.out.println("주소록 등록을 완료했습니다.");
		} else {
			System.out.println("주소록 등록을 실패했습니다.");
		}
		
		pause();
	}

	private void list() {
		
		System.out.println("[주소록 목록보기]");
		
		// 1. DAO 위임 > DB > select > rs
		// 2. 결과셋 반환
		// 3. View에게 전달 + 출력
		
		DAO dao = new DAO();
		
		// *** DB 담당자 > JDBC 코드 관리 > DAO
		// *** 서비스 담당자 > 업무 코드 관리
		// ******** Connection, Statement, ResultSet > 반드시 DAO.java에서 코딩
		// ResultSet rs = dao.list();
		
		// Address > 레코드
		// ArrayList > 테이블
		ArrayList<Address> list = dao.list();
		
		View view = new View();
		view.list(list);
		
		pause();
		
	}
	
	private void edit() {
		
		System.out.println("[주소록 수정하기]");
		
		// 수정할 번호 알고있다고 가정 > 현재 내용 출력 > 번호 입력받기
		Scanner sc = new Scanner(System.in);
		
		System.out.print("수정할 번호: ");
		String seq = sc.nextLine();
		
		DAO dao = new DAO();
		Address dto = dao.get(seq);
		
		System.out.println("이름 : " + dto.getName());
		System.out.println("나이 : " + dto.getAge());
		System.out.println("성별 : " + dto.getGender());
		System.out.println("전화 : " + dto.getTel());
		System.out.println("주소 : " + dto.getAddress());
		
		System.out.println();
		
		System.out.println("수정 사항을 입력하세요. (수정하지 않으려면 엔터 입력)");
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		if (!name.equals("")) {
			dto.setName(name);
		}
		
		System.out.print("나이 : ");
		String age = sc.nextLine();
		if (!age.equals("")) {
			dto.setAge(age);
		}
		
		System.out.print("성별 : ");
		String gender = sc.nextLine();
		if (!gender.equals("")) {
			dto.setGender(gender);
		}
		
		System.out.print("전화번호 : ");
		String tel = sc.nextLine();
		if (!tel.equals("")) {
			dto.setTel(tel);
		}
		
		System.out.print("주소 : ");
		String address = sc.nextLine();
		if (!address.equals("")) {
			dto.setAddress(address);
		}
		
		int result = dao.edit(dto);
		
		if (result == 1) {
			System.out.println("주소록 수정을 완료했습니다.");
		} else {
			System.out.println("주소록 수정을 실패했습니다.");
		}
		
		pause();
	}

	private void del() {
		
		System.out.println("[주소록 삭제하기]");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("삭제할 번호 : ");
		String seq = sc.nextLine();
		
		DAO dao = new DAO();
		
		int result = dao.del(seq);
		
		if (result == 1) {
			System.out.println("주소록 삭제를 완료했습니다.");
		} else {
			System.out.println("주소록 삭제를 실패했습니다.");
		}
		
		pause();
	}
	
	private void pause() {
		Scanner sc = new Scanner(System.in);
		System.out.println("계속하려면 엔터를 입력하세요.");
		sc.nextLine();
	}
}
