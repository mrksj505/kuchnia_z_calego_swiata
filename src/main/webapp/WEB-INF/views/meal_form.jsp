<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
<meta charset="UTF-8">
<title>New/Edit Meal</title>
</head>
<body>
	<div align="center">
		<h1>New/Edit Meal</h1>
		<form:form action="save" method="post" modelAttribute="meal">
		<table>
			<form:hidden path="id_meal"/>
			<tr>
				<td>Name:</td>
				<td><form:input path="meal_name"/></td>
			</tr>
			<tr>
				<td>Kind:</td>
				<td><form:input path="kind"/></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><form:input path="country"/></td>
			</tr>
			<tr>
				<td>Minutes to cook:</td>
				<td><form:input path="minutes_to_cook"/></td>
			</tr>
			<tr>
				<td>Recipe:</td>
				<td><form:textarea style="white-space: pre-wrap;" id="recipe" path="recipe"/></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save"></td>
			</tr>
		</table>
		</form:form>
	</div>
</body>
</html>