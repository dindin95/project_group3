package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.QuestionDTO;

public class QuestionDAO {

	
	private static QuestionDAO dao = new QuestionDAO();
	public static QuestionDAO getDAO()
	{
		return dao;
	}
	
	
	public List<QuestionDTO> getList(Connection conn, int startrow, int endrow, String search, String searchtxt) {
		// TODO Auto-generated method stub
		
		StringBuilder sql=new StringBuilder();
		  sql.append("   select   *                              ");
		  sql.append("   from (                                  ");
		  sql.append("          select rownum as rnum, b.*       ");
		  sql.append("          from (                           ");
		  sql.append("                   select                  ");
		  sql.append("                            q_no    ");
		  sql.append("                            ,q_title    ");
		  sql.append("                            ,q_content         ");
		  sql.append("                            ,m_id        ");
		  sql.append("                            ,q_writedate        ");
		  sql.append("                   from question_g3          ");
		  
	   if(!search.equals("")&& !searchtxt.equals(""))
	   {
	     if(search.equals("q_title"))
	     {
		  sql.append("              where lower(q_title) like ?        ");
	     }else if(search.equals("q_content"))
	     {
	    	 sql.append("     where lower(q_content)  like  ?    ");
	     }
	    }	  
		  sql.append("                   order by q_no desc  ");
		  sql.append("                )b                         ");
		  sql.append("        )                                  ");
		  sql.append("  where rnum>=?  and rnum<=?               ");

		  
		  ResultSet rs=null;
		  ArrayList<QuestionDTO> list=new ArrayList<QuestionDTO>();
		  try(
			  PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			) {
			  
			 if(!search.equals("") &&  !searchtxt.equals("")) 
			 {
				 pstmt.setString(1, "%"+searchtxt.toLowerCase()+"%");
				 pstmt.setInt(2, startrow);
				 pstmt.setInt(3, endrow);

			 }else
			 {
			    pstmt.setInt(1, startrow);
			    pstmt.setInt(2, endrow);
			 }
			 
			 
			  rs=pstmt.executeQuery();
			  while(rs.next())
			  {
				QuestionDTO dto=new QuestionDTO();
				dto.setQ_no(rs.getInt("q_no"));
				dto.setQ_title(rs.getString("q_title"));
				dto.setQ_content(rs.getString("q_content"));
				dto.setM_id(rs.getString("m_id"));
				dto.setQ_writedate(rs.getString("q_writedate"));
				list.add(dto);
			  }
			  
			  
		  }catch(SQLException e)
		  {
			  System.out.println(e);
		  }finally {
			  if(rs!=null) try { rs.close();} catch(SQLException e) {}
		  }
		
		return list;
	}


	public int getTotalCount(Connection conn, String search, String searchtxt) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("       select   count(*)      ");
		sql.append("       from    question_g3    ");
		
		if(!search.equals("") && !searchtxt.equals(""))
		  {
		    if(search.equals("q_title"))
			 {
		    	sql.append(" where lower(q_title) like  ? ");
			 }else if(search.equals("q_content"))
			 {
			    	sql.append(" where lower(q_content) like  ? ");
				 }
		 }
		
		int totalcount = 0;
		ResultSet rs = null;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			if(!search.equals("") && !searchtxt.equals(""))
			 {
				  pstmt.setString(1, "%"+searchtxt.toLowerCase()+"%");
			 }
			
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


	public QuestionDTO detail(Connection conn, int questionnum) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("  select  				");
		sql.append("  			q_no	    ");
		sql.append("  		  , q_title  	");
		sql.append("  		  , q_content  	");
		sql.append("  		  , m_id  		");
		sql.append("  		  , q_writedate ");
		sql.append("  from question_g3	 	");
		sql.append("  where				  	");
		sql.append("  		  q_no=?	  	");
		
		ResultSet rs=null;
		QuestionDTO dto=new QuestionDTO();
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());	
			){
				pstmt.setInt(1, questionnum);
				rs=pstmt.executeQuery();
				
				if(rs.next())
				{
					dto.setQ_no(rs.getInt("q_no"));
					dto.setQ_title(rs.getString("q_title"));
					dto.setQ_content(rs.getString("q_content"));
					dto.setM_id(rs.getString("m_id"));
					dto.setQ_writedate(rs.getString("q_writedate"));
				}
				
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
		return dto;
	}

	
	
}
