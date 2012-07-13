<%@ include file="../common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
                      "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@ include file="../head.jspf" %>
    </head>
    <body>
        <div id="nonFooter">
            <jsp:include page="../header.jsp"/>
            <div id="content">
                <div id="content_main">
                    <h1>Edit person</h1>
                    <form:form commandName="person" method="POST"
                            action="${cp}/person/save.form">
                        <table>
                        <tr>
                            <td>First name:</td>
                            <td><form:input path="firstName"/></td>
                        </tr>
                        <tr>
                            <td>Last name:</td>
                            <td><form:input path="lastName"/></td>
                        </tr>
                        <tr>
                            <td>Birth date:</td>
                            <td><form:input path="birthDate"/> (dd/MM/yyyy)</td>
                        </tr>
                        <tr>
                            <td>E-mail:</td>
                            <td><form:input path="email"/></td>
                        </tr>
                        <tr>
                            <td>&nbsp;</td>
                            <td><input type="submit" value="Submit"/><br/><br/></td>
                        </tr>
                        </table>
                        <form:errors path="*" cssClass="errorBox"/>
                    </form:form>
                </div>
                <jsp:include page="../menu.jsp"/>
            </div>
        </div>
        <jsp:include page="../footer.jsp"/>
    </body>
</html>