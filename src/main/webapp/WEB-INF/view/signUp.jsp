<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%@include file="menu.jsp"%>
    <div class="container">
        <div class="center jumbotron authorization-section">
            <form action="" method="post">
                <h2 class="form-signin-heading"><fmt:message key="sign.up"/></h2>
                <br>
                <c:if test="${errors != null && errors.messages[AttributesHolder.FIRST_NAME] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.FIRST_NAME]}"/>
                    </div>
                </c:if>
                <input type="text" class="form-control" name="${AttributesHolder.FIRST_NAME}" value="<c:out value="${user.firstName}"/>"
                       placeholder="<fmt:message key="user.first.name"/>" required>

                <br>
                <c:if test="${errors != null && errors.messages[AttributesHolder.MIDDLE_NAME] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.MIDDLE_NAME]}"/>
                    </div>
                </c:if>
                <input type="text" class="form-control" name="${AttributesHolder.MIDDLE_NAME}"
                       value="<c:out value="${user.middleName}"/>"
                       placeholder="<fmt:message key="user.middle.name"/>" required >
                <br>
                <c:if test="${errors != null && errors.messages[AttributesHolder.LAST_NAME] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.LAST_NAME]}"/>
                    </div>
                </c:if>
                <input type="text" class="form-control" name="${AttributesHolder.LAST_NAME}" value="<c:out value="${user.lastName}"/>"
                   placeholder="<fmt:message key="user.last.name"/>" required>
                <br>
                <c:if test="${errors != null && errors.messages[AttributesHolder.ROLE] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.ROLE]}"/>
                    </div>
                </c:if>
                <div class="form-group">
                    <select class="form-control" name="${AttributesHolder.ROLE}" id="sel1">
                        <option value=""><fmt:message key="choose.role"/></option>
                        <c:forEach var="item" items="${requestScope[AttributesHolder.ROLES]}">
                            <option value="${item}" ${item == user.role ? 'selected="selected"' : ''}>${item}</option>
                        </c:forEach>
                    </select>
                </div>

                <c:if test="${errors != null && errors.messages[AttributesHolder.EMAIL] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.EMAIL]}"/>
                    </div>
                </c:if>
                <input type="text" class="form-control" name="${AttributesHolder.EMAIL}" value="<c:out value="${user.email}"/>"
                       placeholder="<fmt:message key="user.email"/>" required >
                <br>
                <c:if test="${errors != null && errors.messages[AttributesHolder.PASSWORD] != null}">
                    <div class="alrt alert-danger">
                        <fmt:message key="${errors.messages[AttributesHolder.PASSWORD]}"/>
                    </div>
                </c:if>
                <input type="password" class="form-control" name="${AttributesHolder.PASSWORD}" placeholder="<fmt:message key="user.password"/>" required >
                <br>
                <button class="btn btn-lg btn-primary btn-block" type="submit"><fmt:message key="sign.up"/></button>
            </form>
        </div>
    </div>
</body>
</html>
