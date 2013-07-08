<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false" %>
<c:set value="${pageContext.request.contextPath}/js" var="scripts" />

<html>
<style>
	body {
	background: url("http://40daysofsnap.files.wordpress.com/2013/03/food-face.jpg");
	background-size: cover;	 
}
</style>

<head>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
    </script>
	<title>Home</title>
</head>

<body>
	<h2 align="left">What's for lunch today?</h2>
	<label>Find me</label>
	<input id="searchTerm" name="searchTerm" type="text" align="center" placeholder="Food/Bars/Anything">
	<label> near </label>
	<input id="zipCode" name="zipCode" type="text" align="center" placeholder="Zip Code (Optional)">
	<button id="findLunchLocations">Go!</button>
	<br/>
	 <script type="text/javascript">
	 $(document).ready(function(){
	 			$("#findLunchLocations").click(function() {
	 				if(zipCode.value) {
						var location = zipCode.value;
						alert('location: ' + location);
					}
	 				else if(navigator.geolocation && !zipCode.value) {
	 					navigator.geolocation.getCurrentPosition(whereIsTheUser);
	 				}
	 				else {
	 					alert('Please enter a Zip or try a different browser for auto location');
	 				}
	 			});			
	 
	 			function whereIsTheUser(position) {
	 				var lat = position.coords.latitude;
					var lon = position.coords.longitude;
					alert('location: ' + lat +","+lon);
				}
		});	
		</script>
	</body>

</html>
