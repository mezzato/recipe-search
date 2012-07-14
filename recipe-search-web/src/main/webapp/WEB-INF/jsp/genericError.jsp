
<%@ include file="common.jspf" %>
<%@ page import="java.io.PrintWriter" %>
<h2>
    <spring:message code="attention"/>
</h2>

<div id="errore">
    <h3>
        <spring:message code="error"/>
    </h3>

    <p>
        <spring:message code="${requestScope.messageCode}" text="${requestScope.messageCode}"/>
    </p>

    <!--
    <%
                Exception e = (Exception) request.getAttribute("exception");
                if (e != null) {
                    e.printStackTrace(new PrintWriter(out));
                }
    %>
    -->
</div>
