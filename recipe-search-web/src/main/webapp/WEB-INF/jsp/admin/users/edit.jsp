
<%@ include file="../../common.jspf" %>
<h1><spring:message code="editUser" text="?editUser?"/></h1>
<div><a href="${cpr}/admin/users" class="action action-back"><spring:message code="back" text="?back?"/></a></div>
<div class="form-container">
    <form:form commandName="userBean" method="POST" action="${cpr}/admin/users/${userBean.user.id}">
        <div>
            <form:label path="user.username" cssErrorClass="error"><spring:message code="username" text="?username?"/> <em>*</em></form:label><form:input path="user.username" cssErrorClass="error"/>
            <form:errors path="user.username" cssClass="error"/>
        </div>
        <div class="controlset">
            <form:label path="user.firstName" cssClass="controlset" cssErrorClass="error"><spring:message code="firstName" text="?firstName?"/></form:label><form:input path="user.firstName" cssErrorClass="error"/>
            <form:label path="user.lastName" cssClass="right" cssErrorClass="error"><spring:message code="lastName" text="?lastName?"/></form:label><form:input path="user.lastName" cssErrorClass="error"/>
        </div>
        <form:errors path="user.firstName" cssClass="error"/>
        <form:errors path="user.lastName" cssClass="error"/>
        <div class="controlset">
            <form:label path="newPassword" cssClass="controlset" cssErrorClass="controlset error"><spring:message code="newPassword" text="?newPassword?"/></form:label><form:input path="newPassword" cssErrorClass="error"/>
            <form:label path="confirmPassword" cssClass="right" cssErrorClass="right error"><spring:message code="confirmPassword" text="?confirmPassword?"/></form:label><form:input path="confirmPassword" cssErrorClass="error"/>
        </div>
        <p class="note"><spring:message code="note.userPassword" text="?note.userPassword?"/></p>
        <form:errors path="newPassword" cssClass="error"/>
        <form:errors path="confirmPassword" cssClass="error"/>
        <div class="controlset">
            <label class="controlset"><spring:message code="authorities" text="?authorities?"/></label>
            <div>
                <c:forEach items="${userBean.authorityCheckBoxes}" var="authorityCheckBox" varStatus="loopStatus">
                    <spring:bind path="userBean.authorityCheckBoxes[${loopStatus.index}].checked">
                        <input type="hidden" name="_<c:out value="${status.expression}"/>">
                        <input type="checkbox" id="<c:out value="${status.expression}"/>" name="<c:out value="${status.expression}"/>" value="true" <c:if test="${status.value}">checked</c:if>/><label for="<c:out value="${status.expression}"/>">${authorityCheckBox.authority.role}</label><br/>
                    </spring:bind>
                </c:forEach>
            </div>
        </div>
        <form:errors path="authorityCheckBoxes" cssClass="error"/>
        <div class="buttonrow">
            <input type="submit" value="<spring:message code="save" text="?save?"/>"/>
        </div>
    </form:form>
</div>