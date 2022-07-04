package com.test.toy.etc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.test.toy.DBUtil;

public class EtcDAO {
	
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public EtcDAO() {
		conn = DBUtil.open();
	}

	public ArrayList<CategoryDTO> listCategory() {
		
		try {
			String sql = "select seq, name from tblCategory order by name asc";
			
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<CategoryDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				CategoryDTO dto = new CategoryDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				
				list.add(dto);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int addFood(FoodDTO dto) {
		
		try {
			String sql = "insert into tblFood(seq, name, lat, lng, star, category) values (seqFood.nextVal, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getLat());
			pstmt.setString(3, dto.getLng());
			pstmt.setString(4, dto.getStar());
			pstmt.setString(5, dto.getCategory());
			
			return pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

	public ArrayList<FoodDTO> listFood() {
		
		try {
			String sql = "select tblFood.*, (select marker from tblCategory where seq = tblFood.category) as marker, (select icon from tblCategory where seq = tblFood.category) as icon from tblFood order by name asc";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			ArrayList<FoodDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				FoodDTO dto = new FoodDTO();
				
				dto.setSeq(rs.getString("seq"));
				dto.setName(rs.getString("name"));
				dto.setLat(rs.getString("lat"));
				dto.setLng(rs.getString("lng"));
				dto.setStar(rs.getString("star"));
				dto.setCategory(rs.getString("category"));
				dto.setMarker(rs.getString("marker"));
				dto.setIcon(rs.getString("icon"));
				
				list.add(dto);
			}
			
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
