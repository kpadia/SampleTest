package com.tcs.ilp.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.DAO.TStatusConfigImpl;
import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.bean.UserBean;

public class TStatusUpdateServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, 

IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //Calling username through session
        HttpSession session = request.getSession(false); 
        String uname = (String) session.getAttribute("uname");
        System.out.println("usernsme through session =="+uname);
       
        TicketBean tb = new TicketBean();
        UserBean ub = new UserBean();
        
        
        
        tb.setTicketStatus(request.getParameter("tstatus"));
        tb.setStatus(request.getParameter("status"));
        tb.setTicketStatusId(Integer.parseInt(request.getParameter("tstatusid")));
        ub.setUsername(uname);
        
       TStatusConfigImpl impl = new TStatusConfigImpl();
       String msg = impl.tStatusUpdate(tb, ub);
        System.out.println("stmt = "+msg);

       
        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("TicketStatusConfiguration.jsp");
        	out.print("Ticket status added successfully!!!");
        }else{
        	response.sendRedirect("TStatusConfigUpdate.jsp");
        	out.print("Some error occured!!!");
        }
        
    }
}