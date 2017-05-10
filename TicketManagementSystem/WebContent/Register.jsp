<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<script type="text/javascript">
         
            function Alert() {
               alert ("Registered Successfully!");
               
            }
        
      </script>
</head>
<body>
	<form name="registerForm" method="post" action="registerServlet">
	<h1>Register Here</h1>
<label>	UserName : </label><input type="text" name="username"></input><br /><br /> 
<label>Password : </label><input type="password" name="passwd"></input><br /><br /> 
<label>Name : </label><input type="text" name="name"></input><br />	<br /> 
<label>Login As : </label><select name="usertype" id="usertype">
			<option value="C">User</option>
			<option value="I">IS</option>
		</select><br /><br /> 
<label>Email ID : </label><input type="text" name="eid"></input><br /><br /> 
<label>Contact : </label><input type="text" name="contact"></input><br /><br /> 
<input type="submit" name="registerButton" value="Register" onclick="Alert();"><br /> <br /> 
	</form>
</body>
</html>