<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Type Add Configuration</title>
<script type="text/javascript">
         function Alert() {
    alert ("Ticket Type Added Successfully!!");
    
 }
</script>
</head>
<body>
<form name="addTypePopup" method="Get" action="tTypeAddServlet">
<label>Ticket Type :</label><input type="text" name="ttype" value=""/>
<input type="submit" name="add" value="Add" onclick="Alert();"/>
</form>
</body>
</html>