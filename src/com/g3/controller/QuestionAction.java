package com.g3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.QuestionDTO;
import com.g3.service.QuestionService;


public class QuestionAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 request.setCharacterEncoding("utf-8");	
			
		  String curr=request.getParameter("curr");
		  
		   int currpage=1;
		   if(curr!=null)
		   {
			   currpage=Integer.parseInt(curr);
		   }
			
		 String search=request.getParameter("search");
		 String searchtxt=request.getParameter("searchtxt");
		 
		 if(search==null) search="";
		 if(searchtxt==null) searchtxt="";
		   
	    //전체 자료갯수
		 QuestionService service=QuestionService.getInstance();
		 int totalcount= service.getTotalCount(search, searchtxt);
		 int pagepercount= 3;  //1페이지에 보여줄 자료수
		 
		 int totalpage=(int) Math.ceil((float)totalcount/pagepercount);
				 
		 int startrow=(currpage-1)*pagepercount+1;
		 int endrow=startrow+pagepercount-1;
		 
		 if(endrow>totalcount)
			 endrow=totalcount;
		 
		 
		 int blockcount=3;
		 int startblock=(currpage-1)/blockcount*blockcount+1;
		 int endblock=startblock+blockcount-1;
		 
		 if(endblock>totalpage)
		 {
			 endblock=totalpage;
		 }
		 
		
		List<QuestionDTO> list = service.getList(startrow,endrow,search,searchtxt);
		request.setAttribute("list", list);
		request.setAttribute("currpage", currpage);
		request.setAttribute("datacount", list.size());
		request.setAttribute("startblock", startblock);
		request.setAttribute("endblock", endblock);
		request.setAttribute("totalpage", totalpage);
		request.setAttribute("search", search);
		request.setAttribute("searchtxt", searchtxt);
		 
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/question/question.jsp");
		
		
		return forward;
	}
	

}
