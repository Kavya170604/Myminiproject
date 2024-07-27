<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Hospital Management System</title>
	<style>
		body {
			font-family: Arial, sans-serif;
			background-color: #f0f0f0;
			background-size: cover;
  background-position: center;
  background-image:url('https://images.pexels.com/photos/1692693/pexels-photo-1692693.jpeg?cs=srgb&dl=pexels-tomfisk-1692693.jpg&fm=jpg');
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
		}
		.links {
			text-align: center;
			margin-top: 50px;
		}
		a {
			display: inline-block;
			margin: 20px;
			padding: 10px;
			background-color: #007bff;
			color: #fff;
			text-decoration: none;
			border-radius: 5px;
		}
		a:hover {
			background-color: #0056b3;
		}
	</style>
</head>
<body>

	<div class="links">
	<h1 style="color:white;"><b>Hospital Management System</b></h1>
		<a href="PatientRegForm.jsp">Patient Register Here</a>
		<a href="DoctorRegForm.jsp">Doctor Register Here</a>
		<a href="View.jsp?page=1">Patient Information</a>
	</div>
</body>
</html>
