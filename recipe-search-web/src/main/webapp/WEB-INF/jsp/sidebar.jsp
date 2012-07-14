
<%@ include file="common.jspf" %>
<%@page pageEncoding="UTF-8" %>

<h3><spring:message code="About" text="?About?"/></h3>

<p class="about">
    <c:choose>
        <c:when test="${requestScope.lang eq 'it'}">
            Qui una descrizione dell'applicazione recipe-search.
        </c:when>
        <c:otherwise>
            Here a description of the recipe-search application.
        </c:otherwise>
    </c:choose>
</p>
