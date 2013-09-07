<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<html lang="us">

<style>
	body {
		background: url("http://androidroots.com/wp-content/uploads/2012/09/jelly_bean_6.jpg");
		background-size: cover;	 
	}
</style>

<head>
	<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>">
	<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<script src="//ajax.googleapis.com/ajax/libs/jqueryui/1.7.1/jquery-ui.min.js"></script>
</head>


	<body>
		<div class="container">
			<form:form  id="locationSearchForm" commandName="locationSearchForm" modelAttribute="locationSearchForm">
		
		<div class="jumbotron">
						<h1>Hi there ! What's for lunch today?</h1>
						<p>If you are undecided, let us help you decide !</p>
		</div>
		
		
			<form class="navbar-form navbar-left">
					<input path="searchTerm" name="searchTerm" id="searchTerm" type="text" placeholder="Food/Bars/Anything" class="form-control"/>
					<br>
					<input path="zipCode" name="zipCode" id="zipCode" type="text" placeholder="Zip Code (Optional)" maxlength="5" class="form-control"/>
					<br>
					<button id="findLunchLocations" type="button" class="btn btn-default">Find</button>
			</form>
		
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
	
 	</form:form>
 	</div>
  </body>
  </div>
</html>