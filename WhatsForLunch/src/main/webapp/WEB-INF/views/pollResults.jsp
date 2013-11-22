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
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/bootstrap.min.css"/>">
		<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/app.css"/>">
		<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
		<script type="application/javascript" src="<c:url value="/resources/js/jquery-2.0.3.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/bootbox.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/equalize.min.js"/>"></script>
		<script type="application/javascript" src="<c:url value="/resources/js/notify.min.js"/>"></script>
		<script type="application/javascript">
		
		$(document).ready(function() {
		
			$.notify.defaults({ className: "success" });
			
			$('#shareWithFriends').on('click', function(event){
				event.preventDefault();
				bootbox.prompt("Enter the email IDs of your friends separated by a comma", function(result) {                
					  if (result === null) {                                             
					  	//Cancel button                           
					  } else {
					    console.log("sending email to: " + result);
					    $.ajax({
					    	type: "POST",
					    	url: "spreadTheWord",
					    	data : {"recipients" : result},
					    	success: function(response) {
					    		if(response == "FALSE") {
					    			bootbox.alert("Something went wrong while sending emails. Please try again.");
					    		}
					    		else {
					    			$.notify("Thanks for spreading the word !", {globalPosition : "bottom left"});
					    		}
					    	}
					    });
					  }
				});
			});
			
			$('.voteButton').on('click', function() {
			var business_id = $(this).attr('id');
			var business_name = $(this).siblings('input').val();
			$.ajax({
				type: "POST",
				url: "voteForChoice",
				data: {"id" : business_id},
				success : function(response) {
					if(response == "FALSE") {
							bootbox.alert("Oops, something went wrong! Please try again later.", function() {
			                console.log("Could not add to poll");
			            });
					}
					else {
						$.notify("Voted for " + business_name,  {globalPosition : "bottom left"});
					}	
				}
			});
		}); 
		
	});//end document ready
	</script>
	</head>
	
	<body>
		<div id="notificationMenu" class="well well-sm" data-spy="affix" data-offset-top="100">
			<h4 align="center">Friends don't let friends pick lunch destinations without a vote! Tell your friends about us!
				<button id="shareWithFriends" name="shareWithFriends" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-envelope"></span> Share with my friends</button>
			</h4>
		</div>
		
		<div class="container" id="results">
			<c:set var="i" value="1"></c:set>
		 	<c:forEach var="business" items="${requestedPoll.pollBusinessesList}">
 					<div class="thumbnail" id="pollResultCard">
 						<div class="row" id="row">
 							<div id="businessCard" class="col-md-4">
								<div class="thumbnail" id="thumbnail">
								  <h3 align="center"><a href="${business.businessYelpUrl}">${business.businessName}</a></h3>
								  <img src="${business.businessImageUrl}" width="85" height="85" onError="this.src='http://placehold.it/125x125&text=WFL';" />
								  <br>
								  <img align="center" src="${business.businessRatingImageUrl}"/>
								  <br>
								</div>
						 	</div>
					 			<br>
					 			<br>
							 <div class="pagination-centered">
								 <div id="poll" class="col-md-6 col-md-offset-1">
								   <div class="progress progress-striped active">
						 				<div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
											 <span class="sr-only">40% Complete (success)</span>
										 </div>
									</div>
									<p align="center">
									  	<input id="businessName" value="${business.businessName}" hidden="true"/>
									  	<button id="${business.businessYelpId}" type="button" class="btn btn-primary voteButton"><span class="glyphicon glyphicon-ok-circle"></span> Vote for this!</button>
									</p>
								 </div>
							</div>	
						</div>
					</div> 
			</c:forEach>
		</div>	
	</body>	
</html>