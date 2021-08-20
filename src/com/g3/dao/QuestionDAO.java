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
		  sql.append("   select   *                              			 ");
		  sql.append("   from (                                  			 ");
		  sql.append("          select @rownum:=@rownum+1 as rnum, A.*       ");
		  sql.append("          from (                          			 ");
		  sql.append("                   select                 			 ");
		  sql.append("                            q_no    		 			 ");
		  sql.append("                            ,q_title    				 ");
		  sql.append("                            ,q_content         		 ");
		  sql.append("                            ,m_id        		 		 ");
		  sql.append("                            ,q_writedate       		 ");
		  sql.append("                   from question_g3            		 ");
		  
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
		  sql.append("                )A, (select @rownum:=0) R                         ");
		  sql.append("        ) B                                 ");
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

	//detail 상세보기
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


	//insert 글쓰기
	public void addQuestion(Connection conn, QuestionDTO dto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql = new StringBuilder();
		sql.append("   insert  into   question_g3  (   			");
		sql.append("     			 q_title    				");
		sql.append("     			, q_content    				");
		sql.append("     			, m_id    					");
		sql.append("     			, q_writedate     )    		");
		sql.append("  values  (?,?,?,sysdate()  )  		");
		
		
		try(
			 	PreparedStatement pstmt=conn.prepareStatement(sql.toString());
				){
				pstmt.setString(1, dto.getQ_title());
				pstmt.setString(2, dto.getQ_content());
				pstmt.setString(3, dto.getM_id());
				
				pstmt.executeUpdate();
				System.out.println("글쓰기임");
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

	//delete 삭제
	public void deleteQuestion(Connection conn, int q_no) {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append("	delete  from  question_g3	");
		sql.append("	where q_no=?				");
		
		try(
			 PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			 ){
				pstmt.setInt(1, q_no);
				pstmt.executeUpdate();
			}catch(SQLException e)
			{
				System.out.println(e);
			}
	}

	//modify 수정하기
	public void modifyQuestion(Connection conn, QuestionDTO dto) {
		// TODO Auto-generated method stub
		
		StringBuilder sql=new StringBuilder();
		sql.append("  update    question_g3      ");
		sql.append("  set                  ");
		sql.append("        q_title=?        ");
		sql.append("       , q_content=?     ");
		sql.append("  where                 ");
		sql.append("          q_no=?         ");
		
		try( 
			PreparedStatement pstmt=conn.prepareStatement(sql.toString());		
			){
			pstmt.setString(1, dto.getQ_title());
			pstmt.setString(2, dto.getQ_content());
			pstmt.setInt(3, dto.getQ_no());
			
			pstmt.executeUpdate();
			
			
		} catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}

	//나의 문의글 조회 갯수 
	public int getMyTotalCount(Connection conn, String search, String searchtxt, String m_id) {
		StringBuilder sql = new StringBuilder();
		sql.append("       select   count(*)      ");
		sql.append("       from    question_g3    ");
		sql.append("       where m_id = ?		  ");
		
		if(!search.equals("") && !searchtxt.equals(""))
		  {
		    if(search.equals("q_title"))
			 {
		    	sql.append(" and lower(q_title) like  ? ");
			 }else if(search.equals("q_content"))
			 {
			    	sql.append(" and lower(q_content) like  ? ");
				 }
		 }
		
		int totalcount = 0;
		ResultSet rs = null;
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			if(!search.equals("") && !searchtxt.equals(""))
			 {
				  pstmt.setString(1, m_id);
				  pstmt.setString(2, "%"+searchtxt.toLowerCase()+"%");
			 }else {
				 pstmt.setString(1, m_id);
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

		
	//나의 문의글 조회 
	public List<QuestionDTO> getMyList(Connection conn, int startrow, int endrow, String search, String searchtxt, String m_id) {
		StringBuilder sql=new StringBuilder();
		  sql.append("   select   *                              			 ");
		  sql.append("   from (                                  			 ");
		  sql.append("          select @rownum:=@rownum+1 as rnum, A.*       ");
		  sql.append("          from (                          			 ");
		  sql.append("                   select                 			 ");
		  sql.append("                            q_no    		 			 ");
		  sql.append("                            ,q_title    				 ");
		  sql.append("                            ,q_content         		 ");
		  sql.append("                            ,m_id        		 		 ");
		  sql.append("                            ,q_writedate       		 ");
		  sql.append("                   from question_g3            		 ");
		  sql.append("                   where m_id = ?		    			 ");
		  
		  if(!search.equals("")&& !searchtxt.equals("")){
			  
		     if(search.equals("q_title")){
		    	 
		    	System.out.println("ssss");
			  sql.append("              and lower(q_title) like ?        ");

		     	}else if(search.equals("q_content")){
		    
		     		System.out.println("sdasdasd");
		    	 sql.append("     and lower(q_content)  like  ?    		");
		    	 
		     }
		    }	  
			  sql.append("                   order by q_no desc  			");
			  sql.append("                )A, (select @rownum:=0) R         ");
			  sql.append("        ) B                                 		");
			  sql.append("  where rnum>=?  and rnum<=?               		");


		  System.out.println("ddd>>  " + search);
		  System.out.println("searchtxt >>> " + searchtxt);
		  System.out.println("startrow >>> " + startrow);
		  System.out.println("endrow >>> " + endrow);
			  
		  ResultSet rs=null;
		  ArrayList<QuestionDTO> list=new ArrayList<QuestionDTO>();
		  try(
			  PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			) {
			  
			 if(!search.equals("") &&  !searchtxt.equals("")) {
				 
				 pstmt.setString(1, m_id);
				 pstmt.setString(2, "%"+searchtxt.toLowerCase()+"%");
				 pstmt.setInt(3, startrow);
				 pstmt.setInt(4, endrow);

			 }else {
				 pstmt.setString(1, m_id);
			    pstmt.setInt(2, startrow);
			    pstmt.setInt(3, endrow);
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
	
	//나의 문의글 디테일 
	public QuestionDTO detail(Connection conn, int questionnum, String m_id) {

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
		sql.append("  		 and m_id=?	  	");
		
		ResultSet rs=null;
		QuestionDTO dto=new QuestionDTO();
		try(
				PreparedStatement pstmt=conn.prepareStatement(sql.toString());	
			){
				pstmt.setInt(1, questionnum);
				pstmt.setString(2, m_id);
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
