<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>ClientView</title>
    <style><%@include file="/css/styles.css"%></style>
</head>
<body>
    <a href="${pageContext.servletContext.contextPath}/views/ClientCreate.jsp">Add client</a>
    <div class="block0">
        <table class="block1">
            <tr>
                <td class="block1">id</td>
                <td class="block1">Имя</td>
                <td class="block1">Изменение</td>
                <td class="block1">Удаление</td>
            </tr>
            <c:forEach items="${clients}" var="client" varStatus="status">
                <tr>
                    <td class="block1">id</td>
                    <td class="block1">${client.name}</td>
                    <td class="block1">
                        <%--<form action="${pageContext.servletContext.contextPath}/client/edit" method="get">--%>
                            <%--<input type="hidden" name="clientName" value="${client.name}">--%>
                            <%--<input type="submit" value="Изменить">--%>
                        <%--</form>--%>
                        <a href="${pageContext.servletContext.contextPath}/client/edit?clientName=${client.name}">Изменить</a></td>
                    <td class="block1">
                        <a href="${pageContext.servletContext.contextPath}/client/delete?clientName=${client.name}">Удалить</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>


</body>
</html>
