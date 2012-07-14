
<%@ page import=" org.parancoe.util.MemoryAppender" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div id="wrapper">

    <div id="content">
        <h2>Amministrazione</h2>
        <h3>Logs Applicativi</h3>

        <% String logs = MemoryAppender.getFullLog(); %>
        <code><pre><%=logs%>
        </pre></code>
    </div>
</div>
</body>
</html>