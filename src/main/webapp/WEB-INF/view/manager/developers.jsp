<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<%@ page import="ua.training.utils.constants.PathsHolder" %>
<%@ page import="ua.training.model.entity.Qualification" %>
<html>
<head>
    <title></title>
</head>
<body>
<%@include file="../menu.jsp"%>
<c:if test="${errors != null && errors.messages[AttributesHolder.QUALIFICATION] != null}">
    <div class="alrt alert-danger">
        <fmt:message key="${errors.messages[AttributesHolder.QUALIFICATION]}"/>
    </div>
</c:if>
<table class="table">
    <caption><fmt:message key="users"/></caption>
    <tr>
        <th><fmt:message key="user.id"/></th>
        <th><fmt:message key="user.first.name"/></th>
        <th><fmt:message key="user.middle.name"/></th>
        <th><fmt:message key="user.last.name"/></th>
        <th><fmt:message key="user.role"/></th>
        <th><fmt:message key="user.is.active"/></th>
        <th><fmt:message key="developer.qualification"/></th>
        <th><fmt:message key="developer.is.free"/></th>
        <th></th>
    </tr>
    <c:forEach var="dev" items="${requestScope[AttributesHolder.DEVELOPERS]}">
        <tr>
            <form action="" method="post">
                <input type="hidden" value="${dev.user.id}" name="${AttributesHolder.ID}">
                <td><c:out value="${dev.user.id}"/></td>
                <td><c:out value="${dev.user.firstName}"/></td>
                <td><c:out value="${dev.user.middleName}"/></td>
                <td><c:out value="${dev.user.lastName}"/></td>
                <td><c:out value="${dev.user.role}"/></td>
                <td><c:out value="${dev.user.active}"/></td>
                <td>
                    <c:choose>
                        <c:when test="${empty dev.qualification}">
                        <select class="form-control" name="${AttributesHolder.QUALIFICATION}" id="sel1">
                            <option value=""><fmt:message key="choose.qualification"/></option>
                            <c:forEach var="item" items="${Qualification.values()}">
                                <option value="${item}" ${item == dev.qualification ? 'selected="selected"' : ''}>${item}</option>
                            </c:forEach>
                        </select>
                        </c:when>
                        <c:otherwise>
                            <c:out value="${dev.qualification}"/></td>
                        </c:otherwise>
                    </c:choose>
                <td><c:out value="${dev.free}"/></td>
                <td>
                    <c:if test="${empty dev.qualification}">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            <fmt:message key="developer.set.qualification"/>
                        </button>
                    </c:if>
                </td>
            </form>
        </tr>
    </c:forEach>
</table>
</body>
</html>
