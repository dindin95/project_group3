package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.g3.dto.BookingDTO;
import com.g3.dto.TimeDTO;

public class BookingDAO {

	//예약하기(time 테이블)
	public int insertTime(Connection conn, TimeDTO time) {
		StringBuilder sql = new StringBuilder();
		sql.append("	insert into time_g3 ( t_no, bo_room, startTime, endTime )	");
		sql.append("	values( timeseq.nextval, ?, ?, ? )							");
		
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setInt(1, time.getBo_room());
			pstmt.setString(2, time.getStartTime());
			pstmt.setString(3, time.getEndTime());
			
			result = pstmt.executeUpdate();
			
			System.out.println("insertTime result : " + result);
			
		} catch(SQLException e) {
			System.out.println(e);
			
		}
		
		return result;
	}
	
	//selectTime 메서드 리턴 값을 int로 잡아서 그 값을 insertBooking에 넘겨주기
	public int selectTime(Connection conn, TimeDTO time) {
		StringBuilder sql = new StringBuilder();
		sql.append("	select t_no		");
		sql.append("	from time_g3	");
		
		int timeResult = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
		){
			if(rs.next()) {
				timeResult = rs.getInt(1);
			}
			
		} catch(SQLException e) {
			System.out.println(e);
			
		}

		return timeResult;
	} 

	
	//예약하기(booking 테이블)
	public int insertBooking(Connection conn, BookingDTO booking, int timeResult) {
		StringBuilder sql = new StringBuilder();
		sql.append("	insert into booking_g3 ( bo_no, bo_date, m_id, bo_persons, t_no )	");
		sql.append("	values( bookingseq.nextval, ?, ?, ?, ? )							");
		
		int result = 0;
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			
			pstmt.setString(1, booking.getBo_date());
			pstmt.setString(2, booking.getM_id());
			pstmt.setInt(3, booking.getBo_persons()); 
			pstmt.setInt(4, timeResult);//이게 문제인데.. pstmt.setInt(4, 16); 이렇게 t_no 값을 직접적으로 집어넣으면 동작 함
			
			result = pstmt.executeUpdate();
			
			System.out.println("insertBooking result : " + result);
			
		} catch(SQLException e) {
			System.out.println(e);
			
		}
		
		return result;
	}

}
