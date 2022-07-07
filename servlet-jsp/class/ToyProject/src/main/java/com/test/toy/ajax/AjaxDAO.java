package com.test.toy.ajax;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.toy.DBUtil;

public class AjaxDAO {

	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AjaxDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<ResearchDTO> listResearch() {
		
		try {
			
			String sql = "select * from tblResearch where seq = 1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<ResearchDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				ResearchDTO dto = new ResearchDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setQuestions(rs.getString("questions"));
				dto.setItem1(rs.getString("item1"));
				dto.setItem2(rs.getString("item2"));
				dto.setItem3(rs.getString("item3"));
				dto.setItem4(rs.getString("item4"));
				dto.setCnt1(rs.getString("cnt1"));
				dto.setCnt2(rs.getString("cnt2"));
				dto.setCnt3(rs.getString("cnt3"));
				dto.setCnt4(rs.getString("cnt4"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int getCount() {
		
		try {
			String sql = "select count(*) as cnt from tblResearch";
			
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

	public int checkId(String id) {
		
		try {
			String sql = "select count(*) as cnt from tblUser where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				return rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<String> listBuseo() {
		
		try {
			String sql = "select distinct buseo from tblInsa order by buseo asc";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<String> blist = new ArrayList<String>();
			
			while(rs.next()) {
				blist.add(rs.getString("buseo"));
			}
			
			return blist;
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<BuseoDTO> listInsa(String buseo) {
		
		try {
			String sql = "select num, name, jikwi, tel, city from tblInsa where buseo = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, buseo);
			
			rs = pstmt.executeQuery();
			
			ArrayList<BuseoDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				BuseoDTO dto = new BuseoDTO();
				
				dto.setNum(rs.getString("num"));
				dto.setName(rs.getString("name"));
				dto.setJikwi(rs.getString("jikwi"));
				dto.setTel(rs.getString("tel"));
				dto.setCity(rs.getString("city"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public ArrayList<AddressDTO> listAddress() {
		
		try {
			String sql = "select * from tblAddress";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<AddressDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int delAddress(String seq) {
		
		try {
			String sql = "delete from tblAddress where seq = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, seq);
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public int addAddress(String name, String age, String gender, String tel, String address) {
		
		try {
			String sql = "insert into tblAddress values (seqAddress.nextVal, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, age);
			pstmt.setString(3, address);
			pstmt.setString(4, gender);
			pstmt.setString(5, tel);
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
		
	}

	public ArrayList<AddressDTO> filteredList(String filter) {
		
		if (filter.equals("all")) {
			return listAddress();
		}
		
		try {
			String sql = "select * from tblAddress where gender = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, filter);
			rs = pstmt.executeQuery();
			
			ArrayList<AddressDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				AddressDTO dto = new AddressDTO();
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setAge(rs.getString("age"));
				dto.setAddress(rs.getString("address"));
				dto.setGender(rs.getString("gender"));
				dto.setTel(rs.getString("tel"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	public int updatePosition(DraggableDTO dto) {
		try {
			String sql = "update tblDraggable set left = ?, top = ? where id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getLeft());
			pstmt.setString(2, dto.getTop());
			pstmt.setString(3, dto.getId());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<DraggableDTO> listDraggable() {
		
		try {
			String sql = "select * from tblDraggable";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<DraggableDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				
				DraggableDTO dto = new DraggableDTO();
				
				dto.setId(rs.getString("id"));
				dto.setLeft(rs.getString("left"));
				dto.setTop(rs.getString("top"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
