<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Home Page</title>
</head>
<body>
<% String username = (String)session.getAttribute("uname"); %>
	<h1>Home Page</h1><br/>
	<a href="CreateTicket.jsp">Create Ticket</a><br /><br />
	<a href="UpdateTicket.jsp">Update Ticket</a><br /><br />
	<a href="SearchTicket.jsp">Search Ticket</a><br /><br />
	<div class="topcorner">
	Welcome <%=username %><br/><br/>
	<a href="logoutServlet">Logout</a>
	
	</div>
</body>
</html>