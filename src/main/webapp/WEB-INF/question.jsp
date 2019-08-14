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
<title>Question Profile</title>
</head>
<body>
	<div class="container">
		<h1>
			<c:out value="${question.question}"></c:out>
		</h1>
		<h3>
			Tags:
			<c:forEach items="${question.tags}" var="tag">
				<button>${tag.subject}</button>
			</c:forEach>
		</h3>
		<div class="row">
			<div class="col-md-6">
				<table class="table lw">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Answers</th>
						</tr>
					</thead>
					<tbody>

						<c:forEach items="${question.answers}" var="answer">
							<tr>
								<td>${answer.answer}</td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="col-md-6">
				<h3>Add your answer:</h3>
				<form action="/addAnswer/${question.id}" method="POST">
					<div class="form-group">
						<textarea class="form-control wider" name="answer" rows="5"></textarea>
					</div>
					<button type="submit" class="btn btn-dark">Answer it!</button>
				</form>
			</div>

		</div>
	</div>

</body>
</html>