<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<title>Ticket Status Update Configuration</title>
<script type="text/javascript">
         function Alert() {
    alert ("Ticket Status Updated Successfully!!");
    
 }
</script>

<script type="text/javascript">
function refreshAndClose() {
    window.opener.location.reload(true);
    window.close();
}

</script>
</head>
<body onunload="refreshAndClose();">
<%
	
	//redirect user to index page if not logged in
	String u = (String)session.getAttribute("uname");
	System.out.println("Username on update jsp == "+u);
	if(u == null){
		response.sendRedirect("Login.jsp");
		out.print("Login first!!");
	}else{
	%>
	
<form name="updateStatusPopup" method="Get" action="tStatusUpdateServlet">
<input  style="visibility: hidden;" type="text" name="tstatusid" value="<%=request.getParameter("tstatusid")%>"/><br/>
<label>Ticket Status :</label> <input type="text" name="tstatus" value="<%=request.getParameter("tstatus")%>"/>
<label>Status :</label> <select name="status" id="status">
<option value="<%=request.getParameter("status")%>"><%=request.getParameter("status")%></option>
			<option value="A">Active</option>
			<option value="I">In-Active</option>
</select>
<br/><br/>


<input type="submit" name="update" value="Update" onclick="Alert();"/>
</form>
<%} %>
</body>
</html>