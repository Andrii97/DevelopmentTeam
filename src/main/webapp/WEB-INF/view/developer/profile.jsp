<%@ page import="ua.training.utils.constants.UrlHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registered user</title>
</head>
<body>
<br/>
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
    <c:out value="${user.role.name()}"/>
    <c:out value="${user.active}"/>
    <br/>
</div>
<%--<a href="${pageContext.request.contextPath}${PagesPaths.HOME_PATH}">--%>
<%--<fmt:message key="home.page.href.name"/>--%>
<%--</a>--%>
<c:out value="${pageContext.request.contextPath}${PagesPaths.HOME_PAGE}"/>
<br/>
<c:out value="${pageContext.request.contextPath}${PagesPaths.HOME_PAGE}"/>
<br/>

<link>
<hr/>
<form method="get" action="/rest${UrlHolder.STATEMENTS_OF_WORK}" >
    <input type="submit">
</form>
<form method="post" action="${UrlHolder.LOGOUT}" >
    <input type="submit" value="Logout">
</form>
</body>
</html>
