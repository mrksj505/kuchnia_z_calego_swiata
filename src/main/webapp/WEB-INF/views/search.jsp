<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Result</title>
</head>
<body>
<div align="center">
    <h2>Search Result</h2>
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
        <c:forEach items="${result}" var="meal">
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