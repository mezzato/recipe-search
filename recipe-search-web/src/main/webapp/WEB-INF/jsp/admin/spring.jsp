
<%@ page import="org.parancoe.util.MemoryAppender" %>
<%@ page import="org.apache.commons.configuration.Configuration" %>
<%@ page import="java.util.Iterator" %>
<%@ include file="../common.jspf" %>
<h1>Administration Console</h1>

<h2>Spring Beans</h2>

<ul>
    <%  String[] names = ctx.getBeanDefinitionNames();
                for (int i = 0; i < names.length; i++) {
                    String name = names[i];
    %> <li><%= name%></li>
    <% }%>
</ul>
