<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>
<c:set value="${pageContext.request.contextPath}/js" var="scripts" />

<html>
<style>
	body {
	/*background: url("http://40daysofsnap.files.wordpress.com/2013/03/food-face.jpg");*/
	background-size: cover;	 
}
</style>

<head>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js">
    </script>
	<title>Search Listings</title>
</head>

<form:form  id="showSearchListingsForm" commandName="locationSearchForm" modelAttribute="locationSearchForm">
		<body>
				<c:if test="${not empty results} "></c:if>
				<label>Found </label>
				<form:input path="searchTerm" name="searchTerm" id="searchTerm" type="text" align="center" placeholder="Food/Bars/Anything"/>
				<label> near </label>
				<form:input path="zipCode" name="zipCode" id="zipCode" type="text" align="center" placeholder="Zip Code (Optional)"/>
				
				
				<button id="findLunchLocations" type="button">Go!</button>
				<br/>
					 <script type="text/javascript">
					 $(document).ready(function(){
						 	$("homeForm").submit(function() {
						 		return false;
						 	}) ;
						 	
						 	$("#findLunchLocations").click(function() {
						 			
					 				if(zipCode.value) {
										var location = zipCode.value;
										$.post("findLunchLocations", $("#locationSearchForm").serializeArray());
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
</form:form>
</html>
