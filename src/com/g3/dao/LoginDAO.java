package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.LoginDTO;

public class LoginDAO {
	
	//싱글톤
	private static LoginDAO dao = new LoginDAO();
	
	public static LoginDAO getdao() {
		return dao;
	}
	
	private LoginDAO() {}

	//로그인정보 
	public int check(Connection conn, String m_id, String m_pwd) {

		StringBuilder sql = new StringBuilder();
		sql.append("select 						 ");
		sql.append("	 	m_pwd 				 ");
		sql.append("	 	,m_name 			 ");
		sql.append("	 	,m_phone			 ");
		sql.append("	 	,m_date 			 ");
		sql.append("	 	,m_level 			 ");
		sql.append("from member_g3 				 ");
		sql.append("	where m_id = ? 			 ");
		
		int result=0;
		ResultSet rs = null;
		
		try(
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setString(1, m_id );
			rs= pstmt.executeQuery();
			
			System.out.println("?" + rs);
			
			if(rs.next()) {
				System.out.println("aas? "+ rs.getString("m_pwd"));
				
				if(rs.getString("m_pwd").equals(m_pwd)) { 
					result = 1; //일치 
				}else {
					result = 0; //불일치
				}
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs != null) try {rs.close();} catch(SQLException e) {}
		}
		
		System.out.println("dao " + result);
		
		return result;
	}
	
	
}
