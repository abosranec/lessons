<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>ClientEdit</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content-client">
        <form class="form-client" action="${pageContext.servletContext.contextPath}/client/edit" method="post">
            <input type="hidden" name="oldClientName" value="${oldClient.name}">
            <div class="client-header">
                Изменяем данные для клиента "${oldClient.name}":
            </div>
            <div class="input-text">
                <span>Имя: </span>
                <input type="text" name="clientName" value="${oldClient.name}" required placeholder="Введите полное имя" title="Введите полное имя">
            </div>
            <div class="input-text">
                <label for="sexID">Пол: </label>
                <select id="sexID" name="clientSex" onselect="${oldClient.sex}" required required title="Выберите пол">
                    <c:set var="male" scope="session" value="male" />
                    <c:set var="female" scope="session" value="female" />
                    <c:set var="selected" scope="session" value="selected" />
                    <option value="male"
                        <c:if test="${oldClient.getSex().equals(male)}">
                            <c:out value="${selected}"/>
                        </c:if>>Мужской</option>
                    <option value="female"
                        <c:if test="${oldClient.getSex().equals(female)}">
                            <c:out value="${selected}"/>
                        </c:if>>Женский</option>
                </select>
            </div>
            <div class="input-text">
                <span>Город: </span>
                <input type="text" name="clientCity" value="${oldClient.city}" required placeholder="Введите город" title="Введите город">
            </div>
            <div class="input-text">
                <span>*Адрес: </span>
                <input type="text" name="clientAddress" value="${oldClient.address}" placeholder="Введите адрес" title="Введите адрес">
            </div>
            <div class="input-text">
                <span>Телефон: </span>
                <input type="text" name="clientPhone" value="${oldClient.phone}" required placeholder="Введите телефон" title="Введите телефон">
            </div>
            <div class="input-text">
                <span>Почта: </span>
                <input type="text" name="clientMail" value="${oldClient.mail}" required placeholder="Введите почтовый адрес" title="Введите почтовый адрес">
            </div>
            <div>
                * - поля не обязательные для заполнения.
            </div>
            <input class="button" type="submit" value="Изменить">
        </form>
    </div>
</body>
</html>
