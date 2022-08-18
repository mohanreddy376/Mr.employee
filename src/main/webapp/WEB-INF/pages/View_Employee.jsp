<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<style>   
body { 
	font-family: "Brush Script MT", cursive; 
  background-image: url('https://i.pinimg.com/originals/ea/db/74/eadb74787dda41cc6333341e55293432.gif');
   color: blue;    
    background-size: cover; 
} 
a{
 color: red; 
}
th{
 color: red; 
}

input{
font-family: "Brush Script MT", cursive; 
 color: blue; 
 border: none;
 padding:9px 16px;
 background: transparent;
}

</style> 
<body>
<center>
<h3><c:out value="${title}" /><h3> <br>

<button>
<a href="http://localhost:9191/Add_Employee">New Employee</a>
</button>
<p></p>
<table border = 1>
<tr>
<th>EMPLOYEE NUMBER</th>
<th>EMPLOYEE NAME</th>
<th>SALARY</th>
<th>DEPARTMENT NUMBER</th>
<th>IMAGE</th>
<th>DELETE</th>
<th>UPDATE</th>
</tr>
<c:forEach items="${employees}" var= "e">
<tr>
</form>
<form action="Update">
<td> <center> ${e.empno} </center> </td> 
<td> <input type="text" name="ename" value ="${e.ename}" > </input> </td> 
<td> <input type="text" name="sal" value ="${e.sal}" > </input> </td> 
<td> <input type="text" name="deptno" value ="${e.deptno}" > </input> </td> 

<td> <center> <a href="http://localhost:9191/Image?empno=${e.empno}"> <img src="data:image/png;base64,${e.image}" width="50" height="35"> </a> </center> </td> 

<td> <center> <button type="submit" name="empno" value="${e.empno}">update</button></center></td> 
</form>
<form action="Delete">
<td> <center> <button type="submit" name="empno" value="${e.empno}">delete</button></center> </center></td> 
</tr>
</c:forEach>
</table>
<h6></h6>
<button>
<a href="http://localhost:9191/Home">Back</a>
</button>
</center>
</body>
</html>