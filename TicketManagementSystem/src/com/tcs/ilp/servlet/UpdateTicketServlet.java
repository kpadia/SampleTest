package com.tcs.ilp.servlet;

import java.awt.Checkbox;
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
import com.tcs.ilp.DAO.UpdateTicketImpl;
import com.tcs.ilp.bean.TicketBean;


public class UpdateTicketServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(UpdateTicketServlet.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.info("Enter into the doPost() method of UpdateTicketServlet.java");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession(false); 
        String username=(String)session.getAttribute("uname");  
        out.print("Hello "+username);  
        

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
		UpdateTicketImpl impl = new UpdateTicketImpl();
		ArrayList<TicketBean> ticketArrUpdate = impl.updateUser(tb);
		
		request.setAttribute("ticketArrUpdate", ticketArrUpdate);
		session.setAttribute("ticketArrUpdate", ticketArrUpdate);

			if(ticketArrUpdate.size() > 0)
			{    
				
				response.sendRedirect("UpdateTicket.jsp");
				System.out.println("ticketArr = "+ticketArrUpdate.size());
			}else
			{
				response.sendRedirect("UpdateTicket.jsp");
				out.print("NO RECORDS FOUND"); 
			}
		logger.info("Exit from the doPost() method of UpdateTicketServlet.java");
		
	}
	
	
}
