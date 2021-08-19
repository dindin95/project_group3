package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
		sql.append("delete 						 ");
		sql.append("from member_g3 				 ");
		sql.append("	where m_id = ? 			 ");

		try (
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
			){
			
			pstmt.setString(1, m_id );
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
		
	}
	
	
	
	
}
