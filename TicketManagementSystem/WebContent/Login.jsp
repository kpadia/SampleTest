<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html" />
<link rel="stylesheet" href="css/TicketManagementSystem.css"  type="text/css" />
<title>Login Page</title>
</head>
<body id="body">
<div class = "relative">
	<form name="loginForm" method="POST" action="loginServlet">
		<h1>Login Please </h1><br />
<label>		 User Name : </label>	 <input type="text" name="username" class="inputText"><br /><br />
<label>		 Password : </label>	 <input type="password" name="passwd"><br /><br />
<label>		 Login AS : </label>	<select name="usertype" id="usertype">
			<option value='C'>User</option>
			<option value='I'>IS</option>
			<option value='A'>Admin</option>
		</select><br /><br />
		 New User? <a href="Register.jsp">Register Here</a><br /><br />
		<input type="submit" name="loginButton" value="Login">



	</form>
	</div>
</body>
</html>