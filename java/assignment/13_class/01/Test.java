package com.test.java.obj.question;

public class Test {

	public static void main(String[] args) {
		
		/* Book */
		
		Book b1 = new Book();
		
		b1.setTitle("자바의 정석");
		b1.setPrice(45000);
		b1.setAuthor("남궁성");
		b1.setPublisher("도우출판");
		b1.setIsbn("8994492038");
		b1.setPage(1022);
		
		System.out.println(b1.info());
		
		/* Note */
		
		Note n1 = new Note();
		
		n1.setSize("B4");
		n1.setColor("노란색");
		n1.setPage(25);
		n1.setOwner("홍길동");
		
		System.out.println(n1.info());
		
		Note n2 = new Note();
		
		n2.setSize("A5");
		n2.setColor("흰색");
		n2.setPage(10);
		n2.setOwner("수아");
		
		System.out.println(n2.info());
		
		/* Bugles */
		
		Bugles snack = new Bugles();

		snack.setWeight(500);
		snack.setCreationTime("2022-3-20");
		System.out.println("가격 : " + snack.getPrice() + "원");
		System.out.println("유통 기한이 " + snack.getExpiration() + "일 남았습니다.");

		snack.eat();
		
		Bugles snack2 = new Bugles();

		snack2.setWeight(300);
		snack2.setCreationTime("2022-3-12");
		System.out.println("가격 : " + snack2.getPrice() + "원");
		System.out.println("유통 기한이 " + snack2.getExpiration() + "일 남았습니다.");

		snack2.eat();
		
		/* Employee */
		
		Employee e1 = new Employee();

		e1.setName("홍길동");
		e1.setDepartment("홍보부");
		e1.setPosition("부장");
		e1.setTel("010-1234-5678");
		e1.setBoss(null); //직속 상사 없음

		e1.info();

		Employee e2 = new Employee();

		e2.setName("아무개");
		e2.setDepartment("홍보부");
		e2.setPosition("사원");
		e2.setTel("010-2541-8569");
		e2.setBoss(e1); //직속 상사 e1(홍길동)

		e2.info();
	}

}
