<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.bean.TicketBean" import="com.tcs.ilp.utility.ConnectionManager"
	import="java.sql.Connection" import="java.sql.ResultSet" import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css" type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update PopUp</title>
<script type="text/javascript">
function refreshAndClose() {
   
	window.opener.location.reload(true);
    window.close();
}

function Alert() {
	 alert("Ticket Update Successfully!!!");    
}
</script>

</head>


<body onunload="refreshAndClose();">
<%
	
	//redirect user to index page if not logged in
	String u = (String)session.getAttribute("uname");
	String ut = (String)session.getAttribute("utype");
	System.out.println("Username on usertype jsp == "+ut);
	System.out.println("Username on update jsp == "+u);
	if(u == null){
		response.sendRedirect("Login.jsp");
		out.print("Login first!!");
	}else{
	%>
<form name="UpdatePopup" method="get" action="updateTicket">

<h1>Update Records</h1><br/><br/>
<%try{
	ConnectionManager connManager = new ConnectionManager();		
	
	Connection conn = connManager.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	stmt=conn.createStatement();
	
%>
	<label>Ticket Id:</label> <input type="text" name="ticketid" value="<%=request.getParameter("ticketid")%>" readonly="readonly"/><br/><br/>
		<label>Ticket Type:</label> <input type="text" name="ttype" value="<%=request.getParameter("ttype")%>" readonly="readonly"/><br/><br/>
		<label>Ticket Description:</label> <input  type="text" name="tdesc" value="<%=request.getParameter("tdesc")%>"/><br/><br/>
		<label>	Ticket Status : </label><select name="tstatus">
			<option value="<%=request.getParameter("tstatus")%>"><%=request.getParameter("tstatus")%></option>
			<%	String query = "SELECT T.TICKET_STATUS FROM TCK_STATUS_MST T WHERE T.STATUS = 'A'";
				rset = stmt.executeQuery(query);
				
				while(rset.next()){
					String tstatus=rset.getString("ticket_status");
				%>
				<option value="<%=tstatus%>"><%=tstatus%></option>
				<%}%>
		</select><br /></br>
		<%if(ut.equals("I"))
			{%>
		<label>	Ticket Assigned To : </label><select name="tassignedto">
				<option value="<%=request.getParameter("tassignedto")%>"><%=request.getParameter("tassignedto")%></option>
				<%	String stm = "SELECT T.USER_NAME FROM TCK_USERS T WHERE T.USER_TYPE = 'I'";
				rset = stmt.executeQuery(stm);
				
				while(rset.next()){
					String tassignedto = rset.getString("user_type");
				%>
				<option value="<%=tassignedto%>"><%=tassignedto%></option>
				<%}%>
			</select><br/><br/>
		<%} %>
<%rset.close();
stmt.close();
}catch(Exception e){
	e.printStackTrace();
} %>
		
		<input type= submit name= searchButton value= Update onclick="Alert();"/><br/><br/>
</form>
<%}%>
</body>
</html>