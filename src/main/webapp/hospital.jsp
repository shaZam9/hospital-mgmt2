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
	background-image: url('https://images.unsplash.com/photo-1512678080530-7760d81faba6?ixid=MXwxMjA3fDB8MHxzZWFyY2h8MTF8fGhvc3BpdGFsfGVufDB8fDB8&ixlib=rb-1.2.1&w=1280&q=100');
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
<h1 align="center">Enter Hospital Data</h1>
<form action = createHospital>
	<table align="center">
		<tr>
			<td><h4>Hospital Name</h4></td>
			<td><input type="text" placeholder="Enter Hospital Name" id = "name" name="name" required="required">
			</td>
		</tr>
		<tr>
			<td><h4>Hospital City</h4></td>
			<td><input type="text" placeholder="Enter Hospital City" id = "city" name="city" required="required">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center"><button type="submit">Submit</button></td>
		</tr>
	</table>

</form>
</body>
</html>