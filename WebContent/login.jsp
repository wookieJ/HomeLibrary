<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html">
<html>
<head>
<!-- RESPONSIVE PAGE FOR PHONES -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	type="text/css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/css/styles.css"
	type="text/css" rel="stylesheet" />
<title>Zaloguj się</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="WEB-INF/fragments/header.jspf"></jsp:include>
	<!-- Logowanie -->
	<div class="container">
		<div class="col-sm-6 col-md-4 col-md-offset-4">
			<form class="form-signin" action="j_security_check" method="post">
				<h2 class="form-signin-heading">Zaloguj się</h2>
				<input name="j_username" type="text" class="form-control"
					placeholder="Nazwa użytkownika" required autofocus> <input
					name="j_password" type="password" class="form-control"
					placeholder="Hasło" required>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Zaloguj</button>
				<a href="register">Zarejestruj</a>
			</form>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="WEB-INF/fragments/footer.jspf"></jsp:include>

</body>
</html>