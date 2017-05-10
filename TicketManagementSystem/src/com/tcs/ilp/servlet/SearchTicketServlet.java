package com.tcs.ilp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.SearchTicketImpl;
import com.tcs.ilp.bean.TicketBean;


public class SearchTicketServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(SearchTicketServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.info("Enter into the doPost() method SearchTicketServlet.java");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession(false); 
			
		
		TicketBean tb = new TicketBean();
		
		if(!request.getParameter("ticketid").isEmpty() || request.getParameter("ticketid").length() > 0)
			tb.setTicketId(Integer.parseInt(request.getParameter("ticketid")));
		if(!request.getParameter("ttype").isEmpty() || request.getParameter("ttype").length() > 0)
			tb.setTicketType(request.getParameter("ttype"));
		if(!request.getParameter("tassignedto").isEmpty() || request.getParameter("tassignedto").length() > 0)
			tb.setTicketAssignedTo(request.getParameter("tassignedto"));
		if(!request.getParameter("tstatus").isEmpty() || request.getParameter("tstatus").length() > 0)
			tb.setTicketStatus(request.getParameter("tstatus"));
		
		tb.setCheckbox(request.getParameterValues("checkbox"));
		System.out.println("Checkbox value = "+tb.getCheckbox());
		
		SearchTicketImpl impl = new SearchTicketImpl();
		ArrayList<TicketBean> ticketArrSearch = impl.searchUser(tb);
		request.setAttribute("ticketArrSearch", ticketArrSearch);
		session.setAttribute("ticketArrSearch", ticketArrSearch);
		
		
			if(ticketArrSearch.size() > 0)
			{    
				response.sendRedirect("SearchTicket.jsp");
					System.out.println("ticketArr = "+ticketArrSearch.size());
			}
			else{
				response.sendRedirect("SearchTicket.jsp");
				out.print("No records found");
				out.close();
			}
		
		
		logger.info("Exit from the doPost() method of SearchTicketServlet.java");
		
	}
}
