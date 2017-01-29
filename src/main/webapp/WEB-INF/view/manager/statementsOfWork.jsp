<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
<%@include file="../menu.jsp"%>
<div>
    <table class="table">
        <caption><fmt:message key="statements.of.work.table.title"/></caption>
        <tr>
            <th><fmt:message key="statement.of.work.id"/></th>
            <th><fmt:message key="statement.of.work.name"/></th>
            <th><fmt:message key="statement.of.work.customer"/></th>
            <th><fmt:message key="statement.of.work.filling.date"/></th>
            <th><fmt:message key="statement.of.work.is.approved"/></th>
            <th><fmt:message key="create"/><fmt:message key="project"/></th>
        </tr>
        <c:forEach var="sow" items="${requestScope[AttributesHolder.STATEMENTS_OF_WORK]}">
            <tr>
                <td><c:out value="${sow.id}"/></td>
                <td><c:out value="${sow.name}"/></td>
                <td>
                    <c:out value="${sow.customer.firstName} ${sow.customer.middleName} ${sow.customer.lastName}"/>
                    <br/>
                    <fmt:message key="user.email"/>: <c:out value="${sow.customer.email}"/>
                </td>
                <td><c:out value="${sow.filingDate}"/></td>
                <td><c:out value="${sow.approved}"/></td>
                <td><a href="${PathsHolder.BASIC}${PathsHolder.CREATE_PROJECT}${sow.id}">
                    <button class="btn btn-warning"><fmt:message key="create"/></button>
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
