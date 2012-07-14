
<%@ include file="common.jspf" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ page import="org.springframework.security.core.AuthenticationException" %>
<%-- this form-login-page form is also used as the form-error-page to ask for a login again. --%>
<div id="loginBox">
    <div id="loginTitle"><spring:message code="loginTitle"/></div>
    <div id="loginMessageBox">
        Try <b>parancoe/parancoe</b> and <b>admin/admin</b>.<br/>
        <c:if test="${not empty param.login_error}">
            <font color="red">
                Your login attempt was not successful, try again.<br/>
                Reason: <%= ((AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION)).getMessage() %>
            </font>
        </c:if>
    </div>
    <div class="form-container">
        <form name="loginForm" action="<c:url value='/j_spring_security_check'/>" method="POST">
            <div>
                <label for="username"><spring:message code="username"/></label>
                <input id="username"type='text' name='j_username' tabindex="1" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(WebAttributes.LAST_USERNAME) %>'</c:if>/>
            </div>
            <div>
                <label for="password"><spring:message code="password"/></label>
                <input id="password" type='password' name='j_password' tabindex="2"/>
            </div>
            <div class="controlset">
                <label class="controlset">&nbsp;</label>
                <input id="remember" type="checkbox" name="_acegi_security_remember_me" tabindex="3"/><label for="remember"><spring:message code="remember_me"/></label>
            </div>
            <div class="buttonrow">
                <input id="submit" name="submit" type="submit" value="<spring:message code='sign_in'/>" tabindex="4"/>
            </div>
        </form>
    </div>
</div>
