<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>ClientEdit</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content-client">
        <form class="form-client" action="${pageContext.servletContext.contextPath}/pet/edit" method="post">
            <input type="hidden" name="clientName" value="${clientName}">
            <input type="hidden" name="oldPetName" value="${pet.name}">
            <div class="client-header">
                Изменение данных питомца "${pet.name}" клиента "${clientName}":
            </div>
            <div class="input-text">
                <span>Имя: </span>
                <input type="text" name="name" value="${pet.name}" required placeholder="Введите имя" title="Введите имя">
            </div>
            <div class="input-text">
                <span>Тип: </span>
                <input type="text" name="type" value="${pet.type}" required placeholder="Введите тип" title="Введите тип">
            </div>
            <div class="input-text">
                <span>Дата рождения: </span>
                <input type="date" name="birthday" value="${pet.birthday}" placeholder="Выберете дату рождения" title="Выберете дату рождения">
            </div>
            <div>
                * - поля не обязательные для заполнения.
            </div>
            <input class="button" type="submit" value="Изменить">
        </form>
    </div>
</body>
</html>
