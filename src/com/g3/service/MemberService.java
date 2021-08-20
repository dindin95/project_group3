package com.g3.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.NamingException;

import com.g3.comm.DBConnection;
import com.g3.dao.MemberDAO;


public class MemberService {
   
   private static MemberService service = new MemberService();
   public static MemberService getService() {
      return service;
   }
   
   private MemberService() {}
   
   
   //회원가입 insert
   public void register(String m_id, String m_pwd, String m_name, String m_phone) {
      DBConnection dbconn = DBConnection.getDBConn();
      Connection conn = null;
      
      try{
         conn=dbconn.getConnection();
         
         conn.setAutoCommit(false);
         
         MemberDAO dao = MemberDAO.getdao();
         dao.register(conn, m_id, m_pwd, m_name, m_phone); 
         
         conn.commit();
      }catch(SQLException |NamingException e ){
         System.out.println(e);
         
         try {conn.rollback();} catch(SQLException e2) {}
         
      }finally {
         if(conn !=null) try {conn.close();} catch(SQLException e) {}
      }
      
   }

}


   
   
