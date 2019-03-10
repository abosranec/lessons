<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>PetCreate</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/pet/create" method="post">
        <input type="hidden" name="clientName" value="${clientName}">
        <div>
            <span>Имя: </span>
            <input type="text" name="petName" required>
        </div>
        <div>
            <span>Тип: </span>
            <input type="text" name="petType" required>
        </div>
        <input type="submit" value="Создать">
    </form>
</body>
</html>
