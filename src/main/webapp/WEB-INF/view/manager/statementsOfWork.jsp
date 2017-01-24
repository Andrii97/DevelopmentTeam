<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>statementOfWork</title>
</head>
<body>
<jsp:include page="../headerForAuthorizedUser.jsp"/>
<c:out value="${statementsOfWork}"/><br/>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of statements of work</h2></caption>
        <tr>
            <th>ID</th>
            <th>name</th>
            <th>customerId</th>
            <th>filingDate</th>
            <th>IsApproved</th>
            <th>Create <br/> Project</th>
        </tr>
        <c:forEach var="sow" items="${statementsOfWork}">
            <tr>
                <td><c:out value="${sow.id}"/></td>
                <td><c:out value="${sow.name}"/></td>
                <td><c:out value="${sow.customerId}"/></td>
                <td><c:out value="${sow.filingDate}"/></td>
                <td><c:out value="${sow.approved}"/></td>
                <td><a href="">+</a> </td>
            </tr>
        </c:forEach>
    </table>
</div>
<hr/>

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
