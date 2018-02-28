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
<title>Dodaj książkę</title>
</head>
<body>
	<!-- Header -->
	<jsp:include page="fragments/header.jspf"></jsp:include>
	<!-- Dodanie -->
	<div class="adding-box">
		<div class="container">
			<div class="col-sm-10 col-md-8 col-md-offset-2">
				<form class="adding-form" action="editBook" enctype='multipart/form-data' method="POST">
					<h2 class="form-signin-heading">Edytuj książkę:</h2>

					<div class="form-group">
						<label for="exampleInputEmail1">Tytuł</label> <input type="text"
							class="form-control" id="inputTitle"
							aria-describedby="inputTitle" name="inputTitle"
							value="${requestScope.book.title }">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Autor</label> <input type="text"
							class="form-control" id="inputAuthor"
							aria-describedby="inputAuthor" name="inputAuthor"
							value="${requestScope.book.author }">
					</div>

					<!-- <div class="form-group">
						<label for="exampleSelect2">Example multiple select</label> <select
							multiple class="form-control" id="exampleSelect2">
							<option>1</option>
							<option>2</option>
							<option>3</option>
							<option>4</option>
							<option>5</option>
						</select>
					</div> -->
					<div class="form-group">
						<label for="exampleSelect1">Kategoria</label> <select
							class="form-control" id="exampleSelect1" name="inputCategory">
							<c:choose>
								<c:when test="${requestScope.book.category == 'Programowanie'}">
									<option selected="selected">Programowanie</option>
								</c:when>
								<c:otherwise>
									<option>Programowanie</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'Fantasy'}">
									<option selected="selected">Fantasy</option>
								</c:when>
								<c:otherwise>
									<option>Fantasy</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'SciFi'}">
									<option selected="selected">SciFi</option>
								</c:when>
								<c:otherwise>
									<option>SciFi</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'Przygodowe'}">
									<option selected="selected">Przygodowe</option>
								</c:when>
								<c:otherwise>
									<option>Przygodowe</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'Języki obce'}">
									<option selected="selected">Języki obce</option>
								</c:when>
								<c:otherwise>
									<option>Języki obce</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'Kryminał'}">
									<option selected="selected">Kryminał</option>
								</c:when>
								<c:otherwise>
									<option>Kryminał</option>
								</c:otherwise>
							</c:choose>
							<c:choose>
								<c:when test="${requestScope.book.category == 'Biografia'}">
									<option selected="selected">Biografia</option>
								</c:when>
								<c:otherwise>
									<option>Biografia</option>
								</c:otherwise>
							</c:choose>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleTextarea">Opis</label>
						<textarea class="form-control" name="inputDescription"
							id="inputDescription" rows="3">${requestScope.book.description }</textarea>
					</div>

					<div class="form-group">
						<label for="exampleInputFile">Okładka</label> <input type="file"
							class="form-control-file" name="inputFile" id="inputFile"
							aria-describedby="fileHelp" accept=".jpg, .png"
							value="${requestScope.book.cover }"> <small id="fileHelp"
							class="form-text text-muted">Podaj plik źródłowy okładki
							książki.</small>
					</div>
					<!-- <fieldset class="form-group">
						<legend>Rozszerzenie</legend>
						<div class="form-check">
							<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="inputOption"
								id="inputMobiExtension" value="mobi" checked> MOBI
							</label>
						</div>
						<!-- <div class="form-check">
							<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="inputOption"
								id="optionsRadios2" value="option2"> Option two can be
								something else and selecting it will deselect option one
							</label>
						</div> 
						<div class="form-check disabled">
							<label class="form-check-label"> <input type="radio"
								class="form-check-input" name="inputOption"
								id="inputEpubExtension" value="epub" disabled> EPUB
							</label>
						</div>
					</fieldset> -->
					<!-- <div class="form-check">
						<label class="form-check-label"> <input type="checkbox"
							class="form-check-input"> Check me out
						</label>
					</div> -->
					<input type="hidden" name="book_id" value=${requestScope.book.id }>
					<button type="submit" class="btn btn-primary">Zatwierdź</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="fragments/footer.jspf"></jsp:include>
</body>
</html>