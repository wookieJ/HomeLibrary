<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap-theme.min.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/css/star-rating.min.css"
	type="text/css" rel="stylesheet" />

<title>Strona główna</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
	<!-- Left Tree -->
	<jsp:include page="WEB-INF/fragments/leftTree.jspf"></jsp:include>
	<!-- Index Body -->

	<div class="books">
		<c:if test="${not empty requestScope.books}">
			<c:forEach var="book" items="${requestScope.books}">
				<!-- <div class="card">
								<a href="#"> <img src="${book.cover}" alt="Card image cap">
								</a>
								<h2 class="card-text">${book.title}</h2>
							</div> -->
				<div class="container">
					<div class="row bs-callout bs-callout-primary">
						<div class="col col-md-2 col-sm-3">
							<a href="#"> <img src="${book.cover}" alt="Card image cap">
							</a>
						</div>
						<div class="col col-md-10 col-sm-9">
							<h3 class="centered">
								<a href="<c:out value="#" />"><c:out value="${book.title}" /></a>
							</h3>
							<h6>
								<small>Dodane przez: <c:out
										value="${book.user.username}" /></small>
							</h6>
							<p>
								<c:out value="${book.description}" />
							</p>

							<input id="input-2-xs" name="inputRate"
								class="rating rating-loading" data-min="0" data-max="5"
								data-step="0.1" data-size="xs" value = 0> <a
								href="<c:out value="#" />" class="btn btn-default btn-xs">Więcej</a>
						</div>
					</div>
				</div>
			</c:forEach>
		</c:if>
	</div>

	<!-- Footer -->
	<jsp:include page="WEB-INF/fragments/footer.jspf"></jsp:include>
	<!-- JavaScript includes -->
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/star-rating.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/star-rating.min.js"></script>
</body>
</html>