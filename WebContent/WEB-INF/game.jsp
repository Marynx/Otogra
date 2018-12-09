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
<link
	href="${pageContext.request.contextPath}/resources/css/shop-homepage.css"
	rel="stylesheet">
	<link
	href="${pageContext.request.contextPath}/resources/css/styles.css"
	rel="stylesheet">

</head>
<body>

	<jsp:include page="fragments/navbar.jspf" />

	<!-- Page Content -->
	<div class="container">

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
 <c:if test="${not empty requestScope.game}">
 
				<div class="thumbnail">
					<img class="img-responsive" src="${pageContext.request.contextPath}/image/${game.photo}"
						alt="" width="800px" height="320px">
					<div class="caption-full">
						<h4 class="pull-right"><c:out value="${game.price}"/>pln</h4>
						<h4>
							<p><c:out value="${game.title }"/></p>
							<p><small>Rok: <c:out value="${game.year}"/></small></p>
						</h4>
						<p><c:out value="${game.description }"/></p>
					</div>
					<div class="ratings">
						<p class="pull-right"><c:out value="${reviewCount}"/> reviews</p>
						<p>
						
						<c:forEach var="i" begin="1" end="5">
						<c:choose>
							    <c:when test="${i<score/reviewCount && reviewCount!=0 }">
							        <span class="glyphicon glyphicon-star"></span>  
							    </c:when>    
							    <c:otherwise>
							         <span
								class="glyphicon glyphicon-star-empty"></span>
							    </c:otherwise>
							</c:choose>
						</c:forEach>
								<c:choose>
							    <c:when test="${reviewCount!=0 }">
							        <fmt:formatNumber value="${score/reviewCount}" maxFractionDigits="1"/> stars
							    </c:when>    
							    <c:otherwise>
							        0 stars
							    </c:otherwise>
							</c:choose>
								
						</p>
					</div>
					
				</div>

				<div class="well">

					
		<div class="row">
		
    	<div class="well well-sm">
            <div class="text-center">
            <c:choose>
					<c:when test="${not empty sessionScope.user}">
					
						<a class="btn btn-success btn-lg btn-green" id="open-review-box">Leave a Review</a>
					
					</c:when>
					<c:otherwise>
						<a class="btn btn-success btn-lg btn-green" href="${pageContext.request.contextPath}/addr?id=${game.id}" id="open-review-box">Leave a Review</a>
					</c:otherwise>
				</c:choose>
               <!--   <a class="btn btn-success btn-lg btn-green" href="${pageContext.request.contextPath}/addr?id=${game.id}" id="open-review-box">Leave a Review</a>-->
            </div>
        
            <div class="row" id="post-review-box" style="display:none;">
                <div class="col-md-12">
                    <form accept-charset="UTF-8" action="addr?gameId=${game.id}" method="post">
                    	
                        <input id="ratings-hidden" name="rating" type="hidden" required> 
                        <textarea class="form-control animated" cols="50" id="new-review" name="comment" placeholder="Enter your review here..." rows="5" required></textarea>
        
                        <div class="text-right">
                            <div class="stars starrr" data-rating="0"></div>
                            <a class="btn btn-danger btn-sm" href="#" id="close-review-box" style="display:none; margin-right: 10px;">
                            <span class="glyphicon glyphicon-remove"></span>Cancel</a>
                            <button class="btn btn-success btn-lg" type="submit" >Leave review</button>
                        </div>
                    </form>
                </div>
            </div>
        </div> 
         
		
	</div>
<c:forEach var="review" items="${requestScope.reviews}">
					<hr>

					<div class="row">
						<div class="col-md-12">
						<%
    UserService service=new UserService();
	 Long review=((Review)pageContext.findAttribute("review")).getUserId();
	User user=service.read(review);
    String name=user.getUsername();
    request.setAttribute("userReviewName",name);
%>
							<c:forEach var="i" begin="1" end="5"> 
								<c:choose>
					<c:when test="${i<review.score}">
						<span class="glyphicon glyphicon-star"></span>
					</c:when>
					<c:otherwise>
						<span class="glyphicon glyphicon-star-empty"></span>
					</c:otherwise>
				</c:choose>
								
							</c:forEach>  ${userReviewName}<span
								class="pull-right"><c:out value="${review.time}"/></span>
							<p><c:out value="${review.comment}"/></p>
						</div>
					</div>

					<hr>
</c:forEach>
				</div>
				</c:if>
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
	<script src="resources/js/review.js"></script>

</body>

</html>