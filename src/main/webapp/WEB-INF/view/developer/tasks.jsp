<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="../menu.jsp"%>
<div align="left">
    <a href="${UrlHolder.BASIC}${UrlHolder.ADD_STATEMENT_OF_WORK}"><fmt:message key="create"/></a>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><fmt:message key="tasks"/></caption>
        <tr>
            <th><fmt:message key="task.id"/></th>
            <th><fmt:message key="task.name"/></th>
            <th><fmt:message key="task.description"/></th>
            <th><fmt:message key="task.is.finished"/></th>
        </tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td><c:out value="${task.id}"/></td>
                <td><c:out value="${task.name}"/></td>
                <td><c:out value="${task.description}"/></td>
                <td><c:out value="${task.finished}"/></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
