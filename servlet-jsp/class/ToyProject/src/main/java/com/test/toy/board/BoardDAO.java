package com.test.toy.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.test.toy.DBUtil;

public class BoardDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BoardDAO() {
		conn = DBUtil.open();
	}

	public int add(BoardDTO dto) {
		
		try {
			String sql = "insert into tblBoard(seq, subject, content, id, regdate, readcount, thread, depth, filename, orgfilename) values (seqBoard.nextVal, ?, ?, ?, default, default, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getId());
			
			pstmt.setInt(4, dto.getThread());
			pstmt.setInt(5, dto.getDepth());
			
			pstmt.setString(6, dto.getFilename());
			pstmt.setString(7, dto.getOrgfilename());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<BoardDTO> list(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			String sql = "";
			
			if (map.get("tag") == null) {
				
				if (map.get("isSearch").equals("y")) {
					where = String.format(" where %s like '%%%s%%'",
							map.get("column"),
							map.get("word"));
				}
				
				sql = String.format("select * from (select b.*, rownum as rnum from vwBoard b %s) where rnum between %s and %s", where, map.get("begin"), map.get("end")) ;
			} else {
				sql = "select b.* from vwBoard b\r\n"
						+ "    inner join tblTagging t\r\n"
						+ "        on b.seq = t.bseq\r\n"
						+ "            inner join tblHashTag h\r\n"
						+ "                on h.seq = t.hseq\r\n"
						+ "                    where h.tag = '" + map.get("tag") + "'";
			}
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			ArrayList<BoardDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				
				BoardDTO dto = new BoardDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setCommentcount(rs.getString("commentcount"));
				dto.setReadcount(rs.getString("readcount"));
				
				dto.setDepth(rs.getInt("depth"));
				
				dto.setIsnew(rs.getDouble("isnew"));
				dto.setFilename(rs.getString("filename"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public BoardDTO get(String seq) {
		
		try {
			String sql = "select tblBoard.*, (select name from tblUser where id = tblBoard.id) as name from tblBoard where seq = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			BoardDTO dto = new BoardDTO();
			
			if (rs.next()) {
				
				dto.setSeq(rs.getString("seq"));
				dto.setSubject(rs.getString("subject"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
				dto.setName(rs.getString("name"));
				dto.setRegdate(rs.getString("regdate"));
				dto.setReadcount(rs.getString("readcount"));
				
				dto.setThread(rs.getInt("thread"));
				dto.setDepth(rs.getInt("depth"));
				
				dto.setFilename(rs.getString("filename"));
				dto.setOrgfilename(rs.getString("orgfilename"));
			}
			
			// 해당 글의 해시 태그들 가져오기
			sql = "select tag from tblHashTag h inner join tblTagging t on h.seq = t.hseq where bseq = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			ArrayList<String> list = new ArrayList<>();
			
			while (rs.next()) {
				list.add(rs.getString("tag"));
			}
			
			dto.setTaglist(list);
			
			return dto;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void updateReadCount(String seq) {
		try {
			String sql = "update tblBoard set readcount = readcount + 1 where seq = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public int edit(BoardDTO dto) {
		try {
			String sql = "update tblBoard set subject = ?, content = ?, filename = ?, orgfilename = ? where seq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getSubject());
			pstmt.setString(2, dto.getContent());
			pstmt.setString(3, dto.getFilename());
			pstmt.setString(4, dto.getOrgfilename());
			pstmt.setString(5, dto.getSeq());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int del(String seq) { 
		
		try {
			String sql = "delete from tblBoard where seq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, seq);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int addComment(CommentDTO dto) {
		
		try {
			String sql = "insert into tblComment(seq, content, id, regdate, pseq) values(seqComment.nextVal, ?, ?, default, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getId());
			pstmt.setString(3, dto.getPseq());
			
			return pstmt.executeUpdate(); 
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<CommentDTO> listComment(String seq) {
		
		try {
			String sql = "select tblComment.*, (select name from tblUser where id = tblComment.id) as name from tblComment where pseq = ? order by seq desc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			
			rs = pstmt.executeQuery();
			
			ArrayList<CommentDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				CommentDTO dto = new CommentDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setContent(rs.getString("content"));
				dto.setId(rs.getString("id"));
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

	public int delcomment(String seq) {
		
		try {
			String sql = "delete from tblComment where seq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, seq);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int editComment(CommentDTO dto) {
		
		try {
			String sql = "update tblComment set content = ? where seq = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getContent());
			pstmt.setString(2, dto.getSeq());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void delcommentAll(String seq) {
		try {
			String sql = "delete from tblComment where pseq = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getTotalCount(HashMap<String, String> map) {
		
		try {
			
			String where = "";
			
			if (map.get("isSearch").equals("y")) {
				where = String.format("where %s like '%%%s%%'",
												map.get("column"),
												map.get("word"));
			}
			
			String sql = "select count(*) as cnt from tblBoard " + where;
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public int getMaxThread() {
		
		try {
			String sql = "select nvl(max(thread), 0) as thread from tblBoard";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				return rs.getInt("thread");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public void updateThread(HashMap<String, Integer> map) {
		try {
			
			String sql = "update tblBoard set thread = thread - 1 where > ? and thread < ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, map.get("previousThread"));
			pstmt.setInt(2, map.get("parentThread"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getSeq() {
		
		try {
			String sql = "select max(seq) as seq from tblBoard";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("seq");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public void addHashTag(String tag) {
		try {
			String sql = "insert into tblHashTag (seq, tag) values (seqHashTag.nextVal, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getNewHashTagSeq() {
		
		try {
			String sql = "select max(seq) as seq from tblHashTag";
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql);
			
			if (rs.next()) {
				return rs.getString("seq");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public void addTagging(HashMap<String, String> map) {
		try {
			String sql = "insert into tblTagging (seq, bseq, hseq) values (seqTagging.nextVal, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, map.get("bseq"));
			pstmt.setString(2, map.get("hseq"));
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// 자동완성을 위한 태그 리스트
	public ArrayList<String> taglist() {
		
		try {
			String sql = "select tag from tblHashTag order by tag asc";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<String> list = new ArrayList<String>();
			
			while (rs.next()) {
				list.add(rs.getString("tag"));
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String findExistHashTagSeq(String tag) {
		
		try {
			String sql = "select seq from tblHashTag where tag = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tag);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getString("seq");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void delTaggingAll(String seq) {
		try {
			String sql = "delete from tblTagging where bseq = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, seq);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

}
