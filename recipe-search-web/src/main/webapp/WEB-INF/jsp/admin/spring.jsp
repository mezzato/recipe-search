<%@ page import="org.parancoe.util.MemoryAppender" %>
<%@ page import="org.apache.commons.configuration.Configuration" %>
<%@ page import="java.util.Iterator" %>
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
            
            <h2>Spring Beans</h2>
            
            <ul>
                <%  String[] names = ctx.getBeanDefinitionNames();
                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
                %> <li><%= name%></li>
                <% } %>
            </ul>
        </div>
        <jsp:include page="../footer.jsp"/>
        
    </body>
</html>