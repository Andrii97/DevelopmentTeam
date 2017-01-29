<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <div>
        <form action="" method="post">
            <input type="hidden" name="${AttributesHolder.ID}" value="${statementOfWork.id}"/><br/>
            <div class="block">
                <label><fmt:message key="statement.of.work.name"/></label>
                <input type="text" name="${AttributesHolder.NAME}" value="${statementOfWork.name}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="statement.of.work.customer"/></label>
                <input type="number" readonly name="${AttributesHolder.CUSTOMER_ID}" value="${statementOfWork.customerId}"><br/>
            </div>
            <div class="block">
                <label><fmt:message key="statement.of.work.filling.date"/></label>
                <input type="date" name="${AttributesHolder.FILLING_DATE}" value="${statementOfWork.filingDate}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="statement.of.work.is.approved"/></label>
                <input type="checkbox" readonly name="${AttributesHolder.APPROVED}" value="${statementOfWork.approved}"/><br/>
                <c:out value="${statementOfWork.approved}"/><br/>
            </div>
            <button type="submit"><fmt:message key="save"/></button>
        </form>
        <hr/>
    </div>
</body>
</html>
