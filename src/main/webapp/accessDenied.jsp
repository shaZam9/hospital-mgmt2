<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<style>
body {
	margin: 0;
	background-image: url('https://www.ionos.com/digitalguide/fileadmin/DigitalGuide/Teaser/401-Unauthorized-t.jpg');
	background-size: cover;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

.fix {
	position: fixed;
	bottom: 0px;
	align-self: center;
	text-align: center;
}

@media screen and (max-width: 992px) {
	body {
		background-color: Orange;
		color: black;
	}
}

@media screen and (max-width: 600px) {
	body {
		background-color: pink;
		color: Black;
	}
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
	<div class="p-3 mb-2 bg-dark text-white">
		<h1 align="center">Access Denied</h1>
	</div>
	
	<div class="p-3 mb-2 bg-dark text-white fix" align="center">
	<h5 align="center"><a href="welcome.jsp">Home</a>
	</h5>
	<h5>
		<a href="/logout">Logout</a>
	</h5>
	</div>
	
	
</body>
</html>