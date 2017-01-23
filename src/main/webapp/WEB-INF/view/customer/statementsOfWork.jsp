<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
<c:out value="${statementsOfWork}"/><br/>
<div>
    <hr/>
    <c:forEach var="sow" items="${statementsOfWork}">
        <c:out value="${sow.name}"/><br/>
        <c:out value="${sow.customerId}"/><br/>
        <c:out value="${sow.filingDate}"/><br/>
        <c:out value="${sow.approved}"/><br/>
    </c:forEach>
    <hr/>
</div>

</body>
</html>
