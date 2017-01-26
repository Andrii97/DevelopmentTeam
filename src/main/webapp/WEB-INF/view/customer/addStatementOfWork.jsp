<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../menu.jsp"%>
<div>
    <form action="" method="post">
        <div class="block">
            <label><fmt:message key="statement.of.work.name"/></label>
            <input type="text" name="${AttributesHolder.NAME}" value="${statementOfWork.name}"/><br/>
        </div>
        <div class="block">
            <label><fmt:message key="statement.of.work.is.approved"/></label>
            <input type="checkbox" readonly  name="${AttributesHolder.APPROVED}" value="${statementOfWork.approved}"/><br/>
            <c:out value="false"/><br/>
        </div>
        <button type="submit"><fmt:message key="save"/></button>
    </form>
    <hr/>
</div>
</body>
</html>
