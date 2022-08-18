<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Image</title>
</head>
<body>
<center>
<img src="data:image/png;base64,${image}" width="500" height="350">
<form action="Update_image" method ="POST"  enctype="multipart/form-data">
<table>
<tr> <td>Update Image</td>	 </tr>
<tr>
	<td> <input type="file" name="empimage" accept="image/*"> 	
	<td> <button type="submit" name="empno" value="${empno}">update</button></td>	
</tr>
</table>
</form>
</center>
</body>
</html>