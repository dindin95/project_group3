package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.service.LoginService;

import javafx.scene.control.Alert;

public class LoginResultAction implements Action {

	@Override
	public com.g3.comm.Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String m_id = request.getParameter("m_id");
		String m_pwd = request.getParameter("m_pwd");
		
		System.out.println(m_id);
		System.out.println(m_pwd);
		
		LoginService service = LoginService.getService();
		int result = service.check(m_id,m_pwd);
		
		Forward f = new Forward();
		HttpSession session =request.getSession();//세션정보를 가지고와서 id를 묶어주기

		if(result==1) { 
			request.setAttribute("result", result); 

			session.setAttribute("m_id", m_id); 
			session.setMaxInactiveInterval(60*30); //로그인유지 시간 30분 

			f.setForward(false);
			f.setPath("main.do");
			return f;

		} else {
			
			f.setForward(false);
			f.setPath("login.do");
			String Msg = "아이디 또는 비밀번호를 확인해주세요.";
			session.setAttribute("Msg", Msg); 
			
			return f;
		}

	}

}
