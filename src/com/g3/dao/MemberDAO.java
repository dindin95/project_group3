package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.g3.dto.MemberDTO;
import com.g3.dto.MyPageDTO;

public class MemberDAO {
	
	//싱글톤
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getdao() {
		return dao;
	}
	
	private MemberDAO() {}
	
	//회원탈퇴 
	public static void memberDelete(Connection conn, String m_id) {

		StringBuilder sql = new StringBuilder();
		
		  sql.append("       delete    				");
		  sql.append("       		 from    		");
		  sql.append("       		 	member_g3   ");
		  sql.append("      where   				");
		  sql.append("       		m_id=?    		");
		 

		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
			
			pstmt.setString(1, m_id );
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
	}
	
	 //회원가입insert
    public void register(Connection conn, String m_id, String m_pwd, String m_name, String m_phone) {
       StringBuilder sql = new StringBuilder();
       sql.append(" insert into member_g3(                ");
       sql.append("                         m_id            ");
       sql.append("                         ,m_level            ");
       sql.append("                         ,m_name            ");
       sql.append("                         ,m_pwd            ");
       sql.append("                         ,m_phone         ");
       sql.append("                         ,m_date         ");
       sql.append("                          )                ");
       sql.append(" values ( ?,0,?,?, ?, sysdate()  ) ");
       
       try(
          PreparedStatement pstmt = conn.prepareStatement(sql.toString());
             ){
          
       
          pstmt.setString(1, m_id);
          pstmt.setString(2, m_name);
          pstmt.setString(3, m_pwd);
          pstmt.setString(4, m_phone);
          pstmt.executeUpdate();
          
       }catch(SQLException e) {
          System.out.println(e);
          }
    }

	
	
}
