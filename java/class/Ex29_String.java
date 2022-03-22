package com.test.java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Ex29_String {

	public static void main(String[] args) throws Exception {

		/**
		 * 문자열, String
		 * - JDK 제공하는 문자열 조작 기능을 사용할 수 있음
		 * - 문자열(String)과 문자(char)의 관계? => 문자열은 문자의 집합
		 * - String = char[] (문자 배열)
		 * - 문자열과 배열을 조작하는 기능이 유사
		 * 
		 * - 문자열 함수는 모두 기억합시다
		 * - length() > 문자열 길이
		 * - charAt(index) > 문자 추출
		 * - trim() > 공백 제거
		 * - toUpperCase, toLowerCaase() > 대소문자 변환
		 * - startsWith(word), endsWith(word) > 패턴 검색
		 * - substring(begin, end) > 문자열 추출
		 * - contains(word) > 문자열 검색
		 * - replace(old, new) > 문자열 치환
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
		m15();
	}
	

	private static void m15() {
		
		/* 문자열을 문자 배열로 */
		
		String txt = "홍길동입니다.";
		
		char[] clist = txt.toCharArray();
		System.out.println(Arrays.toString(clist));
		
		char[] clist2 = new char[txt.length()];
		
		for (int i = 0 ; i < clist2.length ; i ++) {
			clist2[i] = txt.charAt(i);
		}
		System.out.println(Arrays.toString(clist2));
	}

	private static void m14() {
		
		/* 문자열 분리 */
		// - String[] split(String delimiter)
		// - 문자열을 구분자를 기준으로 쪼개는 메서드
		// - 배열로 반환됨
		
		String name = "홍길동, 아무개, 하하하, 강호동, 유재석";
		
		String[] names = name.split(", ");
		
		for (int i = 0 ; i < names.length ; i ++) {
			System.out.println(names[i]);
		}
	}

	private static void m13() {
		
		/* 문자열 치환 */
		// String replace(String old, String new)
		// 문자열의 일부를 다른 문자열로 교체하는 메서드
		
		String txt = "안녕하세요. 홍길동입니다. 홍길동입니다. 홍길동입니다.";
		System.out.println(txt.replace("홍길동", "아무개"));
		
		String content = "게시판에 글을 작성합니다. 바보야~!";
		String word = "바보";
		System.out.println(content.replace(word, "**")); // Masking
		
		txt = "     하나       둘       셋       넷        ";
		System.out.printf("[%s]\n", txt);
		System.out.printf("[%s]\n", txt.trim());
		
		// 빈문자열 사용하면 원하는 요소를 지울 수 있음
		System.out.printf("[%s]\n", txt.replace(" ", "")); // 공백을 제거 
		System.out.printf("[%s]\n", txt.replace("하나", "")); 
		
	}

	private static void m12() {
		
		/* 문자열 검색 */
		
		String txt = "안녕하세요 홍길동입니다.";
		
		System.out.println(txt.contains("홍길동"));
		System.out.println(txt.contains("아무개"));
		
		System.out.println(txt.indexOf("홍길동") > -1);
		System.out.println(txt.indexOf("홍길동") > -1);
	}

	private static void m11() {
		
		/* 문자열 추출 */
		// String substring(int beginIndex)
		// String substring(int beginIndex, int endIndex)
		// 검사 시 begin 인덱스는 포함, end 인덱스는 미포함
		
		String txt = "가나다라마바사아자차카타파하";
		System.out.println(txt.substring(3, 7));
		
		System.out.println(txt.charAt(5)); // char
		System.out.println(txt.substring(5, 6)); // String
		
		// 정형화된 데이터 (주민번호)
		String regNum = "970724-2000000";
		
		// 성별
		System.out.println(regNum.charAt(7) == 1 ? "남자" : "여자");
		System.out.println(regNum.substring(7, 8).equals("1") ? "남자" : "여자");
		
		// 몇년생?
		System.out.println("" + regNum.charAt(0) + regNum.charAt(1)); // 빈문자열 더해줘야 함 
		System.out.println(regNum.substring(0, 2));
		
		// 몇월생?
		System.out.println(regNum.substring(2,4));
		
		// 며칠생?
		System.out.println(regNum.substring(4,6));
		
		// 파일 경로
		String path = "C:\\class\\JavaTest\\Hello.java";
		
		// 1. 파일명 추출
		int index = path.lastIndexOf("\\");
		
		String filename = path.substring(index + 1, path.length());
		filename = path.substring(index + 1); // endIndex 지정안해주면 끝까지
		
		// 2. Hello.java
		// 확장자 없는 파일명 추출 > Hello
		index = filename.lastIndexOf(".");
		String filenamewithoutExtension = filename.substring(0, index);
		System.out.println(filenamewithoutExtension);
		
		// 3. 확장자만 추출
		String extension = filename.substring(index + 1);
		System.out.println(extension);
		
		
	}

	private static void m10() {
		
		/* 패턴 검색 */
		// - boolean startsWith(String word)
		// - boolean endsWith(String word)
		
		String txt = "자바 프로그래밍";
		System.out.println(txt.startsWith("자바")); // true
		System.out.println(txt.indexOf("자바") == 0); // 동일한 기능, true
		
		System.out.println();
		
		System.out.println(txt.endsWith("프로그래밍")); // true
		System.out.println(txt.endsWith("밍")); // true
		System.out.println(txt.charAt(txt.length()-1) == '밍');
		System.out.println(txt.indexOf("밍") == txt.length()-1);
		
		/* 확장자 검사 */
		// 파일 경로 (파일명)
		// 파일 경로의 파일이 자바 소스파일인지
		String path = "C:\\class\\java\\JavaTest\\Ex28_String.java";
		
		if (path.endsWith(".java")) {
			System.out.println("O");
		} else {
			System.out.println("X");
		}
		
		// 해당 파일이 이미지인지 검사
		String img = "dog.jpg";
		// img = img.toLowerCase(); 원본을 영구적으로 바꿀 필요가 없음. 조건만 확인하면 됨
		
		if (img.toLowerCase().endsWith(".jpg") 
				|| img.toLowerCase().endsWith(".jpeg") 
				|| img.toLowerCase().endsWith(".jpg")
				|| img.toLowerCase().endsWith(".png")) {
			
			System.out.println("이미지 파일");
		} else {
			System.out.println("다른 종류 파일");
		}
		
				
	}

	private static void m9() {

		/* 문자열 대소문자 변경 */
		// String toUpperCase() > 대문자로
		// String toLowerCase() > 소문자로
		// 검색할 때는 대소문자를 구분할지 안할지 먼저 정해야 함

		String content = "Java 수업 중입니다.";
		String word = "java";

		// 대소문자 구분하여 검색 (case sensitive)
		// 정확도 높고, 검색률 낮음
		if (content.indexOf(word) > -1) {
			System.out.println("검색 결과 있음");
		} else {
			System.out.println("검색 결과 없음");
		}

		// 대소문자를 구분하지 않고 검색 (case insensitive)
		// 정확도 낮고, 검색률 높음
		// 메서드 체인: 문자열.메서드().메서드().메서드()...
		// 이렇게 메서드 위주로 프로그래밍 하게 되면 함수지향 프로그래밍 e.g. 코틀린
		if (content.toUpperCase().indexOf(word.toUpperCase()) > -1) {
			System.out.println("검색 결과 있음");
		} else {
			System.out.println("검색 결과 없음");
		}
	}

	private static void m8() {

		// 게시판 글쓰기 > 금지어!

		String word = "바보"; // 금지어
		String content = "안녕하세요. 메롱~ 저는 자바를 배우는 학생입니다."; // 글 내용

		// if (content.indexOf(word) > -1) { // 금지어를 발견한 경우
		// System.out.println("금지어 발견");
		// } else {
		// System.out.println("글쓰기 진행");
		// }

		String[] words = {"바보", "멍청이", "메롱"};

		for (int i = 0; i < words.length; i++) {
			if (content.indexOf(words[i]) > -1) { // 금지어를 발견한 경우
				System.out.println("금지어 발견");
				break;
			}
		}
		System.out.println("완료");

		// 주민등록번호에 '-'이 있으면?
		String regNum = "970724-2222222";

		// if (regNum.charAt(6) == '-')
		if (regNum.indexOf('-') == 6) {
			System.out.println("O");

		} else {
			System.out.println("X");
		}
	}

	private static void m7() {

		/* 문자열 검색 (**자주 사용함!**) */
		// 문자열 내에서 원하는 문자(열)을 검색 > 발견한 위치(index) 반환
		// int indexOf(char c)
		// int indexOf(String s)
		// => 오버로딩 되어있음
		// 처음 만난 검색어의 위치를 반환한 뒤 종료되버림 (뒤에 반복되는 검색어의 위치는 찾을 수 없음)
		// int indexOf(char c, int beginIndex)
		// int indexOf(String s, int beginIndex)
		// => 검색을 시작할 인덱스를 지정할 수 있음
		// lastIndexOf (오른쪽 -> 왼쪽으로 검색)

		String txt = "안녕하세요. 홍길동입니다.";

		int index = -1;

		index = txt.indexOf('하');
		System.out.println(index); // 2

		index = txt.indexOf('홍');
		System.out.println(index); // 7

		index = txt.indexOf('강');
		System.out.println(index); // -1

		index = txt.indexOf("홍길동");
		System.out.println(index); // 7 (첫번째 문자 위치 반환)

		txt = "안녕하세요. 홍길동입니다. 반갑습니다. 홍길동입니다.";
		index = txt.indexOf("홍길동", 10);
		System.out.println(index); // 22 (10 이후 검색어 위치 반환)

		// index = txt.indexOf("홍길동", index + "홍길동".length());
		// 반복 사용하면 검색어의 모든 위치를 찾을 수 있음 (반복문 사용)

		txt = "홍길동 자바 공부 홍길동";
		
		System.out.println(txt.indexOf("홍길동"));
		System.out.println(txt.indexOf("홍길동", 0+3));
		
		System.out.println(txt.lastIndexOf("홍길동"));
		System.out.println(txt.lastIndexOf("홍길동", 9));
	}

	private static void m6() {

		/* 문자열의 시작과 끝에 존재하는 공백 제거 */
		// String trim()
		// 문자열에 존재하는 공백: whitespace > 스페이스, 탭, 개행
		// 사용자가 실수로 입력하거나 불필요하게 들어간 공백을 제거하는 역할

		String str = "    하나   둘    셋    넷    다섯     ";
		System.out.printf("[%s]", str.trim());

	}

	private static void m5() {

		// 주민번호 입력 > 중간에 '-' 반드시 입력
		String regNum = "970724-1222222";

		if (isValidRegNum(regNum)) {
			System.out.println("올바른 주민번호");

			if (regNum.charAt(7) == '1') {
				System.out.println("남자입니다.");
			} else if (regNum.charAt(7) == '2') {
				System.out.println("여자입니다.");
			}

		} else {
			System.out.println("하이픈을 포함해야 합니다.");
		}

	}

	// 조건이 하나일 때는 올바른 것 또는 올바르지 않은 것을 찾는 것은 상관 없음
	private static boolean isValidRegNum(String regNum) {
		if (regNum.charAt(6) != '-') {
			return false;
		} else {
			return true;
		}
	}

	private static void m4() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 회원 가입
		// - 이름 입력 (길이 2 ~ 5자) + 한글만 가능

		System.out.print("이름: ");
		String name = reader.readLine();

		if (isValid(name)) {
			System.out.println(name + "님 환영합니당^^");
		} else {
			System.out.println("다시 입력해주세요.");
		}

	}

	// 조건이 여러 개일 경우 올바르지 않는 것을 찾는 것이 더 가독성이 좋고 tab의 깊이가 얕아짐
	private static boolean isValid(String name) {

		if (name.length() < 2 || name.length() > 5) {
			return false;
		}

		for (int i = 0; i < name.length(); i++) {
			char c = name.charAt(i);

			if (c < '가' || c > '힣') {
				return false;
			}
		}
		return true;
	}

	// 조건을 반대로 할 경우 가독성 안좋음
	// 탭의 깊이가 깊어질 수록 코드를 관리하기 힘듦
	private static boolean isValid2(String name) {

		if (name.length() > 2 && name.length() < 5) {

			for (int i = 0; i < name.length(); i++) {
				char c = name.charAt(i);

				if (c >= '가' && c <= '힣') {
					// 비어버림
				} else {
					return false;
				}
			}
			return true; // 입력 문자 모두가 한글인게 확인된 위치
		} else {
			return false;
		}

	}

	private static void m3() throws Exception {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		// 아이디 입력 > 올바른 아이디 검사
		// 영어 소문자

		System.out.print("아이디: ");
		String id = reader.readLine();

		for (int i = 0; i < id.length(); i++) {

			char c = id.charAt(i);

			if (c < 'a' || c > 'z') { // 잘못된 조건을 거는 것이 좋음
				System.out.println("잘못된 문자가 발견되었습니다.");
				break;
			}
		}

		System.out.println("종료");

		// String a = 'A';
		// char b = 'a';

		// System.out.println((int)a); // 값형 <-> 참조형 형변환 불가능
		// System.out.println((int)b); // 값형 형변환 > 가능

	}

	private static void m2() {

		/* 문자열 추출 */
		// charAt(int index)
		// 원하는 위치의 문자를 추출

		String txt = "안녕하세요. 홍길동입니다.";

		char c = txt.charAt(3);
		System.out.println(c);

		c = txt.charAt(txt.length() - 1);
		System.out.println(c);

	}

	private static void m1() throws Exception {

		/* 문자열의 길이는 length() 함수 사용 */

		int[] nums = {10, 20, 30};
		System.out.println(nums.length);

		String str = "홍길동입니다.";
		// char[] clist = {'홍','길','동','입','니','다','.'};
		System.out.println(str.length());

		// 요구사항: 사용자 입력 문자 수
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("문장 입력: ");
		String statement = reader.readLine();

		System.out.printf("입력한 문장은 %d개의 문자로 구성되었습니다.\n", statement.length());

		if (statement.length() >= 2 && statement.length() <= 5) {
			System.out.printf("이름은 %s\n", statement);
		} else {
			System.out.println("이름을 2 ~5자로 입력해주세요");
		}

	}

}
