<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>

<html lang="us">

<style>
	body {
		/* background: url("http://androidroots.com/wp-content/uploads/2012/09/jelly_bean_6.jpg"); */
		background : url("resources/images/colors.jpg");
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

	<div class="container">
		<form:form  id="locationSearchForm" method="POST" commandName="locationSearchForm" modelAttribute="locationSearchForm" cssClass="form-inline">
			
			<div class="jumbotron">
				<h1>Hi there ! What's for lunch today?</h1>
				<p>If you are undecided, let us help you decide !</p>
			</div>
			
			<form:errors path="*" cssClass="alert alert-info" element="div" />
			
			<form class="form-inline" role="form">	
				<div class="form-group">
					<label class="sr-only">Find a place to eat or drink</label>
					<form:input path="searchTerm" name="searchTerm" id="searchTerm" type="text" placeholder="Food, bars or anything" cssClass="form-control"/>
					<br>
				</div>
				
				<div class="form-group">	
					<label class="sr-only">Near</label>
					<form:input path="zipCode" name="zipCode" id="zipCode" type="text" placeholder="City or Zip code" cssClass="form-control"/>
					<br>
				</div>
					
				<button id="findLunchLocations" type="submit" name="search" value="search" class="btn btn-primary" >Let's find lunch</button>
			</form>	
		</form:form>
	</div>	
</html>