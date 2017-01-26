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
    <%@include file="./menu.jsp"%>
    <div class="container">
        <div class="center jumbotron authorization-section">
            <form method="post" action="${UrlHolder.LOGIN}">
                <h2 class="form-signin-heading"><fmt:message key="login.title"/><br/></h2>
                <br/>
                <input type="text" class="form-control" name="${AttributesHolder.EMAIL}" placeholder="<fmt:message key="login.email" />" required/>
                <br/>
                <input type="password" class="form-control" name="${AttributesHolder.PASSWORD}" placeholder="<fmt:message key="login.password"/>" required/>
                <br/>
                <button type="submit" class="btn btn-lg btn-primary btn-block">
                    <fmt:message key="login.submit"/>
                </button>
            </form>
        </div>
    </div>
</body>
</html>
