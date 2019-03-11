<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientCreate</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <div>
        <form action="${pageContext.servletContext.contextPath}/client/create" method="post">
            <div>
                <span>Имя: </span>
                <input type="" name="clientName" required>
            </div>
            <div>
                <label for="sexID">Пол: </label>
                <select id="sexID" name="clientSex" required>
                    <option value="male">Мужской</option>
                    <option value="female">Женский</option>
                </select>
            </div>
            <div>
                <span>Город: </span>
                <input type="text" name="clientCity" required>
            </div>
            <div>
                <span>*Адрес: </span>
                <input type="text" name="clientAddress">
            </div>
            <div>
                <span>Телефон: </span>
                <input type="text" name="clientPhone" required>
            </div>
            <div>
                <span>Почта: </span>
                <input type="text" name="clientMail" required>
            </div>
            <div>
                <input type="submit" value="Создать">
            </div>
            <div>
                <span>* - поля не обязательные для заполнения.</span>
            </div>
        </form>
    </div>
</body>
</html>
