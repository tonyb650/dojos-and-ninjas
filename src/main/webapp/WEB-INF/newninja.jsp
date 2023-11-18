<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add a Ninja</title>
</head>
<body>
	<div class="container">
		<h2>New Ninja</h2>
		<form:form action="/ninjas/new" modelAttribute="ninja" method="post">
			<form:label path="dojo" for="dojoName">Dojo:</form:label>
			<form:select path="dojo" id="dojoName">
				<c:forEach var="eachdojo" items="${dojos}">
					<form:option value="${ eachdojo.id }"><c:out value="${ eachdojo.name }"/></form:option>
				</c:forEach>
			</form:select>
			<form:label path="firstName" for="firstName">First Name:</form:label>
			<form:input path="firstName"  type="text" id="firstName" />
			<form:label path="lastName"  for="lastName">Last Name:</form:label>
			<form:input path="lastName"  type="text" id="lastName" />
			<form:label path="age"  for="age">Age:</form:label>
			<form:input path="age"  type="text" id="age" />
			<input type="submit" value="Create" />
		</form:form>
	</div>
</body>
</html>