package com.test.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import mylibrary.db.DBUtil;

public class Ex04_Select {

	public static void main(String[] args) {
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		// m6();
		// m7();
		// m8();
		m9();
	}

	private static void m9() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			// tblAddress 출력
			String sql = "select * from tblAddress order by seq asc";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			// 자원 해제 코드, Clean-Up Code
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m8() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			// 요구사항 : 영업부 직원수와 영업부 직원 명단을 출력하시오.
			// 1. count(*) 구하는 쿼리 작성하기
			// 2. 탐색 코드의 루프 횟수 세기
			
			String sql = "select count(*) as cnt from tblInsa where buseo = '영업부'";
			rs = stmt.executeQuery(sql);
			
			// rs 레코드 하나일 때
			if (rs.next()) {
				System.out.println("직원수: " + rs.getString("cnt"));
			}
			// 자원 해제
			rs.close();
			
			sql = "select * from tblInsa where buseo = '영업부'";
			rs = stmt.executeQuery(sql);
			
			int n = 0;
			
			while(rs.next()) {
				n ++;
				System.out.println(rs.getString("name"));
			}
			
			System.out.println("직원수 : " + n);
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void m7() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			// 회원명 + 대여한 비디오명
			// 컬럼 alias 붙여주기
			String sql = "select m.name as mname, v.name as vname from tblVideo v inner join tblRent r on v.seq = r.video inner join tblMember m on m.seq = r.member";
			
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
				System.out.println();
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m6() {
		
		// select > 오류 발생
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String sql = "select name, buseo, jikwi from tblInsa";
			// rs = stmt.executeQuery(sql); > NPE 발생
			
			// rs 컬럼명 접근 오타 > Oracle 오류 X
			while(rs.next()) {
				rs.getString("name");
				rs.getString("buseo");
				rs.getString("jikwi");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m5() {
		
		// tblInsa + tblBonus
		// 요구사항 : 특정 직원에게 보너스를 지급하시오.
		// 1. 모든 직원 명단을 출력 (직원번호, 이름, 부서, 직위)
		// 2. 사용자가 직원을 선택 (직원번호 입력)
		// 3. 사용자가 보너스 금액 입력
		// 4. 보너스 지급 > insert
		// 5. 지급 내역 명단 출력 (이름, 부서, 직위, 보너스 금액)

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String sql = "select num, name, buseo, jikwi from tblInsa";
			rs = stmt.executeQuery(sql);
			
			System.out.println("[번호]\t[이름]\t[부서]\t[직위]");
			while(rs.next()) {
				System.out.printf("%s\t%s\t%s\t%s\n"
									, rs.getString("num")
									, rs.getString("name")
									, rs.getString("buseo")
									, rs.getString("jikwi"));
			}
			
			System.out.println();
			System.out.print("직원 번호 선택: ");
			Scanner sc = new Scanner(System.in);
			String num = sc.nextLine();
			
			System.out.print("보너스 금액 입력(원): ");
			String bonus = sc.nextLine();
			
			sql = String.format("insert into tblBonus values (seqBonus.nextVal, %s, %s)", num, bonus);
			
			int res = stmt.executeUpdate(sql);
			
			if (res == 1) {
				System.out.println("보너스 지급 완료");
			} else {
				System.out.println("보너스 지급 실패");
			}
			
			System.out.println();
			
			sql = "select i.name, i.buseo, i.jikwi, b.bonus from tblBonus b inner join tblInsa i on b.num = i.num";
			rs = stmt.executeQuery(sql);
			
			System.out.println("[이름]\t[부서]\t[직위]\t[보너스금액]");
			while(rs.next()) {
				System.out.printf("%s\t%s\t%s\t%,d\n"
									, rs.getString("name")
									, rs.getString("buseo")
									, rs.getString("jikwi")
									, rs.getInt("bonus"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m4() {
		
		// 다중값 반환
		// 	- N행 N열
		// 	- 레코드 N줄 + 컬럼 N개
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String buseo = "총무부";
			
			String sql = "select name, jikwi, city, basicpay from tblInsa where buseo = '" + buseo + "'";
			rs = stmt.executeQuery(sql);
			
			System.out.println("[이름]\t[직위]\t[지역]\t[급여]");
			
			while (rs.next()) {
				
				// 직원 한명씩
				System.out.printf("%s\t%s\t%s\t%,10d원\n"
									, rs.getString("name")
									, rs.getString("jikwi")
									, rs.getString("city")
									, rs.getInt("basicpay"));
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		// 다중값 반환
		//  - N행 1열
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String sql = "select name from tblInsa order by name";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			// 결과 집합을 모두 소모
			// 더이상 rs.next() 호출 불가
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		// 다중값 반환
		// 	- 1행 N열
		// 	- 레코드 1줄, 여러 컬럼
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String sql = "select name, age, tel, address from tblAddress where seq = 22";
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println("이름 : " + rs.getString("name"));
				System.out.println("나이 : " + rs.getString("age"));
				System.out.println("전화번호 : " + rs.getString("tel"));
				System.out.println("주소 : " + rs.getString("address"));
			} else {
				System.out.println("데이터가 없습니다.");
			}
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {
		
		// 단일값 반환
		//	- 1행 1열
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			// alias 붙여주기!!
			String sql = "select count(*) as cnt from tblInsa";
			
			// Result == 커서(Cursor) > 판독기 > 스트림, Iterator, 향상된 for
			rs = stmt.executeQuery(sql);
			
			// rs.next() > 커서 1줄 전진
			rs.next();
			
			// rs.getXXX() > 현재 커서가 가리키고 있는 레코드의 특정 컬럼값을 가져와라
			int cnt1 = rs.getInt(1); // 매개변수 > 컬럼 순서(Index)
			int cnt2 = rs.getInt("cnt"); // 매개변수 > 컬럼명 > 훨씬 많이 사용 *******
			String cnt3 = rs.getString("cnt");
			
			System.out.println(cnt1);
			System.out.println(cnt2);
			System.out.println(cnt3);
			
			rs.close();
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
