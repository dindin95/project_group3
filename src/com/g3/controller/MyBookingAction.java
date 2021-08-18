package com.g3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.BookingListDTO;
import com.g3.dto.QuestionDTO;
import com.g3.service.MyPageService;

public class MyBookingAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("MyBookingAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/myPage/myBookingList.jsp");
		
		
		return forward;
		
	}


}