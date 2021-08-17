package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.BookingListDAO;
import com.g3.dto.BookingListDTO;

public class BookingListService {
	
	private static BookingListService service = new BookingListService();
	
	public static BookingListService getService() {
		return service;
	}

	public List<BookingListDTO> getBookingList() {
		

		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		List<BookingListDTO> bookingList = new ArrayList<BookingListDTO>();
		
		try {
			conn = dbconn.getConnection();
			
			BookingListDAO bookingListDAO = new BookingListDAO();
			bookingList  = bookingListDAO.getList(conn);
			
		}catch (SQLException | NamingException e) {
			System.out.println(e);
			
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return bookingList ;
	}
	
	
	

}
