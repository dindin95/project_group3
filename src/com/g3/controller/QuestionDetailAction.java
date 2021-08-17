package com.g3.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.QuestionDTO;
import com.g3.service.QuestionService;

public class QuestionDetailAction implements Action{

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String n=request.getParameter("q_no");
		
		int questionnum=1;
		if(n!=null && !n.equals(""))
		{
			questionnum=Integer.parseInt(n);
		}
		
		QuestionService service = QuestionService.getInstance();
		QuestionDTO dto = service.detail(questionnum);
		
		request.setAttribute("dto", dto);
		
		Forward f=new Forward();
		f.setForward(true);
		f.setPath("WEB-INF/question/questiondetail.jsp");
		  
		return f;
	}
	

}
