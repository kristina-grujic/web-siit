<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Register</title>
</head>
<body>
<h2>Create an account</h2>
<%
	String message = (String) request.getAttribute("success");
	if(message!=null){%>
	<font color="red"><%
		out.println(message);  %></font>
		<%
	}
%>
<form action="MasterServlet" method="
post">
<input type="hidden" name="referer" value="register"/>
<fieldset>
<table>
<tr>
  <td>*Username</td>
  <td>:</td>
  <td><input type="text" name="user" required/></td>
</tr>

<tr>
  <td>*E-mail</td>
  <td>:</td>
  <td><input type="email" name="mail" required/></td>
</tr>

<tr>
  <td>*Name</td>
  <td>:</td>
  <td><input type="text" name="name" required/></td>
</tr>
<tr>
  <td>*Surname</td>
  <td>:</td>
  <td><input type="text" name="surname" required/></td>
</tr>



<tr>
  <td>*Password</td>
  <td>:</td>
  <td><input type="password" name="passwd"  pattern=".{8,}" required/></td>
</tr>

<tr>
  <td>*Confirm password</td>
  <td>:</td>
  <td><input type="password" name="cpasswd" required/></td>
</tr>

<tr>
  <td>Telephone number</td>
  <td>:</td>
  <td><input type='tel' name="phone"/></td>
</tr>
<tr>
<td>*Role </td>
<td>:</td> 
<td><input type="radio" name="role" value="user" checked/> User
<input type="radio" name="role" value="manager"/> Manager
</td>
</tr>
</table>
<br/>
<input type="submit" name="
submit" value=" Register"/>
</fieldset>
</form>
<p> Already have an account? <a href="login.jsp">Log in here</a>
</p>
</body>
</html>