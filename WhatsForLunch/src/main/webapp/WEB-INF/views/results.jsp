<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false" %>



<html lang="us">

<style>
	body {
		background : url("resources/images/colors.jpg");
		background-size: cover;	 
	}
</style>

	<head>
		<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
		<link rel="stylesheet" href="<c:url value="/resources/css/app.css"/>">
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
		<script type="text/javascript" src="<c:url value="/resources/js/jquery-2.0.3.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
		<script type="text/javascript">
			function equalHeight(group) {
				tallest = 0;
				group.each(function() {
					thisHeight = $(this).height();
					if(thisHeight > tallest) {
						tallest = thisHeight;
					}
				});
				
				group.each(function() {
					$(this).height(tallest);
				});
			}
		
			$(document).ready(function() {
					equalHeight($(".thumbnail"));
				
					$('button').on('click', function() {
					var business = document.getElementById('businessName').value;
					$.ajax({
						type: "POST",
						url: "addToPoll",
						data: {"id" : business},
						success : function(response) {
							if(response == "FALSE") {
								bootbox.alert("Oops, something went wrong! Please try again later.", function() {
					                console.log("Could not add to poll");
					            });
							}
							else {
								$('#pass').html('Added your selection to the poll.');
							}	
						}
					});
				});
				
			});//end document ready
		</script>
	</head>
	
	<body>
		<!-- <div>
			<ul class="nav nav-pills pull-right">
		      <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Home</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-list"></span> Poll Dashboard</a></li>
		      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Contact</a></li>
	    	</ul>
	    </div> -->	
    	
    	<br>
    	
		<div class="container">
			<div id="pass" class="alert alert-success" hidden="true"></div>
				<div class="row">
					<c:set var="columnCounter" value="1"/>
					<c:forEach var="business" items="${yelpResponse.businesses}">
							<div id="resultCard" class="col-md-4" >
									<div class="thumbnail">
									  <h3 align="center"><a href="${business.url}">${business.name}</a></h3>
									  <input id="businessName" value="${business.id}" type="hidden">
									  <img src="${business.image_url}" width="125" height="125" onError="this.onerror=null;this.src='http://placehold.it/125x125&text=WFL';" />
										  <div class="caption">
											<p align="center">
											<c:forEach var="address" items="${business.location.display_address}">
												<c:out value="${address}"></c:out>
											</c:forEach>
											</p>
										   </div>
									  <img align="center" src="${business.rating_img_url_large}">
									  <br>
									  <p align="center"><button id="${business.id}" type="button" class="btn btn-primary" name="addToPoll" value="addToPoll"><span class="glyphicon glyphicon-ok-circle"></span> Add to poll</button></p>
									</div>
							  	</div>
						  	<c:set var="columnCounter" value="${columnCounter+1}"/>
							<c:choose>
							  <c:when test="${columnCounter == '4'}">
							  	<br/>
							  	<c:set var="columnCounter" value="1"/>
							  </c:when>
							</c:choose>
					</c:forEach>
				</div>	
		</div>
	</body>	
</html>