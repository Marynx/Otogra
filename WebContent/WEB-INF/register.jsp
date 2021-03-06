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

<title>Otogra</title>

<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->

	<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet">

</head>
<body>

	<jsp:include page="fragments/navbar.jspf" />




<div class="container">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form class="form-signin" method="post" action="${pageContext.request.contextPath}/register">
				<h2 class="form-signin-heading">Zarejestruj się</h2>
				<input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus />
				<input name="inputUsername" type="text" name="inputUsername" class="form-control" placeholder="Nazwa użytkownika" required autofocus />
				<input name="inputPassword" type="password" class="form-control" placeholder="Hasło" required />
				<button class="btn btn-lg btn-primary btn-block" type="submit" >Zarejestruj</button>
			</form>
		</div>
    </div>

<div class="container">

		<hr>

		<!-- Footer -->
		<jsp:include page="fragments/footer.jspf" />

	</div>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>

</body>
</html>