package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.BookingDAO;
import com.g3.dto.BookingDTO;
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
	           
	           //conn.setAutoCommit(false);
	           
	           result = dao.insertBooking(conn, booking, timeResult);
	           conn.commit();
	           
		} catch(SQLException | NamingException e) {
			try { conn.rollback();} catch(SQLException e2) {}
		}
		
		return result;
	}
}
