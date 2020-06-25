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
<title>Friends List</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>

<!-- MainBody -->
<main class="container">

<h1>${profile.name}'s Friend List</h1>
<p>
<c:choose>
<c:when test="${user.id == profile.id}">
<a href="/user">Go to your page </a>/
</c:when>
<c:otherwise>
<a href="/profile?id=${profile.id}">Back to profile </a>/  
</c:otherwise>
</c:choose>
<a href="/users">See Users</a>
</p>
<c:choose>
<c:when test="${friends}">
<ul>
	<c:forEach var="friend" items="${list}">
		<li>
			${friend.username} - <a href="/profile?id=${friend.id}">See profile</a>
			<br>
		</li>
	</c:forEach>
</ul>
</c:when>
<c:otherwise>
No friends yet.<br>
</c:otherwise>
</c:choose>

</main>

</body>
</html>