<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ClientCreate</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/client/create" method="post">
        <span>Name: </span>
        <input type="text" name="clientName">
        <input type="submit" value="submit">
    </form>
</body>
</html>
