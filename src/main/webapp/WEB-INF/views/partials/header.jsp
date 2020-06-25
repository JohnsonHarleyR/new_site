<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
<link href="/style.css" rel="stylesheet" />

<meta charset="ISO-8859-1">
<title>Navigation</title>
</head>
<body>







<!-- Navigation Bar -->
<nav class="navbar navbar-custom">

<!--
display: flex;
  justify-content: center;
  align-items: center;
-->
	
	<ul class="nav" >

		<li class="nav-item">
			<a class="nav-link" href="/"><img height=30px src="/house_icon.png"></a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/mind">Mind</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/soul">Soul</a>
		</li>
		<li class="nav-item">
			<a class="nav-link" href="/forum">Forum</a>
		</li>
		
	</ul>
	
	

	<ul  class="nav">
	
		<c:if test="${user.status == 'admin'}">
			<li class="nav-item" >
				<a style="color:#000000;" class="nav-link">Admin</a>
			</li>
		</c:if>
	
		<li class="nav-item" >
			<c:choose>
				<c:when test="${loggedin == false}">
					<a class="nav-link" href="/login">Sign In</a>
				</c:when>
				<c:when test="${loggedin == true}">
				<a id="hello" class="nav-link" href="/user"><c:out value="Hello, ${user.name}!"/></a>
				</c:when>
			</c:choose>
		</li>
		
		<c:choose>
			<c:when test="${loggedin == false}">
			</c:when>
			<c:when test="${loggedin == true}">
				<li class="nav-item">
				<a class="nav-link" href="/settings">Settings</a>
					
				</li>
			</c:when>
		</c:choose>
		
		<li class="nav-item">
			<c:choose>
				<c:when test="${loggedin == false}">
					<a class="nav-link" href="/sign-up">Sign up</a>
				</c:when>
				<c:when test="${loggedin == true}">
				<a class="nav-link" href="/logout">Sign Out</a>
				</c:when>
			</c:choose>
		</li>
		
		<c:if test="${loggedin}">
			<c:if test="${user.unreadMessages == 0 }">
				<li class="nav-item">
					<a href='/messages' class='nav-link'>
					New Messages</a>
				</li>
			</c:if>
		
		</c:if>
		
		<c:choose>
		<c:when test='${!loggedin}'>
			<li class="nav-item">
			</li>
		</c:when>
		<c:when test='${user.requests != ""}'>
			<li class="nav-item">
				<a id="requestli" href='/requests' class='nav-link'>
				Friend Requests</a>
			</li>
		</c:when>
		<c:otherwise>
			<li class="nav-item">
			</li>
		</c:otherwise>
		</c:choose>
		
		<c:choose>
			<c:when test="${loggedin == false}">
			</c:when>
			<c:when test="${loggedin == true}">
				<li class="nav-item">
				<a class="nav-link" disabled>${user.points} pts</a>
				</li>
			</c:when>
		</c:choose>
		
	</ul>
	
	
</nav>

</body>
</html>