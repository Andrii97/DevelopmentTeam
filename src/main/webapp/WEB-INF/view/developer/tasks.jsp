<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="../menu.jsp"%>
    <c:if test="${errors != null && errors.messages[AttributesHolder.NUMBER] != null}">
        <div class="alrt alert-danger">
            <fmt:message key="${errors.messages[AttributesHolder.NUMBER]}"/>
        </div>
    </c:if>
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
                <th><fmt:message key="task.new.elapsed.time"/></th>
                <th><fmt:message key="task.new.elapsed.time"/></th>
            </tr>
            <c:forEach var="devHasTask" items="${requestScope[AttributesHolder.DEVELOPER_HAS_TASKS]}">
                <tr>
                    <form action="" method="post">
                        <input type="hidden" value="${devHasTask.task.id}" name="${AttributesHolder.TASK_ID}">
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
                        <td>
                            <input type="number" placeholder="<fmt:message key="task.new.elapsed.time"/>" name="${AttributesHolder.ELAPSED_TIME}">
                        </td>
                        <td><button class="btn btn-lg btn-primary btn-block" type="submit">
                            <fmt:message key="update.elapsed.time"/>
                        </button></td>
                    </form>
                </tr>
            </c:forEach>
        </table>

</body>
</html>
