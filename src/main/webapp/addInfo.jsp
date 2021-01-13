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
	background-image: url('https://wallpaperaccess.com/full/619974.jpg');
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
<h1 align="center">Enter Doctor Data</h1>
<form action = createDoctor>
	<table align="center">
		<tr>
			<td><h4>Doctor Name</h4></td>
			<td><input type="text" value="${name}" id = "name" name="name" required="required">
			</td>
		</tr>
		<tr>
			<td><h4>Doctor Password</h4></td>
			<td><input type="text" placeholder="Enter Password" id = "password" name="password" required="required">
			</td>
		</tr>
		<tr>
			<td><h4>Doctor Salary</h4></td>
			<td><input type="text" placeholder="Enter Doctor Salary" id = "salary" name="salary" required="required">
			</td>
		</tr>
		<tr>
			<td><h4>Doctor Department</h4></td>
			<td><input type="text" placeholder="Enter Doctor Department" id = "dept" name="dept" required="required">
			</td>
		</tr>
		<tr>
			<td><h4>Doctor Gender</h4></td>
			<td><input type="radio" id = "female" name="gender" value="female">Female
				<input type="radio" id = "male" name="gender" value="male">Male
			</td>
		</tr>
		<tr>
			<td><h4>Hospital</h4></td>
			<td>
			<select name="hospital">
			<c:forEach items="${hospitalList}" var="hospitalList">
				<option value="${hospitalList.id}">${hospitalList.name}</option>
			</c:forEach>
			
			</select>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><button type="submit">Submit</button></td>
		</tr>
	</table>

</form>
</body>
</html>