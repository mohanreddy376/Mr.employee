
<html>

<style>   
Body { 
	font-family: "Brush Script MT", cursive; 
  background-image: url('https://cdn.dribbble.com/users/106600/screenshots/2156764/media/926501fadcd7a68dc3a30ab39dd5edea.gif');
   color: white;    
    background-size: cover; 
} 
a{
 color: red; 
}

</style> 

<body>
<center>
<h3>Add Employee Data<h3> <br>
<form action="Submit"  method ="POST"  enctype="multipart/form-data" > 
<table>
<tr>
	<td> <label> Employee Number: </label> </td>
	<td> <input type="text" placeholder=" Employee Number" name="empno" required> </td>
</tr>

<tr>
	<td> <label> Employee Name: </label> </td>
	<td> <input type="text" placeholder="Employee Name" name="ename" required> </td>
</tr>
<tr>
	<td> <label> Employee Salary: </label> </td>
	<td> <input type="text" placeholder="Employee Salary" name="sal" required> </td>
</tr>
<tr>
	<td> <label> Employee Department Number: </label> </td>
	<td> <input type="text" placeholder="Employee Department Number" name="deptno" required> </td>
</tr>
<tr>
	<td> <label> Employee Image:</label> </td>
	<td> <input type="file" name="empimage" accept="image/*"> 
	
	</td>
</tr>
</table>
<button type="Submit"> Enter </button>   
 </form>
<button>
<a href="http://localhost:9191/Home">Back</a>
</button>
</body>
</html>