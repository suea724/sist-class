package com.test.java.obj.question;

class Book {
	
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
