package com.g3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.g3.dto.AnswerDTO;
import com.g3.dto.MemberDTO;

public class AnswerDAO {
	
	//������ Ȯ��Ȯ��
	public int checkMember(Connection conn ,String m_id) {
		
		StringBuilder sql = new StringBuilder();
		
		//(m_id, m_name, m_pwd, m_phone, m_date, m_level 1 ������
		sql.append("select               ");
		sql.append("       m_id          ");
		sql.append("      ,m_level       ");
		sql.append("      from member_g3 ");
		sql.append("      where m_id = ? ");
		
		
		ResultSet rs = null;
		int result = 0;
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setString(1, m_id);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result=(rs.getInt("m_level"));				
			}

		

		}catch (SQLException e) {
			System.out.println(e);
		}	finally {
			if(rs !=null)try {rs.close();}catch(SQLException e) {}
		}
		
		return result;
	}
	
	
//����� ������� ������
	public List<AnswerDTO> getView(Connection conn,int qno) {
		
		StringBuilder sql = new StringBuilder();
		
		//a_no, q_no, a_content, a_writeDate, m_id
		sql.append(" select               ");
		sql.append("      a_no    		  ");
		sql.append("     ,q_no     	      ");
		sql.append("     ,a_content 	  ");
		sql.append("     ,a_writeDate     ");
		sql.append("     ,m_id		 	  ");
		sql.append("    from answer_g3    ");
		sql.append(" where q_no = ?		  ");
		
		ResultSet rs = null;
		List<AnswerDTO> answerList = new ArrayList<AnswerDTO>();
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
			
			pstmt.setInt(1, qno);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				AnswerDTO answerDTO = new AnswerDTO();
				answerDTO.setA_no(rs.getInt("a_no"));
				answerDTO.setQ_no(rs.getInt("q_no"));
				answerDTO.setA_content(rs.getString("a_content"));
				answerDTO.setA_writeDate(rs.getDate("a_writeDate"));
				answerDTO.setM_id(rs.getString("m_id"));
				
				answerList.add(answerDTO);
			}
			
		}catch (SQLException e) {
			System.out.println(e);
		}finally {
			if(rs !=null)try{ rs.close();}catch(SQLException e) {}
		}
		
		return answerList;
	}


	public void answerAdd(Connection conn, AnswerDTO answerDTO) {

		System.out.println(answerDTO.getM_id());
		
		StringBuilder sql = new StringBuilder();
		sql.append(" insert into answer_g3 (         		 ");
		sql.append("               q_no   					 ");
		sql.append("              ,a_content 				 ");
		sql.append("              ,a_writeDate 				 ");
		sql.append("              ,m_id )       			 ");
		sql.append(" values ( ?,?,sysdate(),? )				 ");
		
		try(PreparedStatement pstmt= conn.prepareStatement(sql.toString());){
			
			pstmt.setInt(1, answerDTO.getQ_no());
			pstmt.setString(2, answerDTO.getA_content());
			pstmt.setString(3, answerDTO.getM_id());
			
			pstmt.executeUpdate();
			
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}


	public void answerRemove(Connection conn, int ano) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from        		");
		sql.append("            answer_g3   ");
		sql.append("  where a_no = ?        ");
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql.toString())){
			
			pstmt.setInt(1, ano);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println(e);
		}
		
	}


}
