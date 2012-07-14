
<%@ include file="/WEB-INF/jsp/common.jspf" %>
<h1><spring:message code="YourProfile" text="?YourProfile?"/></h1>
<div class="form-container">
    <form:form commandName="userBean" method="POST" action="${cpr}/profile">
        <div><form:label path="user.username"><spring:message code="username" text="?username?"/>:</form:label><form:input path="user.username" disabled="true"/></div>
        <form:errors path="user.username" cssClass="error"/>
        <div><form:label path="newPassword"><spring:message code="newPassword" text="?newPassword?"/>:</form:label><form:password path="newPassword"/></div>
        <form:errors path="newPassword" cssClass="error"/>
        <div><form:label path="confirmPassword"><spring:message code="confirmPassword" text="?confirmPassword?"/>:</form:label><form:password path="confirmPassword"/></div>
        <div><form:label path="user.firstName"><spring:message code="firstName" text="?firstName?"/>:</form:label><form:input path="user.firstName"/></div>
        <form:errors path="user.firstName" cssClass="error"/>
        <div><form:label path="user.lastName"><spring:message code="lastName" text="?lastName?"/>:</form:label><form:input path="user.lastName"/></div>
        <form:errors path="user.lastName" cssClass="error"/>
        <div class="buttonrow">
            <input type="submit" value="<spring:message code="save" text="?save?"/>"/>
        </div>
    </form:form>
</div>
