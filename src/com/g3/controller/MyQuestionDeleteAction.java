package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dao.QuestionDAO;
import com.g3.service.QuestionService;

public class MyQuestionDeleteAction implements Action{

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("MyQuestionDeleteAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		QuestionService service = QuestionService.getInstance();
		service.delete(q_no);
		
		Forward forward=new Forward();
		forward.setForward(false);
		forward.setPath("myQuestion.do?m_id=" + m_id);
		
		return forward;
	}

}
