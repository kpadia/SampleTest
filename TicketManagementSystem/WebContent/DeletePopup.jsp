<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete PopUp</title>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />

<script type="text/javascript">
function refreshAndClose() {
    //alert("Ticket Update Successfully!!!");    
	window.opener.location.reload(true);
    window.close();
}
function Alert() {
	alert("Ticket deleted successfully!!");
}
</script>

</head>
<body onunload="refreshAndClose();">
<form name="deletePopup" method="post" action="deleteServlet">
<p>
<%int ticketid = Integer.parseInt(request.getParameter("ticketid"));
System.out.println("ticketid on delete screen = "+ticketid);%>
Are you sure you want to delete this record?<br/><br/>
<input type= "hidden" name="ticketid" value= "<%=ticketid%>"/>
<input type= submit name= OK value= OK onclick="Alert();"/>
</p>
</form>
</body>
</html>