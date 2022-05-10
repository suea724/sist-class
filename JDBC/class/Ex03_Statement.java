package com.test.java;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;
import mylibrary.db.DBUtil;

public class Ex03_Statement {

	public static void main(String[] args) {

		/**
		 * [Connection]
		 * - 연결/종료
		 * 
		 * [Statement]
		 * - SQL문 실행하는 역할
		 * - 모든 SQL 실행 가능
		 * 
		 * [Statement 종류]
		 * 
		 * 1. Statement
		 * - 기본
		 * 
		 * 2. PreparedStatement
		 * - Statement 개량 > 매개변수 처리 특화
		 * - 안정성 높음, 가독성 높음
		 * - 코드량 증가
		 * 
		 * 3. CallableStatement
		 * - Statement 개량 > 프로시저 호출 전용
		 * - PreparedStatement와 유사
		 */

		// m1();
		// m2();
		// m3();
		m4();

	}

	private static void m4() {
		
		// UI + SQL > 사용자 입력을 받아 insert 실행
		
		Connection conn = null;
		Statement stmt = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			// 자바 자료형과 오라클 자료형은 관계 X
			// 서로 다른 언어 간 자료형 호환 X
			
			System.out.print("이름 : ");
			String name = sc.nextLine();
			
			System.out.print("나이 : ");
			String age = sc.nextLine();

			System.out.print("성별(m 또는 f) : ");
			String gender = sc.nextLine();
			
			System.out.print("전화번호 : ");
			String tel = sc.nextLine();
			
			System.out.print("주소 : ");
			String address = sc.nextLine();
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			String sql = String.format("insert into tblAddress values (seqAddress.nextVal, '%s', %s, '%s', '%s', '%s', default)"
										, name, age, gender, tel, address);
			
			stmt.executeUpdate(sql);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		// delete 실행
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			
			conn = DBUtil.open();
			stmt = conn.createStatement();
			
			// String sql = "delete from tblAddress where seq = 1";
			// String sql = "create sequence seqJava"; // 성공 시 0 반환
			// String sql = "drop sequence seqJava"; // 성공 시 0 반환
			// String sql = "drop table tblAddress";
			String sql = "create table tblAddress ("
					+ "    seq number primary key,"
					+ "    name varchar2(10) not null,"
					+ "    age number(3) not null check (age between 0 and 150),"
					+ "    gender char(1) not null check(gender in('m','f')),"
					+ "    tel varchar2(15) not null,"
					+ "    address varchar2(300) not null,"
					+ "    regdate date default sysdate not null"
					+ ")";
			
			int result = stmt.executeUpdate(sql);
			System.out.println(result);
			
			stmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {

		// update 실행

		Connection conn = null;
		Statement stmt = null;

		try {

			conn = DBUtil.open();
			stmt = conn.createStatement();

			// 문자열 끝에 세미콜론 > 오류!
			String sql = "update tblAddress set age = age + 1 where seq = 1";

			int result = stmt.executeUpdate(sql);
			System.out.println(result);

			stmt.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {

		// insert 실행

		// 1. DB 접속
		// 2. SQL문 실행
		// 3. DB 종료

		Connection conn = null;
		Statement stmt = null;

		try {
			// 1.
			conn = DBUtil.open();

			if (!conn.isClosed()) {
				System.out.println("연결 성공!");

				// 2. 문자열로 SQL 작성
				String sql =
						"insert into tblAddress values (seqAddress.nextVal, '아무개', 25, 'm', '010-5555-5555', '서울시 강남구 대치동', default)";

				stmt = conn.createStatement();

				// 반환값이 없는 쿼리 > 나머지
				// int stmt.executeUpdate(sql);

				// 반환값이 있는 쿼리 > SELECT
				// ResultSet stmt.executeQuery(sql);

				int result = stmt.executeUpdate(sql);

				if (result == 1) {
					System.out.println("등록 성공");
				} else {
					System.out.println("등록 실패");
				}

				stmt.close();
			}

			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
