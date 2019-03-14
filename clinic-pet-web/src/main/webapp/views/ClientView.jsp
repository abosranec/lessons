<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientView</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <div class="header">
        <img class="header-logo" src="${pageContext.request.contextPath}/images/logo.jpg">
        <div class="header-name">Клиника домашних питомцев</div>
    </div>
    <div class="content">
        <c:forEach items="${clients}" var="client" varStatus="status">
            <div class="user-head">
                <span class="name">${client.name}</span>
                <span >
                    <a href="${pageContext.servletContext.contextPath}/client/edit?clientName=${client.name}">Изменить</a>
                </span>
                <span >
                    <a href="${pageContext.servletContext.contextPath}/client/delete?clientName=${client.name}">Удалить</a>
                </span>
            </div>
            <div class="pet-menu">
                <a href="${pageContext.servletContext.contextPath}/pet/create?clientName=${client.name}">Добавить питомца</a>
            </div>
            <div class="pet-head">
                <table class="block1">
                    <c:forEach items="${client.pets}" var="pet">
                        <tr>
                            <td >${pet.name}</td>
                            <td >${pet.type}</td>
                            <td >${pet.birthday}</td>
                                <%--<td class="block1"></td>--%>
                            <td >
                                <a href="${pageContext.servletContext.contextPath}/pet/edit?clientName=${client.name}&petName=${pet.name}">Изменить</a>
                            </td>
                            <td >
                                <a href="${pageContext.servletContext.contextPath}/pet/delete?clientName=${client.name}&petName=${pet.name}">Удалить</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </c:forEach>
    </div>
    <div class="menu">
        <a href="${pageContext.servletContext.contextPath}/views/ClientCreate.jsp">Добавить клиента</a>
    </div>

</body>
</html>
