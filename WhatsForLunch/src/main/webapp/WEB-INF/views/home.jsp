<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<html lang="us">

<style>
	/* body {
		background : url("resources/images/colors.jpg");
		background-size: cover;	 
	} */	
</style>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="resources/css/app.css"/>
		<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css"/>
		<script type="application/javascript" src="<c:url value="/resources/js/jquery-2.0.3.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
	</head>
	
	<body>
		<ul class="nav nav-pills pull-right">
	      <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	      <li><a href="http://localhost:8082/WhatsForLunch/viewResults"><span class="glyphicon glyphicon-stats"></span> View Poll Results</a></li>
	      
	      
	      <!-- <li><a href="#"><span class="glyphicon glyphicon-user"></span> Contact</a></li> -->
	    </ul>
		
		<div class="container">
			<form:form  id="locationSearchForm" method="POST" commandName="locationSearchForm" modelAttribute="locationSearchForm" cssClass="form-inline">
				
				<div class="jumbotron" >
					<h1>Welcome to What's for Lunch?</h1>
					<p align="center">The fastest, most fun way to invite and ask friends what's for lunch !</p>
				</div>
				
				<form:errors path="*" cssClass="alert alert-info" element="div" />
				
				<div align="center">
					<form class="form-inline" role="form">	
						<div class="form-group">
							<label class="sr-only">Find a place to eat or drink</label>
							<form:input path="searchTerm" name="searchTerm" id="searchTerm" type="text" placeholder="Food, bars or anything" cssClass="form-control"/>
							<br>
						</div>
						
						<div class="form-group">	
							<label class="sr-only">Zipcode/City Name</label>
							<form:input path="zipCode" name="zipCode" id="zipCode" type="text" placeholder="City Name or Zip code" cssClass="form-control"/>
							<br>
						</div>
						
						<%-- <div class="form-group">	
							<label class="sr-only">Within</label>
								<form:select path="radius" name="radius" id="radius" cssClass="dropdown">
									<form:options items="${radiusList}"/>
								</form:select>
							<br>
						</div> --%>
							
						<button id="findLunchLocations" type="submit" name="search" value="search" class="btn btn-primary" ><span class="glyphicon glyphicon-search"></span> Let's find lunch</button>
						<!-- <button id="loginWithGoogle" type="submit" name="connectToGoogle" value="connectToGoogle" class="btn btn-primary">Login with Google</button> -->
					</form>
				</div>	
			</form:form>
		</div>
		<br><br><br><br><br><br><br><br>
		
		<footer>
			<div align="center">
				<iframe class="vine-embed" src="https://vine.co/v/ha9YVmn0utZ/embed/simple" width="510" height="300" frameborder="0" ></iframe>
			</div>
		</footer>
	</body>
</html>