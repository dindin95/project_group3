package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.service.MyPageService;

public class MemberDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
				
		MyPageService service = MyPageService.getService();
		service.memberDelete(m_id);
		
		Forward f = new Forward();
		f.setForward(false);
		f.setPath("main.do");
		
		
		session.invalidate(); //기존의 세션 데이터를 모두 삭제
		
		return f;
		
		
	}

}