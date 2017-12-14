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
<title>Strona główna</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
	<!-- Left Tree -->
	<!--<jsp:include page="WEB-INF/fragments/leftTree.jspf"></jsp:include>-->
	<!-- Index Body -->
	<div class="album text-muted">
		<div class="container">
			<div class="col-sm-9 col-md-10 navbar-right">
				<div class="row">
				
				
					<div class="card">
						<a href="#"> <img src="resources/covers/example.jpg"
							alt="Card image cap">
						</a>
						<p class="card-text">This is a wider card with supporting text
							below as a natural lead-in to additional content. This content is
							a little bit longer.</p>
					</div>
					
				</div>
			</div>

		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="WEB-INF/fragments/footer.jspf"></jsp:include>
	<!-- JavaScript includes -->
	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>