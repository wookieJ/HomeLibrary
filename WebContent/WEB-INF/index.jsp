<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html">
<html>
<head>
<!-- RESPONSIVE PAGE FOR PHONES -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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

	<div class="page-container">

		<!-- top navbar -->
		<jsp:include page="fragments/header.jspf"></jsp:include>

		<div class="container">
			<div class="row row-offcanvas row-offcanvas-left">

				<!-- main area -->
				<div class="col-xs-12 col-sm-12 col-md-12">
					<div class="books">
						<c:if test="${param.isEmpty == 1}">
							<h2 id="warning">Nie znaleziono książek</h2>
						</c:if>
						<c:if test="${not empty requestScope.books}">
							<c:forEach var="book" items="${requestScope.books}">
								<!-- <div class="card">
								<a href="#"> <img src="${book.cover}" alt="Card image cap">
								</a>
								<h2 class="card-text">${book.title}</h2>
							</div> -->
								<div class="col col-md-12 col-sm-12">
									<div class="row bs-callout bs-callout-primary">
										<div class="image">
											<div class="col col-md-2 col-sm-4">
												<a href="#"> <img src="${book.cover}"
													alt="Card image cap" width="128" height="180">
												</a>
											</div>
										</div>
										<div class="row-container">
											<div class="col col-md-10 col-sm-10">
												<h3 class="centered">
													<a href="<c:out value="#" />"><c:out
															value="${book.title}" /></a>
												</h3>
												<h6>
													<small>Dodane przez: <c:out
															value="${book.user.username}" /></small>
												</h6>
												<p>
													<c:out value="${book.description}" />
												</p>

												<form action="rate" method="GET">
													<div class="rating-box">
														<div class="container">
															<div class="row">
																<div class="col col-md-4 col-sm-8 col-xs-10">
																	<input id="input-2-xs" name="inputRate"
																		class="rating" data-min="0"
																		data-max="5" data-step="0.1" data-size="xs"
																		value=${book.rate }>
																</div>
																<div class="col col-md-1 col-sm-1 col-xs-1">
																	<input type="hidden" name="book_id" value=${book.id }>
																	<input type="submit" value="Oceń">
																</div>
															</div>
														</div>
													</div>
												</form>

												<div class="more-button">
													<a href="<c:out value="#" />"
														class="btn btn-default btn-xs">Więcej</a>
												</div>
												<c:if test="${requestScope.roleName == 'admin'}">
													<div class="delete-button">
														<a
															href="${pageContext.request.contextPath}/editBook?book=${book.id}">
															<button type="button" class="btn btn-warning">
																<span class="glyphicon glyphicon-pencil"
																	aria-hidden="true"></span> Edytuj
															</button>
														</a> <a
															href="${pageContext.request.contextPath}/deleteBook?book=${book.id}">
															<button type="button" class="btn btn-danger">
																<span class="glyphicon glyphicon-remove"
																	aria-hidden="true"></span> Usuń
															</button>
														</a>
													</div>
												</c:if>
											</div>
										</div>
									</div>

								</div>
							</c:forEach>
						</c:if>

					</div>

				</div>
				<!-- /.col-xs-12 main -->
			</div>
			<!--/.row-->
		</div>
		<!--/.container-->
		<!-- Footer -->
		<jsp:include page="fragments/footer.jspf"></jsp:include>

	</div>
	<!--/.page-container-->

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