package com.tcs.ilp.servlet;

import java.io.IOException;  
import java.io.PrintWriter;
import javax.servlet.ServletException;  

import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.tcs.ilp.DAO.TTypeConfigImpl;
import com.tcs.ilp.bean.TicketBean;
import com.tcs.ilp.bean.UserBean;

public class TTypeAddServlet extends HttpServlet {  
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        
        //Calling username through session
        HttpSession session = request.getSession(false); 
        String uname = (String) session.getAttribute("uname");
        System.out.println("usernsme through session =="+uname);
       
        TicketBean tb = new TicketBean();
        UserBean ub = new UserBean();
        
        tb.setTicketType(request.getParameter("ttype"));
        System.out.println("ticket type in jsp="+request.getParameter("ttype"));
        
        ub.setUsername(uname);
        
       TTypeConfigImpl impl = new TTypeConfigImpl();
       String msg = impl.tTypeAdd(tb, ub);
        System.out.println("stmt = "+msg);

       
        if(msg.equalsIgnoreCase("Success")){
        	response.sendRedirect("TicketTypeConfiguration.jsp");
        	out.print("Ticket status added successfully!!!");
        }else{
        	response.sendRedirect("TTypeConfigAdd.jsp");
        	out.print("Some error occured!!!");
        }
        
    }
}