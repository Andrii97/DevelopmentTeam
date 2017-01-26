<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="../menu.jsp"%>
ADD User
    <div>
        <form action="" method="post">
            <div class="block">
                <label><fmt:message key="user.first.name"/></label>
                <input type="text" name="${AttributesHolder.FIRST_NAME}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="user.middle.name"/></label>
                <input type="text" name="${AttributesHolder.MIDDLE_NAME}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="user.last.name"/></label>
                <input type="text" name="${AttributesHolder.LAST_NAME}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="user.email"/></label>
                <input type="text" name="${AttributesHolder.EMAIL}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="user.password"/></label>
                <input type="password" name="${AttributesHolder.PASSWORD}"/><br/>
            </div>
            <div class="block">
                <label><fmt:message key="user.role"/></label>
                <select name="${AttributesHolder.ROLE}">
                    <c:forEach var="item" items="${requestScope[AttributesHolder.ROLES]}">
                        <option value="${item}" ${item == selectedDept ? 'selected="selected"' : ''}>${item}</option>
                    </c:forEach>
                </select>
                <%--<input type="text" name="${AttributesHolder.ROLE}"/><br/>--%>
            </div>

            <button type="submit"><fmt:message key="save"/></button>
        </form>
        <hr/>
    </div>
</body>
</html>
