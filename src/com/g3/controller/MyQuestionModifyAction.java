package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.QuestionDTO;
import com.g3.service.QuestionService;

public class MyQuestionModifyAction implements Action{

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int q_no = Integer.parseInt(request.getParameter("q_no"));
		
		//서비스 불러오기
		QuestionService service = QuestionService.getInstance();
		QuestionDTO dto = service.getQuestion(q_no);
		
		request.setAttribute("dto", dto);
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/myPage/myQuestionModify.jsp");
		
		
		return forward;
	}

}
