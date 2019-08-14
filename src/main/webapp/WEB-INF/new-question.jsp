<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" href='<c:url value="/css/style.css"/>'
	type="text/css" />
<script type="text/javascript" src="js/myscript.js"></script>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<div class="container">
		<h1>What is your question?</h1>

		<form action="/addQuestion" method="POST">

			<div class="form-group">
				<label for="exampleFormControlTextarea1">Question:</label>
				<textarea class="form-control" name="question" rows="3"></textarea>
			</div>

			<div class="form-group">
				<label for="exampleFormControlInput1">Tags:</label> <input
					type="text" class="form-control" name="tags">
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>

</body>
</html>