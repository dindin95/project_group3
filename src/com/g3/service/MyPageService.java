package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.BookingListDAO;
import com.g3.dao.LoginDAO;
import com.g3.dao.MemberDAO;
import com.g3.dao.MyPageDAO;
import com.g3.dao.QuestionDAO;
import com.g3.dto.LoginDTO;
import com.g3.dto.MemberDTO;
import com.g3.dto.MyPageDTO;
import com.g3.dto.MybookingDTO;
import com.g3.dto.QuestionDTO;

public class MyPageService {
	//싱글톤
	private static MyPageService service = new MyPageService();
	
	public static MyPageService getService() {
		return service;
	}
	
	private MyPageService() {}
	
	//회원정보 조회
	public MyPageDTO getMyPageList(String m_id) {
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		MyPageDTO dto = new MyPageDTO();
		
		try {
			conn = dbconn.getConnection();
			
			dto = MyPageDAO.getMyPageList(conn, m_id);
			
		}catch (SQLException | NamingException e) {
			System.out.println(e);
			
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		return dto;
	}
	
	//회원정보수정
	public int myPageModify(MyPageDTO dto , String m_id) {
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		int result = 0;
		try {
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			result = MyPageDAO.myPageModify(conn, dto, m_id);
			
			conn.commit();
		}catch (SQLException | NamingException e) {
			System.out.println(e);
			
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		return result; 
	}
	
	//나의 예약현황 총갯수 
	public int getTotalCount(String m_id) {
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn=null;
	       
		int totalcount=0;
	       
		   try {
	           conn=dbconn.getConnection();
		       conn.setAutoCommit(false);
		       MyPageDAO dao=MyPageDAO.getdao();
	           
	          totalcount= dao.getTotalCount(conn, m_id);

	          System.out.println("totalcount!!! : "+totalcount);
		       
		       conn.commit();
		   } catch(SQLException|NamingException e)
		   {
			  try { conn.rollback();} catch(SQLException e2) {}
			   
		   }finally {
			   if(conn!=null) try { conn.close();} catch(SQLException e) {}
			   
		   }
		   return totalcount;
	}
	
	//나의 예약현황
	public List<MybookingDTO> getList(int startrow, int endrow, String m_id) {

		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn=null;
		
		List<MybookingDTO> list = new ArrayList<MybookingDTO>();
		
		try {
			conn=dbconn.getConnection();
			
			MyPageDAO dao=MyPageDAO.getdao();
			
			list=dao.getList(conn,startrow,endrow, m_id);
			
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		
		System.out.println("service = " + list.size());
		return list;
	}
	
	//나의 예약현황 삭제 
	public void myBookingDelete(int bo_no) {

		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		try {
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
				
			MyPageDAO.myPageDelete(conn, bo_no);
			
			System.out.println("service " + bo_no);
			conn.commit();
		}catch (SQLException | NamingException e) {
			System.out.println(e);
			
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
	}
	
	
	//회원탈퇴 
	public void memberDelete(String m_id) {
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		try {
			conn = dbconn.getConnection();
			conn.setAutoCommit(false);
			
			MemberDAO.memberDelete(conn, m_id);
			
			conn.commit();
		}catch (SQLException | NamingException e) {
			System.out.println(e);
			
			try {conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();}catch(SQLException e) {}
		}
		
		
	}

	
}
