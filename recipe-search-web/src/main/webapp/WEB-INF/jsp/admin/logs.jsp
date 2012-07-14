
<%@ page import="org.parancoe.util.MemoryAppender" %>
<%@ include file="../common.jspf" %>
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
