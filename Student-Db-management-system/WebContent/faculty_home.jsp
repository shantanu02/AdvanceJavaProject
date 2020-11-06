<%@page import="com.cdac.dto.Faculty"%>
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
    
<%
	Faculty user = (Faculty)session.getAttribute("faculty");
	String userName = "", profilePic = "";
	if(user!=null){
		userName = user.getFacultyName();
		profilePic = user.getProfilePic();
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
background: #ff9966;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #ff5e62, #ff9966);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #ff5e62, #ff9966); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
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
		font-size:25px;
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
	<h2 align="center"> Welcome <%=(session.getAttribute("faculty")!=null) ?
							((Faculty)session.getAttribute("faculty")).getFacultyName() : "!!!!!!!!" %> </h2>
		<div align="center">
			
			<img style="border-radius:50%;" alt="No Profile photo uploaded"
			 src="<%="images/"+profilePic%>" height="150" width="150" > 
		&nbsp;&nbsp;
			
					
		</div>	
		
		<br>	

<div id="container" class="mt-5">
		<table class="table table-hover" >
			<tbody>
				
				<tr >
					<td><label></label></td>
					<td><a style="color:#642B73" href="add_student_form.htm">Add Student</a></td>
				</tr>
				
				
				<tr >
					<td><label></label></td>
					<td><a style="color:#642B73" href="student_list.htm">Student List</a></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td>
						 
      						<a style="color:#642B73" href="search_stu.htm">Search Student</a>
   
					
					</td>
				</tr>
			
				
				
				
			</tbody>
		
			
		</table>
		
		<div align="center">
		
		<a href="file_upload_form.jsp"><button style="font-size:20px; color : black; font-weight:bold;" class="btn btn-warning">Set profile picture !</button></a>
		
		
		</div>
		
		
		
</div>


</body>



</html>