package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.LoginDTO;
import com.g3.dto.MyPageDTO;
import com.g3.service.MyPageService;

public class MyPageModifyAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("MyPageModifyAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		
		String m_name = request.getParameter("m_name");
		String m_pwd = request.getParameter("m_pwd");
		String m_phone = request.getParameter("m_phone");

		MyPageDTO dto = new MyPageDTO();
		dto.setM_name(m_name);
		dto.setM_pwd(m_pwd);
		dto.setM_phone(m_phone);

		MyPageService service = MyPageService.getService();
		service.myPageModify(dto, m_id);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/myPage/myPageList.jsp");

		return forward;
		
		
	}


}