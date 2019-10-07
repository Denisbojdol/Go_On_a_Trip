<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: denis
  Date: 11.09.2019
  Time: 09:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form:form method="post" modelAttribute="user" >
    <div><label> User Email : <form:input path="username" type="text" name="username"/> </label></div>
    <form:errors path="username" cssClass="error" />
    <div><label> User Name : <form:input path="name" type="text" name="name"/> </label></div>
    <form:errors path="name" cssClass="error" />
    <div><label> User Surname : <form:input path="surname" type="text" name="surname"/> </label></div>
    <form:errors path="surname" cssClass="error" />
    <div><label> Password: <form:input path="password" type="password" name="password"/> </label></div>
    <form:errors path="password" cssClass="error" />
    <div><label> Password: <form:input path="password2" type="password" name="password"/> </label></div>
    <form:errors path="password2" cssClass="error" />

    <div><input type="submit" value="Zarejestruj się"/></div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form:form>

</body>
</html>
