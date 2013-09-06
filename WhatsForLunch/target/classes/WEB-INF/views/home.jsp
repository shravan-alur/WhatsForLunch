<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<!-- link rel="stylesheet" href="resources/css/dot-luv/boostrap.min.css"/-->
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>
	
	<title>Home</title>
</head>

<form:form  id="locationSearchForm" commandName="locationSearchForm" modelAttribute="locationSearchForm">
		<body>
				<div class="hero-unit">
					<h1>Hi there ! What's for lunch today?</h1>
					<p>If you are undecided, like most of us are, let us help you decide !</p>
				</div>
				
				<form class="navbar-form">
					<form:input path="searchTerm" name="searchTerm" id="searchTerm" type="text" align="center" placeholder="Food/Bars/Anything"/>
					<form:input path="zipCode" name="zipCode" id="zipCode" type="text" align="center" placeholder="Zip Code (Optional)"/>
					<button id="findLunchLocations" type="button" class="btn">Go!</button>
				</form>
				
				
				<br/>
					 <script type="text/javascript">
					 $(document).ready(function(){
						 	$("homeForm").submit(function() {
						 		return false;
						 	}) ;
						 	
						 	$("#findLunchLocations").click(function() {
						 			
					 				if(zipCode.value) {
										var location = zipCode.value;
										$.post("findLunchLocationsByCity", $("#locationSearchForm").serializeArray());
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
