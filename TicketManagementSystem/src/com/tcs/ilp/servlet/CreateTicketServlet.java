package com.tcs.ilp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.CreateTicketImpl;
import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.bean.UserBean;


public class CreateTicketServlet extends HttpServlet
{
	
	private Logger logger = Logger.getLogger(CreateTicketServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {  
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();  
		request.getRequestDispatcher("Login.jsp");
		HttpSession session = request.getSession(false); 
		String u = (String)session.getAttribute("uname");
		System.out.println("Created by == "+u);
		if(u != null){
			
			logger.info("Enter into the doPost() method of CreateTicketServlet.java");
			UserBean ub = new UserBean();
			TicketBean tb = new TicketBean();
			
			
			tb.setTicketType(request.getParameter("ttype"));
			tb.setTicketDesc(request.getParameter("tdesc"));
			ub.setUsername(u);
			System.out.println("user created = "+ub.getUsername());
			
			CreateTicketImpl impl = new CreateTicketImpl();
			String msg = impl.createUser(tb, ub);
			if(msg.equalsIgnoreCase("Success"))
	    	{
	    		request.getRequestDispatcher("CreateTicket.jsp").forward(request, response);    
	    		out.println("Hello "+u+"\nThank You "+u+", Your ticket has been created successfully!!");
	    		
	    	}
	    	else{
	    		out.print("please enter description");
	    	}
	    }else{
	    	response.sendRedirect("Login.jsp");
	    	out.print("Login First!!");
	    }
	    logger.info("Exit from the doPost() method of CreateTicketServlet.java");
		
	}
}
