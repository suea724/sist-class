package com.test.memo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.jsp.DBUtil;

// DAO의 각 업무 메서드에서는 하나의 업무만 진행! *** 
public class DAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public DAO() {
		conn = DBUtil.open();
	}

	// AddOk 서블릿이 입력받은 데이터(DTO)를 데이터베이스에 반영(insert)
	public int add(DTO dto) {
		try {
			String sql = "insert into tblMemo(seq, subject, content, name, pw, regdate) values (seqMemo.nextVal, ?, ?, ?, ?, default)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getPw());
			
			return pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<DTO> list() {
			try {
				String sql = "select * from tblMemo order by seq desc";
				
				stmt = conn.createStatement();
				
				rs = stmt.executeQuery(sql);
				
				ArrayList<DTO> list = new ArrayList<>();
				
				while(rs.next()) {
					DTO dto = new DTO();
					
					dto.setSeq(rs.getString("seq"));
					dto.setSubject(rs.getString("subject"));
					dto.setContent(rs.getString("content"));
					dto.setName(rs.getString("name"));
					dto.setRegdate(rs.getString("regdate"));
					
					list.add(dto);
				}
				return list;
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return null;
	}

	public DTO get(String seq) {
		try {
			
			String sql = "select * from tblMemo where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			DTO dto = new DTO();
			
			if (rs.next()) {
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
			}
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int edit(DTO dto) {
		try {
			
			String sql = "update tblMemo set subject = ?, content = ?, name = ? where seq = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getSeq());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	// 메모 비밀번호와 입력한 비밀번호가 일치하는지 확인
	public boolean check(DTO dto) {
		
		try {
			String sql = "select count(*) as cnt from tblMemo where seq = ? and pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getSeq());
			pstmt.setString(2, dto.getPw());
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt") == 1 ? true : false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
}
