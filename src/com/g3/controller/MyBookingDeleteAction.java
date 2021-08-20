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
import com.g3.dto.MybookingDTO;
import com.g3.dto.QuestionDTO;
import com.g3.service.MyPageService;
import com.g3.service.QuestionService;

public class MyBookingDeleteAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("MyBookingDeleteAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		
		int bo_no = Integer.parseInt(request.getParameter("bo_no"));
		System.out.println(">>>> " + bo_no );
		
		 MyPageService service=MyPageService.getService();
		service.myBookingDelete(bo_no);
		
		Forward forward=new Forward();
		forward.setForward(false);
		
		System.out.println("????????????????????????????? 여깃!!!!!!!!!!" + m_id);
		
		forward.setPath("myBookingList.do?m_id=" + m_id);
		  
		
		return forward;
		
	}


}