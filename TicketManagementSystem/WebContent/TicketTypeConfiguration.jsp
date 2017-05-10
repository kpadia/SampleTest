<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.bean.TicketBean" import="com.tcs.ilp.utility.ConnectionManager"
	import="java.sql.Connection" import="java.sql.ResultSet" import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Type Configuration</title>

</head>
<body>
<%
	
	//redirect user to index page if not logged in
	String u = (String)session.getAttribute("uname");
	System.out.println("Username on update jsp == "+u);
	if(u == null){
		response.sendRedirect("Login.jsp");
		out.print("Login first!!");
	}else{
	%>
<% 	System.out.println("ticketArr on jsp from session="+(ArrayList<TicketBean>) session.getAttribute("ticketArr"));
ArrayList<TicketBean> ticketArr = (ArrayList<TicketBean>) session.getAttribute("ticketArr");
%>
<form name="ticketTypeConfig" method="post" action="tTypeConfigServlet">
	<h1>Ticket Type Configuration</h1><br/>
	<%try{
	ConnectionManager connManager = new ConnectionManager();		
	
	Connection conn = connManager.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	stmt=conn.createStatement();
	
%>
		<p><label>Ticket Type : </label><select name="ttype" id="ttype">
		<option value=""></option>
		<%	String msg = "SELECT T.TICKET_TYPE FROM TCK_TYPE_MST T WHERE STATUS='A'";
				rset = stmt.executeQuery(msg);
				System.out.println("Query :: "+rset);
				while(rset.next()){
					String ttype=rset.getString("ticket_type");
				%>
				<option value="<%=ttype%>"><%=ttype%></option>
				<%}%>
		 </select>
<%rset.close();
stmt.close();
}catch(Exception e){
	e.printStackTrace();
} %>
		<label>Status : </label><select name="status" id="status">
			<option value=""></option>
			<option value="A">Active</option>
			<option value="I">In-Active</option>			
		</select>
	  <input type="submit" name="searchButton" value="search" ><br/><br/>
			<a href="javascript:window.open('TTypeConfigAdd.jsp', 'AddTypePopup', 'width=400,height=400');">Add</a>
			
		</p>
		<table>
   		<thead>
			<tr>
				<th style="visibility: hidden;">Ticket Type Id</th>
				<th>Ticket Type</th>
				<th>Status</th>
				<th>Created By</th>
				<th>Created Date</th>
				<th>Updated By</th>
				<th>Updated Date</th>
				<th></th>
				<th></th>
			</tr>
		</thead>
		<tbody>
			<%if(ticketArr != null){ 
			Iterator<TicketBean> iter = ticketArr.iterator();
			while(iter.hasNext()){
				TicketBean ticketbean =iter.next();
			%>
			<tr>
				<td style="visibility: hidden;"><%=ticketbean.getTicketTypeId() %></td>
				<td><%=ticketbean.getTicketType()%></td>
				<td><%=ticketbean.getStatus()%></td>
				<td><%=ticketbean.getTicketCreatedBy()%></td>
				<td><%=ticketbean.getTicketCreatedDate()%></td>
				<td><%=ticketbean.getTicketUpdateBy()%></td>
				<td><%=ticketbean.getTicketUpdatedDate()%></td>
				<td><a href="javascript:window.open('TTypeConfigRemove.jsp?ttype=<%=ticketbean.getTicketType()%>', 'RemoveTypePopup', 'width=400,height=400');">Remove</a></td>
				<td><a href="javascript:window.open('TTypeConfigUpdate.jsp?ttype=<%=ticketbean.getTicketType()%>&status=<%=ticketbean.getStatus()%>&ttypeid=<%=ticketbean.getTicketTypeId()%>', 'UpdateTypePopup', 'width=400,height=400');">Update</a></td>
	       </tr>
	       <%}} %>
		</tbody>
</table>
		

		<div class="topcorner">
		<a href="AdminHomePage.jsp">Home</a>
		<a href="logoutServlet">Logout</a>
		</div>
	</form>
	<%} %>
</body>
</html>