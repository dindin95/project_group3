package com.g3.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.g3.comm.Action;
import com.g3.comm.Forward;
import com.g3.dto.BookingListDTO;
import com.g3.service.BookingListService;


/**
 * Servlet implementation class ReplyViewAction
 */
@WebServlet("/bookingList.data")
public class CalendarList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalendarList() {
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
		BookingListService  service = BookingListService.getService();
		
		
	
		List<BookingListDTO> bookingList = service.getBookingList();
		

		   PrintWriter out = response.getWriter(); 

		JSONArray jsonArray = new JSONArray();
		
		for(BookingListDTO dto:bookingList) {
		JSONObject data = new JSONObject();
		data.put("title",dto.getM_id());
		data.put("start", dto.getBo_date().toString());
		data.put("end", dto.getBo_date().toString());
		jsonArray.add(data);

		}
		

		out.print(jsonArray);


	}

}
