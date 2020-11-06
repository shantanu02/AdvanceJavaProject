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
<!--  
<link type="text/css" rel="stylesheet" href="css/style.css">
<link type="text/css" rel="stylesheet" href="css/add-member-style.css">
-->
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
	black:black;
		border : none;
		color : black;
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
	<h3 align="center" >Faculty Login</h3>
	<div align="center" style="font-size:20px; font-weight :bold ;color :gold;" >${Wrong_Credentials }</div>
	<spr:form action="faculty_login.htm" method="Post" commandName="faculty">
	
		<table class="table table-stripped" align="center">
			<tbody>
				<tr>
					<td ><label>Email :</label></td>
					<td>  
						<spr:input  path="facultyEmail" type="email" />
						<font color="golden" ><spr:errors path="facultyEmail" ></spr:errors></font>
					</td>
				</tr>
				
				<tr>
					<td ><label>Password :</label></td>
					<td><spr:password path="facultyPassword" />
						<font color="golden" ><spr:errors path="facultyPassword" ></spr:errors></font>
					</td>
					
				</tr>
			
				<tr>
					<td><label></label></td>
					<td><input class="btn btn-info" type="submit" value="Login" /></td>
					
				</tr>
				
				<tr>
					<td><label></label></td>
					<td></td>
				</tr>
				
				
			</tbody>
		
		
		</table>
	
	
	</spr:form>
	<br>
	<a style="font-size : 30px;" href="forgot_password.jsp">Forgot Password</a><br>
	<a style="font-size : 30px;" href="index.jsp">Back to home page</a>
</div>


</body>



</html>