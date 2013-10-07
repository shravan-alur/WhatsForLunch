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
		<script type="text/javascript" src="<c:url value="/resources/js/equalize.min.js"/>"></script>
		<script type="text/javascript" src="<c:url value="/resources/js/notify.min.js"/>"></script>
		<%-- <script type="text/javascript" src="<c:url value="/resources/js/jquery.equalheights.js"/>"></script> --%>
		<script type="text/javascript">
			
		function equalHeight(group) {    
		    tallest = 0;    
		    group.each(function() {       
		        thisHeight = $(this).height();       
		        if(thisHeight > tallest) {          
		            tallest = thisHeight;       
		        }    
		    });    
		    group.each(function() { $(this).height(tallest); });
		} 
		
		$(document).ready(function() {
					equalHeight($(".thumbnail")); 
			
					$('button').on('click', function() {
					var business_id = $(this).attr('id');
					var business_name = $(this).siblings('input').val();
					//alert('Clicked ' + business_name);
					$.ajax({
						type: "POST",
						url: "addToPoll",
						data: {"id" : business_id},
						success : function(response) {
							if(response == "FALSE") {
								bootbox.alert("Oops, something went wrong! Please try again later.", function() {
					                console.log("Could not add to poll");
					            });
							}
							else {
								$.notify(business_name + " added to your poll !", "success");
							}	
						}
					});
				}); 
			});//end document ready
		</script>
	</head>
	
	<body>
		
    	<br>
    	
		<div class="container" id="results">
			<div class="row" id="row">
					<c:forEach var="business" items="${yelpResponse.businesses}">
							<div id="resultCard" class="col-sm-6 col-md-3">
								<div class="thumbnail">
								  <h3 align="center"><a href="${business.url}">${business.name}</a></h3>
								  <img src="${business.image_url}" width="125" height="125" class="img-responsive" onError="this.onerror=null;this.src='http://placehold.it/125x125&text=WFL';" />
									  <div class="caption">
										<p align="center">
										<c:forEach var="address" items="${business.location.display_address}">
											<c:out value="${address}"></c:out>
										</c:forEach>
										</p>
									 </div>
								  <img align="center" src="${business.rating_img_url_large}"/>
								  <br>
								  <p align="center">
								  	<input id="businessName" value="${business.name}" hidden="true"/>
								  	<button id="${business.id}" type="button" class="btn btn-primary" name="addToPoll" value="addToPoll">
								  	<span class="glyphicon glyphicon-ok-circle"></span> Add to poll</button>
								  </p>
								</div>
							 </div>
					</c:forEach>
			</div>	
		</div>
	</body>	
</html>