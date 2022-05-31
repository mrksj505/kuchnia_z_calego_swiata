<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>Registration</title>
</head>
<body class="container">
<h1>Registration</h1>

<form:form action="register" method="post" modelAttribute="registerDTO">
   <div class="form-group">
      <label>Username
            <form:input path="username"/>
      </label>
   </div>
   <div class="form-group">
      <label>Password
            <form:input path="password"/>
      </label>
   </div>
   <div class="form-group">
      <label>Verify Password
            <form:input path="verifyPassword"/>
      </label>
   </div>
   <input type="submit" class="btn btn-primary" value="Register" />
</form:form>

</body>
</html>