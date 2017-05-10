package com.tcs.ilp.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import com.tcs.ilp.DAO.TStatusConfigImpl;
import com.tcs.ilp.bean.TicketBean;


public class TStatusRemoveServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        
        TicketBean tb = new TicketBean();
        tb.setTicketStatus(request.getParameter("tstatus"));
        
        System.out.print("Ticket Status for remove in servlet == "+request.getParameter("tstatus"));
       TStatusConfigImpl impl = new TStatusConfigImpl();
       String msg = impl.tStatusRemove(tb);
        System.out.println("stmt = "+msg);

       
        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("TicketStatusConfiguration.jsp");
        	out.print("Ticket status removed successfully!!!");
        }else{
        	response.sendRedirect("TStatusConfigRemove.jsp");
        	out.print("Some error occured!!!");
        }
        
    }
}