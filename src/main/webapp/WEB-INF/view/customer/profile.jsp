<%@ page import="ua.training.model.entity.User" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registered user</title>
</head>
<body>
    <!--%! User user =  %-->
    <%--<c:out value="${sessionScope[AttributesHolder.User]}"/>--%>
    
    <c:out value="${user}"/><br/>
    <div>
        <c:out value="${user.firstName}"/>
        <c:out value="${user.middleName}"/>
        <c:out value="${user.lastName}"/>
        <br/>
    </div>
    <div>
        <c:out value="${user.email}"/>
        <br/>
    </div>
    <div>
        <c:out value="${user.role.name()}"></c:out>
        <c:out value="${user.active}"></c:out>
    </div>
</body>
</html>
