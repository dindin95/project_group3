package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.QuestionDTO;
import com.g3.service.QuestionService;

public class QuestionWriteAction implements Action{

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		/*
		 * request.setCharacterEncoding("utf-8");
		 * 
		 * 
		 * String q_title = request.getParameter("q_title"); String q_content =
		 * request.getParameter("q_content"); String m_id =
		 * request.getParameter("m_id");
		 * 
		 * QuestionService service = QuestionService.getInstance(); QuestionDTO dto =
		 * new QuestionDTO();
		 * 
		 * dto.setQ_title(q_title); dto.setQ_content(q_content); dto.setM_id(m_id);
		 * 
		 * service.insertQuestion(dto);
		 */
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/question/questionwrite.jsp");
		System.out.println("성공");
		return forward;
	}

}
