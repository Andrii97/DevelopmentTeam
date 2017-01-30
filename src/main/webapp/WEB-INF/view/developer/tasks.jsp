<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <div>
        <table class="table">
            <caption><fmt:message key="tasks"/></caption>
            <tr>
                <th><fmt:message key="task.id"/></th>
                <th><fmt:message key="task.name"/></th>
                <th><fmt:message key="task.description"/></th>
                <th><fmt:message key="task.is.finished"/></th>
                <th><fmt:message key="project.name"/></th>
                <th><fmt:message key="project.manager"/></th>
                <th><fmt:message key="task.elapsed.time"/></th>
            </tr>
            <c:forEach var="devHasTask" items="${requestScope[AttributesHolder.DEVELOPER_HAS_TASKS]}">
                <tr>
                    <td><c:out value="${devHasTask.task.id}"/></td>
                    <td><c:out value="${devHasTask.task.name}"/></td>
                    <td><c:out value="${devHasTask.task.description}"/></td>
                    <td><c:out value="${devHasTask.task.finished}"/></td>
                    <td><c:out value="${devHasTask.project.name}"/></td>
                    <td>
                        <c:out value="${devHasTask.project.manager.firstName} "/>
                        <c:out value="${devHasTask.project.manager.middleName} "/>
                        <c:out value="${devHasTask.project.manager.lastName}"/>
                        <br/>
                        <fmt:message key="user.email"/>: <c:out value="${devHasTask.project.manager.email}"/>
                    </td>
                    <td><c:out value="${devHasTask.elapsedTime}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
