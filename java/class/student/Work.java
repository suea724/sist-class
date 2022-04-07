package com.test.java.student;

import java.util.Scanner;

// 학생 처리 업무 담당 클래스
public class Work {
	
	private Scanner scanner;
	
	public Work() {
		scanner = new Scanner(System.in);
	}
	
	// CRUD
	public void add() {
		
		Output.subtitle("학생 추가하기");
		
		System.out.print("이름: ");
		String name = scanner.nextLine();
		
		System.out.print("나이: ");
		String age = scanner.nextLine();
		
		System.out.print("성별(1.남자, 2.여자): ");
		String gender = scanner.nextLine();
		
		System.out.print("주소: ");
		String address = scanner.nextLine();
		
		String seq = getSeq();
		
		Student s = new Student(seq, name, age, gender, address);
		
		Data.slist.add(s);
		
		System.out.println();
		System.out.println("학생 추가 완료");
		
		Output.pause();
		
	}
	
	private String getSeq() {
		
		int max = 0;
		
		for (Student s : Data.slist) {
			
			int seq = Integer.parseInt(s.getSeq());
			
			if (seq > max) {
				max = seq;
			}
		}
		return (max + 1) + "";
	}

	public void list() {
		
		Output.subtitle("학생 목록보기");
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for(Student s : Data.slist) {
			System.out.printf("%4s\t%4s\t%4s\t%4s\n", s.getSeq()
												, s.getName()
												, s.getAge()
												, s.getGender().equals("1") ? "남자" : "여자");
		}
		
		System.out.println();
		
		boolean loop = true;
		
		while(loop) {
			
			Output.submenu();
			
			String input = scanner.nextLine();
			
			switch(input) {
				
				case "1": // 상세보기
					view();
					break;
				case "2": // 수정하기
					edit();
					break;
				case "3": // 삭제하기
					delete();
					break; 
				case "4": // 상위메뉴
					loop = false;
					break;
				default:
					System.out.println("다시 입력해주세요");
					break;
				
			}
		}
		
		Output.pause();
		
	}

	private void view() {
		
		// 학생 목록에서 한명 선택 > 번호로
		System.out.print("학생 선택(번호): ");
		
		String input = scanner.nextLine();
		Student result = null;
		
		for (Student s : Data.slist) {
			
			if (input.equals(s.getSeq())) {
				result = s;
				break;
			}
		}
		
		if (result != null) {
			
			System.out.println("[번호] " + result.getSeq());
			System.out.println("[이름] " + result.getName());
			System.out.println("[나이] " + result.getAge());
			System.out.println("[성별] " + (result.getGender().equals("1") ? "남" : "여"));
			System.out.println("[주소] " + result.getAddress());
			
			// 성적 출력
			for (Score s : Data.clist) {
				if (result.getSeq().equals(s.getSeq())) {
					System.out.printf("국어(%d), 영어(%d), 수학(%d) = 평균(%.1f)\n", s.getKor()
																			, s.getEng()
																			, s.getMath()
																			, (s.getKor() + s.getEng() + s.getMath()) / 3.0);
				}
			}
			
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
		
		Output.pause();
		
	}
	
	private void edit() {
		
		System.out.print("학생 선택(번호): ");
		
		String input = scanner.nextLine();
		Student result = null;
		
		for (Student s : Data.slist) {
			
			if (input.equals(s.getSeq())) {
				result = s;
				break;
			}
		}
		
		if (result != null) { 
			
			// 수정 작업
			// > 수정하기 싫으면 그냥 엔터 입력
			
			System.out.println("[이름] " + result.getName());
			System.out.print("수정: ");
			String name = scanner.nextLine();
			
			if (!name.equals("")) {
				result.setName(name);
			}
			
			System.out.println("[나이] " + result.getAge());
			System.out.print("수정: ");
			String age = scanner.nextLine();
			
			if (!age.equals("")) {
				result.setAge(age);
			}
			
			System.out.println("[성별] " + result.getGender());
			System.out.print("수정(1.남자, 2.여자): ");
			String gender = scanner.nextLine();
			
			if (!gender.equals("")) {
				result.setGender(gender);
			}
			
			System.out.println("[주소] " + result.getAddress());
			System.out.print("수정: ");
			String address = scanner.nextLine();
			
			if (!address.equals("")) {
				result.setAddress(address);
			}
			
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
	
	}
	
	private void delete() {
		
		System.out.print("학생 선택(번호): ");
		
		String input = scanner.nextLine();
		Student result = null;
		
		for (Student s : Data.slist) {
			
			if (input.equals(s.getSeq())) {
				result = s;
				break;
			}
		}
		
		if (result != null) {
			
			// Enhanced for문 사용시 ConcurrentModificationException 예외 발생
			for (int i = 0 ; i < Data.clist.size() ; i ++) { // 삭제하려는 학생의 성적 삭제
				if (result.getSeq().equals(Data.clist.get(i).getSeq())) {
					Data.clist.remove(Data.clist.get(i));
				}
			}
			
			Data.slist.remove(result); // 학생 삭제
			System.out.println("삭제 완료");
		} else {
			System.out.println("입력한 학생 번호가 올바르지 않습니다.");
		}
	}

	public void search() {
		
		Output.subtitle("학생 검색하기");
		
		// 검색 조건 입력
		// 이름 or 주소
		System.out.print("검색어(이름/주소): ");
		String input = scanner.nextLine();
		
		System.out.println("[번호]\t[이름]\t[나이]\t[성별]");
		
		for(Student s : Data.slist) {
			
			if (s.getName().contains(input) 
					|| s.getAddress().replace(" ", "").contains(input.replace(" ",""))) {
				
				System.out.printf("%4s\t%4s\t%4s\t%4s\n", s.getSeq()
						, s.getName()
						, s.getAge()
						, s.getGender().equals("1") ? "남자" : "여자");
			}
		}
		
		System.out.println();
		Output.pause();
	}

}
