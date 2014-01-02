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
	      <li><a href="http://localhost:8082/WhatsForLunch/home"><span class="glyphicon glyphicon-home"></span> Home</a></li>
	      <li class="active"><a href="#"><span class="glyphicon glyphicon-stats"></span> View Poll Results</a></li>
	     </ul>
		
		<div class="container">
			<form:form  id="resultSearchForm" method="POST" commandName="resultSearchForm" modelAttribute="resultSearchForm" cssClass="form-inline">
				
				<div class="jumbotron" >
					<h1 align="center">Which poll are we tracking today?</h1>
				</div>
				
				<form:errors path="*" cssClass="alert alert-info" element="div" />
				
				<div align="center">
					<form class="form-inline" role="form">	
						<div class="form-group">
							<label class="sr-only">ID of the poll you want to track</label>
							<form:input path="pollId" name="pollId" id="pollId" type="text" placeholder="Enter the poll ID you received on email" cssClass="form-control" size="40"/>
							<br>
						</div>
						
						<button id="viewPollResults" type="submit" name="findResults" value="findResults" class="btn btn-primary" ><span class="glyphicon glyphicon-search"></span> Find Poll</button>
						
					</form>
				</div>	
			</form:form>
		</div>
	</body>
</html>