<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Trirong">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kuchnia Świata</title>
</head>
<body>
	<form method="get" action="logout">
		<input class="button" type="submit" value="&nbsp; Wyloguj &nbsp;"/>
	</form>
	
		<div class="top" align="center">
			<h1 class="kuchnia_title">KUCHNIA ŚWIATA</h1>
			<form method="get" action="search">
	        	<input type="text" name="keyword" /> &nbsp;
	        	<input class="button" type="submit" value="&nbsp; Znajdź &nbsp;" />
	    	</form>
    	</div>
    	<div class="bot">
		<a class="button" href="new">&nbsp; + Dodaj nowe danie &nbsp;</a>
		
		<table border="1" cellpadding="5">
			<tr>
				<th>Numer</th>
				<th>Nazwa</th>
				<th>Rodzaj</th>
				<th>Kraj</th>
				<th>Czas (min)</th>
				<th>Zdjęcie</th>
				<th>Akcje</th>
			</tr>
			<c:forEach items="${listMeal}" var="meal" varStatus="status">
			<tr>
				<td>${meal.id_meal}</td>
				<td>${meal.meal_name}</td>
				<td>${meal.kind}</td>
				<td>${meal.country}</td>
				<td>${meal.minutes_to_cook}</td>
				<td><img alt="photo" src="${pageContext.request.contextPath}/images/${meal.meal_name}.jpg" width="150" height="100"></td>
				<td>
					<a class="button" style="border: 2px solid rgb(210, 210, 210);" href="details?id=${meal.id_meal}">&nbsp;Przepis&nbsp;</a>
					<br>
					<a class="button" style="border: 2px solid rgb(210, 210, 210);" href="edit?id=${meal.id_meal}">&nbsp;Edytuj&nbsp;</a>
					<br>
					<a class="button" style="border: 2px solid rgb(210, 210, 210);" href="delete?id=${meal.id_meal}">&nbsp;Usuń&nbsp;</a>
				</td>
			</tr>
			</c:forEach>
		</table>
		</div>
</body>
</html>