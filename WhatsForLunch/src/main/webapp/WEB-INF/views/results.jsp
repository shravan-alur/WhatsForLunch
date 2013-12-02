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
		
		$.fn.uniformHeight = function () {
			var maxHeight = 0,
	            wrapper,
	            wrapperHeight;

	        return this.each(function () {

	            // Applying a wrapper to the contents of the current element to get reliable height
	            wrapper = $(this).wrapInner('<div class="wrapper" />').children('.wrapper');
	            wrapperHeight = wrapper.outerHeight();

	            maxHeight = Math.max(maxHeight, wrapperHeight);

	            // Remove the wrapper
	            wrapper.children().unwrap();

	        }).height(maxHeight);
	    }
		
		$.fn.equalizeHeights = function() {
			  var maxHeight = this.map(function( i, e ) {
			    return $( e ).height();
			  }).get();
			  return this.height( Math.max.apply( this, maxHeight ) );
			};
		
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
		
		$(window).bind("load", function() {
			equalHeight($(".thumbnail"));
		});
		
		$(document).ready(function() {
			$.notify.defaults({ className: "success" });
			
			//equalHeight($(".thumbnail"));
			//$('#row').equalize();
			//$('#thumbnail').equalizeHeights();
			//$('#thumbnail').uniformHeight();
			
			$('#notifyFriends').on('click', function(event){
				event.preventDefault();
				bootbox.prompt("Enter the email IDs of your friends separated by a comma", function(result) {                
					  if (result === null) {                                             
					  	//Cancel button                           
					  } else {
					    console.log("sending email to: " + result);
					    $.ajax({
					    	type: "POST",
					    	url: "sendNotification",
					    	data : {"emails" : result},
					    	success: function(response) {
					    		if(response == "FALSE") {
					    			bootbox.alert("Something went wrong while sending emails. Please try again.");
					    		}
					    		else {
					    			$.notify("Your emails were sent, now lets wait for the results !", {globalPosition : "bottom left"});
					    		}
					    	}
					    });
					  }
				});
			});
			
			$('.addToPollButton').on('click', function() {
			var business_id = $(this).attr('id');
			var business_name = $(this).siblings('input').val();
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
						$.notify(business_name + " added to your poll !", {globalPosition : "bottom left"});
					}	
				}
			});
		});
	});//end document ready
	</script>
	</head>
	
	<body>
		<div id="notificationMenu" class="well well-sm" data-spy="affix" data-offset-top="100">
			<h4 align="center">When you are done picking options, invite friends via email to vote and pick a winner. Open the flood gates any time.
				<button id="notifyFriends" name="notifyFriends" type="button" class="btn btn-primary"><span class="glyphicon glyphicon-envelope"></span> Let's ask my friends</button>
			</h4>
		</div>
			
		<div class="container" id="results">
			<div class="row" id="row">
			<c:set var="i" value="1"/>
    				<c:forEach var="business" items="${yelpResponse.businesses}">
							<div id="resultCard" class="col-md-4">
								<div class="thumbnail" id="thumbnail">
								  <h3 align="center"><a href="${business.url}">${business.name}</a></h3>
								  <img src="${business.image_url}" width="125" height="125" onError="this.src='http://placehold.it/125x125&text=WFL';" />
									  <div class="caption">
										<p align="center">
										<c:forEach var="address" items="${business.location.display_address}">
											<c:out value="${address}"></c:out>
										</c:forEach>
										</p>
									 </div>
								  <img align="center" src="${business.rating_img_url_large}"/>
								  <%-- <c:out value="${i}"/> --%>
								  <br>
								  <p align="center">
								  	<input id="businessName" value="${business.name}" hidden="true"/>
								  	<button id="${business.id}" type="button" class="btn btn-primary addToPollButton"><span class="glyphicon glyphicon-ok-circle"></span> Add to poll</button>
								  </p>
								</div>
							 </div>
							 <c:set var="i" value="${i + 1}"/>
					</c:forEach>
			</div>	
		</div>
	</body>	
</html>