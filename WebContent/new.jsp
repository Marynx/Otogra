<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

	<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">

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
				<li><a href="${pageContext.request.contextPath}/Test">test</a></li>
			</ul>
		</div>

	</div>
	</nav>


	<div class="container">
		<div class="col-md-8 col-md-offset-2">
			<form class="form-signin" method="post" action="add">
				<h2 class="form-signin-heading">Dodaj nową gre</h2>
				<input name="inputTitle" type="text" class="form-control" placeholder="Tytuł"
					required autofocus />
				<textarea name="inputDescription" rows="5" name="inputUsername"
					class="form-control" placeholder="Opis" required autofocus></textarea>
				<div class="row">
				<div class="col-sm-2">
				<input name="inputYear" type="number" min="1980" class="form-control" placeholder="Rok"
					required autofocus />
					</div>
					<div class="col-sm-2">
				<input name="inputPrice" type="number" min="0.00" step="1.00" class="form-control" placeholder="Cena"
					required autofocus />
				</div>
			</div>	
				<input class="btn btn-lg btn-primary btn-block" type="submit"
					value="Dodaj!" />
			</form>
		</div>
    </div>

	<footer class="footer">
	<div class="container">
		<p class="navbar-text">
			Weekop - developed by <a href="http://javastart.pl">JavaStart.pl</a>
		</p>
	</div>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>

</body>
</html>