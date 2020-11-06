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
		margin-top : 50px;
		margin-left : 400px;
		width : 500px;
	}
	td{
		color:black;
		
	}
	

</style>


</head>
<body>
	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">Student Database Management System </a>
    <a href="logoutAdmin.htm"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button></a>
    </div>
  </nav>
	
	
	
	
<h2 align="center" color="white" class="mt-4">Add Faculty Details </h2>
<div id="container">

	

	<spr:form action="add_faculty.htm" method="POST" commandName="faculty" >
		
	<table align="center" class="table table-hover" >
			<tbody>
				<tr>
					
					<td>Name : <spr:input path="facultyName"/>
								<font color="red" ><spr:errors path="facultyName" /></font>
								<br></td>
				</tr>
				<tr>
					
					<td>Email : <spr:input path="facultyEmail" type="email" />
								<font color="red" ><spr:errors path="facultyEmail" /></font>
								<br></td>
				</tr>
				<tr>
					
					<td>Phone : <spr:input path="facultyPhone" />
								<font color="red" ><spr:errors path="facultyPhone" /></font>
								<br></td>
				</tr>
				<tr>
					
					<td>Password : <spr:password path="facultyPassword" />
									<font color="red" ><spr:errors path="facultyPassword" /></font>
									<br><br>
			</td>
				</tr>
				
					
			</tbody>
		
		
		</table>
			
		
			<input type="submit" class="btn btn-primary" value="Add Faculty" />

		
		</spr:form>
		
		<br>
	<a href="admin_home.jsp" style="font-size:30px;"> Back to home</a>
</div>



</body>



</html>
	
	
	
