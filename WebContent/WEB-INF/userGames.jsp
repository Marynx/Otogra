<%@page import="pl.otogra.model.Review"%>
<%@page import="pl.otogra.model.User"%>
<%@page import="pl.otogra.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<!--   <link
	href="${pageContext.request.contextPath}/resources/css/shop-homepage.css"
	rel="stylesheet">-->
	<link
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet">

</head>
<body>

	<jsp:include page="fragments/navbar.jspf" />

	<!-- Page Content -->
	<div class="container">
	<hr>
		<div class="row">

			<div class="col-md-3">
				<p class="lead">Otogra</p>
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/my" class="list-group-item">Moje gry</a> 
					<a href="${pageContext.request.contextPath}/random" class="list-group-item">Losuj</a> 
					<a href="${pageContext.request.contextPath}/sort" class="list-group-item">Sortuj</a>
				</div>
			</div>

			<div class="col-md-9">

 
				

				<div class="well">

					
<c:forEach var="userGame" items="${requestScope.userGames}">
	

					<!--  <div class="row">
						<div class="col-md-12">
							  ${userGame.title}<span
								class="pull-right"><c:out value="${userGame.title}"/></span>
							<p><c:out value="${userGame.title}"/></p>
						</div>
					</div>
					-->
					
					<div class="row bs-callout bs-callout-primary">
		      	
		      	 <div class="col  pull-left">
		      		 <img src="${pageContext.request.contextPath}/image/${userGame.photo}" alt="" height="120px" widht="170px">
		      	</div>
		      	
		        <div class="col col-md-6 col-sm-7" style="word-wrap:break-word">
		          <h3 class="centered"><a href="<c:out value="${pageContext.request.contextPath}/game?id=${userGame.id}" />"><c:out value="${userGame.title}" /></a>
		          </h3>
		          <p ><small>Rok:<c:out value="${userGame.year}"/></small></p>
		          <p><c:out value="${userGame.description}" /></p>
		        </div>
		        <div class="col col-md-2 col-sm-2 pull-right">
		      		<a href="${pageContext.request.contextPath}/edit?id=${userGame.id}" 
		      			class="btn btn-block btn-primary btn-success">
		      		<span> Edytuj</span>  </a>
		      		
		      		<a href="${pageContext.request.contextPath}/delete?id=${userGame.id}" 
		      			class="btn btn-block btn-primary btn-danger">
		      		<span>Usuń</span>  </a>
		      	</div>
		      </div>
					
					

				
</c:forEach>
					
				</div>
			
			</div>

		</div>
	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<jsp:include page="fragments/footer.jspf" />

	</div>
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>
	<script src="resources/js/bootstrap-confirmation.js"></script>
	<script src="resources/js/review.js"></script>

</body>

</html>