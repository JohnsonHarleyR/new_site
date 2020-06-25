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
<title>Soul Page</title>
</head>
<body>

<!-- Header -->
<section class="header">
<%@ include file="partials/header.jsp" %>
</section>



<!-- MainBody -->
<main class="container">
<h1>Soul</h1>

<script>
function addPoints() {
  alert("You just earned a point.");
}
</script>

<!-- test for users -->
   <c:if test = "${loggedin == true}">

<div>
        <h3>Your Rank is: <c:out value = "${names}"/></h3>
        </div>
		<div class="progress">
			<div class="progress-bar" role="progressbar" style="width:<c:out value ="${percent}"/>%;" aria-valuenow="${total}"
				aria-valuemin="${min}" aria-valuemax="${max}"></div>
		</div>
		<p> Total Soul Points: <c:out value = "${total}"/></p>
		<p> Points till the Next Rank: <c:out value = "${nextRank}"/></p>
</div>

</c:if>

<!-- Let's try baby animals - Harley's API-->
<img id="baby" style="padding: 15px;float: right; width: 500px;" src="${baby}" />

<br>


<!-- If user is logged in, show option to save -->
<section id="affirmation" style="font-size:larger" >
<c:choose>
	<c:when test="${!loggedin}">
		${affirmation}
		<br>
	</c:when>
	<c:when test="${exists}">
		${affirmation}
		<br>
	</c:when>
	<c:otherwise>
		<form action="/save/affirmation" method="post">
			${affirmation}
			<br>
			<input type="hidden" name="affirmation" 
			value="${affirmation}"/>
			<button class="btn btn-info btn-sm" onclick="addPoints()" type="submit">Save</button>
		</form>
	</c:otherwise>
</c:choose>
</section>

<br>
<br>

<!-- Do it mental health quote now -->
<!-- If user is logged in, show option to save -->
<section id="mquote" style="font-size:larger">

<c:choose>
	<c:when test="${loggedin == false}">
		${mquote.quote}
		-${mquote.author}
		<br>
	</c:when>
	<c:when test="${mexists == true}">
		${mquote.quote}
		-${mquote.author}
		<br>
	</c:when>
	<c:otherwise>
		<form action="/save/affirmation" method="post">
			${mquote.quote}
			-${mquote.author}
			<br>
			<input type="hidden" name="affirmation" 
			value="${mquotestring}"/>
			<button class="btn btn-info" onclick="addPoints()" type="submit">Save</button>
		</form>
	</c:otherwise>
</c:choose>
</section>


<br>
<br>

<!-- Do it with the quote nows -->
<!-- If user is logged in, show option to save -->
<section id="quote" style="font-size:larger">
<c:choose>
	<c:when test="${loggedin == false}">
		${quote.quote}
		${quote.author}
		<br>
	</c:when>
	<c:when test="${qexists == true}">
		${quote.quote}
		${quote.author}
		<br>
	</c:when>
	<c:otherwise>
		<form action="/save/affirmation" method="post">
			${quote.quote}
			${quote.author}
			<br>
			<input type="hidden" name="affirmation" 
			value="${quotestring}"/>
			<button class="btn btn-info" onclick="addPoints()" type="submit">Save</button>
		</form>
	</c:otherwise>
</c:choose>
</section>


 
</main>

</body>
</html>