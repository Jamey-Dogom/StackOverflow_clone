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
<title>Questions Dashboard</title>
</head>
<body>
	<div class="container">
	<h3>StackOverflow (clone)</h3>
		<table class="table table-striped table-dark">
			<thead>
				<tr>
					<th scope="col">Question</th>
					<th scope="col">Tags</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach items="${questions}" var="question">
					<tr>
						<td><a href="/questions/${question.id}">${question.question}</a></td>
						<td>
						<c:forEach items = "${question.tags}" var = "tag">
						${tag.subject}
						</c:forEach>
						</td>
						
					</tr>
				</c:forEach>

			</tbody>
		</table>
	<a class = "ur" href="/questions/new">New Question</a>
	</div>

</body>
</html>