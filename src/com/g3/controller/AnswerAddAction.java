package com.g3.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.AnswerDTO;
import com.g3.service.QuestionService;

public class AnswerAddAction implements Action{

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	
		request.setCharacterEncoding("utf-8");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String aContent = request.getParameter("answer");



		HttpSession session =request.getSession();			
		String m_id = (String) session.getAttribute("m_id");
		
		AnswerDTO answerDTO = new AnswerDTO();
		answerDTO.setQ_no(qno);
		answerDTO.setA_content(aContent);

		
		QuestionService service = QuestionService.getInstance();
		int result = service.checkMember(m_id);
		

		System.out.println("add actuion result" + result);
		if(result == 1) {
			
		 service.answerAdd(answerDTO);
			
		}
		
		Forward forward = new Forward();
		forward.setForward(false);
		forward.setPath("questiondetail.do?q_no="+qno);
		
		return forward;
	}

}
