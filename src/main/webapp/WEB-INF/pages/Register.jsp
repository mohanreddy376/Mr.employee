<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<style>   
Body { 
	font-family: "Brush Script MT", cursive; 
   color: grean;    
    background-size: cover; 
}
h3{
	 color: red; 
	}
a{
 color: red; 
}
</style> 
<title>Register</title>
<body>
<center>
<h2>Sign up<h2> <br>
<form action="/Valid_Register" method="POST" > 
<table>
<tr>
	<td> <label>Name: </label> </td>
	<td> <input type="text" placeholder="Name" name="username" required> </td>
</tr>

<tr>
	<td> <label>User Name: </label> </td>
	<td> <input type="text" placeholder=" Email Address" name="email" required> </td>
</tr>
<tr>
	<td> <label> Password: </label> </td>
	<td> <input type="text" placeholder="Password" name="password" required> </td>
</tr>

<tr>
	<td> <label>Confirm Password: </label> </td>
	<td> <input type="text" placeholder="Confirm Password" name="con_password" required> </td>
</tr>

<tr>
	<td> <label> Captcha: </label> </td>
	<td> <input type="text" name="captcha" required> </td>
	<td> <center> <img src="data:image/png;base64,${image}" width="100" height="25"/> </center> </td> 
</tr>
</table>
<button type="Submit"> Register </button>   
 </form>
 <h3>
 <c:out value="${status}" />
  <h3>
<a href="http://localhost:9191/Index">Login</a>
</body>
</html>