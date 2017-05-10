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

import com.tcs.ilp.DAO.DeleteTicketImpl;
import com.tcs.ilp.bean.TicketBean;


public class DeleteTicketServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(DeleteTicketServlet.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws 

ServletException, IOException{
		logger.info("Enter into the doPost() method of DeleteTicketServlet.java");
		
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession(false); 
		
		TicketBean tb = new TicketBean();
		
		if(!request.getParameter("ticketid").isEmpty() || request.getParameter("ticketid").length() 

> 0)
			tb.setTicketId(Integer.parseInt(request.getParameter("ticketid")));
		if(!request.getParameter("ttype").isEmpty() || request.getParameter("ttype").length() > 0)
			tb.setTicketType(request.getParameter("ttype"));
		if(!request.getParameter("tassignedto").isEmpty() || request.getParameter

("tassignedto").length() > 0)
			tb.setTicketAssignedTo(request.getParameter("tassignedto"));
		
		tb.setCheckbox(request.getParameterValues("checkbox"));
		System.out.println("Checkbox value = "+tb.getCheckbox());
		
		
		
		DeleteTicketImpl impl = new DeleteTicketImpl();
		ArrayList<TicketBean> ticketArrDelete = impl.deleteUser(tb);
		
		request.setAttribute("ticketArrDelete", ticketArrDelete);
		session.setAttribute("ticketArrDelete", ticketArrDelete);
		
			if(ticketArrDelete.size() > 0)
			{    
				RequestDispatcher view = request.getRequestDispatcher("DeleteTicket.jsp");
				view.forward(request,response);
				System.out.println("ticketArrDelete = "+ticketArrDelete.size());
			}else{
				RequestDispatcher view = request.getRequestDispatcher("DeleteTicket.jsp");
				view.forward(request,response);
				out.print("NO RECORDS FOUND");
			}
		
		
		logger.info("Exit from the doPost() method of DeleteTicketServlet.java");
		
	}
}
