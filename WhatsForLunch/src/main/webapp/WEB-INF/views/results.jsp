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

	<div class="container">
		
			<div class="row">
			
			
			<c:forEach var="business" items="${yelpResponse.businesses}">
				<c:set var="columnCounter" value="1"/>
				<div class="col-md-4">
				<div class="thumbnail">
				  <img src="${business.image_url}" alt="..." width="125" height="125">
				  <div class="caption">
						<h3 align="center">${business.name}</h3>
						<p align="center">
						<c:forEach var="address" items="${business.location.display_address}">
							<c:out value="${address}"></c:out>
						</c:forEach>
						</p>
				   </div>
				  <img align="center" src="${business.rating_img_url_large}" alt="...">
				  <br>
				  <p align="center"><a href="#" class="btn btn-primary">Add to My Poll</a></p>
				</div>
			  </div>
			  <c:set var="columnCounter" value="${columnCounter+1}"/>
			  <c:if test="${columnCounter == '3'}">
			  	<br>
			  	<c:set var="columnCounter" value="1"/>
			  </c:if>
			  </c:forEach>
			</div>	
	</div>	
</html>