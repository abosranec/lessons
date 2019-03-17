<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientCreate</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content-client">
        <form class="form-client" action="${pageContext.servletContext.contextPath}/client/create" method="post">
            <div class="client-header">
                Добавление нового клиента:
            </div>
            <div class="input-text">
                <span>Имя: </span>
                <input type="text" name="clientName" required placeholder="Введите полное имя" title="Введите полное имя">
            </div>
            <div class="input-text">
                <label for="sexID">Пол: </label>
                <select id="sexID" name="clientSex" required title="Выберите пол">
                    <option value="male">Мужской</option>
                    <option value="female">Женский</option>
                </select>
            </div>
            <div class="input-text">
                <span>Город: </span>
                <input type="text" name="clientCity" required placeholder="Введите город" title="Введите город">
            </div>
            <div class="input-text">
                <span>*Адрес: </span>
                <input type="text" name="clientAddress" placeholder="Введите адрес" title="Введите адрес">
            </div>
            <div class="input-text">
                <span>Телефон: </span>
                <input type="text" name="clientPhone" required placeholder="Введите телефон" title="Введите телефон">
            </div>
            <div class="input-text">
                <span>Почта: </span>
                <input type="text" name="clientMail" required placeholder="Введите почтовый адрес" title="Введите почтовый адрес">
            </div>
            <div>
                * - поля не обязательные для заполнения.
            </div>
            <input class="button" type="submit" value="Создать">
        </form>
    </div>
</body>
</html>
