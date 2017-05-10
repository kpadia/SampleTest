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

import com.tcs.ilp.DAO.TTypeConfigImpl;
import com.tcs.ilp.bean.TicketBean;


public class TTypeConfigServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(TTypeConfigServlet.class);
	
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		logger.info("Enter into the doPost() method of TTypeConfigServlet.java");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();  
		HttpSession session=request.getSession(false); 
        String u=(String)session.getAttribute("username");  
        System.out.print("Hello "+u);  
        

		TicketBean tb = new TicketBean();
		
		if(!request.getParameter("ttype").isEmpty() || request.getParameter("ttype").length() > 0)
			tb.setTicketStatus(request.getParameter("ttype"));
		if(!request.getParameter("status").isEmpty() || request.getParameter("status").length() > 0)
			tb.setStatus(request.getParameter("status"));
		
		
		TTypeConfigImpl impl = new TTypeConfigImpl();
		ArrayList<TicketBean> ticketArr = impl.tTypeConfig(tb);
		
		request.setAttribute("ticketArr", ticketArr);
		session.setAttribute("ticketArr", ticketArr);
		
			if(ticketArr.size() > 0)
			{    
				RequestDispatcher view = request.getRequestDispatcher("TicketTypeConfiguration.jsp");
				view.forward(request,response);
				System.out.println("ticketArr = "+ticketArr.size());
			}else
			{
				out.print("NO RECORDS FOUND"); 
			}
		
		
		logger.info("Exit from the doPost() method of TTypeConfigServlet.java");
		
	}
	
	
}

