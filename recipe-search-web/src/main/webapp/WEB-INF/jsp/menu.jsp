
<%@ include file="common.jspf" %>
<ul id="nav">
    <li><a href="${cp}/"><spring:message code="menu_home"/></a></li>
    <li><a href="${cp}/recipe/search.html"><spring:message code="search_recipe"/></a></li>
        <authz:authorize ifAnyGranted="ROLE_ADMIN">
        <li><a href="${cp}/admin/index.html"><spring:message code="menu_administration" text="?menu_administration?"/></a></li>
        </authz:authorize>
</ul>
