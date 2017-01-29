<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../menu.jsp"%>
<c:out value="${requestScope[AttributesHolder.STATEMENT_OF_WORK]}"/>
</body>
</html>
