package com.test.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Scanner;
import mylibrary.db.DBUtil;
import oracle.jdbc.internal.OracleTypes;

public class Ex06_CallableStatement {
	
	// JDBC는 기본적으로 모든 SQL 실행 시(executeXXX() 호출) 자동 커밋이 수반된다.
	
	public static void main(String[] args) {
		
		// m1();
		// m2();
		// m3();
		// m4();
		// m5();
		m6();
	}

	private static void m6() {
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			
			// 부서명 입력 > 부서에 속한 직원의 보너스 지급 내역 입력
			Scanner sc = new Scanner(System.in);
			
			System.out.print("부서명 : ");
			String buseo = sc.nextLine();
			
			String sql = "{call procM6(?,?)}";
			
			cstmt = conn.prepareCall(sql);

			cstmt.setString(1, buseo);
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			rs = (ResultSet)cstmt.getObject(2);
			
			System.out.println("== 보너스 지급내역 ==");
			System.out.println("[직원명]\t[지급액]");
			
			while(rs.next()) {
				System.out.printf("%s\t%,10d\n"
									, rs.getString("name")
									, rs.getInt("bonus"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m5() {
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			
			// 커서 사용해서 다중행, 다중열 가져오는 프로시저
			String sql = "{call procM5(?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			cstmt.setString(1, "개발부");
			cstmt.registerOutParameter(2, OracleTypes.CURSOR);
			
			cstmt.executeQuery();
			
			// 오라클 커서는 자바 ResultSet로 참조 > *****
			rs = (ResultSet)cstmt.getObject(2);
			
			while(rs.next()) {
				
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("jikwi"));
				System.out.println(rs.getString("basicpay"));
				System.out.println();
			}
			
			rs.close();
			cstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m4() {
		
		// 문제. 직원 번호 입력하면 이름, 부서, 직위, 지역을 반환 + 출력
		// procM4
		//  - in > 직원 번호
		//  - out > 부서, 직위, 지역
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		
		try {
			conn = DBUtil.open();
			
			System.out.print("직원 번호 입력: ");
			String num = sc.nextLine();
			
			String sql = "{call procM4(?,?,?,?,?)}";
			
			cstmt = conn.prepareCall(sql);
			
			// in 파라미터 설정
			cstmt.setString(1, num);
			
			// out 파라미터 설정
			cstmt.registerOutParameter(2, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(3, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(4, OracleTypes.VARCHAR);
			cstmt.registerOutParameter(5, OracleTypes.VARCHAR);
			
			// 쿼리 실행
			cstmt.executeQuery();
			
			// 값 가져오기
			System.out.println("이름 : " + cstmt.getString(2));
			System.out.println("부서 : " + cstmt.getString(3));
			System.out.println("직위 : " + cstmt.getString(4));
			System.out.println("지역 : " + cstmt.getString(5));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m3() {
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			conn = DBUtil.open();
			
			// 인자값이 없고 반환값이 있는 프로시저
			String sql = "{call procM3(?)}";
			
			cstmt = conn.prepareCall(sql);
			
			// out 매개변수
			cstmt.registerOutParameter(1, OracleTypes.NUMBER);
			
			// PLSQL 문에서 인출을 수행할 수 없습니다.: next
			// rs = cstmt.executeQuery();
			// System.out.println(rs.next());
			
			cstmt.executeQuery(); // rs X
			
			int count = cstmt.getInt(1); // Out Parameter 가져오는 역할
			System.out.println(count);
			
			cstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m2() {
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			conn = DBUtil.open();
			
			// 인자값이 있고 반환값이 없는 프로시저
			// 상수도 사용 가능
			String sql = "{ call procM2(?,?,?,?,?) }";

			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "홍길순");
			cstmt.setString(2, "26");
			cstmt.setString(3, "f");
			cstmt.setString(4, "010-3333-4444");
			cstmt.setString(5, "경기도");
			
			int result = cstmt.executeUpdate();
			System.out.println(result);
			
			cstmt.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void m1() {
		
		// Statement 			> 정적 쿼리
		// PreparedStatement 	> 동적 쿼리
		// CallableStatement	> 프로시저 호출
		
		Connection conn = null;
		CallableStatement cstmt = null;
		
		try {
			conn = DBUtil.open();
			
			// 인자값, 반환값 없는 프로시저 호출
			String sql = "{ call procM1 }";
			
			cstmt = conn.prepareCall(sql); // 매개변수 처리 능력 보유 > ? 사용 지원

			int result = cstmt.executeUpdate();
			System.out.println(result);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void temp() {
		
		Connection conn = null;
		CallableStatement cstmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBUtil.open();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
