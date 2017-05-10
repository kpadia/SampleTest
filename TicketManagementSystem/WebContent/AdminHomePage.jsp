<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<% String username = (String)session.getAttribute("uname"); %>
	<h1>Admin Home Page</h1><br/>
	<a href="TicketStatusConfiguration.jsp">Ticket Status Configuration</a><br /><br />
	<a href="TicketTypeConfiguration.jsp">Ticket Type Configuration</a><br /><br />
	
	<div class="topcorner">
	<a href="logoutServlet">Logout</a>
	</div>
	
</body>
</html>