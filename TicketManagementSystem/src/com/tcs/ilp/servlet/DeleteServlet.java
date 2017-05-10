package com.tcs.ilp.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.DeleteTicketImpl;
import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.utility.ConnectionManager;


public class DeleteServlet extends HttpServlet {
	private Logger logger = Logger.getLogger(DeleteServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		logger.info("Enter into the doPost() method of DeleteServlet.java");
		response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        TicketBean tb =new TicketBean();
        
        
			tb.setTicketId(Integer.parseInt(request.getParameter("ticketid")));
       
        DeleteTicketImpl impl = new DeleteTicketImpl();
        String msg = impl.deleteRecord(tb);
        System.out.println("delete msg == "+msg);
        
        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("DeleteTicket.jsp");
        	out.print("Ticket deleted successfully!!");
        }
        else{
        	out.print("Some error occured");
        }
        logger.info("Exit from the doPost() method of DeleteTicket.java"); 
   	}       
}