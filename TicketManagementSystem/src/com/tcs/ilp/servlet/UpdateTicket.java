package com.tcs.ilp.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;  

import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.UpdateTicketImpl;
import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.utility.ConnectionManager;  

public class UpdateTicket extends HttpServlet {
	private Logger logger = Logger.getLogger(UpdateTicket.class);
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        logger.info("Enter into the doPost() method of UpdateTicket.java");
        
        TicketBean tb = new TicketBean();
        
        tb.setTicketId(Integer.parseInt(request.getParameter("ticketid")));
        tb.setTicketType(request.getParameter("ttype"));
        tb.setTicketDesc(request.getParameter("tdesc"));
        tb.setTicketStatus(request.getParameter("tstatus"));
        tb.setTicketAssignedTo(request.getParameter("tassignedto"));
        
        UpdateTicketImpl impl = new UpdateTicketImpl();
        String msg = impl.updateTable(tb);
        System.out.println("stmt = "+msg);

        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("UpdateTicket.jsp");
        	out.print("Ticket updated Successfully!!!");
        }else{
        	
        	out.print("Some error occured!!!");
        }
        logger.info("Exit from the doGet() method of UpdateTicket.java"); 
    }
}