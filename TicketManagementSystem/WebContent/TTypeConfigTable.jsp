<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.DAO.UpdateTicketImpl" import="com.tcs.ilp.bean.TicketBean"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<title>Table display</title>
</head>
<body>
<% ArrayList<TicketBean> ticketArr = (ArrayList<TicketBean>) session.getAttribute("ticketArr");
	System.out.println("ticketArr on jsp="+ticketArr.size());
   Iterator<TicketBean> iter = ticketArr.iterator(); %>
   
   <table>
   		<thead>
			<tr>
				<th>Ticket Status</th>
				<th>Status</th>
				<th>Created By</th>
				<th>Created Date</th>
				<th>Updated By</th>
				<th>Updated Date</th>
			</tr>
		</thead>
		<tbody>
		
				<%while(iter.hasNext()){
	
				TicketBean ticketbean = iter.next();%>
			<tr>
				<td><%=ticketbean.getTicketStatus()%></td>
				<td><%=ticketbean.getStatus()%></td>
				<td><%=ticketbean.getTicketCreatedBy()%></td>
				<td><%=ticketbean.getTicketCreatedDate()%></td>
				<td><%=ticketbean.getTicketUpdateBy()%></td>
				<td><%=ticketbean.getTicketUpdatedDate() %>
				
	       </tr>
	           <% } %>
	                 
		</tbody>
	</table>
	
	
</body>
</html>
