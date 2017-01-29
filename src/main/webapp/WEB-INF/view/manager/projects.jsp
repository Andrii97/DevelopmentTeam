<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <div class="container">
        <table class="table">
            <caption><fmt:message key="projects.title"/></caption>
            <tr>
                <th><fmt:message key="project.id"/></th>
                <th><fmt:message key="project.name"/></th>
                <th><fmt:message key="project.manager"/></th>
                <th><fmt:message key="project.statement.of.work"/></th>
                <th><fmt:message key="project.start.date"/></th>
                <th><fmt:message key="project.end.date"/></th>
                <th><fmt:message key="project.bill"/></th>
                <th><fmt:message key="delete"/></th>
            </tr>
            <c:forEach var="project" items="${requestScope[AttributesHolder.PROJECTS]}">
                <tr>
                    <td><c:out value="${project.id}"/></td>
                    <td><c:out value="${project.name}"/></td>
                    <td>
                        <c:out value="${project.manager.firstName} ${project.manager.middleName} ${project.manager.lastName}"/>
                        <br/>
                        <fmt:message key="user.email"/>: <c:out value="${project.manager.email}"/>
                    </td>
                    <td><c:out value="${project.statementOfWork.name}"/></td>
                    <td><c:out value="${project.startDate}"/></td>
                    <td><c:out value="${project.endDate}"/></td>
                    <td><c:out value="${project.bill/100}"/></td>
                    <td><a href="${PathsHolder.BASIC}${PathsHolder.DELETE_STATEMENT_OF_WORK}${sow.id}">
                        <button class="btn btn-warning"><fmt:message key="delete"/></button>
                    </a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
