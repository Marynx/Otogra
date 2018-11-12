<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">

<title>Shop Homepage - Start Bootstrap Template</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->

<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet">

</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<a href="#" class="navbar-brand">Otogra</a>

		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navHeaderCollapse">
			<span class="glyphicon glyphicon-list"></span>
		</button>


		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="#">Główna</a></li>
				<li><a href="#">Dodaj</a></li>
				<li><a href="#">Zaloguj się</a></li>
				<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<li><a href="${pageContext.request.contextPath}/logout">Wyloguj się</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="${pageContext.request.contextPath}/login">Zaloguj się</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
		</div>

	</div>
	</nav>


	<div class="container">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form class="form-signin" action="j_security_check" method="post">
				<h2 class="form-signin-heading">Zaloguj się</h2>
				<input name="j_username" type="text" class="form-control"
					placeholder="Nazwa uzytkownika" required autofocus> <input
					name="j_password" type="password" class="form-control"
					placeholder="Hasło" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
				<a href="${pageContext.request.contextPath}/register">Zarejestruj</a>
			</form>
		</div>
	</div>
	<!-- /container -->

	<footer class="footer">
	<div class="container">
		<p class="navbar-text">
			Weekop - developed by <a href="http://javastart.pl">JavaStart.pl</a>
		</p>
	</div>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script> <script
		src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script> <script
		src="resources/js/bootstrap.js"></script>
</body>
</html>