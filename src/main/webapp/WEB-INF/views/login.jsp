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
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Log in</title>
</head>
<h1>Log in</h1>
<body>
	<form:form action="login" method="post" modelAttribute="loginDTO">

		<div class="form-group">
			<label>Username <form:input name="username" path="username" />
			</label>
		</div>
		<div class="form-group">
			<label>Password <form:input path="password" />
			</label>
		</div>
		<input type="submit" class="btn btn-primary" value="Log In" />
	</form:form>
	<p>
		Don't have an account? <a href="/Kuchnia3MVC/register">Register
			for one.</a>
	</p>

</body>
</html>