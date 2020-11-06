<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ page errorPage = "error.jsp" %> 
<!doctype html>

<html lang="en">

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
background: #BA5370;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #F4E2D8, #BA5370);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #F4E2D8, #BA5370); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
color:black;
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
	
  <title>Hello, world!</title>
</head>

<body>
  <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container">
      <a class="navbar-brand" href="#">Student Database Management System </a>
    </div>
  </nav>


  <div class="jumbotron mt-3" style="background:none;" >
    <h1 class="display-4" style="font-weight:bold;">Welcome to Student Database Management System</h1>
    <p class="lead"></p>
    <hr class="my-4">
   
    <a class="btn btn-danger btn-lg mt-3" href="prep_login_form.htm" role="button">Faculty Login</a>
    <a class="btn btn-danger btn-lg mt-3" href="prep_student_form.htm" role="button">Student Login </a>
 	<a class="btn btn-danger btn-lg mt-3" href="prep_login_form_admin.htm" role="button">Admin Login </a>
 	
 
  </div>
	
	<div style="display: flex;flex: 1;flex-direction: column;justify-content:center;align-items:center">

            <h4 style="color:#ba5370"><%= new Date() %></h4>
           <div style="display: flex">
                <i class="fa fa-facebook-square" style="font-size:30px;color:black;margin-right: 10px"></i>
             <i class="fa fa-twitter" style="font-size:30px;color:black;margin-right: 10px"></i>
               <i class="fa fa-instagram" style="font-size:30px;color:black;"></i>
           </div>
        </div>
	
	
	
	
	
	
	


  <!-- Optional JavaScript -->
  <!-- jQuery first, then Popper.js, then Bootstrap JS -->
  <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous">
  </script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous">
  </script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous">
  </script>
</body>

</html>