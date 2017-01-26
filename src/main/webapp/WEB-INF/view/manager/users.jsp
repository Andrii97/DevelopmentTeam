<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<%@ page import="ua.training.utils.constants.PathsHolder" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="../menu.jsp"%>
<a href="${PathsHolder.BASIC}${PathsHolder.ADD_USER}"><fmt:message key="create"/></a>
<table border="1" cellpadding="5">
    <caption><fmt:message key="users"/></caption>
    <tr>
        <th><fmt:message key="user.id"/></th>
        <th><fmt:message key="user.first.name"/></th>
        <th><fmt:message key="user.middle.name"/></th>
        <th><fmt:message key="user.last.name"/></th>
        <th><fmt:message key="user.role"/></th>
        <th><fmt:message key="user.is.active"/></th>
    </tr>
    <c:forEach var="u" items="${sessionScope[AttributesHolder.USERS]}">
        <tr>
            <td><c:out value="${u.id}"/></td>
            <td><c:out value="${u.firstName}"/></td>
            <td><c:out value="${u.middleName}"/></td>
            <td><c:out value="${u.lastName}"/></td>
            <td><c:out value="${u.role}"/></td>
            <td><c:out value="${u.active}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
