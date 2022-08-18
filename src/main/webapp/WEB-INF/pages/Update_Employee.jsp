<html>

<style>   
Body { 
	font-family: "Brush Script MT", cursive; 
  background-image: url('https://media3.giphy.com/media/l3mZnuz4coJp8EBBm/giphy.gif');
   color:  white;    
    background-size: cover; 
} 
a{
 color: red; 
}

</style> 

<body>
<center>
<h2>Update Employee Data<h2> <br>
<h3> </h3>
<h3>Update name </h3>
<form action="SubmitName" > 
<table>
<tr>
	<td> <label> Employee Number: </label> </td>
	<td> <input type="text" placeholder=" Employee Number" name="empno" required> </td>
</tr>

<tr>
	<td> <label> Employee Name: </label> </td>
	<td> <input type="text" placeholder="Employee Name" name="ename" required> </td>
</tr>
</table>

<button type="Submit"> Enter </button>   
 </form>
 <h3> </h3>
<h3>Update Salary </h3>
 <form action="SubmitSalary" > 
<table>
<tr>
	<td> <label> Employee Number: </label> </td>
	<td> <input type="text" placeholder=" Employee Number" name="empno" required> </td>
</tr>

<tr>
	<td> <label> Employee Salary: </label> </td>
	<td> <input type="text" placeholder="Employee Salary" name="sal" required> </td>
</tr>
</table>
<button type="Submit"> Enter </button>   
 </form>
 <h3> </h3>
<h3>Update Department </h3>
<form action="SubmitDeparment" > 
<table>
<tr>
	<td> <label> Employee Number: </label> </td>
	<td> <input type="text" placeholder=" Employee Number" name="empno" required> </td>
</tr>

<tr>
	<td> <label> Employee Department Number: </label> </td>
	<td> <input type="text" placeholder="Employee Department Number" name="deptno" required> </td>
</tr>
</table>
<button type="Submit"> Enter </button>   
 </form>
<button>
<a href="http://localhost:9191/Home">Back</a>
</button>
</body>
</html>