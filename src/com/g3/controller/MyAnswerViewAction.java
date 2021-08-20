package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.service.QuestionService;

public class MyAnswerViewAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	
	   
		HttpSession session =request.getSession();
		
		String m_id = (String) session.getAttribute("m_id");
		
		int qno = Integer.parseInt(request.getParameter("q_no"));
		
		System.out.println("action q_no " + qno);
		
		QuestionService  questionService = QuestionService.getInstance();
		
		int result = questionService.checkMember(m_id);
		
		request.setAttribute("result", result);
	
		System.out.println("m_id result" +result);
		
		Forward forward = new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/myPage/myQuestionDetail.jsp");
		return forward;
	}

}
