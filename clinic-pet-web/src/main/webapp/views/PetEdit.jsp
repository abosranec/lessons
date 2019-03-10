<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>ClientEdit</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <form action="${pageContext.servletContext.contextPath}/pet/edit" method="post">
        <input type="hidden" name="clientName" value="${clientName}">
        <input type="hidden" name="oldPetName" value="${pet.name}">
        <span>
            Изменяем данные питомца "${pet.name}" для клиента "${clientName}":
        </span>
        <div>
            <span>Имя: </span>
            <input type="text" name="name" value="${pet.name}" required>
        </div>
        <div>
            <span>Имя: </span>
            <input type="text" name="type" value="${pet.type}" required>
        </div>
        <div>
            <span>Дата рождения: </span>
            <input type="date" name="birthday" value="${pet.birthday}">
        </div>
        <div>
            <input type="submit" value="Изменить">
        </div>
    </form>
</body>
</html>
