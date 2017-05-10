package com.tcs.ilp.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;

import com.tcs.ilp.DAO.TTypeConfigImpl;
import com.tcs.ilp.bean.TicketBean;


public class TTypeRemoveServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        TicketBean tb = new TicketBean();
        tb.setTicketType(request.getParameter("ttype"));
        System.out.print("Ticket Type for remove in servlet == "+request.getParameter("ttype"));
       TTypeConfigImpl impl = new TTypeConfigImpl();
       String msg = impl.tTypeRemove(tb);
        System.out.println("stmt = "+msg);

       
        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("TicketTypeConfiguration.jsp");
        	out.print("Ticket status removed successfully!!!");
        }else{
        	response.sendRedirect("TTypeConfigRemove.jsp");
        	out.print("Some error occured!!!");
        }
        
    }
}