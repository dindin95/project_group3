package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.service.MemberService;

public class MemberFormResultAction implements Action {

   @Override
   public Forward execute(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      
      
      request.setCharacterEncoding("utf-8");
      
      String m_id = request.getParameter("m_id");
      String m_pwd = request.getParameter("m_pwd");
      String m_name = request.getParameter("m_name");
      String m_phone = request.getParameter("m_phone");
      
      MemberService service = MemberService.getService();
      service.register(m_id, m_pwd,m_name,m_phone);
      
      Forward f= new Forward();
         
     f.setForward(false);
     f.setPath("main.do");
     return f;
      
      
   
   }

}