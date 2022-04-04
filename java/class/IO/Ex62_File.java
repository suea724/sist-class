package com.test.java.io;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Ex62_File {
	
	// 누적 변수
	private static int count = 0;

	public static void main(String[] args) {
		
		/**
		 * 1. 파일 / 디렉토리 조작
		 * 	- 윈도우 탐색기로 하는 행동 > 자바로 구현
		 * 	- 파일, 폴더 > 정보 확인, 새로 만들기, 이름 바꾸기, 이동, 삭제, 복사, ..
		 * 2. 파일 입출력
		 * 	- 파일 > 읽기/쓰기
		 * 	- 텍스트 기반의 입출력
		 * 	- 메모장, 이클립스, ...
		 */
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		// m9();
		// m10();
		// m11();
		// m12();
		// m13();
		// m14();
		// m15();
		m16();
		
	}

	private static void m16() {
		
		// List > 순서 존재 > 루프 사용(방번호), Iterator
		// Set > 순서 없음 > Iterator
		// Map > 순서 없음 > Iterator 사용 X
		
		HashMap<String, String> map = new HashMap<>();
		
		map.put("one", "하나");
		map.put("two", "둘");
		map.put("three", "셋");
		map.put("four", "넷");
		map.put("five", "다섯");
		
		// HashMap의 key들로만 구성된 Set
		Set<String> set = map.keySet();
		System.out.println(set);
		
		// value들로만 구성된 Collection
		Collection<String> values = map.values();
		System.out.println(values);
		
		// keySet을 사용해서 HashMap 루프 돌리기
		Iterator<String> itr = set.iterator();
		
		while(itr.hasNext()) {
			// System.out.println(itr.next());
			
			String key = itr.next();
			System.out.printf("%s=%s\n", key, map.get(key));
		}
	}

	private static void m15() {
		
		// 폴더의 내용 보기 + 업무 추가
		// - 특정 폴더의 모든 파일 갯수 세기
		// - eclipse 폴더 > 파일 11,883, 폴더 2,630 크기 809,094,961 바이트
		// - *재귀 메서드*를 사용해야 편하게 코딩 가능
		
		String path = "D:\\suea7\\class\\eclipse";
		File dir = new File(path);
		
		if (dir.exists()) {
			
			countFile(dir);
			
			System.out.printf("총 파일 갯수: %,d\n", count);
		}
		
	}

	// 넘어온 폴더의 파일 개수 누적 > 재귀 메서드
	private static void countFile(File dir) {
		
		// 1. 목록 가져오기
		File[] list = dir.listFiles();
		
		// 2. 파일 개수
		for (File subfile : list) {
			if (subfile.isFile()) {
				count ++;
				// count += subfile.length(); 파일 총 길이
			}
		}
		
		// 3. 자식 폴더를 대상으로 1~2번 반복
		for (File subdir : list) {
			if (subdir.isDirectory()) {
				// 1~3번 반복 > 자식 폴더가 없을 때까지
				// count ++; 폴더 개수
				countFile(subdir);
			}
		}
	}

	private static void m14() {
		
		// 폴더의 내용 보기 + 업무 추가
		// - 특정 폴더의 모든 파일 갯수 세기
		// - eclipse 폴더 > 파일 11,882, 폴더 2,629 크기 809,094,961 바이트
		// - 재귀 메서드를 사용해야 편하게 코딩 가능
		
		String path = "D:\\suea7\\class\\eclipse";
		File dir = new File(path);
		
		int count = 0;
		
		if (dir.exists()) {
			
			File[] list = dir.listFiles();
			for (File subfile : list) {
				if (subfile.isFile()) {
					count ++;
				}
			}
			
			// 자식 폴더 접근
			for (File subdir : list) {
				
				if (subdir.isDirectory()) {
					File[] sublist = subdir.listFiles();
					
					for (File subsubfile : sublist) {
						if (subsubfile.isFile()) {
							count ++;
						}
					}
					
					// 자식의 자식 폴더..
					for (File subsubdir : sublist) {
						if (subsubdir.isDirectory()) {
							
							File[] subsublist = subsubdir.listFiles();
							
							for (File subsubsubfile : subsublist) {
								if (subsubsubfile.isFile()) {
									count++;
								}
							}
						}
						
					}
				}
				
			}
			
			System.out.printf("총 파일 갯수: %,d\n", count);
		}
		
	}

	private static void m13() {
		
		// 폴더의 내용 보기
		
		File dir = new File("D:\\suea7\\class\\eclipse");
		
//		if (dir.exists()) {
//			
//			// 자식 파일명 + 자식 폴더명 (전체 경로X)
//			String[] list = dir.list();
//			
//			for (String str : list) {
//				
//				// 이름 사용 > File 객체 생성 > isFile(), isDirectory()
//				System.out.println(str);
//				
//				File file = new File(dir.getAbsolutePath() + "\\" + str);
//				System.out.println(file.isFile());
//				System.out.println();
//			}
			
			// 자식 파일 + 자식 폴더
//			File[] files = dir.listFiles(); // 주로 사용 > 더욱 편리함
//			
//			for (File f : files) {
//				System.out.println(f);
//				System.out.println(f.isDirectory());
//				System.out.println(f.getName());
//				System.out.println();
//			}
//		}
		
		// 탐색기 느낌
		File[] list = dir.listFiles();
		
		for (File f : list) {
			
			if (f.isDirectory()) {
				System.out.printf("[%s]\n", f.getName());
			}
		}
		
		for (File f : list) {
			
			if (f.isFile()) {
				System.out.printf("%s\n", f.getName());
			}
		}
		
	}

	private static void m12() {
		
		// 폴더 삭제 > 빈 폴더만 삭제 가능
		
		File dir = new File("D:\\suea7\\class\\java\\file\\member");
		
		if (dir.exists()) {
			System.out.println(dir.delete());
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
		
	}

	private static void m11() {
		
		// 폴더 이동
		
		File dir = new File("D:\\suea7\\class\\java\\file\\TODO");
		File dir2 = new File("D:\\suea7\\class\\java\\move\\TODO");
		
		if (dir.exists()) {
			dir.renameTo(dir2);
		} else {
			System.out.println("대상 폴더가 존재하지 않습니다.");
		}
	}

	private static void m10() {

		// 폴더명 바꾸기
		
		File dir = new File("D:\\suea7\\class\\java\\file\\todo");
		File dir2 = new File("D:\\suea7\\class\\java\\file\\TODO");
		
		if (dir.exists()) {
			dir.renameTo(dir2);
		} else {
			System.out.println("대상 폴더가 존재하지 않습니다.");
		}
	}

	private static void m9() {
		
		// 요구사항: todo > 날짜별 폴더 > "2022-01-01" ~ "2022-12-31"
		
		Calendar c = Calendar.getInstance();
		c.set(2022, 0, 1);
		int maximum = c.getActualMaximum(Calendar.DAY_OF_YEAR); // 해의 총 day 수
		
		
		for (int i = 0 ; i < maximum ; i ++) {
			
			String path = String.format("%tF", c);
			File dir = new File("D:\\suea7\\class\\java\\file\\todo\\" + path);
			System.out.println(dir.mkdir());
			c.add(Calendar.DATE, 1);
		}
		
		System.out.println("종료");
			
	}

	private static void m8() {
		
		// 요구사항: 회원명으로 개인 폴더 생성
		
		String[] names = {"홍길동", "아무개", "하하하", "호호호", "후후후"};
		
		for (int i = 0 ; i < names.length ; i ++) {
			
			String path = String.format("D:\\suea7\\class\\java\\file\\member\\%s", names[i]);
			File dir = new File(path);
			
			if(!dir.exists()) {
				boolean res = dir.mkdir();
				System.out.println(res);
			} else {
				System.out.println("회원 이름 폴더가 이미 존재합니다.");
			}
		}
	}

	private static void m7() {
		
		// 폴더 생성
		
		File dir = new File("D:\\suea7\\class\\java\\file\\bbb\\ccc");
		
		if (!dir.exists()) {
			boolean result = dir.mkdirs();
			System.out.println(result);
		} else {
			System.out.println("이미 같은 이름의 폴더가 존재합니다.");
		}
		
	}

	private static void m6() {
		
		// 파일 삭제
		File file = new File("D:\\suea7\\class\\java\\file\\data.txt");
		
		if (file.exists()) {
			
			boolean result = file.delete();
			System.out.println(result);
		}
	}

	private static void m5() {
		
		// 파일 이동
		// - file\hello.txt -> move\hello.txt
		// - 파일명 바꾸기와 동일한 메서드를 사용
		// - renameTo() > 파일의 이름 뿐만이 아니라 전체 경로를 수정
		
		File file = new File("D:\\suea7\\class\\java\\file\\hello.txt");
		File file2 = new File("D:\\suea7\\class\\java\\move\\hi.txt");
		
		if (file.exists()) {
			file.renameTo(file2);
		} else {
			System.out.println("파일이 존재하지 않습니다.");
		}
	}

	private static void m4() {
		
		// 파일명 바꾸기
		// - file(hello.txt) -> file2(hi.txt)
		
		File file = new File("D:\\suea7\\class\\java\\file\\hello.txt");
		File file2 = new File("D:\\suea7\\class\\java\\file\\hi.txt");
		
		if (file.exists()) {
			System.out.println(file.renameTo(file2));
		} else {
			System.out.println(file.getName() + " 파일이 존재하지 않습니다.");
		}
		
	}

	private static void m3() {
		
		// 파일 조작 > 생성, 복사, 이동, 이름 수정, 삭제
		
		// 새 파일 만들기
		File file = new File("D:\\suea7\\class\\java\\file\\hello.txt");
		
		if (!file.exists()) {
			try {
				// 동일한 파일이 존재하면 새로 만들기 실패
				System.out.println(file.createNewFile());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("이미 동일한 파일이 존재합니다.");
		}
		
	}

	private static void m2() {
		
		// 폴더 > 정보
		final String PATH = "D:\\suea7\\class\\java\\file";
		
		// 디렉토리 참조 객체 > File *폴더도 파일*
		File dir = new File(PATH);
		
		if (dir.exists()) {
			System.out.println("폴더 있음");
			
			System.out.println(dir.getName());
			System.out.println(dir.isFile());
			System.out.println(dir.isDirectory());
			System.out.println(dir.length()); // 폴더의 크기: 0
			System.out.println(dir.getAbsolutePath());
			System.out.println(dir.getPath());
			System.out.println(dir.lastModified());
			System.out.println(dir.isHidden());
			System.out.println(dir.getParent());
			
		} else {
			System.out.println("폴더 있음");
		}
		
	}

	private static void m1() {
		
		// 파일 > 정보
		// D:\suea7\class\java\file\data.txt 파일 생성
		
		// [자바에서 외부의 파일을 접근]
		// 1. 외부 파일을 참조하는 참조 객체를 생성 > File
		// 2. 참조 객체 조작 > 외부 파일에 적용
		
		// 경로 > 보편적으로 final로 처리
		final String PATH = "D:\\suea7\\class\\java\\file\\data.txt";
		
		// 파일 참조 객체 > java.io.File
		File file = new File(PATH);
		
		// 파일 조작 시 파일 존재 여부 확인해야 함
		if (file.exists()) {
			
			System.out.println("파일 있음");
			
			// 정보 출력
			System.out.println(file.getName());
			System.out.println(file.isFile());
			System.out.println(file.isDirectory());
			
			System.out.println(file.length()); // 파일 크기 > byte
			System.out.println(file.getAbsolutePath());
			System.out.println(file.getPath());
			System.out.println(file.lastModified()); // tick값 (millisecond)
			System.out.println(file.isHidden());
			
			long tick = file.lastModified();
			System.out.printf("%tF %tT", tick, tick);
			
		} else { 
			System.out.println("파일 없음");
		}
		
	}

}
