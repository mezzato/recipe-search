<%@ page import="org.parancoe.util.MemoryAppender" %>
<%@ include file="../common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <%@ include file="../head.jspf" %>
</head>
<body>
    <div id="nonFooter">            
        <jsp:include page="../header.jsp"/>
        
        <h1>Administration Console</h1>
        
        <h2>Logs</h2>
        <input type="button" value="Clean Logs" onclick="location.href='logs.html?clean=true'"/>
        <input type="button" value="Refresh Page" onclick="location.href='logs.html'"/>
        
        or print a sample message:
        <a href="logs.html?test=error">error</a>|
        <a href="logs.html?test=warn">warn</a>
        
        <div id="log">
            <code><pre>${log}</pre></code>
        </div>
    </div>
<jsp:include page="../footer.jsp"/>

</body>
</html>