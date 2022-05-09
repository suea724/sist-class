package com.test.java;

import java.sql.Connection;
import mylibrary.db.DBUtil;

public class Ex02 {
	
	public static void main(String[] args) {
		
		try {
			
			Connection conn = DBUtil.open(); // hr 계정 접속
			
			System.out.println(conn.isClosed() ? "연결안됨" : "연결됨");
			
			DBUtil.close();
			
			// 오류
			// 1. 서버 주소 오류
			// 	- IO 오류: The Network Adapter could not establish the connection
			// 2. 계정 아이디/비밀번호 오류
			// 	- ORA-01017: invalid username/password; logon denied
			// 3. 서버 오류
			// 	- Listner refused the connection with the following error:
			// 4. 연결 문자열 오류
			// 	- 부적합한 Oracle URL이 지정되었습니다.
			// 5. 포트번호 오류
			// 	- IO 오류: The Network Adapter could not establish the connection
			// 6. SID 오류
			// 	- Listner refused the connection with the following error:
			//  - ORA-12505, TNS:listner does not currently know of SID given in connector descriptor
			// 7. 드라이브 오류
			// 	- oracle.jdbc.driver.OracleDriver
			// 8. ojdbc.jar 오류
			// 	- oracle.jdbc.driver.OracleDriver
			
			conn = DBUtil.open("localhost", "system", "java1234"); // system 계정 접속
			
			System.out.println(conn.isClosed() ? "연결안됨" : "연결됨");
			
			DBUtil.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
