<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Meal Manager</title>
</head>
<body>
	<div align="center">
		<h1>Meals List 2</h1>
		<form method="get" action="search">
        	<input type="text" name="keyword" /> &nbsp;
        	<input type="submit" value="Search" />
    	</form>
		<h3><a href="new">New Meal</a></h3>
		
		<table border="1" cellpadding="5">
			<tr>
				<th>Number</th>
				<th>Name</th>
				<th>Kind</th>
				<th>Country</th>
				<th>Minutes to Cook</th>
				<th>Recipe</th>
				<th>Image</th>
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
				<td><img alt="photo" src="${pageContext.request.contextPath}/images/${meal.meal_name}.jpg" width="100" height="75"></td>
				<td>
					<a href="edit?id=${meal.id_meal}">Edit</a>
					&nbsp;&nbsp;
					<a href="delete?id=${meal.id_meal}">Delete</a>
				</td>
			</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>