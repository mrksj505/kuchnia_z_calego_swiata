<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="${pageContext.request.contextPath}/css/main.css" rel="stylesheet" >
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Przepis</title>
</head>
<body>
    	<div class="bot" style="background-color: rgb(255, 99, 71, 0.40);">
    			<div align="center">
    				<p><img alt="photo" src="${pageContext.request.contextPath}/images/${meal.meal_name}.jpg" width="300" height="200"></p>
    			</div>
    			<div >
					<p>NAZWA - ${meal.meal_name}</p>
					<p>RODZAJ - ${meal.kind}</p>
					<p>KRAJ- ${meal.country}</p>
					<p>CZAS (min) - ${meal.minutes_to_cook}</p>
					<p>PRZEPIS - ${meal.recipe}</p>
				</div>
		</div>
</body>
</html>