<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Status Add Configuration</title>
<script type="text/javascript">
         function Alert() {
    alert ("Ticket Status Added Successfully!!");
    
 }
</script>
</head>
<body>
<form name="addStatusPopup" method="Get" action="tStatusAddServlet">
<label>Ticket Status :</label><input type="text" name="tstatus" value=""/>
<input type="submit" name="add" value="Add" onclick="Alert();"/>
</form>
</body>
</html>