package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

import com.test.toy.DBUtil;

public class Dummy {
	
	public static void main(String[] args) {
		
		// 게시글 더미 생성
		String sql = "insert into tblBoard(seq, subject, content, id, regdate, readcount) values (seqBoard.nextVal, ?, ?, ?, default, default)";
		
		// 시드 데이터
		String[] subject = {"안뇽ㅎㅎ", "테스트", "하이루", "어솨~", "개오바", "오늘은", "어쩌구 저쩌구", "점심 메뉴 추천좀", "와우~", "OTL", "캬캬", "낄낄낄"};
		String content = "내용입니다.";
		
		String[] id = {"hong", "admin", "suaa"};
		
		try {
			Connection conn = DBUtil.open();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			Random rnd = new Random();
			
			for (int i = 0 ; i < 256 ; i ++) {
				pstmt.setString(1, subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " " + subject[rnd.nextInt(subject.length)] + " ");
				
				pstmt.setString(2, content);
				pstmt.setString(3, id[rnd.nextInt(id.length)]);
				
				pstmt.executeUpdate();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
