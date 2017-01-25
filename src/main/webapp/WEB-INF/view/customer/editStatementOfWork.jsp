<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
<c:out value="${statementOfWork}"/><br/>
<div>
    <c:out value="${statementOfWork.name}"/><br/>
    <c:out value="${statementOfWork.customerId}"/><br/>
    <c:out value="${statementOfWork.filingDate}"/><br/>
    <c:out value="${statementOfWork.approved}"/><br/>
    <hr/>
</div>

</body>
</html>
