<%@ page import="ua.training.utils.constants.UrlHolder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Registered user</title>
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
    <!--%! User user =  %-->
    <%--<c:out value="${sessionScope[AttributesHolder.User]}"/>--%>
    AttributesHolder.USER
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
    <c:out value="Create new StatementOfWork"/>
    <form method="post" action="/rest${UrlHolder.ADD_STATEMENT_OF_WORK}" >
        <input type="text" name="name"/><br/>
        <input type="submit">
    </form>
    <hr/>
    <form method="get" action="/rest${UrlHolder.STATEMENTS_OF_WORK}" >
        <input type="submit">
    </form>
</body>
</html>
