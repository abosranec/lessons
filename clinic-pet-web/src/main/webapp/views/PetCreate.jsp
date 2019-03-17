<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>PetCreate</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content-client">
        <form class="form-client" action="${pageContext.servletContext.contextPath}/pet/create" method="post">
            <input type="hidden" name="clientName" value="${clientName}">
            <div class="client-header">
                Добавление нового питомца для клиента "${clientName}":
            </div>
            <div class="input-text">
                <span>Имя: </span>
                <input type="text" name="petName" required placeholder="Введите имя" title="Введите имя">
            </div>
            <div class="input-text">
                <span>Тип: </span>
                <input type="text" name="petType" required placeholder="Введите тип" title="Введите тип">
            </div>
            <div class="input-text">
                <span>*Дата рождения: </span>
                <input type="date" name="petBirthday" placeholder="Выберете дату рождения" title="Выберете дату рождения">
            </div>
            <div>
                * - поля не обязательные для заполнения.
            </div>
            <input class="button" type="submit" value="Создать">
        </form>
    </div>
</body>
</html>
