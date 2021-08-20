package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.MyPageDTO;
import com.g3.dto.MybookingDTO;

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
	public static int myPageModify(Connection conn, MyPageDTO dto, String m_id) {

		StringBuilder sql = new StringBuilder();
		sql.append("update member_g3 		 	 ");
		sql.append(" set 					 	 ");
		sql.append("	 	m_name = ? 			 ");
		sql.append("	 	, m_pwd = ? 		 ");
		sql.append("	 	, m_phone = ?		 ");
		sql.append("where				 		 ");
		sql.append("		 m_id = ? 			 ");
		
		int result = 0;
		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
			
			pstmt.setString(1, dto.getM_name() );
			pstmt.setString(2, dto.getM_pwd() );
			pstmt.setString(3, dto.getM_phone() );
			pstmt.setString(4, m_id );
			
			 result =pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		System.out.println(result + "   dao!!");
		return result;
	}
	
	//나의 예약현황 총갯수 
	public int getTotalCount(Connection conn, String m_id) {

		StringBuilder sql = new StringBuilder();
		sql.append("       select   count(*)    			  ");
		 sql.append("         from booking_g3 a       		  ");
		 sql.append("          join time_g3 b       		  ");
		 sql.append("          on a.t_no = b.t_no      		  ");
		 sql.append("      where a.m_id = ?     			  ");
		
		
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
	public List<MybookingDTO> getList(Connection conn, int startrow, int endrow, String m_id) {
		
		 StringBuilder sql=new StringBuilder();
		 sql.append("   select   *                              													 ");
		 sql.append("   from (                                  													 ");
		 sql.append("          select @rownum:=@rownum+1 as rnum, A.*       										 ");
		 sql.append("          from (                          														 ");
		 sql.append("                   select                                                                       ");
		 sql.append("                            bo_no   		                                                     ");
		 sql.append("                            ,m_id   	                                                    	 ");
		 sql.append("                            ,bo_date   	                                                     ");
		 sql.append("                            ,bo_room     														 ");
		 sql.append("                            ,ABS(startTime- endTime)  as time       							 ");
		 sql.append("                   from booking_g3 a       													 ");
		 sql.append("                   join time_g3 b       														 ");
		 sql.append("                   on a.t_no = b.t_no      													 ");
		 sql.append("                   where   m_id=?		    													 ");
		 sql.append("                   order by bo_no desc  	 													 ");
		 sql.append("                )A, (select @rownum:=0) R                         								 ");
	     sql.append("        ) B                                 													 ");
	     sql.append("  where rnum>=?  and rnum<=?               													 ");
		 
		  ResultSet rs=null;
		  List<MybookingDTO> list= new ArrayList<MybookingDTO>();
		  
		  try(
			  PreparedStatement pstmt=conn.prepareStatement(sql.toString());
			) {
			  
			  System.out.println("%%%%%%%%%%%%%%%%%%    " + m_id);

			  
			  pstmt.setString(1, m_id);
			    pstmt.setInt(2, startrow);
			    pstmt.setInt(3, endrow);

			    rs=pstmt.executeQuery();
			    
			   while(rs.next()) {
			      MybookingDTO dto=new MybookingDTO();
				  
				  dto.setBo_no(rs.getInt("bo_no"));
				  dto.setBo_date(rs.getDate("bo_date"));
				  dto.setBo_room(rs.getInt("bo_room"));
				  dto.setTime(rs.getInt("time"));
				  dto.setM_id(rs.getString("m_id"));
				  
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
	
	//나의 예약현황 삭제
	public static void myPageDelete(Connection conn, int bo_no) {

		StringBuilder sql = new StringBuilder();
		sql.append("       DELETE    								");
		sql.append("       		 booking_g3    					    ");
		sql.append("       		 ,time_g3    					    ");
		sql.append("      FROM booking_g3     					    ");
		sql.append("       		INNER JOIN 	 time_g3     			");
		sql.append("        	ON time_g3.t_no = booking_g3.t_no 	");
		sql.append("       WHERE	      							");
		sql.append("      		booking_g3.bo_no = ?	 			");
		
		try(
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				){
			
			pstmt.setInt(1, bo_no );
			pstmt.executeUpdate();	
			
			
		} catch(SQLException e)
		{
			System.out.println(e);
		}
		
	}
	
	
	
}
