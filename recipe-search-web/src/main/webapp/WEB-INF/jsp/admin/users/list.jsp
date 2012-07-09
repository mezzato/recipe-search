<%@ include file="../../common.jspf" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <%@ include file="../../head.jspf" %>
    </head>
    <body>
        <div id="nonFooter">            
            <jsp:include page="../../header.jsp"/>
            <div id="content"> 
                <div id="content_main">
                    <h1>Users</h1>
                    
                    <table>
                        <c:forEach var="user" items="${users}">
                            <tr>
                                <td>${user.username}</td>
                                <td>
                                    <a href="edit.form?id=${user.id}">Edit</a>
                                    <a href="delete.html?id=${user.id}">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                    <a href="create.html">New</a>                            
                    
                    <c:if test="${empty users}">
                        No users in the DB
                    </c:if>
                </div>
                <jsp:include page="../../menu.jsp"/>
            </div>
        </div>
        <jsp:include page="../../footer.jsp"/>        
    </body>
</html>