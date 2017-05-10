<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
         function Alert() {
    alert ("Ticket Type Removed Successfully!!");
    
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
<form name="removeTypePopup" method="Get" action="tTypeRemoveServlet">
<label>Ticket Type :</label><input type="text" name="ttype" value="<%=request.getParameter("ttype")%>" readonly="readonly"/>
<input type="submit" name="remove" value="Remove" onclick="Alert();"/>
</form>
<%} %>
</body>
</html>