package com.test.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import mylibrary.db.DBUtil;

public class Ex05_PreparedStatement {

	public static void main(String[] args) {

		// m1();
		m2();
	}

	private static void m2() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBUtil.open();
			
			// 정적 쿼리
			String sql = "select name from tblInsa where num = 1001";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			stmt.close();
			
			// 동적 쿼리
			sql = "select name from tblInsa where num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "1001");
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("name"));
			}
			
			rs.close();
			pstmt.close();
			
			// 인자가 없는 쿼리 > pstmt 사용하면?
			// 상관 없지만 혼동을 줄 수 있음!
			
			sql = "select count(*) as cnt from tblInsa";
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				System.out.println(rs.getString("cnt"));
			}
			
			rs.close();
			pstmt.close();
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void m1() {
		
		/**
		 * [Statement vs PreparedStatement] 
		 * 	- SQL 실행
		 * 	- 매개변수 처리 지원 유무
		 * 	- Statement > 정적 SQL
		 *  - PreparedStatement > 동적 쿼리
		 */
		
		// insert > 사용자 입력
		String name = "하하하";
		String age = "20";
		String gender = "m";
		String tel = "010-1111-2222";
		String address = "서울시 동대문구 이문동";
		 
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		
		try {
			
			conn = DBUtil.open();
			
			// Statement
			stmt = conn.createStatement();
			
			String sql = String.format("insert into tblAddress values (seqAddress.nextVal, '%s', %s, 'm', '%s', '%s', default)"
											, name, age, gender, tel, address);
			
			int result = stmt.executeUpdate(sql); // 실행시 SQL 대입
			System.out.println(result);
			
			// PreparedStatement
			// - ? : 오라클 매개변수
			// - SQL 작성 용이
			// - 매개변수값에 부적절한 값(e.g. 작은따옴표('))이 있어도 자동으로 이스케이프 적용
			sql = "insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
					
			pstmt = conn.prepareStatement(sql); // PreparedStatement 생성시 미리 SQL 대입
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, gender);
			pstmt.setString(4, tel);
			pstmt.setString(5, address);
			
			result = pstmt.executeUpdate();
			System.out.println(result);
			
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
