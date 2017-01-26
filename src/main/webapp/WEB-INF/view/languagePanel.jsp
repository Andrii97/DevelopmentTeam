<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="ua.training.controller.i18n.SupportedLocaleHolder" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<ul class="nav navbar-nav navbar-right">
    <c:forEach items="${SupportedLocaleHolder.values()}" var="locale">
        <c:if test="${locale.locale == sessionScope[AttributesHolder.LOCALE]}"><b>[</c:if>
        <a href="?${AttributesHolder.USER_LOCALE}=${locale.param}">
            <img src="/img/${locale.image}"  height="20" width="20"><%--${locale}--%>
        </a>
        <c:if test="${locale.locale == sessionScope[AttributesHolder.LOCALE]}">]</b></c:if>
    </c:forEach>
</ul>