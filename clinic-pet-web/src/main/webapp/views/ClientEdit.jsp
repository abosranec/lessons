<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>ClientEdit</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/client/edit" method="post">
        <input type="hidden" name="oldClientName" value="${oldClientName}">
        <span>
            Изменяем данные для клиента "${oldClientName}":
        </span>
        <div>
            <span>Имя: </span>
            <input type="text" name="name" value="${oldClientName}" required>
        </div>
        <div>
            <input type="submit" value="Изменить">
        </div>
    </form>
</body>
</html>
