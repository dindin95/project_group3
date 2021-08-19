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
	

	public int Check(Connection conn, String m_id) {
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "SELECT * FROM USER WHERE USERID = ?";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			if( rs.next()) {
				return 0; //이미 존재하는 회원
			}
			else {
				return 1; //가입가능한 회원 아이디 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	public int register(Connection conn, MemberDTO member) {
		
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		String sql = "INSERT INTO MEMBER VALUES (?,?,?,?)";
		try{
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,member.getM_id());
			pstmt.setString(2,member.getM_pwd());
			pstmt.setString(1,member.getM_name());
			pstmt.setString(1,member.getM_phone());
			return pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
	
}
