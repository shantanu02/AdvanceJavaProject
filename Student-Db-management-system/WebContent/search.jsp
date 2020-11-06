<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>

<%

response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
    if(session.getAttribute("faculty")==null){
    response.sendRedirect(request.getContextPath() + "/index.jsp");

}
%>


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
-->

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
		width : 700px;
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
    <a href="logout.htm"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button></a>
    </div>
  </nav>
	
	<div align="center" style="color:red; font-size:25px;">${Student_Not_Present } </div>
<div id="container">
		<spr:form action="search_student.htm" method="POST" commandName="student" >
			
			Name : <spr:input path="studentName" />
				  
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			 <font color="red"><spr:errors path="studentName" /></font>

		</spr:form>
</div>

<hr>
<div align="center">OR</div>


<div id="container">
		<spr:form action="search_by_roll.htm" method="POST" commandName="student" >
			Roll No  : <spr:input  type="number" min="1" max="1000" path="studentRollNo" />	
			
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>

		</spr:form>
</div>

	
	<a  style="font-size:30px; margin: 200px 50px " href="faculty_home.jsp">Back to Home</a>
	
	
	
	
</body>



</html>
	
	
	
