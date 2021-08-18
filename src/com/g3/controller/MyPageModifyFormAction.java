package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.MyPageDTO;
import com.g3.service.MyPageService;

public class MyPageModifyFormAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("MyPageModifyFormAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		
		MyPageService service = MyPageService.getService();
		
		MyPageDTO dto = service.getMyPageList(m_id);
		request.setAttribute("dto", dto);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/myPage/myPageModifyForm.jsp");

		return forward;
		
		
	}


}