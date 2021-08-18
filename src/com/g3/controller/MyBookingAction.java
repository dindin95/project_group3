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
import com.g3.dto.QuestionDTO;
import com.g3.service.MyPageService;

public class MyBookingAction implements Action {

	@Override
	public Forward execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		System.out.println("MyBookingAction");
		
		HttpSession session =request.getSession();
		String m_id = (String) session.getAttribute("m_id");
		/*
		 * String curr=request.getParameter("curr");
		 * 
		 * int currpage=1; if(curr!=null){ currpage=Integer.parseInt(curr); }
		 * 
		 * 
		 * MyPageService service=MyPageService.getService();
		 * 
		 * //전체 자료갯수 int totalcount= service.getTotalCount(m_id);
		 * 
		 * int pagepercount= 10; //1페이지에 보여줄 자료수
		 * 
		 * int totalpage=(int) Math.ceil((float)totalcount/pagepercount);
		 * 
		 * int startrow=(currpage-1)*pagepercount+1; int endrow=startrow+pagepercount-1;
		 * 
		 * if(endrow>totalcount) endrow=totalcount;
		 * 
		 * int blockcount=3; int startblock=(currpage-1)/blockcount*blockcount+1; int
		 * endblock=startblock+blockcount-1;
		 * 
		 * if(endblock>totalpage) { endblock=totalpage; }
		 * 
		 * 
		 * 
		 * List<BookingListDTO> list = service.getList(startrow,endrow, m_id);
		 * 
		 * request.setAttribute("list", list); request.setAttribute("currpage",
		 * currpage); request.setAttribute("datacount", list.size());
		 * request.setAttribute("startblock", startblock);
		 * request.setAttribute("endblock", endblock); request.setAttribute("totalpage",
		 * totalpage);
		 */
		 
		
		Forward forward=new Forward();
		forward.setForward(true);
		forward.setPath("WEB-INF/question/myBookingList.jsp");
		
		
		return forward;
		
	}


}