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
<script type="text/javascript">
	$(document).ready(
	
		function(){
		
			$('#city').change(function(){
				
				
				populateHospitals();			
			});
			
			$('#hospital').change(function(){
				
				console.log("hospitalchange");
				populateDepts();			
			});
			
			$('#dept').change(function(){
				
				populateDoctors();			
			});
			
			function populateHospitals(){
						
				var city = $("#city option:selected").val();
				$('#hospital').html('<select name="hospital" id="hospital"><option disabled="" selected="">Hospitals</option></select>');
				
				$.ajax({
				
					type: 'GET',
					url: '${pageContext.request.contextPath }/getHospitalsByCity/' + city,
					success: function(result){
					
						var result = jQuery.parseJSON(result);
						
						var tabId = '<select name="hospital" id="hospital">';
						tabId+='<option disabled="" selected="">Hospitals</option>';
						
						for(var i = 0; i < result.length; i++){
						
							console.log(result[i].id);
							console.log(result[i].name);
							console.log(result[i].city);
							
							//tabId+= '<option value="' + result[i].id +'">' + result[i].name + '</option>';
							$('#hospital').append('<option value="' + result[i].id +'">' + result[i].name + '</option>');
						}					
						//tabId+='</select>';
						
						//$('#resultHospitals').html(tabId);
						
					}
			});
		}
		
		function populateDepts(){
			
				var hospital = $("#hospital option:selected").val();
				
				$.ajax({
				
					type: 'GET',
					url: '${pageContext.request.contextPath }/getDeptsByHospital/' + hospital,
					success: function(result){
					
						var result = jQuery.parseJSON(result);
						
						var tabId = '<select name="dept" id="dept">';
						tabId+='<option disabled="" selected="">Depts</option>';
						
						for(var i = 0; i < result.length; i++){
						
							console.log(result[i]);
							
							tabId+= '<option value="' + result[i] +'">' + result[i] + '</option>';
						}					
						tabId+='</select>';
						
						$('#resultDepts').html(tabId);
						
					}
			});
		}
	});	
</script>
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
	<!-- <form action="showHospitals"> -->
	<form action="showDoctors">
		<table align="center">
			<tr>
				<td><h4 align="left">Cities: </h4></td>
				<td><select name="city" id="city">
						<c:forEach items="${cities}" var="city">
							<option value="${city}">${city}</option>
						</c:forEach>

				</select></td>
			</tr>
			
		</table><br>
		<div align="center">
		<select name="hospital" id="hospital"><option disabled="" selected="">Hospitals</option></select>
		</div><br>
		<!-- <div id = "resultHospitals" align="center"></div> -->
		<div id = "resultDepts" align="center"></div>
		<!-- <div id = "resultDoctors" align="center"></div> -->
		<br>
		<div align="center">
		<button type="submit">Submit</button></div>
		
	</form>

</body>
</html>