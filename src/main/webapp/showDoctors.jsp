<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
body {
	margin: 0;
	background-image: url('https://wallpapercave.com/wp/ThAOKju.jpg');
	background-size: cover;
}
</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <!-- <a class="navbar-brand" href="#">Navbar</a> -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="welcome.jsp">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="hospital">Create Hospital</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="doctor">Create Doctor</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="showData">Show Data</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/login">Login</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="/logout">Logout</a>
      </li>      
    </ul>
  </div>
</nav>
<h1 align="center">Doctors</h1>
	<form action="updateDoctor">
		<table class="table table-light" align="center">
			<tr>
				<th><h4>Doctor Name</h4></th>
				<th><h4>Doctor Salary</h4></th>
				<th><h4>Doctor Gender</h4></th>
				<th><h4>Doctor Department</h4></th>
				<th><h4>Update</h4></th>
			</tr>
			<c:forEach var="doctor" items="${doctors}">
			<tr>
				<td>${doctor.name}</td>
				<td>${doctor.salary}</td>
				<td>${doctor.gender}</td>
				<td>${doctor.dept}</td>
				<td align="center"><button type="submit" class="button" value="${doctor.id}" name="docId">Update</button></td>
			</tr>
			</c:forEach>
			<!-- <tr>
			<td colspan="2" align="center"><button type="submit">Submit</button></td>
			</tr> -->

		</table>
	</form>

</body>
</html>