<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Dojo Roster - <c:out value="${dojo.name}" /></title>
</head>
<body>
<h1><c:out value="${dojo.name}" /> Location Roster</h1>
	<table>
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Age</th>
			</tr>
		</thead>	
		<tbody>
			<c:forEach var="eachninja" items="${dojo.ninjas}">
				<tr>
					<td><c:out value="${eachninja.firstName }" /></td>
					<td><c:out value="${eachninja.lastName }" /></td>
					<td><c:out value="${eachninja.age }" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>