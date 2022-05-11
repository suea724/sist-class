package com.test.java.mvc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import mylibrary.db.DBUtil;

// DB 업무 담당
public class DAO {
	
	private Connection conn = null;
	private Statement stmt = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// Service 클래스에서 객체 생성 시 커넥션 오픈
	public DAO() {
		conn = DBUtil.open();
	}
	
	public int add(Address dto) {
		
		try {
			
			String sql = "insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?, ?, default)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			
			int result = pstmt.executeUpdate();
			
			return result; // 성공 1, 실패 0
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Address> list() {
		
		try {
			
			String sql = "select * from tblAddress order by seq";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			// ResultSet > ArrayList
			ArrayList<Address> list = new ArrayList<>();
			
			while(rs.next()) {
				
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				list.add(dto);
			}
			
			return list; // select의 결과를 Service에 반환
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public Address get(String seq) {
		
		try {
			
			String sql = "select * from tblAddress where seq = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				Address dto = new Address();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				dto.setAddress(rs.getString("address"));
				dto.setRegdate(rs.getString("regdate"));
				
				return dto;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int edit(Address dto) {
		
		try {
			
			// 모든 컬럼 업데이트 > 쿼리 하나만 사용
			String sql = "update tblAddress set name = ?, age = ?, gender = ?, tel = ?, address = ? where seq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAge());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getTel());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getSeq());
			
			int result = pstmt.executeUpdate();
			
			return result; // 성공 1, 실패 0
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int del(String seq) {
		
		try {
			String sql = "delete from tblAddress where seq = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			int result = pstmt.executeUpdate();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
}
