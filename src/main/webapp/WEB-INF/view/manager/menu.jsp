<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="ua.training.utils.constants.UrlHolder" %>
<div>
    <%@include file="../header.jsp"%>
    <h1>
        <a href="${UrlHolder.MANAGER_URL}"><fmt:message key="menu.home.page"/></a>
        <a href="${UrlHolder.BASIC}${UrlHolder.MANAGER_URL}"></a>
        <a href="${UrlHolder.LOGOUT}"><fmt:message key="logout"/></a>
    </h1>
</div>