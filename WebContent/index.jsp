<%@page import="pl.otogra.service.ReviewService"%>
<%@page import="pl.otogra.service.GameService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page import="pl.otogra.model.Game" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

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
<link
	href="${pageContext.request.contextPath}/resources/css/shop-homepage.css"
	rel="stylesheet">
	
	<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	 rel="stylesheet">

</head>

<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container">
		<a href="${pageContext.request.contextPath}/" class="navbar-brand">Otogra</a>

		<button class="navbar-toggle" data-toggle="collapse"
			data-target=".navHeaderCollapse">
			<span class="glyphicon glyphicon-list"></span>
		</button>

		<div class="collapse navbar-collapse navHeaderCollapse">
			<ul class="nav navbar-nav navbar-right">
				<li class="active"><a href="${pageContext.request.contextPath}/">Główna</a></li>
				<li><a href="${pageContext.request.contextPath}/add">Dodaj</a></li>
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

	<!-- Page Content -->
	<div class="container">

		<div class="row">

			<div class="col-md-3">
			<c:choose>
					<c:when test="${not empty sessionScope.user}">
						<p class="lead"><c:out value="${user.username}"/></p>
					</c:when>
					
				</c:choose>
			
			
				<!--  <p class="lead">Shop Name</p>-->
				<div class="list-group">
					<a href="${pageContext.request.contextPath}/my" class="list-group-item">Moje gry</a> 
					<a href="${pageContext.request.contextPath}/random" class="list-group-item">Losuj</a> 
					<a href="${pageContext.request.contextPath}/sort" class="list-group-item">Sortuj</a>
				</div>
			</div>

			<div class="col-md-9">

				<div class="row carousel-holder">

					<div class="col-md-12">
						<div id="carousel-example-generic" class="carousel slide"
							data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel-example-generic" data-slide-to="0"
									class="active"></li>
								<li data-target="#carousel-example-generic" data-slide-to="1"></li>
								<li data-target="#carousel-example-generic" data-slide-to="2"></li>
							</ol>
							<div class="carousel-inner">
							<c:forEach var="g" items="${requestScope.games}" begin="0" end="2" varStatus="loopCounter">
							<c:choose> 
							    <c:when test="${loopCounter.count==1}">
							        <div class="item active">
									<img class="slide-image" src="${pageContext.request.contextPath}/image/${g.photo}"
										alt="">
										</div>
							    </c:when>    
							    <c:otherwise>
							         <div class="item ">
									<img class="slide-image" src="${pageContext.request.contextPath}/image/${g.photo}"
										alt="">
										</div>
							    </c:otherwise>
							</c:choose>
							</c:forEach>	
								
								<!--  <div class="item active">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>
								<div class="item">
									<img class="slide-image" src="http://placehold.it/800x300"
										alt="">
								</div>-->
							</div>
							<a class="left carousel-control" href="#carousel-example-generic"
								data-slide="prev"> <span
								class="glyphicon glyphicon-chevron-left"></span>
							</a> <a class="right carousel-control"
								href="#carousel-example-generic" data-slide="next"> <span
								class="glyphicon glyphicon-chevron-right"></span>
							</a>
						</div>
					</div>

				</div>

				<div class="row">
					 <c:if test="${not empty requestScope.games}">
	    <c:forEach var="game" items="${requestScope.games}">
					<div class="col-sm-4 col-lg-4 col-md-4">
						<div class="thumbnail">
						
							<img src="${pageContext.request.contextPath}/image/${game.photo}" alt="">
							
							<div class="caption">
								<h4 class="pull-right"><c:out value="${game.price}"/> pln</h4>
								<h4>
									<a href='<c:out value="${pageContext.request.contextPath}/game?id=${game.id}"/>'><c:out value="${game.title}"/></a>
									<br>
									<p><small>Rok: <c:out value="${game.year}"/></small></p>
								</h4>
								<p>
									<c:out value="${game.description }"/>
								</p>
							</div>
							<div class="ratings">
							<%
							GameService service = new GameService();
							ReviewService reviewService=new ReviewService();
							long gameId=((Game)pageContext.findAttribute("game")).getId();
							int score=reviewService.getScore(gameId);
							int reviewCount=service.getReviewCount(gameId);
							
							request.setAttribute("gameScore", score);
							request.setAttribute("reviewCount", reviewCount);
							%>
								<p class="pull-right"><c:out value="${reviewCount}"/> reviews</p>
								<p>
								<c:forEach var="i" begin="1" end="5">
						<c:choose> 
							    <c:when test="${i<gameScore/reviewCount && reviewCount!=0}">
							        <span class="glyphicon glyphicon-star"></span>  
							    </c:when>    
							    <c:otherwise>
							         <span
								class="glyphicon glyphicon-star-empty"></span>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
									<!-- <span class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> <span
										class="glyphicon glyphicon-star"></span> -->
								</p>
							</div>
						</div>
					</div>
					</c:forEach>
					</c:if>

					
				</div>

			</div>

		</div>

	</div>
	<!-- /.container -->

	<div class="container">

		<hr>

		<!-- Footer -->
		<footer>
		<div class="row">
			<div class="col-lg-12">
				<p>Copyright &copy; Otogra 2018</p>
			</div>
		</div>
		</footer>

	</div>
	<!-- /.container -->

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script src="resources/js/bootstrap.js"></script>

</body>

</html>
