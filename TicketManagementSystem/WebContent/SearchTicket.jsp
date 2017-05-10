<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.bean.TicketBean" import="com.tcs.ilp.utility.ConnectionManager"
	import="java.sql.Connection" import="java.sql.ResultSet" import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Ticket</title>
</head>
<body>
<%//redirect user to index page if not logged in
	String u = (String)session.getAttribute("uname");
	String ut = (String)session.getAttribute("utype");
	System.out.println("Username in jsp == "+u);
	if(u == null){
		response.sendRedirect("Login.jsp");
		out.print("Login first!!");
	}else{
	%>
	<% 	System.out.println("ticketArr on jsp from session="+(ArrayList<TicketBean>) session.getAttribute("ticketArrSearch"));
	ArrayList<TicketBean> ticketArrSearch = (ArrayList<TicketBean>) session.getAttribute("ticketArrSearch");
	%>
	<form name="searchTicket" method="post" action="searchTicketServlet">
	<h1>Search Ticket</h1>
<%try{
	ConnectionManager connManager = new ConnectionManager();		
	
	Connection conn = connManager.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	stmt=conn.createStatement();
	
%>
<label>Ticket ID : </label><input type="text" name="ticketid" value="" />
<label>Ticket Type : </label><select name="ttype" id="ttype">
			<option value=""></option>
			<%	String msg = "SELECT T.TICKET_TYPE FROM TCK_TYPE_MST T WHERE T.STATUS='A' ";
				rset = stmt.executeQuery(msg);
				System.out.println("Query :: "+rset);
				while(rset.next()){
					String ttype=rset.getString("ticket_type");
								%>
								<option value="<%=ttype%>"><%=ttype%></option>
								<%}%>
		</select><br /></br>
 <label>Assigned To : </label><select name="tassignedto" id="tassignedto">
 								<option value=""></option>
 								<%	String sql = "SELECT T.USER_NAME FROM TCK_USERS T WHERE T.USER_TYPE='I'";
				rset = stmt.executeQuery(sql);
				System.out.println("Query :: "+rset);
				while(rset.next()){
					String tassignedto=rset.getString("user_name");
								%>
								<option value="<%=tassignedto%>"><%=tassignedto%></option>
								<%}%>
 								</select>	
<label>	Ticket Status : </label><select name="tstatus" id="tstatus">
			<option value=""></option>
			<%	String query = "SELECT T.TICKET_STATUS FROM TCK_STATUS_MST T WHERE T.STATUS='A'";
				rset = stmt.executeQuery(query);
				System.out.println("Query :: "+rset);
				while(rset.next()){
					String tstatus=rset.getString("ticket_status");
				%>
				<option value="<%=tstatus%>"><%=tstatus%></option>
				<%}%>
		</select><br/><br/>
<%rset.close();
stmt.close();
}catch(Exception e){
	e.printStackTrace();
} %>
			<input type="checkbox" name="checkbox" value="">UnAssigned Tickets<br/><br/>		 
		 <input type="submit" name="searchButton" value="Search"><br /><br/>
		 <table>
   		<thead>
			<tr>
				<th>Ticket ID</th>
				<th>Ticket Type</th>
				<th>Ticket Description</th>
				<th>Ticket Status</th>
				<th>Assigned To</th>
				
			</tr>
		</thead>
		<tbody>
			<%if(ticketArrSearch != null){ 
			Iterator<TicketBean> iter = ticketArrSearch.iterator();
			while(iter.hasNext()){
				TicketBean ticketbean =iter.next();
			%>
			<tr>
				
				<td><%=ticketbean.getTicketId()%></td>
				<td><%=ticketbean.getTicketType()%></td>
				<td><%=ticketbean.getTicketDesc()%></td>
				<% if(ticketbean.getTicketStatus() != null){ %>
					<td><%=ticketbean.getTicketStatus()%></td>
					<%}else{ %>
					<td></td><%} %>
				<% if(ticketbean.getTicketAssignedTo() != null){ %>
				<td><%=ticketbean.getTicketAssignedTo()%></td>
				<%}else{ %>
				<td></td><%} %>
				
	       </tr>
	       <%}} %>
		</tbody>
</table>
		 
		 <div class="topcorner">
		<%if(ut.equals("C")){ %>
		<a href="UserHomePage.jsp">Home</a>
		<%}else{%>
			<a href="UserHomePage.jsp">Home</a>
		<%} %>
		<a href="logoutServlet">Logout</a>
		</div>

	</form>
<%} %>
</body>
</html>