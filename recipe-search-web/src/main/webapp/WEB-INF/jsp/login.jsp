<%@ include file="common.jspf" %>
<%@ page import="org.springframework.security.ui.AbstractProcessingFilter" %>
<%@ page import="org.springframework.security.ui.webapp.AuthenticationProcessingFilter" %>
<%@ page import="org.springframework.security.AuthenticationException" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@ include file="head.jspf" %>
    </head>    
    <body onload="document.loginForm.username.focus()">
        <div id="nonFooter">        
            <jsp:include page="header.jsp"/>
            <div id="content">    
                <div id="content_main_full">
                    <%-- this form-login-page form is also used as the form-error-page to ask for a login again. --%>
                    <div id="loginBox">
                        <div id="loginTitle"><spring:message code="loginTitle"/></div>
                        <div id="loginMessageBox">
                            Try <b>parancoe/parancoe</b> and <b>admin/admin</b>.<br/>
                            <c:if test="${not empty param.login_error}">
                                <font color="red">
                                    Your login attempt was not successful, try again.<br/>
                                    Reason: <%= ((AuthenticationException) session.getAttribute(AbstractProcessingFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
                                </font>
                            </c:if>
                        </div>
                        <form name="loginForm" action="<c:url value='/securityCheck.secure'/>" method="POST">
                            <label class="loginLabel" for="username"><spring:message code="username"/></label>
                            <input id="username" class="loginField" type='text' name='j_username' tabindex="1" <c:if test="${not empty param.login_error}">value='<%= session.getAttribute(AuthenticationProcessingFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>'</c:if>/><br/>
                            <label class="loginLabel" for="password"><spring:message code="password"/></label>
                            <input id="password" class="loginField" type='password' name='j_password' tabindex="2"/><br/>
                            <label class="loginLabel" for="remember">&nbsp;</label>
                            <input id="remember" type="checkbox" name="_acegi_security_remember_me" tabindex="3"/><span style="float: left;"> <spring:message code="remember_me"/></span><br/>
                            <label class="loginLabel" for="submit">&nbsp;</label>
                            <input id="submit" name="submit" type="submit" value="<spring:message code='sign_in'/>" tabindex="4"/>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>
