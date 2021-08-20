package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NamingException;


import com.g3.comm.DBConnection;
import com.g3.dao.AnswerDAO;
import com.g3.dao.QuestionDAO;
import com.g3.dto.AnswerDTO;
import com.g3.dto.QuestionDTO;

public class QuestionService {

	private static QuestionService instance = new QuestionService();
	
	public static QuestionService getInstance()
	{
		return instance;
	}
	
	private QuestionService() {}

	public List<QuestionDTO> getList(int startrow, int endrow,String search, String searchtxt) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn=null;
		List<QuestionDTO> list = new ArrayList<QuestionDTO>();
		
		try {
			conn=dbconn.getConnection();
			QuestionDAO dao = new QuestionDAO();
			
			list=dao.getList(conn,startrow,endrow,search,searchtxt);
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		return list;
	}

	public int getTotalCount(String search, String searchtxt) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn=null;
	       int totalcount=0;
	       
		   try {
	           conn=dbconn.getConnection();
		       conn.setAutoCommit(false);
		       QuestionDAO dao=QuestionDAO.getDAO();
	           
	          totalcount= dao.getTotalCount(conn,search, searchtxt);
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

	public QuestionDTO detail(int questionnum) {
		// TODO Auto-generated method stub
		
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		QuestionDTO dto = new QuestionDTO();
		try {
			conn=dbconn.getConnection();
			QuestionDAO dao = new QuestionDAO();
			dto = dao.detail(conn, questionnum);
			
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
			return dto;
		}
	
	public void insertQuestion(QuestionDTO dto) {
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			QuestionDAO dao = new QuestionDAO();
			dao.addQuestion(conn, dto);
			
			
			conn.commit();
		}catch(SQLException|NamingException e)
		{
			try{conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null)try {conn.close();} catch(SQLException e) {}
		}
	}

	public void delete(int q_no) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			QuestionDAO dao = QuestionDAO.getDAO();
			dao.deleteQuestion(conn,q_no);
			conn.commit();
			
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

	public void modify(QuestionDTO dto) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			QuestionDAO dao = QuestionDAO.getDAO();
			dao.modifyQuestion(conn,dto);
			
			conn.commit();
			
			
		}catch(SQLException|NamingException  e)
		{
			try{conn.rollback();} catch(SQLException e2) {}
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
	}

	public QuestionDTO getQuestion(int q_no) {
		// TODO Auto-generated method stub
		DBConnection dbconn=DBConnection.getDBConn();
		Connection conn=null;
		QuestionDTO dto =new QuestionDTO();
		
		try {
			conn=dbconn.getConnection();
			conn.setAutoCommit(false);
			
			QuestionDAO dao = QuestionDAO.getDAO();
			dto=dao.detail(conn,q_no);
			conn.commit();
			
		}catch(SQLException|NamingException e)
		{
			System.out.println(e);
			try {conn.rollback();}catch(SQLException e1) {}
		}finally {
			if(conn!=null) try { conn.close();} catch(SQLException e) {}
		}
		return dto;
	}

	
	//�굹�쓽 臾몄쓽湲� 議고쉶 媛��닔 
	public int getMyTotalCount(String search, String searchtxt, String m_id) {
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn=null;
	       int totalcount=0;
	       
		   try {
	           conn=dbconn.getConnection();
		       conn.setAutoCommit(false);
		       QuestionDAO dao=QuestionDAO.getDAO();
	           
	          totalcount= dao.getMyTotalCount(conn,search, searchtxt, m_id);
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
		
		//�굹�쓽 臾몄쓽湲� 議고쉶 
		public List<QuestionDTO> getMyList(int startrow, int endrow, String search, String searchtxt, String m_id) {
			// TODO Auto-generated method stub
			
					DBConnection dbconn = DBConnection.getDBConn();
					Connection conn=null;
					List<QuestionDTO> list = new ArrayList<QuestionDTO>();
					
					try {
						conn=dbconn.getConnection();
						QuestionDAO dao = new QuestionDAO();
						
						list=dao.getMyList(conn,startrow,endrow,search,searchtxt, m_id);
					}catch(SQLException|NamingException e)
					{
						System.out.println(e);
					}finally {
						if(conn!=null) try { conn.close();} catch(SQLException e) {}
					}
					return list;
		}
		
		
		
		//관리자 체크
		public int checkMember(String m_id) {
			
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			System.out.println("관리자 체크");
			int checkResult =0;
			try {
				conn = dbconn.getConnection();
				
			    AnswerDAO answerDAO = new AnswerDAO();
			    checkResult = answerDAO.checkMember(conn,m_id);
				
			}catch (SQLException | NamingException e) {
				// TODO: handle exception
			}
			
			return checkResult;
			
		}
		
		
		//리플보기
		public List<AnswerDTO> replyView(int qno) {
			
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			
			
			List<AnswerDTO> answerList = new ArrayList<AnswerDTO>();
			try {
				conn = dbconn.getConnection();
				
				AnswerDAO answerDAO = new AnswerDAO();
				
				
				answerList = answerDAO.getView(conn,qno);
				
			}catch(SQLException | NamingException e) {
				System.out.println(e);
			}finally {
				if(conn !=null)try {conn.close();}catch(SQLException e) {}
			}
			
			
			
			return answerList;
		}

		
		public void answerAdd(AnswerDTO answerDTO) {
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn =null;
			try {
				conn=dbconn.getConnection();
				AnswerDAO answerDAO= new AnswerDAO();
				
				int q_no = answerDTO.getQ_no();
				System.out.println("q_no"+q_no);
				List<AnswerDTO> list = answerDAO.getView(conn, q_no);
				
				if(list.size() < 1 ) {
					answerDAO.answerAdd(conn,answerDTO);
				}
				
				
				
			}catch(SQLException | NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null)try {conn.close();}catch(SQLException e) {}
				
			}
			
		}

		public void answerRemove(int ano, int qno) {
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn = null;
			
			try {
				conn = dbconn.getConnection();
				
				AnswerDAO answerDAO = new AnswerDAO();
				answerDAO.answerRemove(conn,ano);
				
			}catch (SQLException | NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null)try {conn.close();}catch(SQLException e) {}
			}
			
		}

		//내 문의글 디테일 
		public QuestionDTO detail(int questionnum, String m_id) {
			DBConnection dbconn=DBConnection.getDBConn();
			Connection conn=null;
			QuestionDTO dto = new QuestionDTO();
			try {
				conn=dbconn.getConnection();
				QuestionDAO dao = new QuestionDAO();
				dto = dao.detail(conn, questionnum, m_id);
				
			}catch(SQLException|NamingException e)
			{
				System.out.println(e);
			}finally {
				if(conn!=null) try { conn.close();} catch(SQLException e) {}
			}
				return dto;
			}


		public void answerModify(AnswerDTO answerDTO ) {
			
			DBConnection dbconn = DBConnection.getDBConn();
			Connection conn =null;
			try {
				conn=dbconn.getConnection();
				AnswerDAO answerDAO= new AnswerDAO();
				 answerDAO.answerModify(conn,answerDTO);
				
			}catch(SQLException | NamingException e) {
				System.out.println(e);
			}finally {
				if(conn!=null)try {conn.close();}catch(SQLException e) {}
				
			}
			

		}
		
		}	
	
