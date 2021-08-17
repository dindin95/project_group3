package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.LoginDAO;


public class LoginService {

	//싱글톤
	private static LoginService service = new LoginService();
	
	public static LoginService getService() {
		return service;
	}
	
	private LoginService() {}
	
	//로그인정보확인 
	public int check(String id, String pwd) {
		
		DBConnection dbconn = DBConnection.getDBConn();
		Connection conn = null;
		
		int result =0;
		try{
			conn=dbconn.getConnection();
			
			conn.setAutoCommit(false);
			
			LoginDAO dao = LoginDAO.getdao();
			result =  dao.check(conn, id, pwd);
			
			System.out.println("result  " + result);

			conn.commit();
		}catch(SQLException |NamingException e ){
			System.out.println(e);
			
			try {conn.rollback();} catch(SQLException e2) {}
			
		}finally {
			if(conn !=null) try {conn.close();} catch(SQLException e) {}
		}
		
		return result;
	}
	
	
}
