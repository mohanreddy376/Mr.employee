<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>   
Body { 
	font-family: "Brush Script MT", cursive; 
   color: blue; 
   background-image: url('https://img.freepik.com/free-vector/pastel-color-watercolor-stain-background_52683-12283.jpg');   
    background-size: cover; 
}
form {      
        width: 400px;
		height: 350px;
    } 
    
    .box1{
    display: flex;
     margin: 4%;
  	 width: 80%;
  	 border: 3px solid #f1f1f1;   
     padding: 75px;
     border-radius: 2%;
      background: white;
} 
 .box2{
 flex:1;
  margin: none;
  	 width: 40%; 
  	  hight: 60%;
      background: white;
} 
table {
		border-collapse: separate;
        border-spacing: 0 15px;
        }
        
        input{
        border: none;
        background-color:  #E5E4E2;
        }
        
        button{
        padding: 12px 100px;  
        border-radius:20% / 100%;
        border: none;
        background-color:  SlateBlue;
        color: white; 
        }
   th{
    padding: 12px 30px;  
        border-radius:20% / 100%;
   } 
   td {
  		display: flex;
        padding: 12px 30px;  
        border-radius:20% / 100%;
  		background-color:  #E5E4E2;
}
h2{
		font-family: "Verdana";
	 color: SlateBlue; 
	}	
h5{
	 color: red; 
	}
a{
 color: red; 
}
</style> 
<title>Login</title>
<body>
<div class="box1">
<div class="box2">
<img class = "img1" src="data:image/png;base64,${logo1}" width="580" height="400"/>
</div>
<div class="box2">
<center>
<h2>Admin Login</h2>
<form action="/Valid_Login" method="POST" > 
<table>
<tr>
	<td> <i class="fa fa-envelope icon"></i> <input type="text" placeholder="Email" name="username" required> </td>
</tr>

<tr>
	<td><i class="fa fa-key icon"></i> <input type="text" placeholder="Password" name="password" required> </td>
</tr>
<tr>
	<th> <center> <img src="data:image/png;base64,${image}" width="100" height="35"/> </center> </th> 
</tr>
<tr>
	<td> <input type="text" placeholder="Captcha" name="captcha" required> </td> 
</tr>
</table>
<button type="Submit"> Login </button>   
 </form>
  </center>
 <h5>
 <c:out value="${status}" />
  <h5>
Dont have an account? <a href="http://localhost:9191/Register">Register</a>
   
  </div>
 </div>
</body>
</html>