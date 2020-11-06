<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="spr" uri="http://www.springframework.org/tags/form" %>



<!DOCTYPE html>
<html>
<head>
    <title>Log-In</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, shrink-to-fit=no"
    />
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
    />
    <!-- Bootstrap CSS -->
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
      crossorigin="anonymous"
    />
    <script
      src="https://kit.fontawesome.com/0ff6456f25.js"
      crossorigin="anonymous"
    ></script>
    <style>
      body {
       			background: #ee9ca7;  /* fallback for old browsers */
background: -webkit-linear-gradient(to right, #ffdde1, #ee9ca7);  /* Chrome 10-25, Safari 5.1-6 */
background: linear-gradient(to right, #ffdde1, #ee9ca7); /* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
color : black;
      }

      .img {
        width: 50vh;
        height: 50vh;
        margin-left: 16%;
        margin-top: 40%;
      }

      #icn {
        font-size: 25px;
        margin: 19px;
        color: black;
        cursor: pointer;
      }

      .mobileShow {
        display: inline;
      }

      /* Smartphone Portrait and Landscape */
      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {
        .mobileShow {
          display: inline;
        }
      }

      .mobileHide {
        display: inline;
      }

      /* Smartphone Portrait and Landscape */
      @media only screen and (min-device-width: 320px) and (max-device-width: 580px) {
        .mobileHide {
          display: none;
        }
      }
    </style>
  </head>
<body>
	<nav
      class="navbar navbar-expand fixed-top text-light navbar-dark bg-dark justify-content-between"
    >
      <div class="nav navbar-nav">
        <!--<a class="nav-item nav-link active" href="#">
          <i class="fa fa-home" aria-hidden="true"></i> Home</a
        >-->
      </div>
      <div class="nav navbar-nav" style="font-family: cursive; font-size: 25px">
        <b> Student Database Management System  </b>
      </div>
      <div class="nav navbar-nav">
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row" style="height: 100vh">
        <!--NAV-BAR-->

        <!--MIDDLE-COLOUM-->
        <div class="col-3 bg-inf1o mobileHide">
          
        </div>
        <div
          class="col-md-6 align-items-center justify-content-center mobileShow"
        >
				<div
            class="row d-flex align-items-center justify-content-center"
            style="height: 20vh"
          ></div>
          <div class="row shadow ml-0 mr-5">
            <div
              class="col-4 text-dark d-flex align-items-center justify-content-center"
              style="
                height: 50vh;
                font-family: cursive;
                background-color: #f2709c;
              "
            >
              Forgot Password
            </div>
            <div
              class="col-8 d-flex align-items-center justify-content-center"
              style="height: 50vh; background: whitesmoke"
            >
            
            
              <form action="forgot_password_student.htm" method="post">
              	<div align="center" style="color:red;">${msg }</div>
                <div class="ml-5 form-group display-3">
                  <i class="fas fa-user-friends"></i>
                </div>
                <div class="form-group">
                  <input type="email" class="form-control" placeholder="Enter Email" name="studentEmail" required/>
                
                </div>
                <div class="form-group">
                  <input
                    type="submit"
                    class="rounded-pill form-control btn btn-info"
                    name="" value="Send Password"
                    placeholder="User-name"
                  /><br>
                  <a href="prep_student_form.htm">Login here !</a><br>
                   <a href="index.jsp">Back to Home</a>
                  
                </div>
              </form>
            </div>
          </div>
        </div>

      </div>
    </div>
    
</body>
</html>