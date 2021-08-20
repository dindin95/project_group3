package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.BookingDAO;
import com.g3.dto.BookingDTO;
import com.g3.dto.BookingTimeDTO;
import com.g3.dto.TimeDTO;

public class BookingService {

	//예약하기
	public int insertBooking(TimeDTO time, BookingDTO booking) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		int result = 0;
		int timeResult = 0;
		
		try {
	           conn=dbconn.getConnection();
	           conn.setAutoCommit(false);
	           
	           BookingDAO dao = new BookingDAO();
	           
	           result = dao.insertTime(conn, time); 
	           conn.commit();
	           
	           timeResult = dao.selectTime(conn, time);
	           
	           result = dao.insertBooking(conn, booking, timeResult);
	           conn.commit();
	           
		} catch(SQLException | NamingException e) {
			try { conn.rollback();} catch(SQLException e2) {}
		}
		
		return result;
	}

	//예약 불가능한 시간 보여주기
	public List<BookingTimeDTO> getBookingTime(int bo_room, String bo_date) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		List<BookingTimeDTO> list = new ArrayList<BookingTimeDTO>();
		
		try {
			conn = dbconn.getConnection();
			
			BookingDAO dao = new BookingDAO();
			list = dao.getBookingTime(conn, bo_room, bo_date);
			
		} catch(SQLException | NamingException e) {
			System.out.println(e);
			
		} finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return list;
	}
	
}
