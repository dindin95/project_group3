package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.MyPageDTO;
import com.g3.dto.QuestionDTO;

public class MyPageDAO {
	
	//싱글톤
	private static MyPageDAO dao = new MyPageDAO();
	
	public static MyPageDAO getdao() {
		return dao;
	}
	
	private MyPageDAO() {}
	
	//회원정보조회 
	public static MyPageDTO getMyPageList(Connection conn, String m_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("select 						 ");
		sql.append("	 	m_id 				 ");
		sql.append("	 	,m_pwd 				 ");
		sql.append("	 	,m_name 			 ");
		sql.append("	 	,m_phone			 ");
		sql.append("	 	,m_date 			 ");
		sql.append("	 	,m_level 			 ");
		sql.append("from member_g3 				 ");
		sql.append("	where m_id = ? 			 ");
		
		ResultSet rs =  null;

		MyPageDTO dto = new MyPageDTO();
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
			
			System.out.println("d>>>>> " + m_id);
			pstmt.setString(1, m_id );
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto.setM_id(rs.getString("m_id"));
				dto.setM_name(rs.getString("m_name"));
				dto.setM_pwd(rs.getString("m_pwd"));
				dto.setM_phone(rs.getString("m_phone"));
				dto.setM_date(rs.getDate("m_date"));
				dto.setM_leval(rs.getInt("m_level"));
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		return dto;
	}
	
	//회원정보수정
	public static void myPageModify(Connection conn, MyPageDTO dto, String m_id) {

		StringBuilder sql = new StringBuilder();
		sql.append("update member_g3 		 	 ");
		sql.append(" set 					 	 ");
		sql.append("	 	m_name = ? 			 ");
		sql.append("	 	, m_pwd = ? 		 ");
		sql.append("	 	, m_phone = ?		 ");
		sql.append("where				 		 ");
		sql.append("		 m_id = ? 			 ");
		
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
			
			pstmt.setString(1, dto.getM_name() );
			pstmt.setString(2, dto.getM_pwd() );
			pstmt.setString(3, dto.getM_phone() );
			pstmt.setString(4, m_id );
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
	}
	
	//나의 예약현황 총갯수 
	public int getTotalCount(Connection conn, String m_id) {

		StringBuilder sql = new StringBuilder();
		sql.append("       select   count(*)      ");
		sql.append("       from    member_g3      ");
		sql.append("       where m_id = ? 	      ");
		
		
		int totalcount = 0;
		ResultSet rs = null;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setString(1, m_id );
			rs=pstmt.executeQuery();		
			if(rs.next())
			{
				totalcount=rs.getInt(1);
			}
			
		} catch(SQLException e)
		{
			System.out.println(e);
		}finally {
			if(rs!=null) try { rs.close();} catch(SQLException e) {}
		}
		
		return totalcount;
	}
	
	//나의 예약현황
	public List<QuestionDTO> getList(Connection conn, int startrow, int endrow, String m_id) {

		/*
		 * StringBuilder sql=new StringBuilder();
		 * sql.append("   select   *                              ");
		 * sql.append("   from (                                  ");
		 * sql.append("          select rownum as rnum, b.*       ");
		 * sql.append("          from (                           ");
		 * sql.append("                   select                  ");
		 * sql.append("                            q_no   		 ");
		 * sql.append("                            ,q_title   	 ");
		 * sql.append("                            ,q_content     ");
		 * sql.append("                            ,m_id        	 ");
		 * sql.append("                            ,q_writedate   ");
		 * sql.append("                   from question_g3        ");
		 * sql.append("                   where   m_id=?		     ");
		 * sql.append("                   order by q_no desc  	 ");
		 * sql.append("                )b                         ");
		 * sql.append("        )                                  ");
		 * sql.append("  where rnum>=?  and rnum<=?               ");
		 * 
		 
		  ResultSet rs=null;
		  
		  List<QuestionDTO> list=new ArrayList<QuestionDTO>();
		  
		  try(
			  PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			) {
			  
			    pstmt.setInt(1, startrow);
			    pstmt.setInt(2, endrow);
			 
			 
			  rs=pstmt.executeQuery();
			  while(rs.next())
			  {
				QuestionDTO dto=new QuestionDTO();
				
				list.add(dto);
			  }
			  
			  
		  }catch(SQLException e)
		  {
			  System.out.println(e);
		  }finally {
			  if(rs!=null) try { rs.close();} catch(SQLException e) {}
		  }
		
		*/
		
		return null;
	}
	
	
	
}
