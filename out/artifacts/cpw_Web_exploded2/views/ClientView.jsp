<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientView</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <a href="${pageContext.servletContext.contextPath}/views/ClientCreate.jsp">Добавить клиента</a>
    <div class="block0">
        <table class="block1">
            <tr>
                <td class="block1">id</td>
                <td class="block1">Имя</td>
                <td class="block1">Изменение</td>
                <td class="block1">Удаление</td>
            </tr>
            <c:forEach items="${clients}" var="client" varStatus="status">
                <div class="block1">
                    <tr>
                        <td class="block1">id</td>
                        <td class="block1">${client.name}</td>
                        <td class="block1">
                            <a href="${pageContext.servletContext.contextPath}/client/edit?clientName=${client.name}">Изменить</a>
                        </td>
                        <td class="block1">
                            <a href="${pageContext.servletContext.contextPath}/client/delete?clientName=${client.name}">Удалить</a>
                        </td>
                    </tr>
                    <tr>
                        <td class="block1">Имя</td>
                        <td class="block1">Тип</td>
                        <td class="block1">Изменение</td>
                        <td class="block1">Удаление</td>
                    </tr>
                    <c:forEach items="${client.pets}" var="pet">
                        <tr>
                            <td class="block1">${pet.name}</td>
                            <td class="block1">${pet.type}</td>
                            <td class="block1">Изменить</td>
                            <td class="block1">Удалить</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td class="block1">
                            <a href="${pageContext.servletContext.contextPath}/pet/create?clientName=${client.name}">Добавить питомца</a>
                        </td>
                    </tr>
                </div>
                <tr>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>
