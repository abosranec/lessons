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
        <input type="hidden" name="oldClientName" value="${oldClient.name}">
        <div>
            Изменяем данные для клиента "${oldClient.name}":
        </div>
        <div>
            <span>Имя: </span>
            <input type="text" name="clientName" value="${oldClient.name}" required>
        </div>
        <div>
            <label for="sexID">Пол: </label>
            <select id="sexID" name="clientSex" required>
                <option value="${oldClient.sex}">Мужской</option>
                <option value="${oldClient.sex}">Женский</option>
            </select>
        </div>
        <div>
            <span>Город: </span>
            <input type="text" name="clientCity" value="${oldClient.city}" required>
        </div>
        <div>
            <span>*Адрес: </span>
            <input type="text" name="clientAddress" value="${oldClient.address}">
        </div>
        <div>
            <span>Телефон: </span>
            <input type="text" name="clientPhone" value="${oldClient.phone}" required>
        </div>
        <div>
            <span>Почта: </span>
            <input type="text" name="clientMail" value="${oldClient.mail}" required>
        </div>
        <div>
            <input type="submit" value="Изменить">
        </div>
    </form>
</body>
</html>
