<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http:/
/www.w3.org/TR/html4/loose.dtd">
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

<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet">

</head>
<body>

	<jsp:include page="fragments/navbar.jspf" />


	<div class="container">
		<div class="col-md-6 col-md-offset-3">
			<c:if test="${game == null}">
			<form class="form-signin" method="post" action="add" enctype="multipart/form-data">
				<h2 class="form-signin-heading">Dodaj nową gre</h2>
				<label>Dodaj zdjęcie:</label>
				 <span class="btn btn-default btn-file">
					<input name="inputPhoto" type="file" id="imgInp" required>
				</span>
				 <img id='img-upload' height="50%" width="50%" />
				  <input
					name="inputTitle" type="text" class="form-control"
					placeholder="Tytuł" required autofocus />
				<textarea name="inputDescription" rows="7" name="inputUsername"
					class="form-control" placeholder="Opis" required autofocus></textarea>
				<div class="row">
					<div class="col-sm-4">
						<input name="inputYear" type="number" min="1980"
							class="form-control" placeholder="Rok" required autofocus />
					</div>
					<div class="col-sm-4">
						<input name="inputPrice" type="number" min="0.00" step="1.00"
							class="form-control" placeholder="Cena" required autofocus />
					</div>
				</div>
				<input class="btn btn-lg btn-primary btn-block" type="submit"
					value="Dodaj!" />
			</form>	
			</c:if>
			<c:if test="${game != null}">
			<form class="form-signin" method="post" action="update" enctype="multipart/form-data">
			 <input type="hidden" name="id" value="<c:out value='${game.id}' />" />
				<h2 class="form-signin-heading">Edytuj grę</h2>
				<label>Zmień zdjęcie:</label>
				 <span class="btn btn-default btn-file">
					<input name="inputPhoto" type="file" id="imgInp" required>
				</span>
				 <img id='img-upload' height="50%" width="50%" />
				  <input
					name="inputTitle" type="text" class="form-control"
					placeholder="Tytuł" value="<c:out value="${game.title}"/>" required autofocus />
				<textarea name="inputDescription" rows="7" name="inputUsername"
					class="form-control" placeholder="Opis"  required autofocus><c:out value="${game.description}"/></textarea>
				<div class="row">
					<div class="col-sm-4">
						<input name="inputYear" type="number" min="1980"
							class="form-control" placeholder="Rok" value="<c:out value="${game.year}"/>" required autofocus />
					</div>
					<div class="col-sm-4">
					<fmt:parseNumber var = "i" type = "number" value = "${game.price}" />
						<input name="inputPrice" type="number" min="0.00" step="1.00"
							class="form-control" placeholder="Cena" value="<c:out value="${i}"/>" required autofocus />
					</div>
				</div>
				<input class="btn btn-lg btn-primary btn-block" type="submit"
					value="Edytuj!" />
			</form>	
			</c:if>
		</div>
	</div>

	<div class="container">

		<hr>

		<!-- Footer -->
		<jsp:include page="fragments/footer.jspf" />

	</div>

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script> <script
		src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script> <script
		src="resources/js/bootstrap.js"></script> <script
		src="resources/js/test.js"></script>
</body>
</html>