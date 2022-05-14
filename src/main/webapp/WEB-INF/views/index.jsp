<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meal Manager</title>
</head>
<body>
	<div align="center">
		<h1>Meals List 2</h1>
		
		<table border="1" cellpadding="5">
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Kind</th>
				<th>Country</th>
				<th>Minutes to Cook</th>
				<th>Recipe</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${listMeal}" var="meal" varStatus="status">
			<tr>
				<td>${meal.id_meal}</td>
				<td>${meal.meal_name}</td>
				<td>${meal.kind}</td>
				<td>${meal.country}</td>
				<td>${meal.minutes_to_cook}</td>
				<td>${meal.recipe}</td>
				<td>
					<a href="edit?id=${meal.id_meal}">Edit</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>