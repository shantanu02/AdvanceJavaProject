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
    <a href="logout.htm"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button></a>
    </div>
  </nav>
	
	
	
	
<h2 align="center" color="white" class="mt-4">Add Student Details </h2>
<div id="container">

	<div  align="center" style="font-size:20px; font-weight :bold ;color :gold;">
		${Student_already_exists}
	
	</div>

	<spr:form action="add_student.htm" method="POST" commandName="student" >
		
	<table align="center" class="table table-hover" >
			<tbody>
				<tr>
					<td><label>Roll No :</label></td>
					<td><spr:input  type="number" min="1" max="1000"  class="form-control" style="width:200px; height :30px;" path="studentRollNo"/>
							<font color="red">	<spr:errors path="studentRollNo" /> </font><br>	</td>
				</tr>
				<tr>
					<td><label>Name :</label></td>
					<td><spr:input class="form-control" style="width:200px; height :30px;" path="studentName" /><br></td>
				</tr>
				<tr>
					<td><label>Email :</label></td>
					<td><spr:input type="email" class="form-control" style="width:200px; height :30px;" path="studentEmail" />
								<font color="red">	 <spr:errors path="studentEmail" /></font><br>	</td>
				</tr>
				<tr>
					<td><label>Blood Group :</label></td>
					<td><spr:select class="form-control" style="width:200px; height :40px;"
						path="studentBloodGroup" >
						<spr:option value="A +ve">A +ve</spr:option>
					 	<spr:option value="A -ve">A -ve</spr:option>
					 	<spr:option value="B +ve">B +ve</spr:option>
					 	<spr:option value="B -ve">B -ve</spr:option>
					 	<spr:option value="O +ve">O +ve</spr:option>
					 	<spr:option value="O -ve">O -ve</spr:option>
					 	<spr:option value="AB +ve">AB +ve</spr:option>
					 	<spr:option value="AB -ve">AB -ve</spr:option>
					 
					 
					 </spr:select><br>
			</td>
				</tr>
				<tr>
					<td><label>Phone :</label></td>
					<td><spr:input class="form-control" style="width:200px; height :30px;" path="studentPhone" /><br>
						<font color="red"><spr:errors path="studentPhone" /></font><br>	</td>
				</tr>
				<tr>
					<td><label>Password : </label></td>
					<td><spr:password class="form-control" style="width:200px; height :30px;" path="studentPassword" />
							<font color="red">	<spr:errors path="studentPassword" /></font><br></td>
				</tr>
					
					
				
					
					
					
			</tbody>
		
		
		</table>
			
		
			<input type="submit" class="btn btn-primary" value="Add Student" />

		
		</spr:form>
		
		<br>
	<a href="faculty_home.jsp" style="font-size:30px;"> Back to home</a>
</div>


</body>



</html>
	
	
	
