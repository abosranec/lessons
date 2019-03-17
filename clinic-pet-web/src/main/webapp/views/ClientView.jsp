<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientView</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
    <%--<style><%@include file="/css/styles.css"%></style>--%>
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content">
        <c:forEach items="${clients}" var="client" varStatus="status">
            <div class="user">
                <div class="user-head">
                    <div class="user-head-name">${client.name}</div>
                    <div class="user-head-edit control-buttons">
                        <a href="${pageContext.servletContext.contextPath}/client/edit?clientName=${client.name}">
                            <img class="icon" src="${pageContext.request.contextPath}/images/icon-edit.png">
                        </a>
                        <a href="${pageContext.servletContext.contextPath}/client/delete?clientName=${client.name}">
                            <img class="icon" src="${pageContext.request.contextPath}/images/icon-delete.png">
                        </a>
                    </div>
                </div>
                <div class="pets">
                    <div class="pet-menu">
                        <a class="button" href="${pageContext.servletContext.contextPath}/pet/create?clientName=${client.name}">
                            <img class="icon" src="${pageContext.request.contextPath}/images/icon-add.png"> Добавить питомца
                        </a>
                    </div>
                    <div class="pet-content">
                        <div class="pet-content-row">
                            <div>Имя</div>
                            <div>Тип</div>
                            <div>Дата</div>
                            <div>Настройки</div>
                        </div>
                        <c:forEach items="${client.pets}" var="pet">
                            <div class="pet-content-row">
                                <div >${pet.name}</div>
                                <div >${pet.type}</div>
                                <div >${pet.birthday}</div>
                                <div class="control-buttons">
                                    <a href="${pageContext.servletContext.contextPath}/pet/edit?clientName=${client.name}&petName=${pet.name}">
                                        <img class="icon" src="${pageContext.request.contextPath}/images/icon-edit.png">
                                    </a>
                                    <a href="${pageContext.servletContext.contextPath}/pet/delete?clientName=${client.name}&petName=${pet.name}">
                                        <img class="icon" src="${pageContext.request.contextPath}/images/icon-delete.png">
                                    </a>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="menu">
        <a class="button" href="${pageContext.servletContext.contextPath}/views/ClientCreate.jsp">
            <img class="icon" src="${pageContext.request.contextPath}/images/icon-add.png"> Добавить клиента
        </a>
    </div>

</body>
</html>
