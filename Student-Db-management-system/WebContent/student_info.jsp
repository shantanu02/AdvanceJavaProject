<%@page import="com.cdac.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>

<%

response.setHeader("Cache-Control","no-cache");
response.setHeader("Cache-Control","no-store");
response.setHeader("Pragma","no-cache");
response.setDateHeader ("Expires", 0);
    if(session.getAttribute("student")==null){
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
    <a href="logoutStudent.htm"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Logout</button></a>
    </div>
  </nav>
	<h2 align="center"> Welcome <span style="color:yellow;"> <%=(session.getAttribute("student")!=null) ?
		((Student)session.getAttribute("student")).getStudentName() : "!!!!!!!!" %><span> </h2>
		<i style="color:white;" class="fa fa-user-graduate"></i>
<div id="container">		
	<h3 align="center" style="color:green;">Student Marks:-</h3>
	
	<h4>Cpp : <%=((Student)session.getAttribute("student")).getStudentMarksCpp() %></h4>
	
	<h4>Dbt : <%=((Student)session.getAttribute("student")).getStudentMarksDbt() %></h4>
	
	<h4>Awp : <%=((Student)session.getAttribute("student")).getStudentMarksAwp() %></h4>
	
	<h4>Mean : <%=((Student)session.getAttribute("student")).getStudentMarksMean() %></h4>
	
	<h4>Osc : <%=((Student)session.getAttribute("student")).getStudentMarksOsc() %></h4>
	
	<h4>Java : <%=((Student)session.getAttribute("student")).getStudentMarksJava() %></h4>
	
	<hr>
	
	<h4 style="color:orange">Precent : <%=  Math.round(((((Student)session.getAttribute("student")).getStudentMarksCpp()+
			((Student)session.getAttribute("student")).getStudentMarksDbt()+ 
			((Student)session.getAttribute("student")).getStudentMarksAwp()+
			((Student)session.getAttribute("student")).getStudentMarksMean()+
			((Student)session.getAttribute("student")).getStudentMarksOsc()+
			((Student)session.getAttribute("student")).getStudentMarksJava())/360)*100) %>%</h4>
	
</div>>

</body>



</html>