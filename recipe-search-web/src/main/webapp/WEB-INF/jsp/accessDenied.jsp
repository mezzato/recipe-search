<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ include file="common.jspf" %>
    <head>
        <%@ include file="head.jspf" %>
    </head>
    <body>
        <div id="nonFooter">        
            <jsp:include page="header.jsp"/>
            <h2><spring:message code="attention"/></h2>
            
            <div class="error">
                <h3><spring:message code="access_denied"/></h3>
                <p><spring:message code="access_denied_message"/><br>
                <a href="${cp}"><spring:message code="back_to_home"/></a></p>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>