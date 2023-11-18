<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Add a Dojo</title>
</head>
<body>
	<div class="container">
		<h2>New Dojo</h2>
		<form:form action="/dojo/new" modelAttribute="dojo" method="post">
			<form:label path="name" for="name">Name</form:label>
			<form:input path="name" type="text" id="name"/>
			<input type="submit" value="Create"/>
		</form:form>
	</div>
</body>
</html>