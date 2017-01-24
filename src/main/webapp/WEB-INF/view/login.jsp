<%@ page import="ua.training.utils.constants.UrlHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <fmt:setBundle basename="i18n.messages"/>
    <jsp:include page="header.jsp"/>
    <br/>
    <fmt:message key="login.password" />
    <%--<form method="get" action="./rest/login" >--%>
    <form method="post" action=".${UrlHolder.LOGIN}" >
        <fmt:message key="login.form.title" />
        <input type="text" name="login"/><br/>
        <fmt:message key="login.password"/>
        <input type="password" name="password"/><br/>
        <input type="submit">
    </form>
</body>
</html>
