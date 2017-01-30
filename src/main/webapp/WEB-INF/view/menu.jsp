<%@ page import="ua.training.utils.constants.PathsHolder" %>
<%@ page import="ua.training.utils.constants.AttributesHolder" %>
<%@ page import="ua.training.model.entity.Role" %>
<%@include file="./header.jsp"%>
<div>
    <nav class="navbar navbar-inverse">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#"><fmt:message key="system.name"/></a>
            </div>
            <ul class="nav navbar-nav">
                <c:if test="${sessionScope[AttributesHolder.USER].role eq Role.MANAGER}">
                    <li><a href="${PathsHolder.MANAGER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li><a href="${PathsHolder.BASIC}${PathsHolder.DEVELOPERS}"><fmt:message key="developers"/></a></li>
                    <li><a href="${PathsHolder.BASIC}${PathsHolder.PROJECTS}"><fmt:message key="manager.projects"/></a></li>
                    <li><a href="${PathsHolder.BASIC}${PathsHolder.STATEMENTS_OF_WORK}">
                        <fmt:message key="manager.menu.statements.of.work"/>
                    </a></li>
                </c:if>
                <c:if test="${sessionScope[AttributesHolder.USER].role eq Role.CUSTOMER}">
                    <li><a href="${PathsHolder.CUSTOMER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li>
                        <a href="${PathsHolder.BASIC}${PathsHolder.STATEMENTS_OF_WORK_BY_CUSTOMER}">
                            <fmt:message key="customer.menu.statements.of.work"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope[AttributesHolder.USER].role eq Role.DEVELOPER}">
                    <li><a href="${PathsHolder.DEVELOPER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li><a href="${PathsHolder.BASIC}${PathsHolder.TASKS}"><fmt:message key="tasks"/></a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty sessionScope[AttributesHolder.USER]}">
                    <li>
                        <a href="${PathsHolder.LOGOUT}">
                            <span class="glyphicon glyphicon-log-out"></span><fmt:message key="logout"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${empty sessionScope[AttributesHolder.USER]}">
                    <li>
                        <a href="${PathsHolder.LOGIN}">
                            <span class="glyphicon glyphicon-log-in"></span> <fmt:message key="login"/>
                        </a>
                    </li>
                    <li>
                        <a href="${PathsHolder.BASIC}${PathsHolder.SIGN_UP}">
                            <span class="glyphicon glyphicon-user"></span> <fmt:message key="sign.up"/>
                        </a>
                    </li>
                </c:if>
            </ul>
            <%@include file="./languagePanel.jsp"%>
        </div>
    </nav>
</div>

<c:if test="${requestScope[AttributesHolder.ERROR_MESSAGE] != null}">
    <div class="container">
        <div class="alrt alert-danger">
            <fmt:message key="${requestScope[AttributesHolder.ERROR_MESSAGE]}"/>
        </div>
    </div>
</c:if>