<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
if (session.getAttribute("errorLogin") != null) {
%><p style="color: red"><%=session.getAttribute("errorLogin")%></p>
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
<title>Logowanie</title>
</head>

<body>

	<div align="center">
	<h1>Logowanie</h1>
	<form:form action="login" method="post" modelAttribute="loginDTO">

		<div class="form-group">
			<label>Nazwa <form:input name="username" path="username" />
			</label>
		</div>
		<div class="form-group">
			<label>Hasło <form:input type="password" path="password" />
			</label>
		</div>
		<input type="submit" class="button" value="&nbsp; Zaloguj &nbsp;" />
	</form:form>
	<p>
		Nie posiadasz konta ? <a href="/Kuchnia3MVC/register">Zarejestruj się.</a>
	</p>
	</div>

</body>
</html>