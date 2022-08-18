<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<style>   
Body { 
	font-family: "Brush Script MT", cursive; 
  background-image: url('https://wallpapercave.com/uwp/uwp1331138.gif');
   color: black;    
    background-size: cover; 
} 
a{
 color: red; 
}

</style> 

<body>
<center>
<h3>
<c:out value="${status}" />
 <h3>
 <button>
<a href="http://localhost:9191/Home">Back</a>
</button>
<button>
<a href="http://localhost:9191/View_Employees">View Employees</a>
</button>
</center>
</body>
</html>