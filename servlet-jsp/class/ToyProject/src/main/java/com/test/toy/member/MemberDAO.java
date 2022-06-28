package com.test.toy.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.test.toy.DBUtil;

public class MemberDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public MemberDAO() {
		conn = DBUtil.open();
	}

	// RegisterOK 서블릿으로부터 넘어온 DTO insert
	public int add(MemberDTO dto) {
		
		try {
			String sql = "insert into tblUser (id, pw, name, lv, pic, regdate) values (?, ?, ?, '1', ?, default)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPic());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public MemberDTO login(MemberDTO dto) {
		
		try {
			String sql = "select * from tblUser where id = ? and pw = ? and active = 'y'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			
			rs = pstmt.executeQuery();
			
			MemberDTO result = new MemberDTO();
			
			if (rs.next()) { // 로그인 성공
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setLv(rs.getString("lv"));
				result.setPic(rs.getString("pic"));
				result.setRegdate(rs.getString("regdate"));
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public MemberDTO get(String id) {
		try {
			String sql = "select * from tblUser where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			MemberDTO result = new MemberDTO();
			
			if (rs.next()) { 
				result.setId(rs.getString("id"));
				result.setPw(rs.getString("pw"));
				result.setName(rs.getString("name"));
				result.setLv(rs.getString("lv"));
				result.setPic(rs.getString("pic"));
				result.setRegdate(rs.getString("regdate"));
				
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int unregister(String id) {
		
		try {
			String sql = "update tblUser set active = 'n', pw = 'not used', name = 'not used', lv = '0', pic = 'not used', regdate = sysdate where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}
