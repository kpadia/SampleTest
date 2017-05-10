package com.tcs.ilp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.RegisterImpl;
import com.tcs.ilp.bean.UserBean;


public class RegisterServlet extends HttpServlet
{
	private Logger logger = Logger.getLogger(RegisterServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		logger.info("Enter into the doPost() method of RegisterServlet.java");
		UserBean ub = new UserBean();
		System.out.println("Hello = "+request.getParameter("username"));		
		logger.debug("USerId = "+request.getParameter("username"));
				
		ub.setUsername(request.getParameter("username"));
		ub.setPassword(request.getParameter("passwd"));
		ub.setName(request.getParameter("name"));
		ub.setUserType(request.getParameter("usertype"));
		ub.setEmail(request.getParameter("eid"));
		ub.setContact(request.getParameter("contact"));
		
		RegisterImpl impl = new RegisterImpl();
		String msg = impl.registerUser(ub);
		if(msg.equalsIgnoreCase("Success"))
		{
			HttpSession session = request.getSession(true);	    
	        session.setAttribute("currentSessionUser",ub); 
	        System.out.println(((UserBean)session.getAttribute("currentSessionUser")).getUsername());
	        try {
			response.sendRedirect("Login.jsp");
				System.out.println("Registered successfully!");
			} catch (IOException e) {
				logger.error("IOException in doPost() method of RegisterServlet.java");
				e.printStackTrace();
		} 
		}else{
			try {
				response.sendRedirect("Login.jsp");
				out.print("You are already registered");
			
			} catch (IOException e) {
				logger.error("IOException in doPost() method of RegisterServlet.java");
				e.printStackTrace();
			} 
		}
		logger.info("Exit from the doPost() method of RegisterServlet.java");
		
	}
}
