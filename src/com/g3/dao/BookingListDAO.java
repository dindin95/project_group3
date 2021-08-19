package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.BookingListDTO;



public class BookingListDAO {

	public List<BookingListDTO> getList(Connection conn) {
		
		
		StringBuilder sql = new StringBuilder();
		sql.append(" select            ");
		sql.append("        t_no	   ");
		sql.append("       ,bo_date	   ");
		sql.append("       ,m_id	   ");
		sql.append(" from booking_g3   ");
		

		List<BookingListDTO> list = new ArrayList<BookingListDTO>();
		
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				ResultSet rs = pstmt.executeQuery();) {
			
			while(rs.next()) {
				BookingListDTO dto = new BookingListDTO();
				dto.setT_no(rs.getInt("t_no"));
				dto.setBo_date(rs.getDate("bo_date"));
				dto.setM_id(rs.getString("m_id"));
				list.add(dto);
				
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return list;
	}

}
