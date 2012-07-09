<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <%@ include file="common.jspf" %>
    <head>
        <%@ include file="head.jspf" %>
    </head>
    <body>
        <div id="nonFooter">    
            <jsp:include page="header.jsp"/>
            <h2>Attenzione</h2>
            
            <div class="error">
                <h3>HTTP: 500</h3>
                
                <p>Si &egrave; verificato un errore non gestito.<br/>
                    <a href="${cp}">torna alla home page </a>
                </p>
            </div>
        </div>
        <jsp:include page="footer.jsp"/>
    </body>
</html>