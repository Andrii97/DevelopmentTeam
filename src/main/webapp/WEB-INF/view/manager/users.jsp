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
<c:out value="${AttributesHolder.DEVELOPERS}"/><hr/>
<table border="1" cellpadding="5">
    <caption><fmt:message key="users"/></caption>
    <tr>
        <th><fmt:message key="user.id"/></th>
        <th><fmt:message key="user.first.name"/></th>
        <th><fmt:message key="user.middle.name"/></th>
        <th><fmt:message key="user.last.name"/></th>
        <th><fmt:message key="user.role"/></th>
        <th><fmt:message key="user.is.active"/></th>
        <th><fmt:message key="developer.qualification"/></th>
        <th><fmt:message key="developer.is.free"/></th>
    </tr>
    <c:forEach var="dev" items="${requestScope[AttributesHolder.DEVELOPERS]}">
        <tr>
            <td><c:out value="${dev.user.id}"/></td>
            <td><c:out value="${dev.user.firstName}"/></td>
            <td><c:out value="${dev.user.middleName}"/></td>
            <td><c:out value="${dev.user.lastName}"/></td>
            <td><c:out value="${dev.user.role}"/></td>
            <td><c:out value="${dev.user.active}"/></td>
            <td><c:out value="${dev.qualification}"/></td>
            <td><c:out value="${dev.free}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
