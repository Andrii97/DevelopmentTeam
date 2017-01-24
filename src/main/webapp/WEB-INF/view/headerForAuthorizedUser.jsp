<%@ page import="ua.training.utils.constants.UrlHolder" %>
<jsp:include page="header.jsp"/>
<form action="${UrlHolder.LOGOUT}" method="post">
    <input style="border: none; background-color: transparent" type="submit" value="LOGOUT" bundle="${msg}"/>"/>
</form>
