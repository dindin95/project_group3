package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.service.QuestionService;

public class AnswerRemoveAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		
		int qno = Integer.parseInt(request.getParameter("q_no"));
		int ano = Integer.parseInt(request.getParameter("a_no"));
		
                           
	    System.out.println(qno+" and "+ano);
		
		HttpSession session =request.getSession();			
		String m_id = (String) session.getAttribute("m_id");
		
		
		
		QuestionService service = QuestionService.getInstance();
		int result = service.checkMember(m_id);
		

		System.out.println("add actuion result" + result);
		if(result == 1) {
			
			service.answerRemove(ano,qno);
			
		}
		
		Forward forward = new Forward();
		forward.setForward(false);
		forward.setPath("questiondetail.do?q_no="+qno);
		
		
		return forward;
	}

}
