<%@ page import="ua.training.utils.constants.UrlHolder" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    Путь к контексту : ${ pageContext.request.contextPath } <br/>
    Имя хоста : ${ header["host"] }<br/>
    Тип и кодировка контента : ${pageContext.response.contentType}<br/>
    Кодировка ответа : ${pageContext.response.characterEncoding}<br/>
    ID сессии : ${pageContext.request.session.id}<br/>
    Время создания сессии в мсек : ${pageContext.request.session.creationTime}<br/>
    Время последнего доступа к сессии : ${pageContext.request.session.lastAccessedTime}<br/>
    Имя сервлета : ${pageContext.servletConfig.servletName}
    <br/>
    <%--<form method="get" action="./rest/login" >--%>
    <form method="get" action="./rest${UrlHolder.LOGIN}" >
        <input type="text" name="login"/><br/>
        <input type="password" name="password"/>
        <input type="submit">
    </form>
</body>
</html>
