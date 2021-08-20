package com.g3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.g3.dao.AnswerDAO;
import com.g3.dto.AnswerDTO;
import com.g3.dto.MemberDTO;
import com.g3.service.QuestionService;


/**
 * Servlet implementation class ReplyViewAction
 */
@WebServlet("/answerView.data")
public class AnswerViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AnswerViewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRep(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doRep(request, response);
	}

	private void doRep(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		request.setCharacterEncoding("utf-8");

		response.setContentType("application/json;charset=utf-8");

		response.setCharacterEncoding("utf-8");
	
		System.out.println("?????????????????  ");
		
		
		int qno = Integer.parseInt(request.getParameter("q_no"));
		

		QuestionService questionService = QuestionService.getInstance();
		

		List<AnswerDTO> answerView = questionService.replyView(qno);

	

		PrintWriter out = response.getWriter(); 
		////a_no, q_no, a_content, a_writeDate, m_id
		
		
		JSONArray arr = new JSONArray();
		for(AnswerDTO dto : answerView  ) {
			JSONObject obj = new JSONObject();
		
			obj.put("a_no", dto.getA_no());
			obj.put("q_no", dto.getQ_no());
			obj.put("a_content", dto.getA_content());
			obj.put("a_writeDate", dto.getA_writeDate().toString());
			obj.put("m_id", dto.getM_id());
			arr.add(obj);
	    	
		}
		
		out.print(arr);
	}

}
