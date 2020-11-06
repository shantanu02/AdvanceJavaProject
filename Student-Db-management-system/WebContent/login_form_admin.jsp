<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

<style>
	body{
					background: #ee9ca7;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #ffdde1, #ee9ca7);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #ffdde1, #ee9ca7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
color : black;
	}
	
	#container{
		align:center;
		margin-top : 20px;
		margin-left : 400px;
		width : 500px;
		height : 500px;
	}
	table{
	color:black;
		border : none;
	}

</style>
</head>
<body>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">Student Database Management System </a>
     
    </div>
  </nav>
	

<div id="container">
	<h3 align="center" >Admin Login</h3>
	
	<spr:form action="admin_login.htm" method="Post" commandName="admin">
	
		<table align="center">
			<tbody>
				<tr>
					<td><label>Email :</label></td>
					<td>  
						<spr:input path="adminEmail" type="email"/>
						<font color="red" ><spr:errors path="adminEmail" ></spr:errors></font>
					</td>
				</tr>
				
				<tr>
					<td><label>Password :</label></td>
					<td><spr:password path="adminPassword" />
						<font color="red" ><spr:errors path="adminPassword" ></spr:errors></font>
					</td>
					
				</tr>
			
				<tr>
					<td><label></label></td>
					<td><input type="submit" class="btn btn-info" value="Login"  /></td>
					
				</tr>
				
				<tr>
					<td><label></label></td>
					<td></td>
				</tr>
				
				
			</tbody>
		
		
		</table>
	
	
	</spr:form>
	<br>
	<a align="center" style="font-size : 25px;" href="index.jsp">Back to home page</a>
</div>


</body>



</html>