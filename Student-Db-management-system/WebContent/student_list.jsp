<%@page import="org.hibernate.Session"%>
<%@page import="com.cdac.dto.*"%>
<%@page import="java.util.List"%>

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
	
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
	
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
		align:center;
		margin-top : 20px;
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
     <a href="logout.htm"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button></a>
    </div>
  </nav>
	
<h2 align="center" style="font-color:white;">Student List</h2>
<div id="container">
		<div align="center">
		<i class="fa fa-search" style="font-size:24px;color:#de6262"></i>
		<input type="text" class="form-control col-6" id="myInput" placeholder="Search for..."> 
		</div>
		<br>
		<table id="myTable" class="table table-dark" >
		<tr>
				<th scope="col">Roll No</th>
				<th  scope="col">Name</th>
				<th  scope="col">Email</th>
				<th  scope="col">Blood Group</th>
				<th  scope="col">Cpp</th>
				<th  scope="col">Dbt</th>
				<th  scope="col">Awp</th>
				<th  scope="col">Mean</th>
				<th  scope="col">Osc</th>
				<th  scope="col">Java</th>
				<th  scope="col">Percentage</th>
				<th  scope="col">Action</th>
		</tr>
		<% 
		List<Student> sList = (List<Student>)request.getAttribute("studentList");
		for(Student student : sList){
		%>
		
		
		
		<tr>
			<td>
				<%=student.getStudentRollNo()%>
			</td>
			<td>
				<%=student.getStudentName()%>
			</td>
			<td>
				<%=student.getStudentEmail()%>
			</td>
			<td>
				<%=student.getStudentBloodGroup()%>
			</td>
			<td>
				<%=student.getStudentMarksCpp()%>
			</td>
			<td>
				<%=student.getStudentMarksDbt()%>
			</td>
			<td>
				<%=student.getStudentMarksAwp()%>
			</td>
			<td>
				<%=student.getStudentMarksMean()%>
			</td>
			<td>
				<%=student.getStudentMarksOsc()%>
			</td>
			<td>
				<%=student.getStudentMarksJava()%>
			</td>
			<td>
				<%= Math.round((((student.getStudentMarksCpp()+student.getStudentMarksDbt()+student.getStudentMarksAwp()+student.getStudentMarksMean()+
						student.getStudentMarksOsc()+student.getStudentMarksJava())/360)*100))%>%
			</td>
			<td class="d-flex ">
				<a class="btn btn-danger mr-2" href="student_delete.htm?studentId=<%=student.getStudentId()%>"
				onclick="if(!(confirm('Are You Sure you want to delete ?'))) return false">Delete</a>
				
				<a class="btn btn-info" href="student_update_form.htm?studentId=<%=student.getStudentId()%>">Update</a>
			</td>
		</tr>
		<% } %>
		
	</table>
	<a href="faculty_home.jsp" style="font-size: 30px;" align="center">Back to home</a>
</div>

 <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
 <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script>
$(document).ready(function(){
		$("#myInput").on("keyup", function() {
		var value = $(this).val().toLowerCase();
	$("#myTable tr").filter(function() {
  		$(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	});
		});
	});
</script>

  </body>
</html>