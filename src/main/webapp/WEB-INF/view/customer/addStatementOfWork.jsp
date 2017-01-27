<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../menu.jsp"%>
<div>
    <form action="" method="post">
        <div class="block">
            <label><fmt:message key="statement.of.work.name"/></label>
            <input type="text" name="${AttributesHolder.NAME}" value="${statementOfWork.name}"/><br/>
        </div>
        <div class="block">
            <label><fmt:message key="statement.of.work.is.approved"/></label>
            <input type="checkbox" readonly  name="${AttributesHolder.APPROVED}" value="${statementOfWork.approved}"/><br/>
            <c:out value="false"/><br/>
        </div>
        <button type="submit"><fmt:message key="save"/></button>
    </form>
    <br/>
    <hr/>
    <table class="table">
        <caption><fmt:message key="tasks"/></caption>
        <tr>
            <th><fmt:message key="task.id"/></th>
            <th><fmt:message key="task.name"/></th>
            <th><fmt:message key="task.description"/></th>
            <th><fmt:message key="task.is.finished"/></th>
        </tr>
        <c:forEach var="task" items="${tasks}">
            <tr>
                <td><c:out value="${task.id}"/></td>
                <td><c:out value="${task.name}"/></td>
                <td><c:out value="${task.description}"/></td>
                <td><c:out value="${task.finished}"/></td>
            </tr>
        </c:forEach>
    </table>
    <hr/>
    <form action="${PathsHolder.BASIC}${PathsHolder.ADD_TASK}" method="post">
        <div class="block">
            <label><fmt:message key="task.name"/></label>
            <input type="text" name="${AttributesHolder.TASK_NAME}" value="${task.name}"/><br/>
        </div>
        <div class="block">
            <label><fmt:message key="task.description"/></label>
            <input type="text" name="${AttributesHolder.TASK_DESCRIPTION}" value="${task.description}"/><br/>
        </div>
        <div class="block">
            <h4><label><fmt:message key="task.requirements"/></label></h4>
            <div class="block">
                <label><fmt:message key="developer.qualification"/></label><br/>
            </div>
            <div class="block">
                <label><fmt:message key="task.developers.number.junior"/></label>
                <input type="number" name="${AttributesHolder.TASK_NEEDED_JUNIORS}"/>
            </div>
            <div class="block">
                <label><fmt:message key="task.developers.number.middle"/></label>
                <input type="number" name="${AttributesHolder.TASK_NEEDED_MIDDLES}"/>
            </div>
            <div class="block">
                <label><fmt:message key="task.developers.number.senior"/></label>
                <input type="number" name="${AttributesHolder.TASK_NEEDED_SENIORS}"/><br/>
            </div>
        </div>
        <button type="submit"><fmt:message key="save"/> <fmt:message key="task"/></button>
    </form>
    <hr/>
</div>
</body>
</html>
