package com.test.java.obj.question.q1;

class Book {
	
	/*
		- Book 객체의 정보
			- 제목, 가격, 저자, 출판사, 발행년도, ISBN, 페이지수
		- 모든 멤버 변수의 접근 지정자는 private으로 한다.
		- 멤버 접근을 위한 Setter와 Getter를 정의한다.
			- 제목 : 읽기/쓰기, 최대 50자 이내(한글, 영어, 숫자)
		 	- 가격 : 읽기/쓰기, 0 ~ 1000000원
			- 저자 : 읽기/쓰기, 제한 없음
			- 페이지수 : 읽기/쓰기, 1~무제한
			- 출판사 : 쓰기 전용
			- 발행년도 : 읽기 전용(2019년)
			- ISBN : 읽기/쓰기
		- Book 객체의 모든 정보를 문자열로 반환하는 메소드를 구현한다.
			- String info()
		- 클래스가 잘 설계되었는지 객체를 가지고 사용해본다.
			- Book 객체 생성
			- 멤버 값 넣기 + 값 출력
			- 유효성 검사 테스트
	 */
	
	private String title;
	private int price;
	private String author;
	private String publisher;
	private String pubYear = "2019";
	private String isbn;
	private int page;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		
		if (validTitle(title)) {
			this.title = title;
		} else {
			System.out.println("제목이 유효하지 않습니다.");
		}
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		
		if (price >= 0 && price <= 1000000) {
			this.price = price;
		} else {
			System.out.println("가격이 유효하지 않습니다.");
		}
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public String getPubYear() {
		return pubYear;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public int getPage() {
		return page;
	}
	
	public void setPage(int page) {
		
		if (page >= 1) {
			this.page = page;
		} else {
			System.out.println("페이지 수가 유효하지 않습니다.");
		}
	}
	
	// 제목 유효성 체크
	private boolean validTitle(String title) {
		
		if (title.length() > 50) {
			return false;
		} 
		
		for (int i = 0 ; i < title.length() ; i ++) {
			char c = title.charAt(i);
			
			// 아닌 조건을 &&로 묶어도 같은 결과가 나옴
			// (c < '가' || c > '힣') && (c < 'A' || c > 'Z')
			// 둘다 만족하면 true
			if (!(c >= '가' && c <= '힣' 
					|| c >= 'A' && c <= 'Z' 
					|| c >= 'a' && c <= 'z' 
					|| c >= '0' && c <= '9' 
					|| c == ' ')) {
				return false;
			}
		}
		return true;
	}
	
	public String info() {
		return String.format("제목: %s\n가격: %,d원\n저자: %s\n출판사: %s\n발행년도: %s년\nISBN: %s\n페이지: %,d장\n"
				,title, price, author, publisher, pubYear, isbn, page);
	}
	
}
