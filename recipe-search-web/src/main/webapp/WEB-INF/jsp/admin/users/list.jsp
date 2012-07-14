
<%@ include file="../../common.jspf" %>
<h1><spring:message code="users" text="?users?"/></h1>
<div><a href="${cpr}/admin/users/new" class="action action-add"><spring:message code="newUser" text="?newUser?"/></a></div>
<div class="displaytag">
    <display:table  id="user"  name="users" sort="list" pagesize="20" defaultsort="5" defaultorder="ascending" requestURI="" >
        <!--  name="sessionScope.juggers" -->
        <display:column titleKey="username" sortable="true">
            <a	href="${cpr}/admin/users/${user.id}/edit">${user.username}</a>
        </display:column>
        <display:column titleKey="lastName" sortable="true">
            <c:out value="${user.lastName}" />
        </display:column>
        <display:column titleKey="firstName" sortable="true">
            <c:out value="${user.firstName}" />
        </display:column>
        <display:column titleKey="actions" class="actionColumn" >
            <a href="${cpr}/admin/users/${user.id}/edit" class="action action-edit"><spring:message code="edit" text="?edit?"/></a>
            <spring:message code='confirmDeleteUser' text="?confirmDeleteUser?" var="confirmDeleteUserMessage"/>
            <a href="${cpr}/admin/users/${user.id}?_method=DELETE" class="action action-delete" onclick="return confirm('${confirmDeleteUserMessage}')"><spring:message code="delete" text="?delete?"/></a>
        </display:column>

    </display:table>
</div>
