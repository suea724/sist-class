package com.test.java;

public class Ex07_Output {

	public static void main(String[] args) {
		
		// System.out.print("\r\n");
		System.out.println();
		
		String name1 = "홍길동";
		int kor1 = 100;
		int eng1 = 100;
		int math1 = 80;

		String name2 = "아무개";
		int kor2 = 95;
		int eng2 = 89;
		int math2 = 77;
		
		System.out.println("=============================");
		System.out.println("             성적표           ");
		System.out.println("=============================");
		System.out.println("[이름]\t[국어]\t[영어]\t[수학]");
		System.out.println("-----------------------------");
		
		System.out.print(name1 + "\t");
		System.out.print(kor1 + "\t");
		System.out.print(eng1 + "\t");
		System.out.print(math1 + "\n");
		
		System.out.print(name2 + "\t");
		System.out.print(kor2 + "\t");
		System.out.print(eng2 + "\t");
		System.out.println(math2);
		
		String seq = "1";
		String name = "홍길동";
		String age = "20";
		String address = "서울시 강남구 역삼동";
		String tel = "010-1234-5678";
		
		System.out.printf("insert into tblMember(seq, name, age, address, tel)"
				+ " values (%s, '%s', %s, '%s', '%s');",
				seq,
				name,
				age, 
				address, 
				tel);
		
		int num = 123;
		
		System.out.printf("[%d]\n", num);
		System.out.printf("[%10d]\n", num);	// 10칸을 확보하고 그 안에 출력해라
		System.out.printf("[%-10d]\n", num);	// 좌측 정렬
		
		System.out.printf("[%5d]\n", 12345678);
		
		double num2 = 3.14;
		
		System.out.println(num2);
		System.out.printf("%f\n", num2);
		System.out.println();
		
		System.out.println(10/3);
		System.out.printf("%f\n",10.0/3);
		System.out.printf("%.2f\n",10.0/3);
		
		int price = 1234567;
		System.out.printf("금액: %,d원\n",price);
		
		// 숫자 출력 시 단위 출력 필수!
		System.out.println("========================");
		System.out.println("          음료          ");
		System.out.println("========================");
		System.out.printf("콜라: \t\t%,5d원\n", 2500);		
		System.out.printf("스무디: \t\t%,5d원\n", 3500);		
		System.out.printf("박카스: \t\t%,5d원\n", 500);		
		System.out.printf("아메리카노: \t%,5d원\n", 12000);		
		
	}
}
