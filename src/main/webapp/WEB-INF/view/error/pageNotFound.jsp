<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>ERROR</title>
</head>

<body>
    <%@include file="../menu.jsp"%>
    <div class="col-sm-9 section">
        <h2><small><fmt:message key="system.error"/></small></h2>
        <hr>
        <div class="center jumbotron authorization-section">
            <div class="center">
                <h2><small><fmt:message key="system.page.not.found"/></small></h2>
            </div>
        </div>
    </div>
</body>
</html>
