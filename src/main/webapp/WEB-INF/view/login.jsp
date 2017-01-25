<%@ page import="ua.training.utils.constants.UrlHolder" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <br/>
    <div>
        <form method="post" action="${UrlHolder.LOGIN}" >
            <fmt:message key="login.email" />
            <input type="text" name="${AttributesHolder.EMAIL}"/><br/>
            <fmt:message key="login.password"/>
            <input type="password" name="${AttributesHolder.PASSWORD}"/><br/>
            <button type="submit"><fmt:message key="login.submit"/></button>
        </form>
    </div>
</body>
</html>
