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
				<form class="adding-form" action="add" enctype='multipart/form-data' method="POST" >
					<h2 class="form-signin-heading">Dodaj książkę</h2>

					<div class="form-group">
						<label for="exampleInputEmail1">Tytuł</label> <input type="text"
							class="form-control" id="inputTitle"
							aria-describedby="inputTitle" name="inputTitle"
							placeholder="Podaj tytuł">
					</div>

					<div class="form-group">
						<label for="exampleInputEmail1">Autor</label> <input type="text"
							class="form-control" id="inputAuthor"
							aria-describedby="inputAuthor" name="inputAuthor"
							placeholder="Podaj autora lub autorki">
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
							<option>Programowanie</option>
							<option>Fantasy</option>
							<option>Sci-Fi</option>
							<option>Przygodowe</option>
							<option>Języki obce</option>
							<option>Kryminał</option>
							<option>Biografia</option>
						</select>
					</div>

					<div class="form-group">
						<label for="exampleTextarea">Opis</label>
						<textarea class="form-control" name="inputDescription"
							id="inputDescription" rows="3" placeholder="Opis"></textarea>
					</div>

					<div class="form-group">
						<label for="exampleInputFile">Okładka</label> <input type="file"
							class="form-control-file" name="inputFile" id="inputFile"
							aria-describedby="fileHelp" accept=".jpg, .png"> <small
							id="fileHelp" class="form-text text-muted">Podaj plik
							źródłowy okładki książki.</small>
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
					<button type="submit" class="btn btn-primary">Dodaj</button>
				</form>
			</div>
		</div>
	</div>

	<!-- Footer -->
	<jsp:include page="fragments/footer.jspf"></jsp:include>
</body>
</html>