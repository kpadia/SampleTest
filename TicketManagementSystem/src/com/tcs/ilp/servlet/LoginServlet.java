package com.tcs.ilp.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.tcs.ilp.DAO.LoginImpl;
import com.tcs.ilp.bean.UserBean;


public class LoginServlet extends HttpServlet
{
	private Logger logger = Logger.getLogger(LoginServlet.class);
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		logger.info("Enter into the doPost() method of LoginServlet.java");
		UserBean ub = new UserBean();
		System.out.println("Hello = "+request.getParameter("username"));		
		logger.debug("username = "+request.getParameter("username"));
				
		ub.setUsername(request.getParameter("username"));
		ub.setPassword(request.getParameter("passwd"));
		ub.setUserType(request.getParameter("usertype"));
		logger.debug("UserType = "+request.getParameter("usertype"));
		
		LoginImpl impl = new LoginImpl();
		String msg = impl.validateUser(ub);
		System.out.println("msg = "+msg);	
		System.out.println("test = " +ub.getUsername());
		
		String u = request.getParameter("username");
		String ut = request.getParameter("usertype");
		System.out.println("User name session == "+u);
		System.out.println("User Type Session = "+ut);
		
			if(msg.equalsIgnoreCase("Success"))
			{
				HttpSession session = request.getSession();
				session.setAttribute("uname",u);
				session.setAttribute("utype", ut);
				try
				{
					System.out.println("ub.getUserType() = "+ub.getUserType());		
					if(ub.getUserType().equals("C"))
						response.sendRedirect("UserHomePage.jsp");
					if(ub.getUserType().equals("I"))
						response.sendRedirect("ISHomePage.jsp");
					if(ub.getUserType().equals("A"))
						response.sendRedirect("AdminHomePage.jsp");
					out.print("Welcome "+u);
				}
				catch (IOException e)
				{
					logger.error("IOException in doPost() method of LoginServlet.java");
					e.printStackTrace();
				}
			}
			else
			{
				try
				{
					request.getRequestDispatcher("Login.jsp").include(request, response);
					out.print("Username or Password is incorrect!!!");
				}
				catch (IOException | ServletException e)
				{
					logger.error("IOException in doPost() method of LoginServlet.java");
					e.printStackTrace();
				} 
			}
		logger.info("Exit from the doPost() method of LoginServlet.java");
		
	}
}
