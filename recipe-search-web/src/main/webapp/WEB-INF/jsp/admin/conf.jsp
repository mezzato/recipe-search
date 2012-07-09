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
        
        <h2>Configuration: <%= BaseConf.getEnv() %></h2>
        
        <table>
            <tr>
                <th>key</th>
                <th>value</th>
            </tr>
            
            <% Configuration c = conf.getConfiguration();
            Iterator i = c.getKeys();
            while (i.hasNext()) {
            String key = (String) i.next();
            Object value = conf.getConfiguration().getProperty(key);
            %>
            <tr>
                <td><%=key%></td>
                <td><%=value%></td>
            </tr>
            <% } %>
        </table>
    </div>
<jsp:include page="../footer.jsp"/>

</body>
</html>