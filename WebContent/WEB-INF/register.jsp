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
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css" type="text/css" rel="stylesheet"/>
<title>Rejestracja</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="fragments/header.jspf" />
	
	<!-- Rejestracja -->
	<div class="container">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form class="form-signin" action="register" method="post">
				<c:if test="${param.repeat == 1}">
					<h2 id="warning">Użytkownik o podanym mailu lub loginie już istnieje!</h2>
				</c:if>
				<h2 class="form-signin-heading">Zarejestruj się</h2>
				<input name="inputEmail" type="email" class="form-control" placeholder="Email" required autofocus>
				<input name="inputUsername" type="text" class="form-control" placeholder="Nazwa użytkownika" required>
				<input name="inputPassword" type="password" class="form-control" placeholder="Hasło" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Zarejestruj</button>
			</form>
		</div>
	</div>
	
	<!-- Footer -->
	<jsp:include page="fragments/footer.jspf" />

	<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
	<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/resources/js/bootstrap.js"></script>
</body>
</html>