<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : newjsp
    Created on : Jul 2, 2014, 11:33:05 AM
    Author     : Joas Mogale
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="livevalidation_prototype.js" type="text/javascript"></script>
        <script src="validate.js" type="text/javascript"></script>
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <script type="text/javascript">
		window.onload = function(){ 
		//Get submit button
		var submitbutton = document.getElementById("tfq");
		//Add listener to submit button
		if(submitbutton.addEventListener){
			submitbutton.addEventListener("click", function() {
			if (submitbutton.value == 'Search our website'){//Customize this text string to whatever you want
				submitbutton.value = '';
			}
		});
	}
	}
</script>
<!-- CSS styles for standard search box with placeholder text-->
<link rel="stylesheet" href="css/style.css" type="text/css">
<style type="text/css">
	#tfheader{
		
	}
	#tfnewsearch{
		float:right;
		padding:20px;
	}
	.tftextinput2{
		margin: 0;
		padding: 5px 15px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		color:#666;
		border:1px solid #0076a3; border-right:0px;
		border-top-left-radius: 5px 5px;
		border-bottom-left-radius: 5px 5px;
	}
	.tfbutton2 {
		margin: 0;
		padding: 5px 7px;
		font-family: Arial, Helvetica, sans-serif;
		font-size:14px;
		font-weight:bold;
		outline: none;
		cursor: pointer;
		text-align: center;
		text-decoration: none;
		color: #ffffff;
		border: solid 1px #0076a3; border-right:0px;
		background: #0095cd;
		background: -webkit-gradient(linear, left top, left bottom, from(#00adee), to(#0078a5));
		background: -moz-linear-gradient(top,  #00adee,  #0078a5);
		border-top-right-radius: 5px 5px;
		border-bottom-right-radius: 5px 5px;
	}
	.tfbutton2:hover {
		text-decoration: none;
		background: #007ead;
		background: -webkit-gradient(linear, left top, left bottom, from(#0095cc), to(#00678e));
		background: -moz-linear-gradient(top,  #0095cc,  #00678e);
	}
	/* Fixes submit button height problem in Firefox */
	.tfbutton2::-moz-focus-inner {
	  border: 0;
	}
	.tfclear{
		clear:both;
	}
</style>
<!-- load tables, jQuery-->
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script>
$(document).ready(function(){
  $("#vehicleTable").click(function(){
    $( "#results" ).load( "insertVehicle.jsp" );
  });
  $("#ownerTable").click(function(){
    $( "#results" ).load( "insertOwner.jsp" );
  });
});
</script>
    </head>
    <body>
        <body>
	<div id="page">
		<div id="header">
			<a href="index.html" class="logo">
                            <img src="images/logo.png" alt=""></a>
			<div class="navigation">
				<ul class="primary">
					<li >
						<a href="index.html">home</a>
					</li>
					<li class="selected">
						<a href="report.jsp">Report</a>
					</li>
				</ul>
				<ul class="secondary">
					<li >
						<a href="edit.html">Edit</a>
					</li>
					<li>
						<a href="insertion.jsp">Insert</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="body">
			<div class="content">
				<div class="aside">
					<!-- HTML for SEARCH BAR -->
					<div id="tfheader">
						<form id="tfnewsearch" method="get" action="http://www.google.com">
						        <input type="text" id="tfq" class="tftextinput2" name="q" size="21" maxlength="120" value="Search"><input type="submit" value=">" class="tfbutton2">
						</form>
						<div class="tfclear"></div>
					</div>
                                        <div id="results">
                                            
                                        </div>
				</div>
			<div class="navbox">
					<ul class="nav">
						<li><a id ="vehicleTable" href="#">Vehicle</a></li> 
						<li><a id ="ownerTable" href="#">Owner</a></li>  
					</ul>
	</div>
			</div>
		</div>
		<div id="footer">
			<ul>
				<li class="twitter">
					<a href="http://freewebsitetemplates.com/go/twitter/">twitter</a>
				</li>
				<li class="facebook">
					<a href="http://freewebsitetemplates.com/go/facebook/">facebook</a>
				</li>
				<li class="googleplus">
					<a href="http://freewebsitetemplates.com/go/googleplus/">googleplus</a>
				</li>
			</ul>
			<p>
				&copy; Copyright 2014. All rights reserved
			</p>
		</div>
	</div>
</body>
    </body>
</html>
