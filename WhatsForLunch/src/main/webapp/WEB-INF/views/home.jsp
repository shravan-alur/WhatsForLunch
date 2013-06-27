<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>

<head>
	<title>Home</title>
</head>

<body>
	<h1>What's for lunch today?</h1>
	<P id="locationTester">Would you like to find places near your location?</P>
	<button id="getLocation" onclick="findUserLocation()">Get Location</button>
	
		<script type="text/javascript">
				var x = document.getElementById("locationTester");
				
				function findUserLocation() {
					if(navigator.geolocation) {
						navigator.geolocation.getCurrentPosition(whereIsTheUser);
					}
					else {
						x.innerHTML = "Try a different browser";
					}
				}
				
				function whereIsTheUser(position) {
					var lat = position.coords.latitude;
					var lon = position.coords.longitude;
					x.innerHTML = "Latitude: " + lat + " Longitude: " + lon; 
				}
		</script>
	</body>

</html>
