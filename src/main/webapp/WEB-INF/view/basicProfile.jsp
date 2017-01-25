<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div>
    <div>
        <label><fmt:message key="user.firstName"/> </label>
        <c:out value="${user.firstName}"/>
        <br/>
    </div>
    <div>
        <label><fmt:message key="user.middleName"/> </label>
        <c:out value="${user.middleName}"/>
        <br/>
    </div>
    <div>
        <label><fmt:message key="user.lastName"/> </label>
        <c:out value="${user.lastName}"/>
        <br/>
    </div>
    <br/>
</div>
<div>
    <fmt:message key="user.email"/>
    <c:out value="${user.email}"/>
    <br/>
</div>
<div>
    <fmt:message key="user.role"/>
    <c:out value="${user.role.name()}"/>
    <c:out value="${user.active}"/>
    <br/>
</div>