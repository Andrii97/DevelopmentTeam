<%@ page import="ua.training.utils.constants.UrlHolder" %>
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
                    <li><a href="${UrlHolder.MANAGER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li><a href="${UrlHolder.BASIC}${UrlHolder.USERS}"><fmt:message key="users"/></a></li>
                    <li><a href="${UrlHolder.BASIC}${UrlHolder.PROJECTS}"><fmt:message key="manager.projects"/></a></li>
                </c:if>
                <c:if test="${sessionScope[AttributesHolder.USER].role eq Role.CUSTOMER}">
                    <li><a href="${UrlHolder.CUSTOMER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li>
                        <a href="${UrlHolder.BASIC}${UrlHolder.STATEMENTS_OF_WORK_BY_CUSTOMER}">
                            <fmt:message key="customer.menu.statements.of.work"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${sessionScope[AttributesHolder.USER].role eq Role.DEVELOPER}">
                    <li><a href="${UrlHolder.DEVELOPER_URL}"><fmt:message key="menu.home.page"/></a></li>
                    <li><a href="${UrlHolder.BASIC}${UrlHolder.TASKS}"><fmt:message key="tasks"/></a></li>
                </c:if>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${not empty sessionScope[AttributesHolder.USER]}">
                    <li>
                        <a href="${UrlHolder.LOGOUT}">
                            <span class="glyphicon glyphicon-log-out"></span><fmt:message key="logout"/>
                        </a>
                    </li>
                </c:if>
                <c:if test="${empty sessionScope[AttributesHolder.USER]}">
                    <li>
                        <a href="${UrlHolder.LOGIN}">
                            <span class="glyphicon glyphicon-log-in"></span> <fmt:message key="login"/>
                        </a>
                    </li>
                    <li>
                        <a href="${UrlHolder.BASIC}${UrlHolder.SIGN_UP}">
                            <span class="glyphicon glyphicon-user"></span> <fmt:message key="sign.up"/>
                        </a>
                    </li>
                </c:if>
            </ul>
            <%@include file="./languagePanel.jsp"%>
        </div>
    </nav>
</div>