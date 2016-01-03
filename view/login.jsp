<html>
<head>
<title>Log in</title>
</head>
<body>

<%
	String message = (String) request.getAttribute("success");
	if(message!=null){%>
	<font color="red"><%
		out.println("Login unsuccessful! Try again!");  %></font>
		<%
	}
	String regmes = (String) request.getAttribute("registered");
	if(regmes!=null){
		out.println("Registration successful! You can now login into the system!");
		}
	
%>
<p>
<form action="MasterServlet?login" method="
post">
<input type="hidden" name="referer" value="login"/>
<table>
<tr>
  <td>Username</td>
  <td>:</td>
  <td><input type="text" name="user" required></td>
</tr>
<tr>
  <td>Password</td>
  <td>:</td>
  <td><input type="password" name="passwd" required></td>
</tr>
</table>

<input type="submit" name="
submit" value=" Log in">
</form>
</p>
<p> Don't have an account? <a href="register.jsp">Register</a>
</p>

</body>
</html>