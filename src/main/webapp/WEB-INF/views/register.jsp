<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
if (session.getAttribute("errorUsername") != null) {
%><p style="color: red"><%=session.getAttribute("errorUsername")%></p>
<%
}
%>
<%
if (session.getAttribute("errorPasswords") != null) {
%><p style="color: red"><%=session.getAttribute("errorPasswords")%></p>
<%
}
%>

<html>
<head>
<style type="text/css">
body {
	color: white;
	font-size: 20px;
	font-family: "Trirong", serif;
	font-weight: bold;
	text-shadow: 1px 1px 1px #000000;
	background-color: Tomato;
}

input[type=text] {
	width: 30%;
	padding: 5px;
	box-sizing: border-box;
	margin-top: 5px;
	margin-bottom: 5px;
}
input[type=password] {
	width: 30%;
	padding: 5px;
	box-sizing: border-box;
	margin-top: 5px;
	margin-bottom: 5px;
}
.button {
	font-size: 20px;
	border: 2px solid white;
	border-radius: 10px;
	text-align: center;
	text-shadow: 1px 1px 1px #000000;
	text-decoration: none;
	background-color: Tomato;
	color: white;
}
</style>
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Rejestracja</title>
</head>
<body>
	<div align="center">
	<h1>Rejestracja</h1>

	<form:form action="register" method="post" modelAttribute="registerDTO">
		<div class="form-group">
			<label>Nazwa <form:input path="username" />
			</label>
		</div>
		<div class="form-group">
			<label>Hasło <form:input type="password" path="password" />
			</label>
		</div>
		<div class="form-group">
			<label>Powtórz hasło <form:input type="password" path="verifyPassword" />
			</label>
		</div>
		<input type="submit" class="button" value="Zarejestruj" />
	</form:form>
	</div>
</body>
</html>