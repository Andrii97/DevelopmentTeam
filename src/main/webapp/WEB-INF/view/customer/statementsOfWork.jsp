<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.training.utils.constants.UrlHolder" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
<%@include file="menu.jsp"%>
<div align="left">
    <a href="${UrlHolder.BASIC}${UrlHolder.ADD_STATEMENT_OF_WORK}"><fmt:message key="create"/></a>
</div>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><fmt:message key="statements.of.work.table.title"/></caption>
        <tr>
            <th><fmt:message key="statement.of.work.id"/></th>
            <th><fmt:message key="statement.of.work.name"/></th>
            <th><fmt:message key="statement.of.work.customerId"/></th>
            <th><fmt:message key="statement.of.work.filling.date"/></th>
            <th><fmt:message key="statement.of.work.is.approved"/></th>
            <th><fmt:message key="edit"/></th>
            <th><fmt:message key="delete"/></th>
        </tr>
        <c:forEach var="sow" items="${statementsOfWork}">
            <tr>
                <td><c:out value="${sow.id}"/></td>
                <td><c:out value="${sow.name}"/></td>
                <td><c:out value="${sow.customerId}"/></td>
                <td><c:out value="${sow.filingDate}"/></td>
                <td><c:out value="${sow.approved}"/></td>
                <td><a href="${UrlHolder.BASIC}${UrlHolder.STATEMENT_OF_WORK}${sow.id}">+</a></td>
                <td><a href="${UrlHolder.BASIC}${UrlHolder.DELETE_STATEMENT_OF_WORK}${sow.id}">+</a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>
