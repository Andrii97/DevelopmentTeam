<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="ua.training.controller.i18n.SupportedLocaleHolder" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<head>
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
</head>
<%-- there is no need to use fmt setLocale, because native session scoped attribute already set in LocaleFilter --%>
<fmt:requestEncoding value="UTF-8" />
<fmt:setBundle basename="${sessionScope[AttributesHolder.BUNDLE_FILE]}"/>
<%--<nav class="navbar navbar-inverse">--%>
    <ul class="nav navbar-nav navbar-right">
    <c:forEach items="${SupportedLocaleHolder.values()}" var="locale">
        <c:if test="${locale.locale == sessionScope[AttributesHolder.LOCALE]}"><b>[</c:if>
        <a href="?${AttributesHolder.USER_LOCALE}=${locale.param}">
            <img src="/img/${locale.image}"  height="20" width="20"><%--${locale}--%>
        </a>
        <c:if test="${locale.locale == sessionScope[AttributesHolder.LOCALE]}">]</b></c:if>
    </c:forEach>
    </ul>
<%--</nav>--%>