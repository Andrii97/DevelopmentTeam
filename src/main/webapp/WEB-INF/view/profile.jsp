<%@ page import="ua.training.utils.constants.PathsHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="menu.jsp"%>
    <div class="container">
        <div>
            <div>
                <label><fmt:message key="user.first.name"/> </label>
                <c:out value="${user.firstName}"/>
                <br/>
            </div>
            <div>
                <label><fmt:message key="user.middle.name"/> </label>
                <c:out value="${user.middleName}"/>
                <br/>
            </div>
            <div>
                <label><fmt:message key="user.last.name"/> </label>
                <c:out value="${user.lastName}"/>
                <br/>
            </div>
            <br/>
        </div>
        <div>
            <fmt:message key="user.email"/>:
            <c:out value="${user.email}"/>
            <br/>
        </div>
        <div>
            <fmt:message key="user.role"/>
            <c:out value="${user.role.name()}"/>
            <c:out value="${user.active}"/>
            <br/>
        </div>
    </div>
</body>
</html>