<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.*" import="com.tcs.ilp.bean.TicketBean" import="com.tcs.ilp.utility.ConnectionManager"
	import="java.sql.Connection" import="java.sql.ResultSet" import="java.sql.Statement"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Ticket</title>
<script type="text/javascript">
         function Alert() {
    alert ("Ticket Created Successfully!!");
    
 }
</script>
</head>
<body>
	<%
		//redirect user to index page if not logged in
	String u = (String)session.getAttribute("uname");
	System.out.println("Username in jsp == "+u);
	if(u == null){
		response.sendRedirect("Login.jsp");
		out.print("Login first!!");
	}else{
	%>
	
	<form name="createTicket" action="createTicketServlet" method="post">
	<h1>Create Ticket</h1><br/>
<%try{
	ConnectionManager connManager = new ConnectionManager();		
	
	Connection conn = connManager.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	stmt=conn.createStatement();
	
%>
		<label>Ticket Type : </label><select name="ttype" id="ttype">
			<option value=""></option>
			<%	String msg = "SELECT T.TICKET_TYPE FROM TCK_TYPE_MST T WHERE T.STATUS='A'";
				rset = stmt.executeQuery(msg);
				System.out.println("Query :: "+rset);
				while(rset.next()){
					String ttype=rset.getString("ticket_type");
								%>
								<option value="<%=ttype%>"><%=ttype%></option>
								<%}%>
		</select><br /></br>
<%rset.close();
stmt.close();
}catch(Exception e){
	e.printStackTrace();
} %>
		<label>Ticket Description :</label> <input type="text" name="tdesc"></input><br /><br /> 
		<input type="submit" name="saveButton" value="Save" onclick="Alert();"><br /><br />
		 <div class="topcorner">
		 <a href="UserHomePage.jsp">Home</a>
		 <a href="logoutServlet">Logout</a><br /><br />
		 </div>
	</form>
<%}%>

</body>
</html>