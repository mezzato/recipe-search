<%@ page import="javax.servlet.http.Cookie" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="org.parancoe.util.MemoryAppender"%>
<div style="clear: left;"><a href="#" onclick="Element.toggle('debug');"> debug </a></div>

<div id="debug" style="display: none;">
    <h2>Request Params</h2>
    <table>
        <% for (Enumeration e = request.getParameterNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            String value = request.getParameter(key);
        %>
        <tr>
            <td><%=key%>
            </td>
            <td><%=value%>
            </td>
        </tr>
        <%}%>
    </table>

    <h2>Request Attributes</h2>
    <table>
        <% for (Enumeration e = request.getAttributeNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            Object value = request.getAttribute(key);
        %>
        <tr>
            <td><%=key%>
            </td>
            <td><%=value%>
            </td>
        </tr>
        <%}%>
    </table>

    <h2>Session Attributes</h2>
    <table>
        <% for (Enumeration e = session.getAttributeNames(); e.hasMoreElements();) {
            String key = (String) e.nextElement();
            Object value = session.getAttribute(key);
        %>
        <tr>
            <td><%=key%>
            </td>
            <td><%=value%>
            </td>
        </tr>
        <%}%>
    </table>

    <h2>Headers</h2>
    <table><% for (Enumeration e = request.getHeaderNames(); e.hasMoreElements();) {
        String name = (String) e.nextElement(); %>
        <tr>
            <td><%=name%></td><td><%=request.getHeader(name)%></td>
            </tr>
        <%}%>
    </table>
        <h2>Cookies</h2>
        <table>
            <% if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {%>
        <tr>
            <td><%=cookie.getName()%>
            </td>
            <td><%=cookie.getValue()%> <a href="javascript:readIt('<%=cookie.getName()%>');">read</a>
                <a href="javascript:eraseIt('<%=cookie.getName()%>');">erase</a>
            </td>
        </tr>

    <% }
    }
    %> </table>

    <h2>Log Fragment</h2>
    <code><pre>
    <%= MemoryAppender.getLastNLines(100) %> 
    </pre></code>

</div>